package Estruturas_de_dados;

public class Pilha<T> {
    private Nodo<T> topo;
    private int tamanho;

    public Pilha() {
        this.topo = null;
        this.tamanho = 0;
    }

    public void push(T elemento) {
        Nodo<T> novoNodo = new Nodo<>(elemento);
        novoNodo.setProximo(topo);
        topo = novoNodo;
        tamanho++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha esta vazia.");
        }
        T elemento = topo.getElemento();
        topo = topo.getProximo();
        tamanho--;
        return elemento;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        return topo.getElemento();
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public int size() {
        return tamanho;
    }
}