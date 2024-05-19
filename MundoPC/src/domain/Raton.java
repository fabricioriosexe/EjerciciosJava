
package domain;


public class Raton extends DispositivoEntrada{
    private  final int idRaton;
    private static int contadorRatones;
    
    public Raton(String tipodeentrada, String marca){
        super(tipodeentrada,marca);
        this.idRaton = ++Raton.contadorRatones;
    }

    public int getIdRaton() {
        return idRaton;
    }

    @Override
      public String toString() {
       return ("------MOUSE--------ID Raton: "+this.idRaton +"\t"+ "Tipo de entrada: "+this.getTipodeentrada()+"\t"+"Marca: "+this.getMarca());
    }

   
    
}
