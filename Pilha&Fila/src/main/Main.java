import pilhaEfila.Fila2;
import pilhaEfila.FilaErick;
import pilhaEfila.PilhaErick;

public class Main {
    public static void main(String[] args) {

        FilaErick fila = new FilaErick();
        PilhaErick pilha = new PilhaErick();
        Fila2 fila2 = new Fila2();

        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);

        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);
        pilha.push(5);

        fila2.enqueue(1);
        fila2.enqueue(2);
        fila2.enqueue(3);
        fila2.enqueue(4);
        fila2.enqueue(5);


        System.out.println("Fila: ");
        while (!fila.isEmpty()) {
            System.out.println(fila.dequeue());
        }
        fila.dequeue();
        while (!fila.isEmpty()) {
            System.out.println(fila.dequeue());
        }


        System.out.println("Pilha: ");
        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }

        System.out.println("Fila2: ");
        while (!fila2.isEmpty()) {
            System.out.println(fila2.dequeue());
        }

    }
}
