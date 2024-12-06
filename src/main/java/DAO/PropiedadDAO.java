package DAO;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "propiedad")
public class PropiedadDAO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(nullable = false)
    private String direccion;

    private String plano;
    private String moneda;
    private String formaPago;
    private String estado;

    @ElementCollection
    private List<String> fotos; // Almacena las rutas como una colección

    private String notas;

    @ManyToOne
    @JoinColumn(name = "duenio", nullable = false)
    private PersonaDAO duenio;

    // Getters y Setters

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

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
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

