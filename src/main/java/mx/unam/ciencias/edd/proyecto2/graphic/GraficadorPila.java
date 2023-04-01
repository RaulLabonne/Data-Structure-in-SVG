package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.Lista;

public class GraficadorPila extends GraficadorLineal{
    
    int altura;
    final int ancho = 150;
    final int coordenadaX = 30;

    public GraficadorPila(int elementos, Lista<Integer> lista){
        this.elementos = elementos;
        this.lista = lista;
        altura = 60 * elementos;
        altura = altura + 40;
    }

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
