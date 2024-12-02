package DAO;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Transaccion")
public class transaccionDAO {
    @Id
    private int id;

    @Column(name = "nombreComprador", nullable = false)
    private String nombreComprador;

    @ManyToOne
    @JoinColumn(name = "IDinmueble")
    private propiedadDAO propiedad;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "monto")
    private double monto;

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public propiedadDAO getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(propiedadDAO propiedad) {
        this.propiedad = propiedad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
