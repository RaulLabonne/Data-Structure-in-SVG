package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.proyecto2.graphic.GraficadorArbol;
import mx.unam.ciencias.edd.proyecto2.graphic.GraficadorCola;
import mx.unam.ciencias.edd.proyecto2.graphic.GraficadorLista;
import mx.unam.ciencias.edd.proyecto2.graphic.GraficadorPila;
import mx.unam.ciencias.edd.proyecto2.graphic.GraficadorRojinegro;

/* 
 * Clase que dada una colección, da el codigo svg para su graficación.
 */
public class ColeccionGrafica {
    
    /* Numero de elementos */
    int elementos;
    /* Lista con los elementos */
    Lista<Integer> lista;
    /* El tipo de colección */
    TipoColeccion coleccion;

    /* Constructor de la clase */
    public ColeccionGrafica(Lista<Integer> lista, TipoColeccion coleccion){
        this.lista = lista;
        this.coleccion = coleccion;
        elementos = lista.getElementos();
    }

    /* 
     * Metodo que dado el tipo de coleccion da el codigo svg en una cadena para 
     * poder ser guardada en un archivo de tipo .svg.
     * Si el tipo de colección es invalido, terminalos el programa.
     */
    public String codigoSVG(){
        String s = "";
        switch (coleccion) {
            case LISTA:
                GraficadorLista gLista = new GraficadorLista(elementos, lista);
                s = gLista.codigoSVG();
                return s;
            case COLA:
                GraficadorCola gCola = new GraficadorCola(elementos, lista.reversa());
                s = gCola.codigoSVG();
                return s;
            case PILA:
                GraficadorPila gPila = new GraficadorPila(elementos, lista.reversa());
                s = gPila.codigoSVG();
                return s;
            case ARBOLBINARIO_ORDENADO:
                ArbolBinarioOrdenado<Integer> aOrdenado = new ArbolBinarioOrdenado<>(lista);
                GraficadorArbol gAOrdenado = new GraficadorArbol(aOrdenado, elementos);
                s = gAOrdenado.codigoSVG();
                return s;
            case ARBOLBINARIO_COMPLETO:
                ArbolBinarioCompleto<Integer> aCompleto = new ArbolBinarioCompleto<>(lista);
                GraficadorArbol gACompleto = new GraficadorArbol(aCompleto, elementos);
                s = gACompleto.codigoSVG();
                return s;
            case ARBOLBINARIO_ROJINEGRO:
                ArbolRojinegro<Integer> rojinegro = new ArbolRojinegro<>(lista);
                GraficadorRojinegro gRojinegro = new GraficadorRojinegro(rojinegro, elementos);
                s = gRojinegro.codigoSVG();
                return s;
            case ARBOLBINARIO_AVL:
                ArbolAVL avl = new ArbolAVL<>(lista);
                return "";
            // Si el tipo de colección es invalido.
            default:
                System.out.println("Tipo de colección no disponible, favor de verificar que su tipo de colección este bien escrito o que se encuentre en la siguiente lista.\n" +
                "Tipos de datos disponibles:\n" + "\tLista\n \tCola\n \tPila\n \tArbolBinarioOrdenado\n \tArbolBinarioCompleto\n \tArbolRojinegro\n \tArbolAVL\n");
                System.exit(1);
                return s; 
        }
    }

}
