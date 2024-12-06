package Model;

import java.util.Arrays;

public class Propiedad {
    private int ID;
    private String direccion;
    private String plano; // EL STRING ES LA RUTA DEL PLANO
    private String moneda;
    private String formaPago;
    private String estado;
    private String[] fotos; // CADA STRING DEL ARRREGLO ES LA RUTA DE LA FOTO.
    private String notas; // NOTAS ADICIONALES
    private int duenio; // id dueño

    public Propiedad(int ID, String direccion, String plano, String moneda, String formaPago, String estado, String[] fotos, String notas, int duenio) {
        this.ID = ID;
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

    public String[] getFotos() {
        return fotos;
    }

    public void setFotos(String[] fotos) {
        this.fotos = fotos;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public int getDuenio() {
        return duenio;
    }

    public void setDuenio(int duenio) {
        this.duenio = duenio;
    }

    @Override
    public String toString() {
        return "Propiedad{" +
                "ID=" + ID +
                ", direccion='" + direccion + '\'' +
                ", plano='" + plano + '\'' +
                ", moneda='" + moneda + '\'' +
                ", formaPago='" + formaPago + '\'' +
                ", estado='" + estado + '\'' +
                ", fotos=" + Arrays.toString(fotos) +
                ", notas='" + notas + '\'' +
                ", dueño=" + duenio +
                '}';
    }
}

