package model;

/**
 * Clase Modelo: Libro Representa un libro en la biblioteca
 *
 * @author Sistema Biblioteca
 * @version 1.0
 * @author GIOVANNI
 */
public class Libro {

    private int idLibro;
    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;
    private int anoPublicacion;
    private int cantidadTotal;
    private int cantidadDisponible;
    private String categoria;
    private String descripcion;
    private String estado;    // Activo, Inactivo

    // ============================================================
    // CONSTRUCTORES
    // ============================================================
    /**
     * Constructor vacío
     */
    public Libro() {
    }

    /**
     * Constructor con parámetros principales /**
     *
     */
    public Libro(String titulo, String autor, String isbn, String editorial,
            int anoPublicacion, int cantidadTotal) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.anoPublicacion = anoPublicacion;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadTotal;
        this.estado = "Activo";
    }

    /**
     * Constructor con todos los parámetros
     */
    public Libro(int idLibro, String titulo, String autor, String isbn,
            String editorial, int anoPublicacion, int cantidadTotal,
            int cantidadDisponible, String categoria, String descripcion,
            String estado) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.anoPublicacion = anoPublicacion;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadDisponible;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estado = estado;
    }
// ==================================================
// GETTERS Y SETTERS
// ==================================================

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

// ==================================================
// MÉTODOS ADICIONALES
// ==================================================
    /**
     * Calcula el porcentaje de disponibilidad del libro
     *
     * @return Porcentaje (0-100)
     */
    public double calcularPorcentajeDisponibilidad() {
        if (cantidadTotal == 0) {
            return 0;
        }
        return (double) cantidadDisponible / cantidadTotal * 100;
    }

    /**
     * * Verifica si hay ejemplares disponibles
     *
     * @return true si hay disponibles, false si no
     */
    public boolean tieneDisponibles() {
        return cantidadDisponible > 0;
    }

    @Override
    public String toString() {
        return "Libro{"
                + "idLibro=" + idLibro
                + ", titulo='" + titulo + '\''
                + ", autor='" + autor + '\''
                + ", isbn='" + isbn + '\''
                + ", cantidadTotal=" + cantidadTotal
                + ", cantidadDisponible=" + cantidadDisponible
                + ", estado='" + estado + '\''
                + '}';
    }
}
