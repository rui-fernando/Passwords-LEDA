package Estruturas_de_dados;
public class Fila<T> {
    private Nodo<T> frente;
    private Nodo<T> fim;
    private int tamanho;

    public Fila() {
        this.frente = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void adicionar(T elemento) {
        Nodo<T> novoNodo = new Nodo<>(elemento);
        if (estaVazia()) {
            frente = novoNodo;
            fim = novoNodo;
        } else {
            fim.setProximo(novoNodo);
            fim = novoNodo;
        }
        tamanho++;
    }

    public T remover() {
        if (estaVazia()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        T elementoRemovido = frente.getElemento();
        frente = frente.getProximo();
        tamanho--;
        if (estaVazia()) {
            fim = null;
        }
        return elementoRemovido;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }
}

