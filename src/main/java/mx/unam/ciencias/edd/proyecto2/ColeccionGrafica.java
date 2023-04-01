package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.proyecto2.graphic.GraficadorCola;
import mx.unam.ciencias.edd.proyecto2.graphic.GraficadorLista;
import mx.unam.ciencias.edd.proyecto2.graphic.GraficadorPila;

public class ColeccionGrafica {
    
    int elementos;
    Lista<Integer> lista;
    TipoColeccion coleccion;

    public ColeccionGrafica(Lista<Integer> lista, TipoColeccion coleccion){
        this.lista = lista;
        this.coleccion = coleccion;
        elementos = lista.getElementos();
    }

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
                return "";
            case ARBOLBINARIO_COMPLETO:
                return "";
            case ARBOLBINARIO_ROJINEGRO:
                return "";
            case ARBOLBINARIO_AVL:
                return "";
            default:
            return "";
                /* System.out.println("Tipo de colección no disponible, favor de verificar que su tipo de colección este bien escrito o que se encuentre en la siguiente lista.\n" +
                "Tipos de datos disponibles:\n" + "\tLista\n \tCola\n \tpila\n \tArbolBinarioOrdenado\n \tArbolBinarioCompleto\n \tArbolRojinegro\n \tArbolAVL\n");
                System.exit(1);
                break; */
        }
    }

}
