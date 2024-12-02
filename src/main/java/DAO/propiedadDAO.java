package DAO;

import jakarta.persistence.*;

@Entity
@Table(name = "Propiedad")
@Inheritance(strategy = InheritanceType.JOINED)
public class propiedadDAO {
    @Id
    private int id;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "plano")
    private String plano;

    @Column(name = "moneda")
    private String moneda;

    @Column(name = "formaPago")
    private String formaPago;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fotos")
    private String fotos;

    @Column(name = "notas")
    private String notas;

    @ManyToOne
    @JoinColumn(name = "duenioID")
    private PersonaDAO duenio;

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}


