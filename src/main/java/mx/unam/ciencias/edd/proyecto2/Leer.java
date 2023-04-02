package mx.unam.ciencias.edd.proyecto2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * Clase para leer archivos
 */
public class Leer extends Lectura{

    /* El archivo a leer */
    String archivo;

    /* Constuctor de la clase */
    public Leer(String archivo){
        this.archivo = archivo;
    }

    /** 
     * Metodo para obtener en una cadena la colección y sus elementos en un formato
     * aceptable para el demas procesos.
     */
    public String leer(){
        String coleccion = "";
        try {
            BufferedReader in =
            new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(archivo)));
            String line;
            while ((line = in.readLine()) != null)
                coleccion += caracteres(line);
            coleccion = coleccion.trim();
            in.close();
            } catch (IOException e){
                System.out.println("Error al leer el archivo " + archivo);
                System.exit(1);
            }
        return coleccion;
    }
}
