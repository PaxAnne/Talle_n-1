package modelo;

/**
 *
 * @fernando-vasquez_paz-muñoz
 */
 public class Cola
   {
   private int maxT;
   private long[] datos;
   private int principio;
   private int fin;
   private int puntero;
   
   
   public Cola(int T)          
      {
      maxT = T;
      datos = new long[maxT];
      principio = 0;
      fin = -1;
      puntero = 0;
      }//cierre constructor 
   
   // Insertar Datos //
   
    public void insertar (long D){
        if(fin == maxT-1) {       // revisar si la Cola esta llena
            datos[0] = D;       
            puntero++;
            long temp = datos[0];
            for (int i = 0; i < maxT-1; i++) {
                datos[i] = datos[i+1];
            }
            datos[maxT-1]=temp;
        }//cierre del if
        else {
            fin ++;
            datos [fin] = D; 
            puntero ++;
        }//cierre del else
     }//cierre del metodo insertar 
   
   
// Eliminar Datos //
    public void remove(){
        if (principio == fin+1) {
            System.out.println("La cola presente se encuentra VACIA");
        }//cierre del if
        else {
            datos[principio]= 0;
            
            if (principio==0){
            }//cierre del if
            else{
                principio--;
            }//cierre del else
            
            puntero --;
            fin --;
            long temp = datos[0];
            for (int i = 0; i < maxT-1; i++) {
                datos[i] = datos[i+1];
            }
            datos[maxT-1]=temp;
        }//cierre del else
      } // cierre del metodo eliminar  
   
   
//---------Mostrar el primer dato----------
   public long peekFront()      
      {
      return datos[principio];
      }//cierre metodo
   
//---------Mostrar el utimo dato------------
   public long peekRear()      
      {
      return datos[fin];
      }//cierre metodo
   
//----------Ver si la Cola esta vacia--------
   public boolean isEmpty()    
      {
      return (puntero==0);
      }
//-----------Ver si la Cola esta llena--------
   public boolean isFull()     
      {
      return (puntero==maxT);
      }
//----------Ver la cantidad de datos que tiene la Cola-------
   public int size()           
      {
      return puntero;
      }
//---------Imprimir datos de la cola-------------------------
   public void imprimir(){
       for (int i = 0; i < maxT; i++) {
           System.out.println(datos[i]);
       }//cierre del for
    }
   public void imprimirEx(){
        if(maxT>=10){
            System.out.println("\n\tLos Primeros 10 datos de la Cola son:");
            for (int i = 0; i < 10; i++) {
                System.out.println( "\t"+datos[i]);
            }//cierre del for
            System.out.println("\n\tLos Últimos 10 datos de la Cola son:");
            for (int i = maxT-11; i < maxT; i++) {
                System.out.println("\t" +datos[i]);
            }//cierre del for
        }//cierre del for
    }
   
   public void consultarFin(){
       System.out.println("F: "+fin);
   }
   public void consultarPrin(){
       System.out.println("P: "+principio);
   }
   }  // cierre de la clase 