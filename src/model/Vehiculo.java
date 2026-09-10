package model;

import excepciones.DatosVehiculoException;

public abstract class Vehiculo {

    private String nombre;
    private double velocidad;
    private double velocidadMaxima;
    private double aceleracion;
    private double distanciaRecorrida;
    private String rutaImagen;

    public Vehiculo(
            String nombre,
            double velocidadMaxima,
            double aceleracion,
            String rutaImagen
    ) throws DatosVehiculoException {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosVehiculoException(
                    "El nombre del vehículo no puede estar vacío."
            );
        }

        if (velocidadMaxima <= 0) {
            throw new DatosVehiculoException(
                    "La velocidad máxima debe ser mayor que cero."
            );
        }

        if (aceleracion <= 0) {
            throw new DatosVehiculoException(
                    "La aceleración debe ser mayor que cero."
            );
        }

        this.nombre = nombre;
        this.velocidad = 0;
        this.velocidadMaxima = velocidadMaxima;
        this.aceleracion = aceleracion;
        this.distanciaRecorrida = 0;
        this.rutaImagen = rutaImagen;
    }

    public void acelerar() {
        velocidad += aceleracion;

        if (velocidad > velocidadMaxima) {
            velocidad = velocidadMaxima;
        }
    }

    public void avanzar() {
        distanciaRecorrida += velocidad;
    }

    public void frenar() {
        velocidad -= aceleracion;

        if (velocidad < 0) {
            velocidad = 0;
        }
    }

    public void reiniciar() {
        velocidad = 0;
        distanciaRecorrida = 0;
    }

    public abstract void usarHabilidad();

    public abstract String getTipo();

    public String mostrarInformacion() {
        return "Nombre: " + nombre
                + "\nTipo: " + getTipo()
                + "\nVelocidad máxima: " + velocidadMaxima
                + "\nAceleración: " + aceleracion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    protected void setVelocidad(double velocidad) {
        if (velocidad < 0) {
            this.velocidad = 0;
        } else if (velocidad > velocidadMaxima) {
            this.velocidad = velocidadMaxima;
        } else {
            this.velocidad = velocidad;
        }
    }

    protected void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = Math.max(0, distanciaRecorrida);
    }
}