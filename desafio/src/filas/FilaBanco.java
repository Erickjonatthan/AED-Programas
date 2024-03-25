package filas;
import cliente.Cliente;
import linked.ListaLigada;

public class FilaBanco{
    
   ListaLigada lista = new ListaLigada();

   public void enqueue(Cliente item) {
        lista.insereFim(item);
   }

   public Cliente dequeue() {
        Cliente valor = lista.buscaIndice(0);
        lista.removeInicio();
        return valor;
   }

   public boolean isEmpty() {
         if (lista.buscaIndice(0) == null){
             return true;
         }
            return false;
   }

   public int size() {
        return -1;
   }

   public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < lista.size(); i++) {
             result.append("Cliente ").append(i + 1);
             if (i < lista.size() - 1) {
                  result.append(", ");
             }
        }
        result.append("]");
        return result.toString();
   }
     
}