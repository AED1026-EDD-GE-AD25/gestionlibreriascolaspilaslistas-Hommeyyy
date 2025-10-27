package miPrincipal.modelo;

import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import pila.Pila;
import cola.Cola;
import utilerias.Fecha;
import miPrincipal.servicio.ServicioDatos;
import java.util.Scanner;

public class Libreria {
    ServicioDatos dataService;
    ListaDoble<Libro> listaLibros;
    Cola<Libro> colaLibros;
    Pila<Libro> pilaLibrosEliminados;
    Scanner scanner; 

    public Libreria(){
        dataService = new ServicioDatos();
        scanner = new Scanner(System.in);
        listaLibros = new ListaDoble<>();
        colaLibros = new Cola<>();
        pilaLibrosEliminados = new Pila<>();
    }

    public void agregarLibro(Libro libro){
        listaLibros.agregar(libro);
    }

    public ListaDoble<Libro> obtenerLibros() {
        return listaLibros;
    }

    public boolean agregarLibroCola(Libro libro) {
        colaLibros.encolar(libro);
        return true;
    }

    public Libro obtenerLibroCola() {
        return colaLibros.desencolar();
    }

    public Libro obtenerLibroPila() {
        return pilaLibrosEliminados.cima();
    }

    public Libro crearLibro(String titulo, String autor, String isbn) {
        return new Libro(titulo, autor, isbn);
    }

    public Pedido crearPedido(Libro libro, Fecha fecha) {
        return new Pedido(libro, fecha);
    }

    public boolean devolverLibro(Libro libro) throws PosicionIlegalException {
        int pos = listaLibros.remover(libro);
        return pos != -1;
    }

    public Libro eliminarUltimoLibro() throws PosicionIlegalException {
        int ultimaPos = listaLibros.getTamanio() - 1;
        if (ultimaPos < 0) return null;
        Libro libroEliminado = listaLibros.getValor(ultimaPos);
        listaLibros.remover(ultimaPos);
        pilaLibrosEliminados.apilar(libroEliminado);
        return libroEliminado;
    }

    public Libro deshacerEliminarLibro() throws PosicionIlegalException {
        if (pilaLibrosEliminados.esVacia()) return null;
        Libro libroRecuperado = pilaLibrosEliminados.retirar(); // usar retirar que devuelve el elemento
        listaLibros.agregar(libroRecuperado);
        return libroRecuperado;
    }

    public void buscarLibro(String isbn) {
        boolean encontrado = false;
        for (int i = 0; i < listaLibros.getTamanio(); i++) {
            try {
                Libro libro = listaLibros.getValor(i);
                if (libro != null && libro.getIsbn() != null && libro.getIsbn().equals(isbn)) {
                    System.out.println("Libro encontrado en la posición " + i + ": " + libro);
                    encontrado = true;
                    break;
                }
            } catch (PosicionIlegalException e) {
                System.err.println("Error al acceder la posición " + i + ": " + e.getMessage());
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ISBN: " + isbn);
        }
    }
}