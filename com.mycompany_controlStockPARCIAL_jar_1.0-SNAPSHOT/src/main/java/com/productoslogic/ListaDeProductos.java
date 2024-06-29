
package com.productoslogic;

import com.archivosbd.BDProductos;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author "el profe Ariel"
 */
public class ListaDeProductos {
    private LinkedList<Producto> productos;

    public ListaDeProductos() {
        productos=new LinkedList();
    }
    
    public void agregar(Producto a){
        productos.add(a);
    }
    
    public void eliminar(int indice){
        productos.remove(indice);
    }
       
       
    public int total(){
        return productos.size();
    }
    
    public Producto obtener(int indice){
        return productos.get(indice);
    }
    
       
    public void cargarProductos(){
        BDProductos bd=new BDProductos();
        productos=bd.obtener();        
    }
    
    public void guardarEnArchivo(){
        BDProductos bd=new BDProductos();
        bd.borrarTodo();
        for (int i=0;i<productos.size();i++){
            bd.registrarProducto(productos.get(i));            
        }
    }

}
