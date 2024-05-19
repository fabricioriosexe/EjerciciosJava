package domain;

public class DispositivoEntrada {
    private String tipodeentrada;
    private String marca;

    public DispositivoEntrada(String tipodeentrada, String marca) {
        this.tipodeentrada = tipodeentrada;
        this.marca = marca;
    }

    public String getTipodeentrada() {
        return tipodeentrada;
    }

    public void setTipodeentrada(String tipodeentrada) {
        this.tipodeentrada = tipodeentrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "DispositivoEntrada{" + "tipodeentrada=" + tipodeentrada + ", marca=" + marca + '}';
    }
    
}
