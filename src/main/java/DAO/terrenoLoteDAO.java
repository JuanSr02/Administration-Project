package DAO;

import jakarta.persistence.*;

@Entity
@Table(name = "Terreno_Lote")
public class terrenoLoteDAO extends propiedadDAO {
    @Column(name = "M2s")
    private int m2s;

    @Column(name = "estadoProp")
    private String estadoProp;

    @Column(name = "servicios_comodidades")
    private String serviciosComodidades;

    @Column(name = "Precio_Venta_Alquiler")
    private double precioVentaAlquiler;

    // Getters y setters
    public int getM2s() {
        return m2s;
    }

    public void setM2s(int m2s) {
        this.m2s = m2s;
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

