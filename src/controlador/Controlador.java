package controlador;

import modelo.*;

/**
 *
 * @author fernando-vasquez_paz-muñoz
 */
public final class Controlador {

    public Controlador() {
        //CSV reader
        Paltas[] arreglo = cargarArchivo();
        comprobarArchivo(arreglo);
        System.out.println("Se comprueba la correcta lectura y exibición de los datos"+"\n");
        
        //Insertion Sort
        long start1 = System.nanoTime();
        Paltas[] arregloIS = Paltas.insertionSort(arreglo);
        long end1 = System.nanoTime();
        comprobarArchivo(arregloIS);
        System.out.println("Tiempo de ejecución de insertion sort en nanosegundos: "+ (end1-start1)+"\n");
        
        //Quick Sort
        long start2 = System.nanoTime();
        Paltas[] arregloQS = Paltas.quickSort(arreglo, 0, arreglo.length);
        long end2 = System.nanoTime();
        comprobarArchivo(arregloQS);
        System.out.println("Tiempo de ejecución de quick sort en nanosegundos: "+ (end2-start2)+"\n");
        
        //Conclusiones
        System.out.println("Comparación del Tiempo de ejecución");
        System.out.println("\t*El algoritmo de Insertion Sort tardó "+(end1-start1)+" nanosegundos");
        System.out.println("\t*El algoritmo de Quick Sort tardó "+(end2-start2)+" nanosegundos");
        System.out.println("\t*Esto muestra que el Quick Sort es "+((end1-start1)-(end2-start2))+" nanosegundos más rápido");
        
        
        //Queue
        
        Cola q = new Cola(arreglo.length); //Se crea la cola
        for (int i = 0; i < arreglo.length; i++) {//Se le agregan los volumenes de paltas.csv
            q.insertar(arreglo[i].getVolume());
        }
        
        q.imprimirEx();//Mostrar los datos Originales
        q.remove(); //Eliminar un dato de la cola
        System.out.println("\nPosteriormente de remover un dato a la Cola");
        q.imprimirEx();//Despues de remover 1 dato a la cola
        q.insertar(10); //insertar 1 dato a la cola
        q.insertar(20); //insertar 1 dato a la cola
        System.out.println("\nLuego de Insertar Dos datos Nuevos a la Cola");
        q.imprimirEx();// mostra la cola despues de insertar 2 datos
    }
        
    public Paltas[] cargarArchivo(){
        CSVreader CSV = new CSVreader();
        Paltas[] arreglo = CSV.entregarArreglo();
        return arreglo;
    }
    
    public Void comprobarArchivo(Paltas[] arreglo){
        for (int i = 0; i < 30; i++) {
            System.out.println(arreglo[i].toString());
        }
        System.out.println("");
        return null;
    }
    

}
