/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exaventas;

/**
 *
 * @author prg
 */
public class Venta {
    private String fecha;
    private Articulo articulo;
    private boolean servida;
    private int unidades;
    
    public Venta(){}
    
    public Venta (String fecha,Articulo articulo,  int unidades){
        setFecha(fecha);
        setArticulo(articulo);
        setUnidades(unidades);
     
    }
    public double importeVenta(){
        return unidades*articulo.getPrecioUnitario();
        
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    public boolean isServida() {
        return servida;
    }

    public void setServida(boolean servida) {
        this.servida = servida;
    }
    
    public String toString(){
        String salida ="Fecha: "+fecha+ "  Articulo: "+articulo.toString();
        salida += "Unidades: "+unidades+ " Servido: "+servida+"\n";
        return salida;
      
    }
    
}
