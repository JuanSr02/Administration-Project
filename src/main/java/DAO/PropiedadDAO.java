package DAO;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "propiedad")
@Inheritance(strategy = InheritanceType.JOINED)
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

    private String notas_servicios_comodidades;

    private int M2Cubiertos;
    private int M2Descubiertos;
    private String Ambientes;
    private double Precio_Venta_Alquiler;

    @ManyToOne
    @JoinColumn(name = "duenio", nullable = false)
    private PersonaDAO duenio;

    @ManyToOne
    @JoinColumn(name = "inquilino", nullable = true)
    private PersonaDAO inquilino;

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

    public String getNotas_servicios_comodidades() {
        return notas_servicios_comodidades;
    }

    public void setNotas_servicios_comodidades(String notas_servicios_comodidades) {
        this.notas_servicios_comodidades = notas_servicios_comodidades;
    }

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

    public double getPrecio_Venta_Alquiler() {
        return Precio_Venta_Alquiler;
    }

    public void setPrecio_Venta_Alquiler(double precio_Venta_Alquiler) {
        Precio_Venta_Alquiler = precio_Venta_Alquiler;
    }

    public PersonaDAO getDuenio() {
        return duenio;
    }

    public void setDuenio(PersonaDAO duenio) {
        this.duenio = duenio;
    }

    public PersonaDAO getInquilino() {
        return inquilino;
    }

    public void setInquilino(PersonaDAO inquilino) {
        this.inquilino = inquilino;
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
                ", fotos=" + fotos +
                ", notas_servicios_comodidades='" + notas_servicios_comodidades + '\'' +
                ", M2Cubiertos=" + M2Cubiertos +
                ", M2Descubiertos=" + M2Descubiertos +
                ", Ambientes='" + Ambientes + '\'' +
                ", Precio_Venta_Alquiler=" + Precio_Venta_Alquiler +
                ", duenio=" + duenio +
                ", inquilino=" + inquilino +
                '}';
    }




}

