package ModelUnused;

public class Terreno_Lote extends Propiedad {
    public Terreno_Lote(int ID, String direccion, String plano, String moneda, String formaPago, String estado, String[] fotos, String notas_servicios_comodidades, int m2Cubiertos, int m2Descubiertos, String ambientes, double precio_Venta_Alquiler, int inquilino, int duenio) {
        super(ID, direccion, plano, moneda, formaPago, estado, fotos, notas_servicios_comodidades, m2Cubiertos, m2Descubiertos, ambientes, precio_Venta_Alquiler, inquilino, duenio);
    }

    @Override
    public String toString() {
        return "Terreno_Lote{} " + super.toString();
    }
}
