package domain;

public class Computadoras {

    private final int idComputadoras;
    private Monitor monitor;
    private Raton raton;
    private Teclado teclado;
    private static int contadorComputadoras;

    public Computadoras() {
        this.idComputadoras = ++Computadoras.contadorComputadoras;
    }

    public Computadoras(Monitor monitor, Raton raton, Teclado teclado) {
        this();
        this.monitor = monitor;
        this.raton = raton;
        this.teclado = teclado;
    }

    public int getIdComputadoras() {
        return idComputadoras;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Raton getRaton() {
        return raton;
    }

    public void setRaton(Raton raton) {
        this.raton = raton;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    @Override
    public String toString() {
        return "Computadoras{" + "idComputadoras=" + idComputadoras + ", monitor=" + monitor + ", raton=" + raton + ", teclado=" + teclado + '}';
    }

    
}
