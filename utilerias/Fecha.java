package utilerias;
public class Fecha {
 //coloca aquí el código visto en clase
    private int dia;
    private int mes;
    private int anio;

    
    public Fecha() {
        dia = 1;
        mes = 1;
        anio = 2025;
    }

    
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}