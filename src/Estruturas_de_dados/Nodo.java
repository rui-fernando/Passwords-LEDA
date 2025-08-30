package Estruturas_de_dados;

public class Nodo<T> {
    private T elemento;
    private Nodo<T> proximo;

    public Nodo(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }
}
