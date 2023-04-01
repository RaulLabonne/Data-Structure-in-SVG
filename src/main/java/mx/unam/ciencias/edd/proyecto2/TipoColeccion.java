package mx.unam.ciencias.edd.proyecto2;

public enum TipoColeccion {
    LISTA,
    COLA,
    PILA,
    ARBOLBINARIO_ORDENADO,
    ARBOLBINARIO_COMPLETO,
    ARBOLBINARIO_ROJINEGRO,
    ARBOLBINARIO_AVL,
    GRAFICA,
    ERROR;


    public static TipoColeccion getColeccion(String coleccion){
        switch(coleccion){
            case "Lista":                   return LISTA;
            case "Cola":                    return COLA;
            case "Pila":                    return PILA;
            case "ArbolBinarioOrdenado":    return ARBOLBINARIO_ORDENADO;
            case "ArbolBinarioCompleto":    return ARBOLBINARIO_ORDENADO;
            case "ArbolRojinegro":          return ARBOLBINARIO_ROJINEGRO;
            case "ArbolAVL":                return ARBOLBINARIO_AVL;
            default:                        return ERROR;
        }
    }
}
