package DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "localcomercial")
public class LocalComercialDAO extends PropiedadDAO{
    @Override
    public String toString() {
        return "LocalComercialDAO{} " + super.toString();
    }
}

