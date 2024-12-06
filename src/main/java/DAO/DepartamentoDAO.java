package DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
public class DepartamentoDAO extends PropiedadDAO {
    private int M2Cubiertos;
    private int M2Descubiertos;
    private String Ambientes;
    private String estadoProp;
    private String servicios_comodidades;
    private double Precio_Venta_Alquiler;

    // Getters y Setters
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
}

