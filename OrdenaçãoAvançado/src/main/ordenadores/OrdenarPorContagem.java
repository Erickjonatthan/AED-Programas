package ordenadores;
public class OrdenarPorContagem implements Ordenador{

    @Override
    public int[] ordene(int[] array) {
        int maiorNum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maiorNum) {
                maiorNum = array[i];
            }
        }
        int[] arrayOrdenado = new int[array.length];
        int[] temp = new int[maiorNum + 1];

        for (int i = 0; i < array.length; i++) {
            temp[array[i]] = temp[array[i]] + 1;

        }

        for (int i = 1; i < maiorNum + 1; i++) {
            temp[i] = temp[i] + temp[i - 1];

        }

        for (int i = (array.length - 1); i >= 0; i--) {
            arrayOrdenado[temp[array[i]] - 1] = array[i];
            temp[array[i]] = temp[array[i]] - 1;

        }

        return arrayOrdenado;
    }

}
