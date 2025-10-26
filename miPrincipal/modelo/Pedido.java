package miPrincipal.modelo;

import utilerias.Fecha;

public class Pedido {
   
    private Libro libro;
    private Fecha fechaPedido;

   
    public Pedido(Libro libro, Fecha fecha){
        this.libro = libro;
        this.fechaPedido = fecha;
    }

   
    public Libro getLibro() {
        return libro;
    }

    public Fecha getFechaPedido() {
        return fechaPedido;
    }

    
    @Override
    public String toString(){
        return "Pedido -> Libro: [" + libro + "], Fecha: " + fechaPedido;
    }
}