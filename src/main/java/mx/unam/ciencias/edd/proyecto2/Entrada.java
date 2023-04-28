package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/** 
 * Clase para procesar el archivo para preparar para la graficación.
 * Si no es graficable, termina el programa.
 */
public class Entrada {
    
    /* Unico archivo que recibe el programa */
    String archivo;
    /* Los datos obtenidos del archivo */
    ColeccionYDatos informacion;
    /* Coleccion necesaria para graficar */
    Lista<Integer> lista;
    /* Tiṕo de estructuraa */
    TipoColeccion coleccion;

    /* Constructor de la clase */
    public Entrada(String archivo){
        this.archivo = archivo;
        lista = new Lista<>();
        informacion = new ColeccionYDatos(archivo);
        informacion.setElementos();
        informacion.setTipos();
        coleccion = TipoColeccion.getColeccion(informacion.getTipo());
    }

    /** 
     * Metodo para pasar los elementos del arreglo obtenido del archivo y
     * agregarlos a una lista.
     */
    public void setNumeros(){
        for (int i = 0; i < informacion.getElementos().length; i++){
            if (informacion.elementos[i].isEmpty())
                continue;
            try {
                int n = Integer.parseInt(informacion.elementos[i]);
                lista.agrega(n);
            } catch (NumberFormatException e) {
                System.out.println("Los elementos deben ser todos números enteros");
                System.exit(1);
            }
        }
    }

    /** 
     * Regresa la lista.
     * @return la lista.
     */
    public Lista<Integer> getNumeros(){
        return lista;
    }

    /**
     * Regresa el tipo de estructura de dato.
     * @return el tipo de estructura de dato.
     */
    public TipoColeccion getColeccion(){
        return coleccion;
    }

    /** 
     * Metodo que ejecuta el programa para poder dibujarlo
     * Si es invalido, se termina la ejecución.
     */
    public void ejecuta(){
        setNumeros();
        ColeccionGrafica dibujar = new ColeccionGrafica(lista, coleccion);
        String s = dibujar.codigoSVG();
        dibujar(s);
    }

    /** 
     * Metodo auxiliar que escribe el codigo obtenido en un archivo .svg.
     * @param codigo el codigo svg generado por el programa.
     */
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
