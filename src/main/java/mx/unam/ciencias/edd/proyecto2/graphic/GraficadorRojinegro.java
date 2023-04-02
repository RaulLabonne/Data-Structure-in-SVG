package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.ArbolRojinegro;

/** 
 * Clase para obtener la representación grafica de un arbol rojinegro en codigo svg.
 */
public class GraficadorRojinegro extends GraficadorArbol{

    /* Constructor de la clase */
    public GraficadorRojinegro(ArbolRojinegro<Integer> aRn, int elementos) {
        super(aRn, elementos);
    }
}
