package ordenadores;
public class OrdenarPorMerge implements Ordenador{

    @Override
    public int[] ordene(int[] array) {
        return array;
    }

    public int[] merge(int[] array, int[] array2) {

        int[] array3 = new int[array.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < array.length && j < array2.length) {
            if (array[i] < array2[j]) {
                array3[k] = array[i];
                i++;
            } else {
                array3[k] = array2[j];
                j++;
            }
            k++;
        }
        while (i < array.length) {
            array3[k] = array[i];
            i++;
            k++;
        }
        while (j < array2.length) {
            array3[k] = array2[j];
            j++;
            k++;
        }
        return array3;
    }
    
}
