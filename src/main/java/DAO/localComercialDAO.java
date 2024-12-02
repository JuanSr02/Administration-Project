package DAO;

import jakarta.persistence.*;

@Entity
@Table(name = "LocalComercial")
public class localComercialDAO extends propiedadDAO {
    @Column(name = "M2Cubiertos")
    private int m2Cubiertos;

    @Column(name = "Ambientes")
    private String ambientes;

    @Column(name = "estadoProp")
    private String estadoProp;

    @Column(name = "Precio_Venta_Alquiler")
    private double precioVentaAlquiler;

    // Getters y setters
    public int getM2Cubiertos() {
        return m2Cubiertos;
    }

    public void setM2Cubiertos(int m2Cubiertos) {
        this.m2Cubiertos = m2Cubiertos;
    }

    public String getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(String ambientes) {
        this.ambientes = ambientes;
    }

    public String getEstadoProp() {
        return estadoProp;
    }

    public void setEstadoProp(String estadoProp) {
        this.estadoProp = estadoProp;
    }

    public double getPrecioVentaAlquiler() {
        return precioVentaAlquiler;
    }

    public void setPrecioVentaAlquiler(double precioVentaAlquiler) {
        this.precioVentaAlquiler = precioVentaAlquiler;
    }
}

