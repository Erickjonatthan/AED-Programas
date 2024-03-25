package linked;

import cliente.Cliente;

public class No {
    private Cliente valor;
    private No proximo;
    
    public No(Cliente valor) {
        this.valor = valor;
    }
    
    public Cliente getValor() {
        return this.valor;
    }
    
    public void setValor(Cliente valor) {
        this.valor = valor;
    }
    
    public No getProximo() {
        return this.proximo;
    }
    
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}

