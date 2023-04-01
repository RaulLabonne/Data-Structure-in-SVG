package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.ArbolBinario;
import mx.unam.ciencias.edd.VerticeArbolBinario;

public class GraficadorArbol extends Graficador {

    ArbolBinario<Integer> ab;
    int elementos;
    int ancho;
    int altura;


    public GraficadorArbol(ArbolBinario<Integer> ab, int elementos){
        this.ab = ab;
        this.elementos = elementos;
    }

    @Override public String codigoSVG(){
        return "";
    }

    public String vertice(int coordenadaX, int coordenadaY, VerticeArbolBinario v, String color, String letra){
            String vertice = String.format("<circle cx='%d' cy='%d' r='20' stroke='%d' stroke-width='3' fill='black' /> \n", coordenadaX, coordenadaY, color);
            vertice += String.format("<text fill='%s' font-family='sans-serif' font-size='20' x='%d' y='%d' text-anchor='middle'>%s</text>", 
                                    letra, coordenadaX, coordenadaY, v.get());
            return vertice;
    }

}
