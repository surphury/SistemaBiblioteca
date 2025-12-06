package model;
import java.time.LocalDate;
/**
 *
 * @author LAPTOP-404
 */
public class Prestamo {
    private int idPrestamo;
    private int idUsuario;
    private int idLibro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionEsperada;
    private LocalDate fechaDevolucionReal;
    private int cantidadEjemplares;
    private String estado; //Vigente, Devuelto, Atrasado, Cancelado
    private String observaciones;
    private double multaGenerada;
    private boolean multaPagada;
    
    
    public Prestamo() {       
    }
    /** *Construcor con parámetros principales */
    public Prestamo(int idUsuario, int idLibro, LocalDate fechaPrestamo,
                    LocalDate fechaDevolucionEsperada, int cantidadEjemplares)  { 
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
        this.estado = "Vigente";
        this.multaGenerada = 0;
        this.multaPagada = false;
    } 
     /** * Constructor con todos los parámetros */
    public Prestamo(int idPrestamo, int idUsuario, int idLibro, LocalDate fechaPrestamo,
                     LocalDate fechaDevolucionEsperada, LocalDate fechaDevolucionReal,
                     int cantidadEjemplares, String estado, String observaciones,
                     double multaGenerada, boolean multaPagada) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.cantidadEjemplares = cantidadEjemplares;
        this.estado = estado;
        this.observaciones = observaciones;
        this.multaGenerada = multaGenerada;
        this.multaPagada = multaPagada;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucionEsperada() {
        return fechaDevolucionEsperada;
    }

    public void setFechaDevolucionEsperada(LocalDate fechaDevolucionEsperada) {
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }

    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(LocalDate fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public double getMultaGenerada() {
        return multaGenerada;
    }

    public void setMultaGenerada(double multaGenerada) {
        this.multaGenerada = multaGenerada;
    }

    public boolean isMultaPagada() {
        return multaPagada;
    }

    public void setMultaPagada(boolean multaPagada) {
        this.multaPagada = multaPagada;
    }
    
    /**
     * Calcula los dias de retraso
     * @return Número de dias vendidos (0 si no esta vencido)
     */
    public long calcularDiasRetraso(){
        LocalDate hoy = LocalDate.now();
        if (hoy.isAfter(fechaDevolucionEsperada)) {
            return java.time.temporal.ChronoUnit.DAYS.
                    between(fechaDevolucionEsperada, hoy);
        } 
        return 0;
    }
    
    /**
     * Verifica si el préstamo está vencido
     * @return true si está vencido, false si no
     */
    public boolean estaVencido() {
        return LocalDate.now().isAfter(fechaDevolucionEsperada);
    }
    
    /**
     * Calcula la multa basada en los dias de retraso
     * @param multaDiaria El monto de la multa por dia
     * @return La multa total calculada
     */
    
    public double calcularMulta(double multaDiaria) {
        long diasRetraso = calcularDiasRetraso();
        return diasRetraso * multaDiaria;
        
    } 
    
    @Override
    public String toString() {
        return "Prestamo{" +
                "idPrestamo=" + idPrestamo +
                ", idUsuario=" + idUsuario +
                ", idLibro=" + idLibro +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fehcaDevolucionEsperada=" + fechaDevolucionEsperada +
                ", estado='" + estado + '\'' +
                ", multaGenerada=" + multaGenerada +
                '}';
                        
    }
}
