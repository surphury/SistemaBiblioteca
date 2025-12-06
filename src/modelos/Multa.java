package model;
import java.time.LocalDate;

public class Multa {
    private int idMulta;
    private int idPrestamo;
    private int idUsuario;
    private double montoMulta;
    private String razon;
    private String estadoPago;  //Pendiente, Pagada, Perdonada
    private LocalDate fechaGeneracion;
    private LocalDate fechaPago;
    
    
    //===============================================================================
    //CONSTRUCTORES
    //===============================================================================
    
    /**
     * Constructor vacio
     */
    public Multa(){
    }
    
    /**
     * Constructor con parámetros principales
     */
    public Multa(int idPrestamo, int idUsuario, double montoMulta, String razon) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.montoMulta = montoMulta;
        this.razon = razon;
        this.estadoPago = "Pendiente";
        this.fechaGeneracion = LocalDate.now();
         
    } 
    /**
     * Constructor con todos los parámetros
     */
    public Multa(int idMulta, int idPrestamo, int idUsuario, double montoMulta,
                 String razon, String estadoPago, LocalDate fechaGeneracion, LocalDate fechaPago) {
        this.idMulta = idMulta;
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.montoMulta = montoMulta;
        this.razon = razon;
        this.estadoPago = estadoPago;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaPago = fechaPago;
    }
    
    //===============================================================================
    // GETERS Y SETTERS
    //===============================================================================
    
    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
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

    public double getMontoMulta() {
        return montoMulta;
    }

    public void setMontoMulta(double montoMulta) {
        this.montoMulta = montoMulta;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    // =========================================================================
    // MÉTODOS ADICIONALES
    // =========================================================================
    
    /**
     * Marca la multa como paga
     */
    public void pagarMulta() {
        this.estadoPago = "Pagada";
        this.fechaPago = LocalDate.now();
    }
    
    /**
     * Perdona la multa
     */
    
    public void perdonarMulta() {
        this.estadoPago = "Perdonada";
    }
    
    /**
     * Verifica si la multa está pagada
     * @return true si está pagada, false si no
     */
    public boolean estaPagada() {
        return "Pagada".equals(estadoPago);
    }
    
    /**
     * Verifica si la multa está pendiente
     * @return true si está pendiente, false si no
     */
    public boolean estaPendiente() {
        return "Pendiente".equals(estadoPago);
    }
    
    /**
     * Calcula dias desde la generación de la multa
     * @return Número de dias
     */
    public long calcularDiasDesdeGeneracion() {
        return java.time.temporal.ChronoUnit.DAYS.between(fechaGeneracion, LocalDate.now());
    } 
    
    @Override
    public String toString() {
        return "Multa{" +
                "idMulta=" + idMulta +
                ", idPrestamo=" + idPrestamo +
                ", idUsuario=" + idUsuario +
                ", montoMulta=" + montoMulta +
                ", razon='" + razon + '\'' +
                ", estadoPago='" + estadoPago + '\'' +
                ", fechaGeneracion=" + fechaGeneracion +
                '}';
    }
    
}
