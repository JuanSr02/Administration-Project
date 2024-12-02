package DAO;

import jakarta.persistence.*;

@Entity
@Table(name = "Martillero")
public class martilleroDAO extends PersonaDAO {
    @Column(name = "matricula", nullable = false)
    private String matricula;

    // Getters y setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

