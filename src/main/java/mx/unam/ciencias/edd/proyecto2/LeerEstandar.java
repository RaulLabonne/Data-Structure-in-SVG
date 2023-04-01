package mx.unam.ciencias.edd.proyecto2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/** 
 * Clase para la leer archivos desde la entrada estandar
 */
public class LeerEstandar extends Lectura{

    /* Constructor de la clase, solo es para poder llamar a su unico metodo */
    public LeerEstandar(){}

    /** 
     * Metodo para obtener en una cadena la colección y sus elementos en un formato
     * aceptable para el demas procesos.
     */
    @Override public String leer(){
        String coleccion = "";
        try{
            BufferedReader br =
            new BufferedReader(
                new InputStreamReader(System.in));
            String s;
            while ((s = br.readLine()) != null){
                coleccion += caracteres(s);
            }
            coleccion = coleccion.trim();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
        return coleccion;
    }
}
