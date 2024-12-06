package DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "terreno_lote")
public class Terreno_LoteDAO extends PropiedadDAO{
    private int M2s;
    private String estadoProp;
    private String servicios_comodidades;
    private double Precio_Venta_Alquiler;

    // Getters y Setters
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
}

