package DAO;

import jakarta.persistence.*;

@Entity
@Table(name = "casa")
public class CasaDAO extends PropiedadDAO {
    @Override
    public String toString() {
        return "CasaDAO{} " + super.toString();
    }
}

