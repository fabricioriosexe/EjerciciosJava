package claseseinterfaces;
public class Adultos extends Pacientes{
    private int presionArterial;
    private double altura;
    private double peso;

    public Adultos(double peso, double altura, int presionArterial,int dni,String obraSocial,String nombre) {
        super(dni, obraSocial, nombre);
        this.peso = peso;
        this.altura = altura;
        this.presionArterial = presionArterial;
    }

    public int getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(int presionArterial) {
        this.presionArterial = presionArterial;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Adultos{" + Adultos.super.toString() +
                " presionArterial=" + presionArterial +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
