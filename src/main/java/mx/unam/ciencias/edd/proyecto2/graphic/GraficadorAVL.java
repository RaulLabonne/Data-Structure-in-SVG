package mx.unam.ciencias.edd.proyecto2.graphic;

import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.VerticeArbolBinario;

public class GraficadorAVL extends GraficadorArbol{

    public GraficadorAVL(ArbolAVL<Integer> ab, int elementos) {
        super(ab, elementos);
    }

    @Override public String vertice(Double coordenadaX, Double coordenadaY, VerticeArbolBinario<Integer> v, String color, String letra){
        String verticeAVL = super.vertice(coordenadaX, coordenadaY, v, color, letra);
        verticeAVL += balanceVertice(coordenadaX, coordenadaY, v, color, letra);

        return verticeAVL;
    }

    private String balanceVertice(Double coordenadaX, Double coordenadaY, VerticeArbolBinario<Integer> v, String color, String letra){
        String balances = String.format("\t<text fill='%s' font-family='sans-serif' font-size='15' x='%f' y='%f' text-anchor='middle'>%s</text>\n", 
                                        letra, coordenadaX + 7, coordenadaY - 25, balanceStr(v));
        if(v == ab.raiz()){
            balances = String.format("\t<text fill='%s' font-family='sans-serif' font-size='15' x='%f' y='%f' text-anchor='middle'>%s</text>\n", 
                                    letra, coordenadaX, coordenadaY - 25, balanceStr(v));
        }else if (v.padre().hayIzquierdo())
            if(v == v.padre().izquierdo())
                balances = String.format("\t<text fill='%s' font-family='sans-serif' font-size='15' x='%f' y='%f' text-anchor='middle'>%s</text>\n", 
                                    letra, coordenadaX - 7, coordenadaY - 25, balanceStr(v));
        else if (v.padre().hayDerecho())
            if(v == v.padre().derecho())
                balances = String.format("\t<text fill='%s' font-family='sans-serif' font-size='15' x='%f' y='%f' text-anchor='middle'>%s</text>\n", 
                                    letra, coordenadaX + 7, coordenadaY - 25, balanceStr(v));
        return balances;
    }
    
    private String balanceStr(VerticeArbolBinario<Integer> vAVL){
        return String.format("[%d/%d]", vAVL.altura(), balance(vAVL));
    }

    private int balance(VerticeArbolBinario<Integer> vAVL){
        int alturaIzq = vAVL.hayIzquierdo() ? vAVL.izquierdo().altura() : 1;
        int alturaDer = vAVL.hayDerecho() ? vAVL.derecho().altura() : 1;
        return alturaIzq - alturaDer;
        //altura(vAVL.izquierdo()) - altura(vAVL.derecho());
    }
}
