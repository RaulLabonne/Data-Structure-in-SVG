package mx.unam.ciencias.edd.proyecto2.graphic;

/** 
 * Clase abstracta para poder iniciar un codigo svg
 */
public abstract class Graficador {

    /** 
     * Regresa el codigo para iniciar la graficación.
     * @return el codigo para inicial la graficación.
     */
    public static String inicio(){
        return "<?xml version='1.0' encoding='UTF-8' ?>\n";
    }

    /**
     * Regresa el codigo para terminar el codigo.
     * @return el codigo para terminar el codigo.
     */
    public static String cierre(){
        return "\t</g> \n</svg>";
    }

    /**
     * Regresa el codigo para darle el tamaño necesario para empezar a graficar.
     * @param ancho el ancho de la imagen.
     * @param altura la altura de la imagen.
     * @return el codigo para darle el tamaño necesario para empezar a graficar.
     */
    public static String empezarGraficar(Double ancho, Double altura){
        return String.format("<svg width='%f' height='%f'>\n \t<g>\n", ancho, altura);
    }

    /**
     * Regresa, en forma de codigo, una linea que conectara los nodos o vertices 
     * de la colección para su graficación.
     * @param inicioX la coordenada en el eje X de donde empieza.
     * @param inicioY la coordenada en el eje Y de donde empieza.
     * @param finalX la coordenada en el eje X de donde termina.
     * @param finalY la coordenada en el eje Y de donde termina.
     * @return una linea que conectara los nodos o vertices de la colección para su graficación.
     */
    public String linea(Double inicioX, Double inicioY, Double finalX, Double finalY){
        return String.format("\t<line x1='%f' y1='%f' x2='%f' y2='%f' stroke='black' stroke-width='3' />\n"
                            , inicioX, inicioY, finalX, finalY);
    }

    /**
     * Regresa, en una cadena, el codigo svg que grafica la coleccion dada.
     * @return el codigo svg que grafica la colección dada.
     */
    public abstract String codigoSVG();

}
