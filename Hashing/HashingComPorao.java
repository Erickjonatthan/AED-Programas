package hashing;

public class HashingComPorao {
    private static final int SIZE = 100;
    private Integer[] table = new Integer[SIZE];

    public void insert(int chave) {
        int index = chave % SIZE;
        while (table[index] != null && table[index] != chave) {
            index = (index + 1) % SIZE;
            if (index == chave % SIZE) return;
        }
        table[index] = chave;
    }

    public void delete(int chave) {
        int index = chave % SIZE;
        int originalIndex = index;
        while (table[index] != null && table[index] != chave) {
            index = (index + 1) % SIZE;
            if (index == originalIndex) return;
        }
        if (table[index] != null) {
            table[index] = null;
        }
    }

    public boolean search(int chave) {
        int index = chave % SIZE;
        int originalIndex = index;
        while (table[index] != null && table[index] != chave) {
            index = (index + 1) % SIZE;
            if (index == originalIndex) return false;
        }
        return table[index] != null;
    }
}