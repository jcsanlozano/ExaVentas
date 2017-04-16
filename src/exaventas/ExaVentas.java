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
public class ExaVentas {
// modificacion git
    // static ArrayList<Articulo> articulos;
    static Articulos articulos;
    static Ventas ventas;
    static int numero;
    static int n2;

    public static void main(String[] args) {
        generaListaArticulos();
        System.out.println("listado articulos:\n" + articulos.toString());
        ventas = new Ventas();
        leerVentas();

        System.out.println("ListadoVentas");
        System.out.println(ventas.toString());

        actualizaArticulosConVentas();

        System.out.println("ListadoVentas");
        System.out.println(ventas.toString());

        System.out.println("listado articulos:\n" + articulos.toString());
        articulos.actualizaTotalUnidadesVendidasPorMes();

        System.out.println("totalUnidadesVendidasPorMes");
        System.out.println(articulos.totalUnidadesVendidasPorMesToString());
        
        articulos.getListaArticulos().sort(null);
        System.out.println("listado articulos por nombre:\n" + articulos.toString());
        

    }

    static void generaListaArticulos() {
        articulos = new Articulos();
        Articulo articulo;
        articulo = new Articulo("alcachofas", 2.5, 10);
        articulos.insertaArticulo(articulo);
        articulo = new Articulo("tomate", 1.5, 15);
        articulos.insertaArticulo(articulo);
        articulo = new Articulo("anchoas", 4.5, 10);
        articulos.insertaArticulo(articulo);
        articulo = new Articulo("atun", 1.75, 20);
        articulos.insertaArticulo(articulo);
        articulo = new Articulo("aceitunas", 1.9, 20);
        articulos.insertaArticulo(articulo);
        articulo = new Articulo("sardinas", 160, 25);
        articulos.insertaArticulo(articulo);

    }

    static void leerVentas() {

        Articulo articulo;
        String fecha;
        int unidades;
        String nombreArticulo;
        nombreArticulo = Leer.cadena("Teclee el nombre del artículo (\"0\" = fin): ");
        while (nombreArticulo.compareTo("0") != 0) {
            articulo = articulos.buscaArticulo(nombreArticulo);
            if (articulo != null) {
                fecha = Leer.cadena("Teclee la fecha: (dd-mm-aaaa):");
                unidades = Leer.entero("Tecleee unidades: ");
                ventas.insertaVenta(new Venta(fecha, articulo, unidades));
                System.out.println("Venta añadida");
            } else {
                System.out.println("El articulo no existe.");
            }

            nombreArticulo = Leer.cadena("Teclee el nombre del artículo (\"0\" = fin): ");
        }

    }

    static void actualizaArticulosConVentas() {
        Articulo arti;
        int mes;
        for (Venta v : ventas.getVentas()) {
            arti = articulos.buscaArticulo(v.getArticulo().getNombre());
            if (!v.isServida()) {
                if (arti.getExistencias() >= v.getUnidades()) {
                    arti.setExistencias(arti.getExistencias() - v.getUnidades());
                    v.setServida(true);
                    mes = Integer.parseInt(v.getFecha().substring(3, 5)) - 1;
                    arti.setUnidadesVendidasEnUnMes(mes, arti.getUnidadesVendidasEnUnMes(mes) + v.getUnidades());
                }
            }
        }

    }

}
