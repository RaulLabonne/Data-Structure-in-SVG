package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.Lista;

/* 
 * Clase para obtener la representación grafica de una lista en codigo svg.
 */
public class GraficadorLista extends GraficadorCola{

    /**
     * Constructor de la clase
     */
    public GraficadorLista(int elementos, Lista<Integer> lista) {
        super(elementos, lista);
    }

    /** 
     * Nos regresa una flecha que representa el anterior y siguiente de los nodos.
     */
    @Override public String linea(Double inicioX, Double inicioY, Double finalX, Double finalY){
        String dobleflecha = super.linea(inicioX, inicioY, finalX, finalY);
        dobleflecha += String.format("<polygon points='%f,%f %f,%f %f,%f' fill='black'/>",
                                    inicioX, inicioY, inicioX + 5, inicioY + 5 , inicioX + 5 , inicioY - 5);
        return dobleflecha;
    }
}
