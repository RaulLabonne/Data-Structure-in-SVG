package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.ArbolBinario;
import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.Color;
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
    /* El color de la letra */
    String colorLetra;

    /* Constructor de la clase */
    public GraficadorArbol(ArbolBinario<Integer> ab, int elementos){
        this.ab = ab;
        this.elementos = elementos;
        alturaArbol = ab.altura();
        //La altura de la imagen dependera de la altura del arbol.
        altura = alturaArbol * distancia;
        //Para tener un pequeño borde.
        altura = altura + 80;
        codigo = "";
    }

    /** 
     * Metodo que establece el ancho de la imagen.
     */
    public void setAncho(){
        if (elementos == 1 || elementos == 0){
            ancho = 120;
            return;
        }
        //El ancho de la imagen dependera de la rama más larga del arbol.
        int auxiliar = Math.max(ramaIzquierda(), ramaDerecha());
        //La distancia entre el ultimo vertice de la rama y el borde.
        int base = 20;
        for (int i = 0; i <= auxiliar; i++){
            base = base * 2;
        }
        //Para tener un borde.
        base = base + 40;
        //Multuplicamos por dos para el ancho total de la imagen.
        ancho = base * 2;
    }

    /** 
     * Regresa el número de vertices que hay en la rama izquierda de la raiz.
     * @return el número de vertices que hay en la rama izquierda de la raiz.
     */
    private int ramaIzquierda(){
        int ramaIz = 0;
        VerticeArbolBinario<Integer> v = ab.raiz();
        while (v.hayIzquierdo()){
            ramaIz++;
            v = v.izquierdo();
        }
        return ramaIz;
    }

    /** 
     * Regresa el número de vertices que hay en la rama derecha de la raiz.
     * @return el número de vertices que hay en la rama derecha de la raiz.
     */
    private int ramaDerecha(){
        int ramaDr = 0;
        VerticeArbolBinario<Integer> v = ab.raiz();
        while (v.hayDerecho()){
            ramaDr++;
            v = v.derecho();
        }
        return ramaDr;
    }

    /** 
     * Regresa la mitad del ancho actual.
     * @return la mitad del ancho actual.
     */
    private double mitad(double anchoActual){
        return anchoActual/2;
    }

    /** 
     * Dada la profundidad del vertice, regresa la constante para poder obtener su coordenada en el eje X.
     * @param profundidad la profundidad del vertice.
     * @return la constante para poder obtener su coordenada en el eje X.
     */
    private double coordenadaX(int profundidad){
        double auxiliar = mitad(ancho);
        for (int i = 0; i <= profundidad; i++){
            auxiliar = mitad(auxiliar);
        }
        return auxiliar;
    }

    /**
     * Metodo que dibuja, en codigo svg, las aristas del arbol. Recorre el arbol en DFS-InOrder.
     * @param v el vertice a conectar.
     * @param coordenadaX la coordenada en el eje X para poder definir donde empieza y donde termina.
     * @param coordenadaY la coordenada en el eje Y para poder definir donde empieza y donde termina.
     */
    private void dibujaAristas(VerticeArbolBinario<Integer> v, Double coordenadaX, Double coordenadaY){
        //Clausula de escape
        if(!v.hayIzquierdo() && !v.hayDerecho()){
            return;
        }
        //Si hay izquierdo, conectamos el vertice actual con su izquierdo.
        if (v.hayIzquierdo()){
            codigo += linea(coordenadaX, coordenadaY , coordenadaX - coordenadaX(v.profundidad()), coordenadaY + 120);
            dibujaAristas(v.izquierdo(), coordenadaX - coordenadaX(v.profundidad()), coordenadaY + 120);
        }
        //Si hay derecho, conectamos el vertice actual con su izquierdo.
        if (v.hayDerecho()){
            codigo += linea(coordenadaX, coordenadaY , coordenadaX + coordenadaX(v.profundidad()), coordenadaY + 120);
            dibujaAristas(v.derecho(), coordenadaX + coordenadaX(v.profundidad()), coordenadaY + 120);
        }
    }

    /**
     * Metodo que dibuja, en codigo svg, los vertices del arbol. Recorre el arbol en DFS-InOrder.
     * @param v el vertice a dibujar.
     * @param coordenadaX la coordenada en el eje X del vertice.
     * @param coordenadaY la coordenada en el eje Y del vertice.
     * @param color el color del vertice.
     * @param colorLetra el color del elemento del vertice.
     * 
     */
    private void dibujaVertices(VerticeArbolBinario<Integer> v, Double coordenadaX, Double coordenadaY, String color, String colorLetra){
        //Clausula de escape.
        if(!v.hayIzquierdo() && !v.hayDerecho()){
            //Dibujamos el vertice y terminamos.
            this.codigo += vertice(coordenadaX, coordenadaY, v, color(v), colorLetra);
            return;
        }
        if (v.hayIzquierdo())
            dibujaVertices(v.izquierdo(), coordenadaX - coordenadaX(v.profundidad()), coordenadaY + 120, color(v.izquierdo()), colorLetra);
        this.codigo += vertice(coordenadaX, coordenadaY, v, color, colorLetra);
        if (v.hayDerecho())
            dibujaVertices(v.derecho(), coordenadaX + coordenadaX(v.profundidad()), coordenadaY + 120, color(v.derecho()), colorLetra);
    }

    /**
     * Regresa, en una cadena, el codigo svg que grafica el arbol dado.
     * @return el codigo svg que grafica el arbol dado.
     */
    @Override public String codigoSVG(){
        setAncho();
        dibujaAristas(ab.raiz(), mitad(ancho), 40.0);
        dibujaVertices(ab.raiz(), mitad(ancho), 40.0, color(ab.raiz()), colorLetra);
        String svg = "";
        svg += inicio();
        svg += empezarGraficar(ancho, altura);
        svg += codigo;
        svg += cierre();
        return svg;
    }

    /**
     * Regresa, en forma de codigo , la representación grafica de un vertice.
     * @param coordenadaX coordenada en el eje X del centro del vertice.
     * @param coordenadaY coordenada en el eje Y del centro del vertice.
     * @param v el vertice a graficar.
     * @param color el color del vertice.
     * @param letra el color de la letra.
     * @return la representación grafica de un vertice.
     */
    public String vertice(Double coordenadaX, Double coordenadaY, VerticeArbolBinario<Integer> v, String color, String letra){
            String vertice = String.format("\t<circle cx='%f' cy='%f' r='20' stroke='Black' stroke-width='1' fill='%s' /> \n", 
                                            coordenadaX, coordenadaY, color);
            vertice += String.format("\t<text fill='%s' font-family='sans-serif' font-size='20' x='%f' y='%f' text-anchor='middle'>%s</text>\n", 
                                    letra, coordenadaX, coordenadaY + 5, v.get());
            return vertice;
    }

    /** 
     * Regresa el color que tendra el vertice y asigna el color de la letra.
     * Solo cambiara si el arbol es un arbol rojinegro.
     * @param v el vertice a colorear.
     * @return el color que tendra el vertice.
     */
    public String color(VerticeArbolBinario<Integer> v){
        if (!(ab instanceof ArbolRojinegro)){
            colorLetra = "Black";
            return "White";
        }
        else{
            colorLetra = "White";
            Color color = ((ArbolRojinegro<Integer>) ab).getColor(v);
            if(color == Color.ROJO)
                return "Red";
            else
                return "Black";
        }
    }

}
