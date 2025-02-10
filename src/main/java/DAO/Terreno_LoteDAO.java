package DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "terreno_lote")
public class Terreno_LoteDAO extends PropiedadDAO{
    @Override
    public String toString() {
        return "Terreno_LoteDAO{} " + super.toString();
    }
}

