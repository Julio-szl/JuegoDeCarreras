package model;

import java.util.Random;

public class Deportivo extends Vehiculo {

    private Random random = new Random();

    public Deportivo(String nombre) {
        super(nombre, 10, 9, 8, 3);
    }

    @Override public int avanzar() {

        int movimiento = random.nextInt(5) + 8;

        avanzarPosicion(movimiento);

        return movimiento;
    }
}