package mx.unam.ciencias.edd.proyecto2;


/** 
 * Enumeración para los tipos de colecciones 
*/
public enum TipoColeccion {

    LISTA,
    COLA,
    PILA,
    ARBOLBINARIO_ORDENADO,
    ARBOLBINARIO_COMPLETO,
    ARBOLBINARIO_ROJINEGRO,
    ARBOLBINARIO_AVL,
    GRAFICA,
    /* Si la coleccion obtenida esta mal escrita o no es valida */
    ERROR;

    /** 
     * Nos da el tipo de estructura que es dado una cadena.
     * @param coleccion la cadena donde dice el tipo de estructura de dato.
     */
    public static TipoColeccion getColeccion(String coleccion){
        switch(coleccion){
            case "Lista":                   return LISTA;
            case "Cola":                    return COLA;
            case "Pila":                    return PILA;
            case "ArbolBinarioOrdenado":    return ARBOLBINARIO_ORDENADO;
            case "ArbolBinarioCompleto":    return ARBOLBINARIO_COMPLETO;
            case "ArbolRojinegro":          return ARBOLBINARIO_ROJINEGRO;
            case "ArbolAVL":                return ARBOLBINARIO_AVL;
            case "Grafica":                 return GRAFICA;
            default:                        return ERROR;
        }
    }
}
