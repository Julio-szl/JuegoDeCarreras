package model;

public abstract class Vehiculo {

    private String nombre;
    private int velocidadMaxima;
    private int aceleracion;
    private int manejo;
    private int nitro;
    private int posicion;

    public Vehiculo(String nombre, int velocidadMaxima, int aceleracion,
                    int manejo, int nitro) {

        this.nombre = nombre;
        this.velocidadMaxima = velocidadMaxima;
        this.aceleracion = aceleracion;
        this.manejo = manejo;
        this.nitro = nitro;
        this.posicion = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public int getManejo() {
        return manejo;
    }

    public int getNitro() {
        return nitro;
    }

    public int getPosicion() {
        return posicion;
    }

    public void avanzarPosicion(int cantidad) {
        posicion += cantidad;
    }

    public void reiniciarPosicion() {
        posicion = 0;
    }

    public abstract int avanzar();

    public int usarNitro() {

        if (nitro > 0) {
            nitro--;
            return 8;
        }

        return 0;
    }

    public String mostrarEstadisticas() {

        return "Vehiculo: " + nombre +
                "\nVelocidad maxima: " + velocidadMaxima +
                "\nAceleracion: " + aceleracion +
                "\nManejo: " + manejo +
                "\nNitros disponibles: " + nitro;
    }
}