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
    private long dniCuitCuil;

    @Column(name = "telefono")
    private Long telefono;

    @Column(name = "email")
    private String email;

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
}

