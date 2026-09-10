package model;

public class Deportivo extends Vehiculo {

    public Deportivo(String nombre, String imagen) {
        super(
                nombre,
                0.0f,
                4.0f,
                0.0f,
                imagen
        );
    }

    @Override
    public void acelerar() {
        aumentarVelocidad(getAceleracion() + 2.0f);

        System.out.println(
                getNombre() + " aceleró rápidamente."
        );
    }

    @Override
    public void usarHabilidad() {
        aumentarVelocidad(8.0f);

        System.out.println(
                getNombre() + " utilizó TURBO."
        );
    }
}