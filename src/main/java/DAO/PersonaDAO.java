package DAO;

import jakarta.persistence.*;

@Entity
@Table(name = "Persona")
public class PersonaDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "nombreCompleto", nullable = false)
    private String nombreCompleto;

    @Column(name = "DNI_CUIT_CUIL", unique = true, nullable = false)
    private long dniCuitCuil;

    @Column(name = "telefono", nullable = true)
    private long telefono;

    @Column(name = "email", nullable = true)
    private String email;

    public PersonaDAO() {}

    public PersonaDAO(int ID,String nombreCompleto, long dniCuitCuil, long telefono, String email) {
        this.ID= ID;
        this.nombreCompleto = nombreCompleto;
        this.dniCuitCuil = dniCuitCuil;
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

    public long getDniCuitCuil() {
        return dniCuitCuil;
    }

    public void setDniCuitCuil(long dniCuitCuil) {
        this.dniCuitCuil = dniCuitCuil;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
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
        return "PersonaDAO{" +
                "ID=" + ID +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", dniCuitCuil=" + dniCuitCuil +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                '}';
    }
}
