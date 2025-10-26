package listaDoble;

public class Cola<T> {

    private Nodo<T> cabeza; 
    private Nodo<T> cola;   
    private int tamanio;

    public Cola(){
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    public boolean esVacia(){
        return cabeza == null;
    }

    
    public void encolar(T valor){
        Nodo<T> nuevo = new Nodo<>();
        nuevo.setValor(valor);

        if(esVacia()){
            cabeza = nuevo;
            cola = nuevo;
        }else{
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
        tamanio++;
    }

    
    public T desencolar(){
        if(!esVacia()){
            T valor = cabeza.getValor();
            cabeza = cabeza.getSiguiente();

            if(cabeza != null){
                cabeza.setAnterior(null);
            }else{
                cola = null; 
            }

            tamanio--;
            return valor;
        }
        return null;
    }

    public T frente(){
        if(!esVacia()){
            return cabeza.getValor();
        }
        return null;
    }

    public int getTamanio(){
        return tamanio;
    }
}
