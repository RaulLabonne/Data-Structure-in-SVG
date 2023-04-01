package mx.unam.ciencias.edd.proyecto2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Leer extends Lectura{

    String archivo;

    public Leer(String archivo){
        this.archivo = archivo;
    }

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
