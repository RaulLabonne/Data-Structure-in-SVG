package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.Lista;

/** 
 * Clase para poder graficar colecciones de tipo lineal.
 */
public abstract class GraficadorLineal extends Graficador{

    /* Numero de elementos en la colección */
    int elementos;
    /* Lista que contiene los elementos */
    Lista<Integer> lista;
    /* Ancho que tendran nuestros nodos*/
    final int anchoNodo = 90;
    /* Altura que tendran nuestros nodos */
    final int alturaNodo = 60;
    
    /**
     * Regresa, en forma de codigo, la representación grafica de un nodo.
     * @param coordenadaX la posición en el eje X del nodo.
     * @param coordenadaY la posición en el eje Y del nodo.
     * @param cLetraX La posición en el eje X del elemento del nodo.
     * @param cLetraY La posición en el eje Y del elemento del nodo
     * @param indice el indice del elemento del nodo a colocar.
     * @return la representacion grafica de un nodo.
     * 
     */
    public String nodo(int coordenadaX, int coordenadaY, int cLetraX, int cLetraY, int indice) {
        String nodo = String.format("<rect x='%d' y='%d' width='%d' height='%d' fill='white' stroke='black' stroke-width='3' /> \n", coordenadaX, coordenadaY, anchoNodo, alturaNodo);
        nodo += String.format("<text fill='black' font-family='sans-serif' font-size='40' x='%d' y='%d' text-anchor='middle'>%s</text> \n", cLetraX, cLetraY, lista.get(indice));

        return nodo;
    }

}
