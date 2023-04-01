package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.Lista;

public abstract class GraficadorLineal extends Graficador{

    int elementos;
    Lista<Integer> lista;
    final int anchoNodo = 90;
    final int alturaNodo = 60;
    
    public String nodo(int coordenadaX, int coordenadaY, int cLetraX, int cLettraY, int indice) {
        String nodo = String.format("<rect x='%d' y='%d' width='%d' height='%d' fill='white' stroke='black' stroke-width='3' /> \n", coordenadaX, coordenadaY, anchoNodo, alturaNodo);
        nodo += String.format("<text fill='black' font-family='sans-serif' font-size='40' x='%d' y='%d' text-anchor='middle'>%s</text> \n", cLetraX, cLettraY, lista.get(indice));

        return nodo;
    }

}
