package mx.unam.ciencias.edd.proyecto2;


public abstract class Lectura {
    
    public abstract String leer();

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
