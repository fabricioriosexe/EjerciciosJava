package domain;

public class Orden {

    private final int idOrden;
    private static int contadorOrdenes;
    private Computadoras [] computadoras;
    private static final int MAX_COMPUTADORAS = 10;
    private int contadorComputadoras;

    public Orden() {
        this.idOrden = ++Orden.contadorOrdenes;
        computadoras = new Computadoras[MAX_COMPUTADORAS];
        System.out.println("Orden creada");
    }

    public void AgregarComputadoras(Computadoras computadora) {
        if(contadorComputadoras<MAX_COMPUTADORAS){
        computadoras[contadorComputadoras]=computadora;
            System.out.println("Compu agragada");
            this.contadorComputadoras++;
        }else{
            System.out.println("Orden llena");
        }
        }
    public void MostrarOrden(){
         System.out.println("--------------");
         System.out.println("Orden N°"+this.idOrden);
        for (int i = 0; i < contadorComputadoras; i++) {
            System.out.println(i+".Computadora: "+computadoras[i].toString());
        }
}
        
   
    
}
