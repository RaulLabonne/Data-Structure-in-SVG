package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.Grafica;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.VerticeGrafica;

/** 
 * Clase para obtener la representación grafica de una grafica en codigo svg.
 */
public class GraficadorGrafica extends Graficador{
    
    /* Clase interna privada para guardar las coordenadas de los vertices */
    private class CoordenadaVertice{

        /* El elemento del vertice */
        int vertice;
        /* La coordenada en el eje X del vertice */
        double coordenadaX;
        /* La coordenada en el eje X del vertice */
        double coordenadaY;

        /* Constructor de la clase */
        public CoordenadaVertice(int vertice, double coordenadaX, double coordenadaY){
            this.vertice = vertice;
            this.coordenadaX = coordenadaX;
            this.coordenadaY = coordenadaY;
        }
    }
    
    /* Grafica a graficar */
    Grafica<Integer> grafica;
    /* El tamaño de la hoja */
    double hoja;
    /* El radio del circulo */
    double radio;
    /* Nuestra constante que es el grado de un circulo */
    final double angulo = 360;
    /* Los grados de distancia de vertice a vertice */
    double divisionAngulo;
    /* Los vertices que ya tienen coordenadas */
    Lista<CoordenadaVertice> verticesAgregados;

    /* Constructor de la clase */
    public GraficadorGrafica(Grafica<Integer> grafica){
        this.grafica = grafica;
        verticesAgregados = new Lista<>();
        divisionAngulo = angulo/grafica.getElementos();
        setRadio();
        setHoja();
    }

    /** 
     * Metodo que dado el radio de la circunferencia, obtiene el ancho y alto de la hoja
     */
    private void setHoja(){
        double auxiliar = radio;
        auxiliar = auxiliar + 40;
        hoja = auxiliar * 2;
    }

    /** 
     * Metodo que dado la cantidad de elementos, establece el radio de la circunferencia
     */
    private void setRadio(){
        int auxiliar = 60;
        int contador = 1;
        for (int i = 4; i <= grafica.getElementos(); i = i * 2)
            auxiliar = auxiliar + (60 * contador++);
        radio = auxiliar;
    }

    /**
     * Metodo que establece las coordenadas para todo vertice para poder obtener en codigo svg las
     * coordenadas necesarias para obtener en codigo svg, las arista que conectan a los vertices.
     * @return el codigo svg de las aristas que conectan a los vertices
     * 
     */
    private String graficaAristas(){
        String strArista = "";
        double anguloVertice = 0;
        Lista<VerticeGrafica<Integer>> vertices = new Lista<>();
        grafica.paraCadaVertice((v) -> vertices.agrega(v));
        for (VerticeGrafica<Integer> vertice : vertices) {
            double coordenadaX = radio * Math.cos(Math.toRadians(anguloVertice));
            double coordenadaY = radio * Math.sin(Math.toRadians(anguloVertice));
            coordenadaX = coordenadaX + hoja/2;
            coordenadaY = coordenadaY + hoja/2;
            anguloVertice += divisionAngulo;
            CoordenadaVertice verticeAgraficar = new CoordenadaVertice(vertice.get(), coordenadaX, coordenadaY);
            verticesAgregados.agrega(verticeAgraficar);
            for (VerticeGrafica<Integer> verticeVecino : vertice.vecinos())
                for (CoordenadaVertice coordenadaV : verticesAgregados) 
                    if(verticeVecino.get() == coordenadaV.vertice)
                        strArista += linea(coordenadaV.coordenadaX, coordenadaV.coordenadaY, verticeAgraficar.coordenadaX, verticeAgraficar.coordenadaY);
        }
        return strArista;
    }

    /**
     * Metodo que regresa en codigo svg, los vertice de la grafica.
     * @return  los vertices de la grafica.
     * 
     */
    private String graficaVertices(){
        String vertice = "";
        for (CoordenadaVertice coordenadaV : verticesAgregados)
            vertice += vertice(coordenadaV.coordenadaX, coordenadaV.coordenadaY, coordenadaV.vertice);
        return vertice;
    }

    /**
     * Regresa, en forma de codigo , la representación grafica de un vertice.
     * @param coordenadaX coordenada en el eje X del centro del vertice.
     * @param coordenadaY coordenada en el eje Y del centro del vertice.
     * @param v el vertice a graficar.
     * @return la representación grafica de un vertice.
     */
    public String vertice(Double coordenadaX, Double coordenadaY, int v){
        String vertice = String.format("\t<circle cx='%f' cy='%f' r='20' stroke='Black' stroke-width='1' fill='White' /> \n", 
                                        coordenadaX, coordenadaY);
        vertice += String.format("\t<text fill='Black' font-family='sans-serif' font-size='20' x='%f' y='%f' text-anchor='middle'>%s</text>\n", 
                                coordenadaX, coordenadaY + 5, v);
        return vertice;
    }

    /**
     * Metodo que genera numeros aleatorios de 1 a 255 para hacer colores rgb.
     * @return un numero aleatorio de 1 a 255.
     * 
     */
    private int colorRandom(){
        int minimo = 1;
        int maximo = 255;
        int valorRandom  = (int) (Math.random()*maximo-minimo) + minimo;
        return Math.abs(valorRandom);
    }

    /**
     * Regresa, en una cadena, el codigo svg que grafica la coleccion dada.
     * @return el codigo svg que grafica la colección dada.
     */
    @Override public String codigoSVG() {
        String svg = "";
        svg += inicio();
        svg += empezarGraficar(hoja, hoja);
        svg += graficaAristas();
        svg += graficaVertices();
        svg += cierre();
        return svg;
    }
    
    /**
     * Regresa, en forma de codigo, una linea que conectara los nodos o vertices con colores aleatorios.
     * de la colección para su graficación.
     * @param inicioX la coordenada en el eje X de donde empieza.
     * @param inicioY la coordenada en el eje Y de donde empieza.
     * @param finalX la coordenada en el eje X de donde termina.
     * @param finalY la coordenada en el eje Y de donde termina.
     * @return una linea que conectara los nodos o vertices de la colección para su graficación.
     */
    @Override public String linea(Double inicioX, Double inicioY, Double finalX, Double finalY){
        return String.format("\t<line x1='%f' y1='%f' x2='%f' y2='%f' stroke='rgb(%d,%d,%d)' stroke-width='3' />\n"
        , inicioX, inicioY, finalX, finalY, colorRandom(), colorRandom(), colorRandom());
    }
}
