package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.Coleccion;

public abstract class Graficador {

    public static String inicio(){
        return "<?xml version='1.0' encoding='UTF-8' ?>\n";
    }

    public static String cierre(){
        return "\t</g> \n</svg>";
    }

    public static String empezarGraficar(int ancho, int altura){
        return String.format("<svg width='%d' height='%d'>\n \t<g>\n", ancho, altura);
    }

    public String linea(int inicioX, int inicioY, int finalX, int finalY){
        return String.format("\t<line x1='%d' y1='%d' x2='%d' y2='%d' stroke='black' stroke-width='3' />\n"
                            , inicioX, inicioY, finalX, finalY);
    }

    public abstract String codigoSVG();

}
