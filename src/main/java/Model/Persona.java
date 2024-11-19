package Model;

public class Persona {
    private int ID;
    private String nombreCompleto;
    private long DNI_CUIT_CUIL;
    private long telefono;
    private String email;

    public Persona(int ID, String nombreCompleto, long DNI_CUIT_CUIL, long telefono, String email) {
        this.ID = ID;
        this.nombreCompleto = nombreCompleto;
        this.DNI_CUIT_CUIL = DNI_CUIT_CUIL;
        this.telefono = telefono;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public long getDNI_CUIT_CUIL() {
        return DNI_CUIT_CUIL;
    }

    public void setDNI_CUIT_CUIL(long DNI_CUIT_CUIL) {
        this.DNI_CUIT_CUIL = DNI_CUIT_CUIL;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "ID=" + ID +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", DNI_CUIT_CUIL=" + DNI_CUIT_CUIL +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                '}';
    }
}
