package Estruturas_de_dados;

public class ListaEncadeada<T> {
    private Nodo<T> cabeca;
    private int tamanho;

    public ListaEncadeada() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void adicionar(T elemento) {
        Nodo<T> novoNodo = new Nodo<>(elemento);
        if (cabeca == null) {
            cabeca = novoNodo;
        } else {
            Nodo<T> atual = cabeca;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNodo);
        }
        tamanho++;
    }

    public void adicionar(int indice, T elemento) {
        if (indice < 0 || indice > tamanho) {
            throw new IndexOutOfBoundsException("Indice fora do intervalo.");
        }

        Nodo<T> novoNodo = new Nodo<>(elemento);
        if (indice == 0) {
            novoNodo.setProximo(cabeca);
            cabeca = novoNodo;
        } else {
            Nodo<T> atual = cabeca;
            for (int i = 0; i < indice - 1; i++) {
                atual = atual.getProximo();
            }
            novoNodo.setProximo(atual.getProximo());
            atual.setProximo(novoNodo);
        }
        tamanho++;
    }

    public T remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Indice fora do intervalo.");
        }

        Nodo<T> removido;
        if (indice == 0) {
            removido = cabeca;
            cabeca = cabeca.getProximo();
        } else {
            Nodo<T> atual = cabeca;
            for (int i = 0; i < indice - 1; i++) {
                atual = atual.getProximo();
            }
            removido = atual.getProximo();
            atual.setProximo(removido.getProximo());
        }
        tamanho--;
        return removido.getElemento();
    }

    public T buscar(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Indice fora do intervalo.");
        }

        Nodo<T> atual = cabeca;
        for (int i = 0; i < indice; i++) {
            atual = atual.getProximo();
        }
        return atual.getElemento();
    }

    public boolean contem(T elemento) {
        Nodo<T> atual = cabeca;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    public void set(int indice, T elemento) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Indice fora do intervalo.");
        }
        Nodo<T> atual = cabeca;
        for (int i = 0; i < indice; i++) {
            atual = atual.getProximo();
        }
        atual.setElemento(elemento);
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }
}

