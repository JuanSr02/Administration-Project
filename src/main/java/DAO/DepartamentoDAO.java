package DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
public class DepartamentoDAO extends PropiedadDAO {
    @Override
    public String toString() {
        return "DepartamentoDAO{} " + super.toString();
    }
}

