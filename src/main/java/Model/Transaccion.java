package Model;

public class Transaccion {
    private String nombreComprador;
    private int IDinmueble;
    private int ID;
    private String fecha;
    private double monto;

    public Transaccion(String nombreComprador, int IDinmueble, int ID, String fecha, double monto) {
        this.nombreComprador = nombreComprador;
        this.IDinmueble = IDinmueble;
        this.ID = ID;
        this.fecha = fecha;
        this.monto = monto;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public int getIDinmueble() {
        return IDinmueble;
    }

    public void setIDinmueble(int IDinmueble) {
        this.IDinmueble = IDinmueble;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "nombreComprador='" + nombreComprador + '\'' +
                ", IDinmueble=" + IDinmueble +
                ", ID=" + ID +
                ", fecha='" + fecha + '\'' +
                ", monto=" + monto +
                '}';
    }
}
