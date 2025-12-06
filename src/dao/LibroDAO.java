package dao;
import conexion.conexionBD;
import modelos.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPTOP-404
 */
public class LibroDAO {
    private Connection conexion;
/**
     * Constructor - obtiene la conexión de la BD
     */
    public LibroDAO() {
        this.conexion = conexionBD.obtenerConexion();
    } 
  // ===================================================
// CREATE - GUARDAR LIBRO
// ===================================================
    public boolean guardarLibro(Libro libro) {
        String sql = "INSERT INTO libros (titulo, "
                + "autor, isbn, editorial,"
                + " ano_publicacion, cantidad_total, "
                + "cantidad_disponible,"
                + " categoria, estado) " 
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, libro.getTitulo());
        ps.setString(2, libro.getAutor());
        ps.setString(3, libro.getIsbn());
        ps.setString(4, libro.getEditorial());
        ps.setInt(5, libro.getAnoPublicacion());
        ps.setInt(6, libro.getCantidadTotal());
        ps.setInt(7, libro.getCantidadDisponible());
        ps.setString(8, libro.getCategoria());
        ps.setString(9, libro.getEstado());

        ps.executeUpdate();
        ps.close();

        System.out.println("✓ Libro guardado correctamente");
        return true;
} catch (SQLException e) {
    System.err.println("X Error al guardar libro: " 
            + e.getMessage());
    e.printStackTrace();
    return false;
}
    }
    // ===========================================================
// READ - OBTENER LIBROS
// ===========================================================

/**
 * Obtiene todos los libros de la base de datos
 * @return Lista de libros
 */
public List<Libro> obtenerTodos() {
    List<Libro> libros = new ArrayList<>();
    String sql = "SELECT * FROM libros ORDER BY titulo";
    try {
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Libro libro = new Libro(
                rs.getInt("id_libro"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("isbn"),
                rs.getString("editorial"),
                rs.getInt("ano_publicacion"),
                rs.getInt("cantidad_total"),
                rs.getInt("cantidad_disponible"),
                rs.getString("categoria"),
                rs.getString("descripcion"),
                rs.getString("estado")
            );
libros.add(libro);
}
rs.close();
st.close();
} catch (SQLException e) {
    System.err.println("X Error al obtener libros: " 
            + e.getMessage());
    e.printStackTrace();
}
return libros;
}

/**
 * Obtiene un libro por su ID
 *
 * @param idLibro El ID del libro a buscar
 * @return Libro encontrado, null si no existe
 */
public Libro obtenerPorId(int idLibro) {
    String sql = "SELECT * FROM libros "
            + "WHERE id_libro = ?";

    try {
        PreparedStatement 
                ps = conexion.prepareStatement(sql);
        ps.setInt(1, idLibro);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Libro libro = new Libro(
                rs.getInt("id_libro"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("isbn"),
                rs.getString("editorial"),
                rs.getInt("ano_Publicacion"),
                rs.getInt("cantidad_total"),
                rs.getInt("cantidad_disponible"),
                rs.getString("categoria"),
                rs.getString("descripcion"),
                rs.getString("estado")
                        
                );


rs.close();
ps.close();
return libro;
}
rs.close();
ps.close();
} catch (SQLException e) {
    System.err.println("X Error al obtener libro por ID: "
        + e.getMessage());
    e.printStackTrace();
}

return null;
}

/**
 * Obtiene un libro por su ISBN
 *
 * @param isbn El ISBN del libro
 * @return Libro encontrado, null si no existe
 */
public Libro obtenerPorIsbn(String isbn) {
    String sql = "SELECT * FROM libros "
            + "WHERE isbn = ?";

    try{
        PreparedStatement 
                ps = conexion.prepareStatement(sql);
        ps.setString(1, isbn);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Libro libro = new Libro(
                rs.getInt("id_libro"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("isbn"),
                rs.getString("editorial"),
                rs.getInt("ano_publicacion"),
                rs.getInt("cantidad_total"),
                rs.getInt("cantidad_disponible"),
                rs.getString("categoria"),
                rs.getString("descripcion"),
                rs.getString("estado")
            );
            rs.close();
            ps.close();
            return libro;
        }
        rs.close();
        ps.close();

} catch (SQLException e) {
    System.err.println("X Error al obtener libro por ISBN: "
        + e.getMessage());
    e.printStackTrace();
}
return null;
}


/**
 * Busca libros por título (búsqueda parcial)
 *
 * @param titulo Parte del título a buscar
 * @return Lista de libros que coinciden
 */
public List<Libro> buscarPorTitulo(String titulo) {
    List<Libro> libros = new ArrayList<>();
    String sql = "SELECT * FROM libros "
            + "WHERE titulo LIKE ? ORDER BY titulo";
    try {
        PreparedStatement 
                ps = conexion.prepareStatement(sql);
        ps.setString(1, "%" + titulo + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Libro libro = new Libro(
                rs.getInt("id_libro"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("isbn"),
                rs.getString("editorial"),
                rs.getInt("ano_publicacion"),
                rs.getInt("cantidad_total"),
                rs.getInt("cantidad_disponible"),
                rs.getString("categoria"),
                rs.getString("descripcion"),
                rs.getString("estado")
            );

libros.add(libro);
}
rs.close();
ps.close();

} catch (SQLException e) {
    System.err.println("X Error al buscar libros por título: "
        + e.getMessage());
    e.printStackTrace();
}
return libros;
}

/**
 * Obtiene libros por autor
 * @param autor El autor a buscar
 * @return Lista de libros del autor
 */
public List<Libro> obtenerPorAutor(String autor) {
    List<Libro> libros = new ArrayList<>();
    String sql = "SELECT * FROM libros WHERE autor = ? ORDER BY titulo";
    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, autor);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Libro libro = new Libro(
                rs.getInt("id_libro"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("isbn"),
                rs.getString("editorial"),
                rs.getInt("ano_publicacion"),
                rs.getInt("cantidad_total"),
                rs.getInt("cantidad_disponible"),
                rs.getString("categoria"),
                rs.getString("descripcion"),
                rs.getString("estado")
                       );
libros.add(libro);
}
rs.close();
ps.close();

} catch (SQLException e) {
    System.err.println("X Error al obtener libros por autor: "
        + e.getMessage());
    e.printStackTrace();
}
return libros;
}

/**
 * Obtiene libros disponibles
 * @return Lista de libros con disponibilidad mayor a 0
 */
public List<Libro> obtenerDisponibles() {
    List<Libro> libros = new ArrayList<>();
    String sql = "SELECT * FROM libros WHERE cantidad_disponible > 0"
        + " AND estado = 'Activo' ORDER BY titulo";
  try {
    Statement st = conexion.createStatement();
    ResultSet rs = st.executeQuery(sql);
    

    while (rs.next()) {
        Libro libro = new Libro(
            rs.getInt("id_libro"),
            rs.getString("titulo"),
            rs.getString("autor"),
            rs.getString("isbn"),
            rs.getString("editorial"),
            rs.getInt("ano_publicacion"),
            rs.getInt("cantidad_total"),
            rs.getInt("cantidad_disponible"),
            rs.getString("categoria"),
            rs.getString("descripcion"),
            rs.getString("estado")
        );
        libros.add(libro);
    }
    rs.close();
    st.close();
   } catch (SQLException e) {
    System.err.println("X Error al obtener libros por autor: "
        + e.getMessage());
    e.printStackTrace();
    }
     return libros; 
  }   

// =========================================================
// UPDATE - ACTUALIZAR LIBRO
// =========================================================

/**
 * Actualiza los datos de un libro
 * @param libro El libro con datos actualizados
 * @return true si se actualizó correctamente, false si no
 */
public boolean actualizarLibro(Libro libro) {
    String sql = "UPDATE libros SET titulo = ?, "
                + "autor = ?, isbn = ?,"
                + " editorial = ?, "
                + "ano_publicacion = ?, "
                + "cantidad_total = ?, "
                + "cantidad_disponible = ?, "
                + "categoria = ?, "
                + "descripcion = ?, estado = ? "
                + "WHERE id_libro = ?";

    try {
        PreparedStatement 
                ps = conexion.prepareStatement(sql);
        ps.setString(1, libro.getTitulo());
        ps.setString(2, libro.getAutor());
        ps.setString(3, libro.getIsbn());
        ps.setString(4, libro.getEditorial());
        ps.setInt(5, libro.getAnoPublicacion());
        ps.setInt(6, libro.getCantidadTotal());
        ps.setInt(7, libro.getCantidadDisponible());
        ps.setString(8, libro.getCategoria());
        ps.setString(9, libro.getDescripcion());
        ps.setString(10, libro.getEstado());
        ps.setInt(11, libro.getIdLibro());

        ps.executeUpdate();
        ps.close();

        System.out.println("✓ Libro actualizado correctamente");
                return true;
    } catch (SQLException e) {
        System.err.println
        ("X Error al actualizar libro: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
   }

 /* ELIMINAR LIBRO
 
 */
public boolean eliminarLibro(int idLibro) {
    String sql = "DELETE FROM libros WHERE id_libro = ?";
    try {
       PreparedStatement 
                ps = conexion.prepareStatement(sql);
       ps.setInt(1, idLibro);
       ps.executeUpdate();
        ps.close();
       System.out.println("✓ Libro eliminado correctamente");
       return true;
        
        
    }catch (SQLException e) {
        System.err.println
        ("X Error al eliminar libro: " + e.getMessage());
        e.printStackTrace();
        return false;
      }
  } 

}
