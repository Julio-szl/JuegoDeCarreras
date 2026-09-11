package model;

public abstract class Jugador {

    private String name;
    private Vehiculo vehiculo;
    private double distanciaRecorrida;
    private int posicionCarrera;
    
    public Jugador(String name, Vehiculo vehiculo) {
        this.name = name;
        this.vehiculo = vehiculo;
    }

    public String getName() {
        return name;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public int getPosicionCarrera() {
        return posicionCarrera;
    }

    public void avanzar(double distancia) {
        this.distanciaRecorrida += distancia;
    }

    public abstract void decidirMovimiento();
    
}
