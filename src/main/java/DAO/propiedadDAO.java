package DAO;

import jakarta.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "Propiedad")
public class propiedadDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = true)
    private String plano;

    @Column(nullable = false)
    private String moneda;

    @Column(nullable = false)
    private String formaPago;

    @Column(nullable = false)
    private String estado;

    @Column(name = "fotos", columnDefinition = "TEXT")
    private String fotos; // SQLite maneja TEXT como un string.

    @Column(name = "notas", columnDefinition = "TEXT")
    private String notas;

    @ManyToOne
    @JoinColumn(name = "duenioID", nullable = false)
    private PersonaDAO duenio;

    public propiedadDAO() {}

    public propiedadDAO(String direccion, String plano, String moneda, String formaPago, String estado, String fotos, String notas, PersonaDAO duenio) {
        this.direccion = direccion;
        this.plano = plano;
        this.moneda = moneda;
        this.formaPago = formaPago;
        this.estado = estado;
        this.fotos = fotos;
        this.notas = notas;
        this.duenio = duenio;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public PersonaDAO getDuenio() {
        return duenio;
    }

    public void setDuenio(PersonaDAO duenio) {
        this.duenio = duenio;
    }

    @Override
    public String toString() {
        return "PropiedadDAO{" +
                "ID=" + ID +
                ", direccion='" + direccion + '\'' +
                ", plano='" + plano + '\'' +
                ", moneda='" + moneda + '\'' +
                ", formaPago='" + formaPago + '\'' +
                ", estado='" + estado + '\'' +
                ", fotos='" + fotos + '\'' +
                ", notas='" + notas + '\'' +
                ", duenio=" + duenio +
                '}';
    }
}
