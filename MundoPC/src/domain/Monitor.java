package domain;

public class Monitor {

    private final int idMonitor;
    private String Marca;
    private double tamaño;
    private String resolucion;
    private static int contadorMonitor;

    public Monitor() {
        this.idMonitor = ++Monitor.contadorMonitor;
    }

    public Monitor(String marca, double tamaño, String resolucion) {
        this();
        this.Marca = marca;
        this.tamaño = tamaño;
        this.resolucion = resolucion;
    }

    public int getIdMonitor() {
        return idMonitor;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    @Override
    public String toString() {
        return "------Monitor------\nID Monitor: "+this.idMonitor+"\tMarca: "+this.Marca+"\n Tamaño"+this.tamaño+"\t Resolucion"+this.resolucion;
    }

}
