package model;

public class RayoJoaquin extends Vehiculo {

    public RayoJoaquin(String nombre, String imagen) {
        super(
                nombre,
                0.0f,
                6.0f,
                0.0f,
                imagen
        );
    }

    @Override
    public void acelerar() {
        aumentarVelocidad(getAceleracion());

        System.out.println(
                getNombre() + " aceleró con velocidad supersónica."
        );
    }

    @Override
    public void usarHabilidad() {
        aumentarVelocidad(12.0f);
        aumentarDistancia(8.0f);

        System.out.print(
                getNombre() + " utilizó ¡KACHOW!."
        );
    }
}