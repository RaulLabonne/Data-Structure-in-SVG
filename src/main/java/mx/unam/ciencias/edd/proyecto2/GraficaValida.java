package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Grafica;
import mx.unam.ciencias.edd.Lista;

/** 
 * Clase para crear graficas
 */
public class GraficaValida {
    
    /* Los elementos a poner en la grafica */
    Lista<Integer> lista;
    /* La cantidad de elementos */
    int elementos;
    /* La grafica a regresar */
    Grafica<Integer> grafica;
    
    /* Constructor de la clase */
    public GraficaValida(Lista<Integer> lista, int elementos){
        this.lista = lista;
        System.out.println(lista);
        this.elementos = elementos;
        grafica = new Grafica<>();
        setGrafica();
    }

    /** 
     * Metodo que crea una grafica a partir de una lista.
     * Cada par de elementos sera una arista, si el elemento ya 
     * esta en la grafica solo conectamos con el otro elemento,
     * si ambos estan solo conectamos.
     */
    public void setGrafica(){
        for (Integer elemento : lista)
            if(!grafica.contiene(elemento))
                grafica.agrega(elemento);
        for (int i = 0; i < lista.getElementos(); i += 2){
            if (lista.get(i) == lista.get(i + 1)){
                continue;
            }
            if (!grafica.sonVecinos(lista.get(i), lista.get(i + 1)))
                grafica.conecta(lista.get(i), lista.get(i + 1));
        }
    }

    /**
     * Metodo que nos regresa la grafica construida.
     * @return la grafica construida.
     * 
     */
    public Grafica<Integer> getGrafica(){
        return grafica;
    }
}