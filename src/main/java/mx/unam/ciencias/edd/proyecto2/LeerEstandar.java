package mx.unam.ciencias.edd.proyecto2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class LeerEstandar extends Lectura{

    String s;

    public LeerEstandar(){}

    public String leer(){
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
