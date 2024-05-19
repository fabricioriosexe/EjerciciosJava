
package domain;

public class Teclado extends DispositivoEntrada{
    private final int idTeclado;
    private static int contadorTeclado;
    
    public Teclado(String tipodeentrada,String marca){
    super(tipodeentrada,marca);
    this.idTeclado = ++Teclado.contadorTeclado;
    }

    public int getIdTeclado() {
        return idTeclado;
    }

    @Override
    public String toString() {
        return ("------TECLADO--------\n"+"ID TECLADO: "+this.idTeclado+"\t Marca: "+this.getMarca()+"\t Tipo de entrada: "+this.getTipodeentrada());
    }
    
}
