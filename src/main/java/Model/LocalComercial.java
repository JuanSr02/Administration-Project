package Model;

public class LocalComercial extends Propiedad {
    private int M2Cubiertos;
    private String Ambientes;
    private String estadoProp;
    private double Precio_Venta_Alquiler;

    public LocalComercial(int ID, String direccion, String plano, String moneda, String formaPago, String estado, String[] fotos, String notas, Persona duenio, int m2Cubiertos, String ambientes, String estadoProp, double precio_Venta_Alquiler) {
        super(ID, direccion, plano, moneda, formaPago, estado, fotos, notas, duenio);
        M2Cubiertos = m2Cubiertos;
        Ambientes = ambientes;
        this.estadoProp = estadoProp;
        Precio_Venta_Alquiler = precio_Venta_Alquiler;
    }

    public int getM2Cubiertos() {
        return M2Cubiertos;
    }

    public void setM2Cubiertos(int m2Cubiertos) {
        M2Cubiertos = m2Cubiertos;
    }

    public String getAmbientes() {
        return Ambientes;
    }

    public void setAmbientes(String ambientes) {
        Ambientes = ambientes;
    }

    public String getEstadoProp() {
        return estadoProp;
    }

    public void setEstadoProp(String estadoProp) {
        this.estadoProp = estadoProp;
    }

    public double getPrecio_Venta_Alquiler() {
        return Precio_Venta_Alquiler;
    }

    public void setPrecio_Venta_Alquiler(double precio_Venta_Alquiler) {
        Precio_Venta_Alquiler = precio_Venta_Alquiler;
    }

    @Override
    public String toString() {
        return "LocalComercial{" +
                "M2Cubiertos=" + M2Cubiertos +
                ", Ambientes='" + Ambientes + '\'' +
                ", estadoProp='" + estadoProp + '\'' +
                ", Precio_Venta_Alquiler=" + Precio_Venta_Alquiler +
                '}';
    }
}
