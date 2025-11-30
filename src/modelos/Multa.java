package model;

public class Multa {
    private int id;
    private int prestamoId;
    private double monto;
    private boolean pagada;

    public Multa() {}

    public Multa(int id, int prestamoId, double monto, boolean pagada) {
        this.id = id;
        this.prestamoId = prestamoId;
        this.monto = monto;
        this.pagada = pagada;
    }

    // getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getPrestamoId() { return prestamoId; }
    public void setPrestamoId(int prestamoId) { this.prestamoId = prestamoId; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public boolean isPagada() { return pagada; }
    public void setPagada(boolean pagada) { this.pagada = pagada; }
}
