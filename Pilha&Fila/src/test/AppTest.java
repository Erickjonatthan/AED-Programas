package test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import list.Pilha;
import pilhaEfila.Fila2;
import pilhaEfila.PilhaErick;
import pilhaEfila.FilaErick;

public class AppTest {

    private FilaErick e;
    private PilhaErick f;
    private Fila2 d;

    @Before
    public void setUp() throws Exception {
        e = new FilaErick();
        f = new PilhaErick();
        d = new Fila2();
    }

    @Test
    public void testFila() {
        e.enqueue(1);
        e.enqueue(2);
        e.enqueue(2);
        e.enqueue(5);
        assertEquals("Não é o primeiro " + 0, 1, e.dequeue());
        assertEquals("Não é o primeiro " + 0, 2, e.dequeue());
        assertEquals("Não é o primeiro " + 0, 2, e.dequeue());
        assertEquals("Não é o primeiro " + 0, 5, e.dequeue());
    }

    @Test
    public void testPilha() {
        f.push(0);
        f.push(2);
        f.push(2);
        f.push(5);
        assertEquals("Não é o primeiro " + 0, 5, f.pop());
        assertEquals("Não é o primeiro " + 0, 2, f.pop());
        assertEquals("Não é o primeiro " + 0, 2, f.pop());
        assertEquals("Não é o primeiro " + 0, 0, f.pop());
    }

    @Test
    public void testFilaPilha() {
        d.enqueue(1);
        d.enqueue(2);
        d.enqueue(2);
        d.enqueue(5);
        assertEquals("Não é o primeiro " + 0, 1, d.dequeue());
        assertEquals("Não é o primeiro " + 0, 2, d.dequeue());
        assertEquals("Não é o primeiro " + 0, 2, d.dequeue());
        assertEquals("Não é o primeiro " + 0, 5, d.dequeue());
    }

}