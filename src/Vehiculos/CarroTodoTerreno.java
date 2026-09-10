package Vehiculos;

public class CarroTodoTerreno extends Vehiculo {

    public CarroTodoTerreno(String nombre, String imagen) {
        super(
                nombre,
                0.0f, // Velocidad inicial
                2.5f, // Aceleración
                0.0f, // Distancia inicial
                imagen
        );
    }

    @Override
    public void acelerar() {
        aumentarVelocidad(getAceleracion());

        System.out.println(
                getNombre() + " aceleró con tracción todoterreno."
        );
    }

    @Override
    public void usarHabilidad() {
        aumentarVelocidad(2.0f);
        aumentarDistancia(10.0f);

        System.out.println(
                getNombre()
                        + " utilizó TRACCIÓN TOTAL."
        );
    }
}