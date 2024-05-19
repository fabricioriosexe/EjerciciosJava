
package claseseinterfaces;

public class Pacientes {
    private  String nombre;
    private  int dni;
    private  String obraSocial;

    public Pacientes(int dni, String obraSocial, String nombre) {
        this.dni = dni;
        this.obraSocial = obraSocial;
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Pacientes{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                ", obraSocial='" + obraSocial + '\'' +
                '}';
    }
}
