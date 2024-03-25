package pilhaEfila;
import linked.ListaLigada;
import list.Pilha;

public class PilhaErick implements Pilha{
    
    ListaLigada lista = new ListaLigada();

    @Override
    public boolean isEmpty() {
       if (lista.buscaIndice(0) == -1){
          return true;
       }
         return false;
    }
    @Override
    public int pop() {
        int valor = lista.buscaIndice(0);
        lista.removeInicio();
        return valor;
    }
    @Override
    public void push(int item) {
        lista.insereInicio(item);
    }
    
}