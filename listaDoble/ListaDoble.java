package listaDoble;

public class ListaDoble<T> {
    private Nodo<T> cabeza;
    private int tamanio;

    public ListaDoble() {
        cabeza = null;
        tamanio = 0;
    }

    public int getTamanio() {
        return tamanio;
    }

    public boolean esVacia() {
        return cabeza == null;
    }

    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<>();
        nuevo.setValor(valor);
        if (esVacia()) {
            cabeza = nuevo;
        } else {
            Nodo<T> aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
        }
        tamanio++;
    }

    public T getValor(int pos) throws PosicionIlegalException {
        if (pos < 0 || pos >= tamanio) throw new PosicionIlegalException();
        Nodo<T> aux = cabeza;
        for (int i = 0; i < pos; i++) aux = aux.getSiguiente();
        return aux.getValor();
    }

    public int remover(T valor) throws PosicionIlegalException {
        Nodo<T> aux = cabeza;
        int pos = 0;
        while (aux != null) {
            if (aux.getValor().equals(valor)) {
                remover(pos);
                return pos;
            }
            aux = aux.getSiguiente();
            pos++;
        }
        return -1;
    }

    public T remover(int pos) throws PosicionIlegalException {
        if (pos < 0 || pos >= tamanio) throw new PosicionIlegalException();
        Nodo<T> aux = cabeza;
        if (pos == 0) {
            T valor = cabeza.getValor();
            cabeza = cabeza.getSiguiente();
            if (cabeza != null) cabeza.setAnterior(null);
            tamanio--;
            return valor;
        } else {
            for (int i = 0; i < pos; i++) aux = aux.getSiguiente();
            T valor = aux.getValor();
            Nodo<T> antes = aux.getAnterior();
            Nodo<T> despues = aux.getSiguiente();
            if (antes != null) antes.setSiguiente(despues);
            if (despues != null) despues.setAnterior(antes);
            tamanio--;
            return valor;
        }
    }

    public boolean contiene(T valor) {
        Nodo<T> aux = cabeza;
        while (aux != null) {
            if (aux.getValor().equals(valor)) return true;
            aux = aux.getSiguiente();
        }
        return false;
    }
}