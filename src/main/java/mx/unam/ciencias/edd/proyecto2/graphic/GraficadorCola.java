package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.Lista;

/** 
 * Clase para obtener la representación grafica de una cola en codigo svg.
 */
public class GraficadorCola extends GraficadorLineal{

    /* Altura definitiva de la imagen. */
    final int altura = 100;
    /* Ancho de la imagen. */
    int ancho;
    /* Coordenada en el eje Y definitiva para los nodos */
    final int coordenadaY = 20;

    /** 
     * Constructor de la clase
     */
    public GraficadorCola(int elementos, Lista<Integer> lista){
        this.elementos = elementos;
        this.lista = lista;
        //El ancho estara determinado por el número de elementos.
        ancho = 120 * elementos;
        //Para tener un pequeño borde.
        ancho = ancho + 30;
    }

    /**
     * Regresa, en una cadena, el codigo svg que grafica la colección dada.
     * @return el codigo svg que grafica la colección dada.
     */
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

    /** 
     * Nos regresa una flecha que conecta a los nodos.
     */
    @Override public String linea(int inicioX, int inicioY, int finalX, int finalY){
        String flecha = super.linea(inicioX, inicioY, finalX, finalY);
        flecha += String.format("<polygon points='%d,%d %d,%d %d,%d' fill='black'/>",
                                finalX, finalY, finalX - 5, finalY + 5 , finalX - 5 , finalY - 5);
        return flecha;
    }

}
