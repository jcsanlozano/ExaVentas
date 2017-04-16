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
public class Articulos {
    private ArrayList<Articulo> listaArticulos;
    
    
    //este array contendrá las unidades de todos los articulos vendidas en cada mes
    private int[] totalUnidadesVendidasPorMes;
    
    
    //constructor
    public Articulos(){
        listaArticulos = new ArrayList<Articulo>();
        totalUnidadesVendidasPorMes = new int[12];
    }
    public ArrayList getListaArticulos(){
        return listaArticulos;
    }
    
    public int[] getTotalUnidadesVendidasPorMes(){
        return totalUnidadesVendidasPorMes;
        
    }
    public void insertaArticulo(Articulo articulo){
        listaArticulos.add(articulo);
    } 
    
   
    //Recibe el nombre de un artículo y devuelve el bjeto articulo que
    // se correponde con el nombre o null si el articulo no está.
    public Articulo buscaArticulo(String nombre){
        for(Articulo art:listaArticulos)
            if (art.getNombre().compareToIgnoreCase(nombre)==0 )
                        return art;
        return null;
    }
    
    public String toString(){
        String salida="";
         for (Articulo a : listaArticulos)
             salida += a.toString()+a.unidadesMensualesToString()+"\n";
        return salida;
    
    }
    
    //devuelve una cadena que contiene las unidades vendidas de todos los artículos 
    // cada mes con el formato Ene.: 3 / Feb.: 4 /........
    public String totalUnidadesVendidasPorMesToString(){
         String[] meses = {"Ene.", "Feb.", "Mar.", "Abr.", "May.", "Jun.", "Jul.", "Ago.", "Sep.", "Oct.", "Nov.", "Dic."};
         String salida = "";
        for (int i = 0; i < totalUnidadesVendidasPorMes.length; i++) {
            salida += meses[i] + ": " + totalUnidadesVendidasPorMes[i] + " / ";
        }
        salida += "\n";
        return salida;
        
    }
    
//    public void actualizarTotalUnidadesVendidasPorMes(){
//        for (Articulo art : listaArticulos){
//            for(int i=0;i<art.getUnidadesVendidasEnCadaMes().length;i++){
//                totalUnidadesVendidasPorMes[i]+=art.getUnidadesVendidasEnUnMes(i);
//            }
//        }  
//    }
   
    
//Acumula en la tabla    totalUnidadesVendidasPorMes las unidades vendidas en cada mes
// a partir de la tabla unidadesVendidasEnUnMes que tiene cada artículo.
    public void actualizaTotalUnidadesVendidasPorMes(){
              for(int i=0;i<totalUnidadesVendidasPorMes.length;i++)
                       for (Articulo art : listaArticulos)
                           totalUnidadesVendidasPorMes[i]+=art.getUnidadesVendidasEnUnMes(i);
    }
 }
