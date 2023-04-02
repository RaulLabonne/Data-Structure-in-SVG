package mx.unam.ciencias.edd.proyecto2;

/** 
 * Clase abstracta para poder leer archivos desde diferentes entradas
 */
public abstract class Lectura {
    
    /** 
     * Metodo para obtener en una cadena la colección y sus elementos en un formato
     * aceptable para el demas procesos.
     */
    public abstract String leer();

    /** 
     * Metodo que dada una cadena, lo limpia y quita cualquier caracter especial que 
     * podria tener para su proceso.
     * @param linea la cadena a limpiar.
     */
    public static String caracteres(String linea){
        linea = linea.trim();
        if(linea.contains("#") || linea.isEmpty())
            return "";
        linea = linea.replace("\t", " ");
        linea = linea.replace("\n", " ");
        String espacio = " ";
        espacio += linea;
        return espacio;
    }

}
