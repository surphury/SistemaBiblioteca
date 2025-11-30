package model;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int anio;
    private String isbn;

    public Libro() {}

    public Libro(int id, String titulo, String autor, int anio, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }

    // getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    @Override
    public String toString() {
        return id + " - " + titulo + " - " + autor;
    }
}
