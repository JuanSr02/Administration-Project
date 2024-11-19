package Model;

public class Departamento extends Propiedad {
    private int M2Cubiertos;
    private int M2Descubiertos;
    private String Ambientes;
    private String estadoProp;
    private String servicios_comodidades;
    private double Precio_Venta_Alquiler;

    public Departamento(int ID, String direccion, String plano, String moneda, String formaPago, String estado, String[] fotos, String notas, Persona duenio, int m2Cubiertos, int m2Descubiertos, String ambientes, String estadoProp, String servicios_comodidades, double precio_Venta_Alquiler) {
        super(ID, direccion, plano, moneda, formaPago, estado, fotos, notas, duenio);
        M2Cubiertos = m2Cubiertos;
        M2Descubiertos = m2Descubiertos;
        Ambientes = ambientes;
        this.estadoProp = estadoProp;
        this.servicios_comodidades = servicios_comodidades;
        Precio_Venta_Alquiler = precio_Venta_Alquiler;
    }

    public int getM2Cubiertos() {
        return M2Cubiertos;
    }

    public void setM2Cubiertos(int m2Cubiertos) {
        M2Cubiertos = m2Cubiertos;
    }

    public int getM2Descubiertos() {
        return M2Descubiertos;
    }

    public void setM2Descubiertos(int m2Descubiertos) {
        M2Descubiertos = m2Descubiertos;
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

    public String getServicios_comodidades() {
        return servicios_comodidades;
    }

    public void setServicios_comodidades(String servicios_comodidades) {
        this.servicios_comodidades = servicios_comodidades;
    }

    public double getPrecio_Venta_Alquiler() {
        return Precio_Venta_Alquiler;
    }

    public void setPrecio_Venta_Alquiler(double precio_Venta_Alquiler) {
        Precio_Venta_Alquiler = precio_Venta_Alquiler;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "M2Cubiertos=" + M2Cubiertos +
                ", M2Descubiertos=" + M2Descubiertos +
                ", Ambientes='" + Ambientes + '\'' +
                ", estadoProp='" + estadoProp + '\'' +
                ", servicios_comodidades='" + servicios_comodidades + '\'' +
                ", Precio_Venta_Alquiler=" + Precio_Venta_Alquiler +
                '}';
    }
}