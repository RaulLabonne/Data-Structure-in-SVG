package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.Lista;

public class GraficadorLista extends GraficadorCola{

    public GraficadorLista(int elementos, Lista<Integer> lista) {
        super(elementos, lista);
    }
    @Override public String linea(int inicioX, int inicioY, int finalX, int finalY){
        String dobleflecha= super.linea(inicioX, inicioY, finalX, finalY);
        dobleflecha += String.format("<polygon points='%d,%d %d,%d %d,%d' fill='black'/>",
                                    inicioX, inicioY, inicioX + 5, inicioY + 5 , inicioX + 5 , inicioY - 5);
        return dobleflecha;
    }
}
