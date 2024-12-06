package DAO;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "martillero")
public class MartilleroDAO extends PersonaDAO{
    private String matricula;

    @ElementCollection
    private List<Integer> propiedades; // Almacena IDs de propiedades

    // Getters y Setters

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Integer> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Integer> propiedades) {
        this.propiedades = propiedades;
    }
}
