package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Grafica;
import mx.unam.ciencias.edd.Lista;

public class GraficaValida {
    
    Lista<Integer> lista;
    int elementos;
    Grafica<Integer> grafica;
    
    public GraficaValida(Lista<Integer> lista, int elementos){
        this.lista = lista;
        System.out.println(lista);
        this.elementos = elementos;
        grafica = new Grafica<>();
        setGrafica();
    }

    public void setGrafica(){
        for (Integer elemento : lista)
            if(!grafica.contiene(elemento))
                grafica.agrega(elemento);
        for (int i = 0; i < lista.getElementos(); i ++){
            if (lista.get(i) == lista.get(i + 1)){
                i = i + 1;
                continue;
            }
            if (!grafica.sonVecinos(lista.get(i), lista.get(i + 1)))
                grafica.conecta(lista.get(i), lista.get(i + 1));
            i = i + 1;
        }
    }

    public Grafica<Integer> getGrafica(){
        return grafica;
    }
}

/*  while(!lista.esVacia()){
     int elementoA = lista.eliminaPrimero();
     System.out.println("Agregue " + elementoA);
     int elementoB = lista.eliminaPrimero();
     System.out.println("Agregue " + elementoB);
     if (elementoA == elementoB)
         if(!grafica.contiene(elementoA)){
             grafica.agrega(elementoA);
             System.out.println(elementoA + "en la grafica");
         }
     else{
         if (!grafica.contiene(elementoA)){
             grafica.agrega(elementoA);
             System.out.println(elementoA + "en la grafica");
         }
         if (!grafica.contiene(elementoB)){
             grafica.agrega(elementoB);
             System.out.println(elementoB + "en la grafica");
         }
         if (!grafica.sonVecinos(elementoA, elementoB))
             grafica.conecta(elementoA, elementoB);
     } */