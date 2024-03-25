public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] array = { 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int i = partition(array, 0, array.length - 1);
        System.out.println("valor de i " + i);
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
    }


    public static int partition(int[] values, int left, int right) {
        
        int pivot = values[left];
        int i = left;

        for (int j = left + 1; j <= right; j++) {
            if (values[j] <= pivot) {
                i+=1;
                int temp = values[i];
                values[i] = values[j];
                values[j] = temp;
            }
        }

        // troca pivot (values[left]) com i.
        int temp = values[i];
        values[i] = values[left];
        values[left] = temp;
        
        return i; 
    }
}
