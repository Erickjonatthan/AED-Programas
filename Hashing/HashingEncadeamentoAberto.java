package hashing;

import java.util.LinkedList;

public class HashingEncadeamentoAberto {
    private static final int SIZE = 100;
    private LinkedList<Integer>[] table = new LinkedList[SIZE];

    public HashingEncadeamentoAberto() {
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void insert(int chave) {
        int index = chave % SIZE;
        table[index].add(chave);
    }

    public void delete(int chave) {
        int index = chave % SIZE;
        table[index].remove((Integer) chave);
    }

    public boolean search(int chave) {
        int index = chave % SIZE;
        return table[index].contains(chave);
    }
}