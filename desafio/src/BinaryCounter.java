import java.util.Scanner;

import filas.FilaBinaryCounter;

public class BinaryCounter {
    
    
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite seu número para contar");
        int numero = scan.nextInt();
        for (int i = 1; i <= numero; i++) {
          String binario = converteBinario(i);

          System.out.println(binario);
           
        }
    
        scan.close();
    
    }

    private static String converteBinario(int i) {
        
        FilaBinaryCounter fila = new FilaBinaryCounter();
    
        while(i>0){
            int resto = i % 2;
            fila.enqueue(resto);
            i = i/2;
        
        }

        String resultado = "";
        while(!fila.isEmpty()){
            resultado = fila.dequeue() + resultado  ;
        }
        return resultado ;

    }
}
