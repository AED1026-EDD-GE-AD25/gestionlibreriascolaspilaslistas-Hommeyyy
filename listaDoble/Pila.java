package listaDoble;

public class Pila<T> {

    private Nodo<T> cima; 
    private int tamanio;

    public Pila(){
        cima = null;
        tamanio = 0;
    }

    
    public boolean esVacia(){
        return cima == null;
    }

    
    public void apilar(T valor){
        Nodo<T> nuevo = new Nodo<>();
        nuevo.setValor(valor);

        if(esVacia()){
            cima = nuevo;
        }else{
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
        tamanio++;
    }

   
    public void retirar(){
        if(!esVacia()){
            cima = cima.getSiguiente();
            tamanio--;
        }
    }

    
    public T cima(){
        if(!esVacia()){
            return cima.getValor();
        }
        return null;
    }

    public int getTamanio(){
        return tamanio;
    }
}