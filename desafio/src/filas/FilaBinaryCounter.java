package filas;
import array.ListaArray;

public class FilaBinaryCounter{
    
   ListaArray lista = new ListaArray();

   
   public void enqueue(int item) {
        lista.insereFim(item);
   }

   
   public int dequeue() {
        int valor = lista.buscaIndice(0);
        lista.removeInicio();
        return valor;
   }

   
   public boolean isEmpty() {
         if (lista.buscaIndice(0) == -1){
             return true;
         }
            return false;
   }


}    
