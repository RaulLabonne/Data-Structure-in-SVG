package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.Grafica;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.VerticeGrafica;

public class GraficadorGrafica extends Graficador{
    
    private class CoordenadaVertice{
        int vertice;
        double coordenadaX;
        double coordenadaY;

        public CoordenadaVertice(int vertice, double coordenadaX, double coordenadaY){
            this.vertice = vertice;
            this.coordenadaX = coordenadaX;
            this.coordenadaY = coordenadaY;
        }
        public int getVertice(){
            return vertice;
        }
    }
    
    Grafica<Integer> grafica;
    double hoja;
    double radio;
    double circunferencia;
    final double angulo = 360;
    double divisionAngulo;
    Lista<CoordenadaVertice> verticesAgregados;

    public GraficadorGrafica(Grafica<Integer> grafica){
        this.grafica = grafica;
        verticesAgregados = new Lista<>();
        divisionAngulo = angulo/grafica.getElementos();
    }

    private void setHoja(){
        double auxiliar = radio;
        auxiliar = auxiliar + 40;
        hoja = auxiliar * 2;
    }

    private void setRadio(){
        int auxiliar = 60;
        for (int i = 4; i <= grafica.getElementos(); i = i * 2)
            auxiliar = auxiliar + 60;
        radio = auxiliar;
        //double división = angulo / grafica.getElementos();
        //radio = Math.abs((3 * 20) / (2 * Math.sin(Math.toRadians(división/2))));
    }

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
                    if(verticeVecino.get() == coordenadaV.getVertice())
                        strArista += linea(coordenadaV.coordenadaX, coordenadaV.coordenadaY, verticeAgraficar.coordenadaX, verticeAgraficar.coordenadaY);
        }
        return strArista;
    }

    private String graficaVertices(){
        String vertice = "";
        for (CoordenadaVertice coordenadaV : verticesAgregados)
            vertice += vertice(coordenadaV.coordenadaX, coordenadaV.coordenadaY, coordenadaV.vertice);
        return vertice;
    }

    public String vertice(Double coordenadaX, Double coordenadaY, int v){
        String vertice = String.format("\t<circle cx='%f' cy='%f' r='20' stroke='Black' stroke-width='1' fill='White' /> \n", 
                                        coordenadaX, coordenadaY);
        vertice += String.format("\t<text fill='Black' font-family='sans-serif' font-size='20' x='%f' y='%f' text-anchor='middle'>%s</text>\n", 
                                coordenadaX, coordenadaY + 5, v);
        return vertice;
    }

    private int colorRandom(){
        int minimo = 1;
        int maximo = 255;
        int valorRandom  = (int) (Math.random()*maximo-maximo) + minimo;
        return Math.abs(valorRandom);
    }


    @Override public String codigoSVG() {
        setRadio();
        setHoja();
        String svg = "";
        svg += inicio();
        svg += empezarGraficar(hoja, hoja);
        svg += graficaAristas();
        svg += graficaVertices();
        svg += cierre();
        return svg;
    }
    
    @Override public String linea(Double inicioX, Double inicioY, Double finalX, Double finalY){
        return String.format("\t<line x1='%f' y1='%f' x2='%f' y2='%f' stroke='rgb(%d,%d,%d)' stroke-width='3' />\n"
        , inicioX, inicioY, finalX, finalY, colorRandom(), colorRandom(), colorRandom());
    }
}
