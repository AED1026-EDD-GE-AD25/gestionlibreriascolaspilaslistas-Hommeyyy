package miPrincipal.modelo;

public class Libro {
   
    private String titulo;
    private String autor;
    private String isbn;

    public Libro(String titulo, String autor, String isbn){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString(){
        return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Libro otro = (Libro) obj;
        return isbn != null && isbn.equals(otro.isbn);
    }

    @Override
    public int hashCode() {
        return isbn != null ? isbn.hashCode() : 0;
    }
}