package DAO;

import jakarta.persistence.*;

@Entity
@Table(name = "Casa")
public class casaDAO extends propiedadDAO {
    @Column(name = "M2Cubiertos")
    private int m2Cubiertos;

    @Column(name = "M2Descubiertos")
    private int m2Descubiertos;

    @Column(name = "Ambientes")
    private String ambientes;

    @Column(name = "estadoProp")
    private String estadoProp;

    @Column(name = "servicios_comodidades")
    private String serviciosComodidades;

    @Column(name = "Precio_Venta_Alquiler")
    private double precioVentaAlquiler;

    // Getters y setters
    public int getM2Cubiertos() {
        return m2Cubiertos;
    }

    public void setM2Cubiertos(int m2Cubiertos) {
        this.m2Cubiertos = m2Cubiertos;
    }

    public int getM2Descubiertos() {
        return m2Descubiertos;
    }

    public void setM2Descubiertos(int m2Descubiertos) {
        this.m2Descubiertos = m2Descubiertos;
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

    public String getServiciosComodidades() {
        return serviciosComodidades;
    }

    public void setServiciosComodidades(String serviciosComodidades) {
        this.serviciosComodidades = serviciosComodidades;
    }

    public double getPrecioVentaAlquiler() {
        return precioVentaAlquiler;
    }

    public void setPrecioVentaAlquiler(double precioVentaAlquiler) {
        this.precioVentaAlquiler = precioVentaAlquiler;
    }
}

