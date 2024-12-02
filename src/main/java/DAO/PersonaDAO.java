package DAO;

import jakarta.persistence.*;

@Entity
@Table(name = "Persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonaDAO{
    @Id
    private int id;

    @Column(name = "nombreCompleto", nullable = false)
    private String nombreCompleto;

    @Column(name = "DNI_CUIT_CUIL", nullable = false, unique = true)
    private String dniCuitCuil;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    public PersonaDAO() {

    }

    public PersonaDAO(String nombreCompleto, int id, String dniCuitCuil, String telefono, String email) {
        this.nombreCompleto = nombreCompleto;
        this.id = id;
        this.dniCuitCuil = dniCuitCuil;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDniCuitCuil() {
        return dniCuitCuil;
    }

    public void setDniCuitCuil(String dniCuitCuil) {
        this.dniCuitCuil = dniCuitCuil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

