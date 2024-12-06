package DAO;

import jakarta.persistence.*;

@Entity
@Table(name = "transaccion")
public class TransaccionDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne
    @JoinColumn(name = "nombreComprador", nullable = false)
    private PersonaDAO comprador;

    @ManyToOne
    @JoinColumn(name = "IDinmueble", nullable = false)
    private PropiedadDAO inmueble;

    private String fecha;
    private double monto;

    // Getters y Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public PersonaDAO getComprador() {
        return comprador;
    }

    public void setComprador(PersonaDAO comprador) {
        this.comprador = comprador;
    }

    public PropiedadDAO getInmueble() {
        return inmueble;
    }

    public void setInmueble(PropiedadDAO inmueble) {
        this.inmueble = inmueble;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
