import cliente.Cliente;
import filas.FilaBanco;

public class BancoOphidian {
    public static void main(String[] args) {
        
        FilaBanco fila = new FilaBanco();

        // Simulação de 5 minutos
        for (int minutos = 1; minutos <= 5; minutos++) {
            System.out.println("Minuto " + minutos + ":");

            int novosClientes = (int) (Math.random() * 5) + 1;

            for (int i = 0; i < novosClientes; i++) {
                Cliente novoCliente = new Cliente("Cliente" + (i + 1));
                fila.enqueue(novoCliente);
                System.out.println("   Novo cliente adicionado à fila: " + novoCliente.getNome());
            }
            
            System.out.println("   Fila atual: " + fila);

            // Atendendo os clientes
            while (!fila.isEmpty()) {
                Cliente cliente = fila.dequeue();

                // Simula 25% de chance de problemas com a papelada
                if (Math.random() <= 0.25) {
                    System.out.println("   Cliente " + cliente.getNome() + " não atendido, voltando para o final da fila");
                    cliente.setPapelada(false);
                    fila.enqueue(cliente);
                } else {
                    System.out.println("   Cliente " + cliente.getNome() + " atendido");
                }  
            }

            System.out.println("   Fila atual: " + fila);

            System.out.println("   Fila vazia. Próximo minuto.\n");
        }
    }
}
