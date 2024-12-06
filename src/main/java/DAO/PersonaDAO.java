package DAO;

import jakarta.persistence.*;

@Entity
@Table(name = "persona")
public class PersonaDAO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(nullable = false)
    private String nombreCompleto;

    @Column(unique = true, nullable = false)
    private String DNI_CUIT_CUIL;

    private String telefono;
    private String email;

    // Getters y Setters

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

    public String getDNI_CUIT_CUIL() {
        return DNI_CUIT_CUIL;
    }

    public void setDNI_CUIT_CUIL(String DNI_CUIT_CUIL) {
        this.DNI_CUIT_CUIL = DNI_CUIT_CUIL;
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

