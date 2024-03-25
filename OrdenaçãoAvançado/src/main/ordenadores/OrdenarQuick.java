package ordenadores;
public class OrdenarQuick implements Ordenador{

    @Override
    public int[] ordene(int[] array) {
        quickParticio(array, 0, array.length - 1);
        return array;
    }

    public int quickParticio(int[] array, int inicio, int fim) {
        int i = inicio;
        if (inicio < fim) {
            int pivo = array[inicio];
            
            for (int j = inicio + 1; j <= fim; j++) {
                if (array[j] <= pivo) {
                    i += 1;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            int temp = array[i];
            array[i] = array[inicio];
            array[inicio] = temp;
            
            quickParticio(array, inicio, i - 1);
            quickParticio(array, i + 1, fim);
            

        }
       return i;
    }

}
