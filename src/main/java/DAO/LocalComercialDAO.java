package DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "localcomercial")
public class LocalComercialDAO extends PropiedadDAO{
    private int M2Cubiertos;
    private String Ambientes;
    private String estadoProp;
    private double Precio_Venta_Alquiler;

    // Getters y Setters
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
}

