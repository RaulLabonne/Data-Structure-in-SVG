package mx.unam.ciencias.edd.proyecto2;

public class ColeccionYDatos {
    
    String[] elementos;
    String tipo;
    String[] arreglo;

    public ColeccionYDatos(String archivo){
        arreglo = archivo.split(" ");
    }

    public void setElementos(){
        elementos = new String[arreglo.length - 1];
        for (int i = 1; i < arreglo.length; i++)
            elementos[i-1] = arreglo[i];
    }
    
    public String[] getElementos(){
        return elementos;
    }

    public void setTipos(){
        tipo = arreglo[0];
    }

    public String getTipo(){
        return tipo;
    }

}
