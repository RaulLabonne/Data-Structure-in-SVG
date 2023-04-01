package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.Lista;

public class GraficadorCola extends GraficadorLineal{

    final int altura = 100;
    int ancho;
    final int coordenadaY = 20;

    public GraficadorCola(int elementos, Lista<Integer> lista){
        this.elementos = elementos;
        this.lista = lista;
        ancho = 120 * elementos;
        ancho = ancho + 30;
    }

    @Override public String codigoSVG(){
        String svg = "";
        svg += inicio();
        svg += empezarGraficar(ancho, altura);
        int auxiliar = 30;
        int inicioFlecha = 0;
        for (int i = 0; i < elementos; i++){
            svg += nodo(auxiliar, coordenadaY, auxiliar + 45, 60, i);
            auxiliar = auxiliar + 120;
            inicioFlecha = inicioFlecha + 120;
            if(inicioFlecha < ancho - 30)
                svg += linea(inicioFlecha, 50, inicioFlecha + 30, 50);
        }
        svg += cierre();
        return svg;
    }

    @Override public String linea(int inicioX, int inicioY, int finalX, int finalY){
        String flecha = super.linea(inicioX, inicioY, finalX, finalY);
        flecha += String.format("<polygon points='%d,%d %d,%d %d,%d' fill='black'/>",
                                finalX, finalY, finalX - 5, finalY + 5 , finalX - 5 , finalY - 5);
        return flecha;
    }

}
