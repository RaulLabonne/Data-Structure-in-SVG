package mx.unam.ciencias.edd.proyecto2;


/* 
 * Proyecto 2: Graficador
 */
public class Proyecto2 {
    
    public static void main(String[] args){
        if(args.length > 1){
            System.out.println("Error");
            System.exit(1);
        }
        String coleccion;
        if (args.length == 0){
            LeerEstandar imprimir = new LeerEstandar();
            coleccion = imprimir.leer();
        } else {
            Leer imprimir = new Leer(args[0]);
            coleccion = imprimir.leer();
        }
        Entrada graficar = new Entrada(coleccion);
        graficar.ejecuta();
    }
}
