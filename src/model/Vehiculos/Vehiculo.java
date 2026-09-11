package model.Vehiculos;

public abstract class Vehiculo {

    private String nombre;
    private float velocidad;
    private float aceleracion;
    private float distancia;
    private String imagen;

    public Vehiculo(
        String nombre,
        float velocidad,
        float aceleracion,
        float distancia,
        String imagen
    ) {
        this.nombre = nombre;
        this.aceleracion = aceleracion;
        this.distancia = distancia;
        this.imagen = imagen;

        setVelocidad(velocidad);
    }

    public abstract void acelerar();

    public abstract void usarHabilidad();

    public void setVelocidad(float velocidad) {
        try {
            if (velocidad < 0) {
                throw new IllegalArgumentException(
                    "La velocidad no puede ser negativa"
                );
            }

            this.velocidad = velocidad;

        } catch (IllegalArgumentException e) {
            System.out.println(
                "Error de velocidad: " + e.getMessage()
            );

            this.velocidad = 0;
        }
    }

    protected void aumentarVelocidad(float cantidad) {
        setVelocidad(velocidad + cantidad);
    }

    protected void aumentarDistancia(float cantidad) {
        if (cantidad > 0) {
            distancia += cantidad;
        }
    }

    public void avanzar() {
        distancia += velocidad;
    }

    public void reiniciar() {
        velocidad = 0;
        distancia = 0;
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre
            + "\nTipo: " + getClass().getSimpleName()
            + "\nVelocidad: " + velocidad
            + "\nAceleracion: " + aceleracion
            + "\nDistancia: " + distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public float getAceleracion() {
        return aceleracion;
    }

    public float getDistancia() {
        return distancia;
    }

    public String getImagen() {
        return imagen;
    }
}