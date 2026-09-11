package model.Vehiculos;

public class MrBean extends Vehiculo {

    public MrBean(String nombre, String imagen) {
        super(
                nombre,
                0.0f,
                2.5f,
                0.0f,
                imagen
        );
    }

    @Override
    public void acelerar() {
        aumentarVelocidad(getAceleracion());

        System.out.println(
                getNombre() + " aceleró con mucha energía."
        );
    }

    @Override
    public void usarHabilidad() {
        aumentarVelocidad(3.0f);
        aumentarDistancia(10.0f);

        System.out.println(
                getNombre() + " utilizó ¡IMPULSO COMPACTO!"
        );
    }
}