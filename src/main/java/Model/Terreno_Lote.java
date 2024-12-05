package Model;

public class Terreno_Lote extends Propiedad {
    private int M2s;
    private String estadoProp;
    private String servicios_comodidades;
    private double Precio_Venta_Alquiler;

    public Terreno_Lote(int ID, String direccion, String plano, String moneda, String formaPago, String estado, String[] fotos, String notas, String duenio, int m2s, String estadoProp, String servicios_comodidades, double precio_Venta_Alquiler) {
        super(ID, direccion, plano, moneda, formaPago, estado, fotos, notas, duenio);
        M2s = m2s;
        this.estadoProp = estadoProp;
        this.servicios_comodidades = servicios_comodidades;
        Precio_Venta_Alquiler = precio_Venta_Alquiler;
    }

    public int getM2s() {
        return M2s;
    }

    public void setM2s(int m2s) {
        M2s = m2s;
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
        return "Terreno_Lote{" +
                "M2s=" + M2s +
                ", estadoProp='" + estadoProp + '\'' +
                ", servicios_comodidades='" + servicios_comodidades + '\'' +
                ", Precio_Venta_Alquiler=" + Precio_Venta_Alquiler +
                '}';
    }
}
