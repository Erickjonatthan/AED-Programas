package estrut;

public class No {
    int valor;
    No direita;
    No esquerda;
    int altura; // novo campo para armazenar a altura do nó

    public No(int valor, No direita, No esquerda) {
        this.valor = valor;
        this.direita = direita;
        this.esquerda = esquerda;
        this.altura = 1; // inicialmente, a altura de um novo nó é 1
    }

    public No(int valor) {
        this.valor = valor;
        this.altura = 1; // inicialmente, a altura de um novo nó é 1
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    // Método para calcular o fator de balanceamento do nó
    public int getFatorBalanceamento() {
        int alturaEsquerda = (esquerda == null) ? 0 : esquerda.getAltura();
        int alturaDireita = (direita == null) ? 0 : direita.getAltura();
        return alturaEsquerda - alturaDireita;
    }

    public No sucessor(No no){
        No sucessor = no;
        sucessor = sucessor.getDireita();
        while(sucessor.getEsquerda() != null){
            sucessor = sucessor.getEsquerda();
        }
        return sucessor;
    }

    public No antecessor(No no){
        No antecessor = no;
        antecessor = antecessor.getEsquerda();
        while(antecessor.getDireita() != null){
            antecessor = antecessor.getDireita();
        }
        return antecessor;
    }   
}