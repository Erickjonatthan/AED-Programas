package ordenadores;

public class OrdenarPorContagemSimples implements Ordenador{

    @Override
    public int[] ordene(int[] array) {
        int maiorNum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maiorNum) {
                maiorNum = array[i];
            }
        }

        boolean[] existencia = new boolean[maiorNum + 1];
        for (int num : array) {
            existencia[num] = true;
        }

        int[] arrayOrdenado = new int[array.length];
        int index = 0;
        for (int i = 0; i < existencia.length; i++) {
            if (existencia[i]) {
                arrayOrdenado[index++] = i;
            }
        }

        return arrayOrdenado;
    }
    
}
