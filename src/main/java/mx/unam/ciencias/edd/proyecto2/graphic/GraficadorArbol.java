package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.ArbolBinario;
import mx.unam.ciencias.edd.VerticeArbolBinario;

/** 
 * Clase para obtener la representación grafica de un arbol binario en codigo svg.
 */
public class GraficadorArbol extends Graficador {

    /* El arbol a graficar */
    ArbolBinario<Integer> ab;
    /* Numero de vertices */
    int elementos;
    /* Altura del arbol */
    int alturaArbol;
    /* Ancho de la imagen */
    int ancho;
    /* Altura de la imagen */
    int altura;
    /* Distancia definitiva entre cada nivel */
    final int distancia = 120;
    /* Un auxiliar para poder usar nuestro metodo recursivo */
    String codigo;


    public GraficadorArbol(ArbolBinario<Integer> ab, int elementos){
        this.ab = ab;
        this.elementos = elementos;
        alturaArbol = ab.altura();
        altura = alturaArbol * distancia;
        altura = altura + 80;
        codigo = "";
    }

    public void setAncho(){
        if (elementos == 1 || elementos == 0){
            ancho = 120;
            return;
        }
        int auxiliar = Math.max(ramaIzquierda(), ramaDerecha());
        int base = 20;
        for (int i = 0; i <= auxiliar; i++){
            base = base * 2;
        }
        base = base + 40;
        ancho = base * 2;
    }

    private int ramaIzquierda(){
        int ramaIz = 0;
        VerticeArbolBinario<Integer> v = ab.raiz();
        while (v.hayIzquierdo()){
            ramaIz++;
            v = v.izquierdo();
        }
        return ramaIz;
    }

    private int ramaDerecha(){
        int ramaDr = 0;
        VerticeArbolBinario<Integer> v = ab.raiz();
        while (v.hayDerecho()){
            ramaDr++;
            v = v.derecho();
        }
        return ramaDr;
    }

    private double mitad(double anchoActual){
        return anchoActual/2;
    }

    private double coordenadaX(int profundidad){
        double auxiliar = mitad(ancho);
        for (int i = 0; i <= profundidad; i++){
            auxiliar = mitad(auxiliar);
        }
        return auxiliar;
    }

    private void dibujarArbol(VerticeArbolBinario<Integer> v, Double coordenadaX, Double coordenadaY, String color, String colorLetra){
        if(!v.hayIzquierdo() && !v.hayDerecho()){
            this.codigo += vertice(coordenadaX, coordenadaY, v, color, colorLetra);
            return;
        }
        if (v.hayIzquierdo()){
            dibujarArbol(v.izquierdo(), coordenadaX - coordenadaX(v.profundidad()), coordenadaY + 120, color, colorLetra);
            codigo += linea(coordenadaX, coordenadaY , coordenadaX - coordenadaX(v.profundidad()), coordenadaY + 120);
        }
        this.codigo += vertice(coordenadaX, coordenadaY, v, color, colorLetra);
        if (v.hayDerecho()){
            codigo += linea(coordenadaX, coordenadaY , coordenadaX + coordenadaX(v.profundidad()), coordenadaY + 120);
            dibujarArbol(v.derecho(), coordenadaX + coordenadaX(v.profundidad()), coordenadaY + 120, color, colorLetra);
        }
    }

    @Override public String codigoSVG(){
        setAncho();
        dibujarArbol(ab.raiz(), mitad(ancho), 40.0, color(), colorLetra());
        String svg = "";
        svg += inicio();
        svg += empezarGraficar(ancho, altura);
        svg += codigo;
        svg += cierre();
        return svg;
    }

    public String vertice(Double coordenadaX, Double coordenadaY, VerticeArbolBinario<Integer> v, String color, String letra){
            String vertice = String.format("<circle cx='%f' cy='%f' r='20' stroke='Black' stroke-width='1' fill='%s' /> \n", 
                                            coordenadaX, coordenadaY, color);
            vertice += String.format("<text fill='%s' font-family='sans-serif' font-size='20' x='%f' y='%f' text-anchor='middle'>%s</text>\n", 
                                    letra, coordenadaX, coordenadaY, v.get());
            return vertice;
    }

    private String color(){
        return "White";
    }

    private String colorLetra(){
        return "Black";
    }

}
