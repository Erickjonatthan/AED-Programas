package pilhaEfila;
import linked.ListaLigada;
import list.Fila;

public class FilaErick implements Fila{
    
    ListaLigada lista = new ListaLigada();

   @Override
   public void enqueue(int item) {
        lista.insereFim(item);
   }

   @Override
   public int dequeue() {
        int valor = lista.buscaIndice(0);
        lista.removeInicio();
        return valor;
   }

   @Override
   public boolean isEmpty() {
         if (lista.buscaIndice(0) == -1){
             return true;
         }
            return false;
   }

     @Override
     public int size() {
          return -1;
     }
  
    
}