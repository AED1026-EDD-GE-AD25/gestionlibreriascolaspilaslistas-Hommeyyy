package pila;
import listaDoble.Nodo;
public class Pila<T> {
    private Nodo<T> cima; 
    private int tamanio;

    public Pila() {
        cima = null;
        tamanio = 0;
    }

    public boolean esVacia() { return cima == null; }

    public void apilar(T valor) {
        Nodo<T> nuevo = new Nodo<>();
        nuevo.setValor(valor);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        tamanio++;
    }

    public void retirar() {
        if (!esVacia()) {
            cima = cima.getSiguiente();
            tamanio--;
        }
    }

    public T cima() { return esVacia() ? null : cima.getValor(); }

    public int getTamanio() { return tamanio; }
}