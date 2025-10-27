package miPrincipal.iu;
import miPrincipal.servicio.ServicioDatos;
import miPrincipal.modelo.Libro;
import miPrincipal.modelo.Pedido;
import miPrincipal.modelo.Libreria;
import java.util.Scanner;
import utilerias.Fecha;
import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;

public class MenuOpciones{
    static Scanner scanner = new  Scanner(System.in);
    static private Libreria libreria = new Libreria();

    public static void agregarLibro(){
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();

        System.out.print("Ingrese el ISBN del libro: ");
        String isbn = scanner.nextLine();

        Libro libro = libreria.crearLibro(titulo, autor, isbn);
        libreria.agregarLibro(libro);

        System.out.println("Libro agregado correctamente.\n");
    }
    
    public static void mostrarLibros() throws PosicionIlegalException{
        ListaDoble<Libro> lista = libreria.obtenerLibros();
        if(lista.esVacia()){
            System.out.println("No hay libros en la librería.\n");
        }else{
            System.out.println("Lista de libros:");
            for(int i = 0; i < lista.getTamanio(); i++){
                System.out.println(i + ": " + lista.getValor(i));
            }
            System.out.println();
        }
    }

    public static void agregarLibroCola(){
        System.out.print("Ingrese el título del libro a reservar: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro a reservar: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro a reservar: ");
        String isbn = scanner.nextLine();

        Libro libro = libreria.crearLibro(titulo, autor, isbn);
        libreria.agregarLibroCola(libro);

        System.out.println("Libro agregado a la cola de reservas.\n");
    }

    public static Libro obtenerLibroCola(){
        Libro libro = libreria.obtenerLibroCola();
        if(libro != null){
            System.out.println("Libro recuperado de la cola: " + libro + "\n");
        }else{
            System.out.println("La cola está vacía.\n");
        }
        return libro;
    }

    public static void mostrarReservaLibros(){
        System.out.println("Para ver la cola de libros, recupere libro por libro con obtenerLibroCola()");
    }

    public static void crearPedido(){
        System.out.print("Ingrese el título del libro para el pedido: ");
        String tituloPedido = scanner.nextLine();
        System.out.print("Ingrese el autor del libro para el pedido: ");
        String autorPedido = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro para el pedido: ");
        String isbnPedido = scanner.nextLine();

        Libro libroPedido = libreria.crearLibro(tituloPedido, autorPedido, isbnPedido);
        Pedido pedido=null;

        if (libroPedido!=null){
            pedido = libreria.crearPedido(libroPedido, new Fecha());
            if (pedido !=null)
                System.out.println("Pedido creado exitosamente: "+pedido);
            else
                System.out.println("No fue posible crear el pedido");
        }else{
            System.out.println("Error: no fue posible crear el Libro");
        }
    }

    public static void devolverLibro() throws PosicionIlegalException{
        System.out.print("Ingrese el ISBN del libro a devolver: ");
        String isbn = scanner.nextLine();

        libreria.buscarLibro(isbn); 

        Libro libro = new Libro("", "", isbn);
        boolean resultado = libreria.devolverLibro(libro);

        if(resultado){
            System.out.println("Libro devuelto correctamente.\n");
        }else{
            System.out.println("No se encontró el libro para devolver.\n");
        }
    }

    public static Libro eliminarUltimoLibro() throws PosicionIlegalException{
        Libro libro = libreria.eliminarUltimoLibro();
        System.out.println("Libro eliminado: " + libro + "\n");
        return libro;
    }

    public static void deshacerEliminarLibro(){
        try{
            Libro libro = libreria.deshacerEliminarLibro();
            if(libro != null){
                System.out.println("Se deshizo la eliminación. Libro restaurado: " + libro + "\n");
            }else{
                System.out.println("No hay libros para deshacer.\n");
            }
        }catch(PosicionIlegalException e){
            System.out.println("No fue posible deshacer la eliminación.\n");
        }
    }
}
