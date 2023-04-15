package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.VerticeArbolBinario;

/** 
 * Clase para obtener la representación grafica de un arbol AVL en codigo svg.
 */
public class GraficadorAVL extends GraficadorArbol{

    /* Constructor de la clase. */
    public GraficadorAVL(ArbolAVL<Integer> ab, int elementos) {
        super(ab, elementos);
    }

    /**
     * Regresa, en forma de codigo , la representación grafica de un vertice AVL.
     * @param coordenadaX coordenada en el eje X del centro del vertice.
     * @param coordenadaY coordenada en el eje Y del centro del vertice.
     * @param v el vertice a graficar.
     * @param color el color del vertice.
     * @param letra el color de la letra.
     * @return la representación grafica de un vertice.
     */
    @Override public String vertice(Double coordenadaX, Double coordenadaY, VerticeArbolBinario<Integer> v, String color, String letra){
        String verticeAVL = super.vertice(coordenadaX, coordenadaY, v, color, letra);
        verticeAVL += balanceVertice(coordenadaX, coordenadaY, v, letra);

        return verticeAVL;
    }

    /**
     * Regresa, en forma de codigo, la representación grafica del balance de un vertice.
     * @param coordenadaX coordenada en el eje X del balance.
     * @param coordenadaY coordenada en el eje Y del balance.
     * @param v el vertice a sacar el balance.
     * @param letra color de la letra.
     * @return la representación grafica del balance de un vertice.
     */
    private String balanceVertice(Double coordenadaX, Double coordenadaY, VerticeArbolBinario<Integer> v, String letra){
        String balances = String.format("\t<text fill='%s' font-family='sans-serif' font-size='15' x='%f' y='%f' text-anchor='middle'>%s</text>\n", 
                                        letra, coordenadaX + 7, coordenadaY - 25, balanceStr(v));
        if(v == ab.raiz()){
            balances = String.format("\t<text fill='%s' font-family='sans-serif' font-size='15' x='%f' y='%f' text-anchor='middle'>%s</text>\n", 
                                    letra, coordenadaX, coordenadaY - 25, balanceStr(v));
        }else if (v.padre().hayIzquierdo())
            if(v == v.padre().izquierdo())
                balances = String.format("\t<text fill='%s' font-family='sans-serif' font-size='15' x='%f' y='%f' text-anchor='middle'>%s</text>\n", 
                                    letra, coordenadaX - 7, coordenadaY - 25, balanceStr(v));
        else if (v.padre().hayDerecho())
            if(v == v.padre().derecho())
                balances = String.format("\t<text fill='%s' font-family='sans-serif' font-size='15' x='%f' y='%f' text-anchor='middle'>%s</text>\n", 
                                    letra, coordenadaX + 7, coordenadaY - 25, balanceStr(v));
        return balances;
    }
    
    /** 
     * Regresa en una cadena el balance del vertice dado.
     * @param vAVL el vertice a obtener su balance.
     * @return el balance del vertice dado.
     */
    private String balanceStr(VerticeArbolBinario<Integer> vAVL){
        return String.format("[%d/%d]", vAVL.altura(), balance(vAVL));
    }

    /**
     * Regresa el balance del vertice.
     * @param vAVL el vertice a obtener su balance.
     * @return el balance del vertice.
     */
    private int balance(VerticeArbolBinario<Integer> vAVL){
        int alturaIzq = vAVL.hayIzquierdo() ? vAVL.izquierdo().altura() : 1;
        int alturaDer = vAVL.hayDerecho() ? vAVL.derecho().altura() : 1;
        return alturaIzq - alturaDer;
    }
}
