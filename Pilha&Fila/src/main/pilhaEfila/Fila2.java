package pilhaEfila;
import list.FilaComPilha;
import list.Pilha;

public class Fila2 implements FilaComPilha{
    
    Pilha pilha1 = new PilhaErick();
    
    
    @Override
    public void enqueue(int x) {
        
        Pilha pilha2 = new PilhaErick();

        while (!pilha1.isEmpty()) {
            pilha2.push(pilha1.pop());
        }

        pilha1.push(x);

        while (!pilha2.isEmpty()) {
            pilha1.push(pilha2.pop());
        }
    }

    @Override
    public int dequeue() {
        if (pilha1.isEmpty()) {
            return -1;
        }
        return pilha1.pop();
    }
    
    @Override
    public boolean isEmpty() {
        return pilha1.isEmpty();
    }

    @Override
    public int size() {
        return -1;
    }
}