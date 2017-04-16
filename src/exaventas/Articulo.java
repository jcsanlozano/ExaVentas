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
public class Articulo implements Comparable<Articulo>{

    private String nombre;
    private double precioUnitario;
    private int existencias;
    private int[] unidadesVendidasEnCadaMes;

    public Articulo(String nombre, double precioUnitario, int existencias) {

        setNombre(nombre);
        setPrecioUnitario(precioUnitario);
        setExistencias(existencias);
        unidadesVendidasEnCadaMes = new int[12];
    }

     public String unidadesMensualesToString() {
        String[] meses = {"Ene.", "Feb.", "Mar.", "Abr.", "May.", "Jun.", "Jul.", "Ago.", "Sep.", "Oct.", "Nov.", "Dic."};
        String salida = "";
        for (int i = 0; i < unidadesVendidasEnCadaMes.length; i++) {
            salida += meses[i] + ": " + unidadesVendidasEnCadaMes[i] + " / ";
        }
        salida += "\n";
        return salida;
    }
     
    public double[] importesMensuales(){
        double[] importesMensuales = new double[12];
        for(int i = 0; i< unidadesVendidasEnCadaMes.length; i++)
            importesMensuales[i]=unidadesVendidasEnCadaMes[i]*precioUnitario;
        
        return importesMensuales;
     
    } 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int[] getUnidadesVendidasEnCadaMes() {
        return unidadesVendidasEnCadaMes;
    }

    public int getUnidadesVendidasEnUnMes(int mes) {
        return unidadesVendidasEnCadaMes[mes];
    }

    public void setUnidadesVendidasEnUnMes(int mes, int unidades) {
        unidadesVendidasEnCadaMes[mes] = unidades;
    }

    public String toString() {
        String salida = "Nombre: " + nombre + ", Precio unitario:" + precioUnitario + "  Existencias: " + existencias + "\n";

        return salida;
    }
    
    public  int compareTo(Articulo a){
        return this.nombre.compareTo(a.nombre);
    }
    

}
