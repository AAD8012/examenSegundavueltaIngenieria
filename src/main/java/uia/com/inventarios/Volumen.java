package uia.com.inventarios;

public class Volumen {
    private int largo;
    private int alto;
    private int ancho;

    public Volumen() {
    }

    public Volumen(int largo, int alto, int ancho) {
        this.largo = largo;
        this.alto = alto;
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    @Override
    public String toString() {
        return "Volumen{" +
                "largo=" + largo +
                ", alto=" + alto +
                ", ancho=" + ancho +
                '}';
    }
}
