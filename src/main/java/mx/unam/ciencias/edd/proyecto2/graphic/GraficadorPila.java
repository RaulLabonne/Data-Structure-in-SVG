package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.Lista;

/** 
 * Clase para obtener la representación grafica de una pila en codigo svg.
 */
public class GraficadorPila extends GraficadorLineal{
    
    /* La altura de la imagen */
    int altura;
    /* El ancho definitivo de la imagen */
    final int ancho = 150;
    /* La coordenada en el eje X definitiva del nodo */
    final int coordenadaX = 30;

    /* Constructor de la clase */
    public GraficadorPila(int elementos, Lista<Integer> lista){
        this.elementos = elementos;
        this.lista = lista;
        //La altura estará determinada por el número de elementos.
        altura = 60 * elementos;
        //Para tener un pequeño borde.
        altura = altura + 40;
    }

    /**
     * Regresa, en una cadena, el codigo svg que grafica la colección dada.
     * @return el codigo svg que grafica la colección dada.
     */
    @Override public String codigoSVG(){
        String svg = "";
        svg += inicio();
        svg += empezarGraficar(ancho, altura);
        int auxiliar = 20;
        for (int i = 0; i < elementos; i++){
            svg += nodo(coordenadaX, auxiliar, 75 , auxiliar + 40, i);
            auxiliar = auxiliar + 60;
        }
        svg += cierre();
        return svg;
    }


}
