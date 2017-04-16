/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exaventas;

import java.util.ArrayList;

/**
 *
 * @author prg
 */
public class Ventas {
    
    ArrayList<Venta> listaVentas;
    
    public Ventas(){
        listaVentas = new ArrayList<Venta>();
      
    }
    public void insertaVenta(Venta venta){
        listaVentas.add(venta);
    }
    
    public ArrayList<Venta> getVentas(){
        return listaVentas;
    }
    
    public String toString(){
        String salida ="";
         for (Venta v: listaVentas){
           salida += v.toString()+"\n";
        }
         return salida;
    }
    
    public double totalVentas(){
        double total = 0;
        for(Venta v: listaVentas)
                total += v.importeVenta();
        return total;
    }
    
}
