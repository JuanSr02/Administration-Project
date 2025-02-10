package ModelUnused;

import java.util.Arrays;

public class Propiedad {
    private int ID;
    private String direccion;
    private String plano; // EL STRING ES LA RUTA DEL PLANO
    private String moneda;
    private String formaPago;
    private String estado;
    private String[] fotos; // CADA STRING DEL ARRREGLO ES LA RUTA DE LA FOTO.
    private String notas_servicios_comodidades; // Servicios_comodidades
    private int M2Cubiertos;
    private int M2Descubiertos;
    private String Ambientes;
    private double Precio_Venta_Alquiler;
    private int duenio; // id dueño
    private int inquilino; // id inquilino

    public Propiedad(int ID, String direccion, String plano, String moneda, String formaPago, String estado, String[] fotos, String notas_servicios_comodidades, int m2Cubiertos, int m2Descubiertos, String ambientes, double precio_Venta_Alquiler, int inquilino, int duenio) {
        this.ID = ID;
        this.direccion = direccion;
        this.plano = plano;
        this.moneda = moneda;
        this.formaPago = formaPago;
        this.estado = estado;
        this.fotos = fotos;
        this.notas_servicios_comodidades = notas_servicios_comodidades;
        M2Cubiertos = m2Cubiertos;
        M2Descubiertos = m2Descubiertos;
        Ambientes = ambientes;
        Precio_Venta_Alquiler = precio_Venta_Alquiler;
        this.inquilino = inquilino;
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

    public int getDuenio() {
        return duenio;
    }

    public void setDuenio(int duenio) {
        this.duenio = duenio;
    }

    public int getInquilino() {
        return inquilino;
    }

    public void setInquilino(int inquilino) {
        this.inquilino = inquilino;
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

