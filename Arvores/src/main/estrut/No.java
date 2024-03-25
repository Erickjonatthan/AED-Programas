package estrut;

public class No {
    int valor;
    No direta;
    No esquerda;

    public No(int valor, No direta, No esquerda) {
        this.valor = valor;
        this.direta = direta;
        this.esquerda = esquerda;
    }

    public No(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getDireta() {
        return direta;
    }

    public void setDireta(No direta) {
        this.direta = direta;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No sucessor(No no){
        No sucessor = no;

        sucessor = sucessor.getDireta();

        while(sucessor.getEsquerda() != null){
            sucessor = sucessor.getEsquerda();
        }
        return sucessor;
    }

        public No antecessor(No no){
            No antecessor = no;

            antecessor = antecessor.getEsquerda();

            while(antecessor.getDireta() != null){
                antecessor = antecessor.getDireta();
            }
        return antecessor;
    }   
}
