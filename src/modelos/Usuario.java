package modelos;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String dni;

    public Usuario() {}

    public Usuario(int id, String nombre, String apellido, String correo, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.dni = dni;
    }

    // getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    @Override
    public String toString() {
        return id + " - " + nombre + " " + apellido;
    }
}
