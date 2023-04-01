package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.proyecto2.graphic.Graficador;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Entrada {
    
    String archivo;
    ColeccionYDatos informacion;
    Lista<Integer> lista;
    TipoColeccion coleccion;

    public Entrada(String archivo){
        this.archivo = archivo;
        lista = new Lista<>();
        informacion = new ColeccionYDatos(archivo);
        informacion.setElementos();
        informacion.setTipos();
        coleccion = TipoColeccion.getColeccion(informacion.getTipo());
    }

    public void setNumeros(){
        for (int i = 0; i < informacion.getElementos().length; i++){
            try {
                int n = Integer.parseInt(informacion.elementos[i]);
                lista.agrega(n);
            } catch (NumberFormatException e) {
                System.out.println("Los elementos deben ser todos números enteros");
                System.exit(1);
            }
        }
    }

    public Lista<Integer> getNumeros(){
        return lista;
    }

    public TipoColeccion getColeccion(){
        return coleccion;
    }


    public void ejecuta(){
        setNumeros();
        ColeccionGrafica dibujar = new ColeccionGrafica(lista, coleccion);
        String s = dibujar.codigoSVG();
        dibujar(s);
    }

    private void dibujar(String codigo) {
        try{
            BufferedWriter out = 
                new BufferedWriter(
                    new OutputStreamWriter(
                        new FileOutputStream(coleccion + ".svg")));
            out.write(codigo);
            out.close();
        } catch (IOException ioe){}
    }
}
