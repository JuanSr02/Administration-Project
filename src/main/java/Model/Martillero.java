package Model;

import java.util.Arrays;

public class Martillero extends Persona {
    private int ID;
    private String matricula;
    private int[] propiedades; // ID DE LAS PROPIEDADES QUE TIENE A CARGO

    public Martillero(int ID, String nombreCompleto, String DNI_CUIT_CUIL, String telefono, String email, int ID1, String matricula, int[] propiedades) {
        super(ID, nombreCompleto, DNI_CUIT_CUIL, telefono, email);
        this.ID = ID1;
        this.matricula = matricula;
        this.propiedades = propiedades;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int[] getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(int[] propiedades) {
        this.propiedades = propiedades;
    }

    @Override
    public String toString() {
        return "Martillero{" +
                "ID=" + ID +
                ", matricula='" + matricula + '\'' +
                ", propiedades=" + Arrays.toString(propiedades) +
                '}';
    }
}
