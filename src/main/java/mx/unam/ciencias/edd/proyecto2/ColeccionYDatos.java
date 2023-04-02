package mx.unam.ciencias.edd.proyecto2;

/** 
 * Clase que separa los elementos del tipo de colección para poder
 * ser procesado sin problemas.
 */
public class ColeccionYDatos {
    
    /* Los elementos de la colección */
    String[] elementos;
    /* El tipo de dato abstracto */
    String tipo;
    /* El arreglo recibido */
    String[] arreglo;

    /* Constructor de la clase */
    public ColeccionYDatos(String archivo){
        //Separamos la cadena recibida por espacios
        arreglo = archivo.split(" ");
    }

    /** 
     * Metodo que establece los elementos de la colección,
     * consideramos que todos los elementos son numeros.
     */
    public void setElementos(){
        elementos = new String[arreglo.length - 1];
        for (int i = 1; i < arreglo.length; i++)
            elementos[i-1] = arreglo[i];
    }
    
    /** 
     * Regresa los elementos obtenidos del archivo.
     * @return los elementos obtenidos del archivo.
     */
    public String[] getElementos(){
        return elementos;
    }

    /** 
     * Metodo que establece el tipo de colección, la colección
     * siempre debe estar al inicio del archivo.
     */
    public void setTipos(){
        tipo = arreglo[0];
    }
    
    /** 
     * Regresa el tipo de estructura de dato.
     * @return el tipo de estructura de dato.
     */
    public String getTipo(){
        return tipo;
    }

}
