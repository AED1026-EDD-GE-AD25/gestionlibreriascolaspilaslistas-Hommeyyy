package listaDoble;

/**
 * Clase genérica ListaDoble<T>
 * Representa una lista doblemente enlazada con operaciones básicas
 * de inserción, eliminación, búsqueda y recorrido.
 */
public class ListaDoble<T> {

    // 🔹 Atributos
    private Nodo<T> cabeza; // Primer nodo de la lista
    private int tamanio;    // Cantidad de elementos en la lista

    // 🔹 Constructor por defecto
    public ListaDoble() {
        cabeza = null;
        tamanio = 0;
    }

    // 🔹 Getter para tamaño
    public int getTamanio() {
        return tamanio;
    }

    // 🔹 Verifica si la lista está vacía
    public boolean esVacia() {
        return cabeza == null;
    }

    /*
     * Agrega un nuevo nodo al final de la lista
     * @param valor: valor a agregar
     */
    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<>();
        nuevo.setValor(valor);

        if (esVacia()) { // Si la lista está vacía
            cabeza = nuevo;
        } else { // Si ya hay elementos
            Nodo<T> aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux); // Enlace doble
        }
        tamanio++;
    }

    /*
     * Inserta un nuevo nodo en la lista
     * @param valor: valor a agregar
     * @param pos: indica la posición en donde se insertará el nodo
     * @throws PosicionIlegalException: si la posición no existe
     */
    public void insertar(T valor, int pos) throws PosicionIlegalException {
        if (pos >= 0 && pos <= tamanio) {
            Nodo<T> nuevo = new Nodo<>();
            nuevo.setValor(valor);

            if (pos == 0) { // Insertar al principio
                nuevo.setSiguiente(cabeza);
                if (cabeza != null) {
                    cabeza.setAnterior(nuevo);
                }
                cabeza = nuevo;

            } else { // Insertar en medio o final
                Nodo<T> aux = cabeza;
                for (int i = 0; i < pos - 1; i++) {
                    aux = aux.getSiguiente();
                }

                Nodo<T> siguiente = aux.getSiguiente();
                aux.setSiguiente(nuevo);
                nuevo.setAnterior(aux);
                nuevo.setSiguiente(siguiente);

                if (siguiente != null) {
                    siguiente.setAnterior(nuevo);
                }
            }
            tamanio++;
        } else {
            throw new PosicionIlegalException();
        }
    }

    /*
     * Elimina un nodo de una determinada posición
     * @param pos: posición a eliminar
     * @return valor del nodo eliminado
     * @throws PosicionIlegalException: si la posición no existe
     */
    public T remover(int pos) throws PosicionIlegalException {
        if (pos >= 0 && pos < tamanio) {
            Nodo<T> aux = cabeza;

            if (pos == 0) { // Eliminar cabeza
                T valor = cabeza.getValor();
                cabeza = cabeza.getSiguiente();
                if (cabeza != null) {
                    cabeza.setAnterior(null);
                }
                tamanio--;
                return valor;
            } else { // Eliminar en medio o final
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                T valor = aux.getValor();
                Nodo<T> antes = aux.getAnterior();
                Nodo<T> despues = aux.getSiguiente();

                if (antes != null) {
                    antes.setSiguiente(despues);
                }
                if (despues != null) {
                    despues.setAnterior(antes);
                }
                tamanio--;
                return valor;
            }
        } else {
            throw new PosicionIlegalException();
        }
    }

    /*
     * Elimina un nodo de la lista buscándolo por su valor.
     * Si lo encuentra, retorna la posición y lo elimina.
     * Si no lo encuentra, retorna -1.
     */
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
        return -1; // No encontrado
    }

    /*
     * Devuelve el valor de una determinada posición
     * @param pos: posición a obtener
     * @return valor del nodo
     * @throws PosicionIlegalException: si la posición no existe
     */
    public T getValor(int pos) throws PosicionIlegalException {
        if (pos >= 0 && pos < tamanio) {
            Nodo<T> aux = cabeza;
            for (int i = 0; i < pos; i++) {
                aux = aux.getSiguiente();
            }
            return aux.getValor();
        } else {
            throw new PosicionIlegalException();
        }
    }

    /*
     * Limpia la lista completamente
     */
    public void limpiar() {
        cabeza = null;
        tamanio = 0;
    }

    /*
     * Busca un valor en la lista
     * @param valor: valor a buscar
     * @return true si lo contiene, false en caso contrario
     */
    public boolean contiene(T valor) {
        Nodo<T> aux = cabeza;
        while (aux != null) {
            if (aux.getValor().equals(valor)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    /*
     * Devuelve todos los datos de la lista en forma de String
     */
    
    public String toString() {
        String cadena = "";
        Nodo<T> aux = cabeza;
        while (aux != null) {
            cadena += aux.getValor() + "\n";
            aux = aux.getSiguiente();
        }
        return cadena;
    }
}