package model;

import java.util.Random;

public class Computadora extends Jugador {

    private String dificultad;
    private Random random;
    
    public Computadora(String name, Vehiculo vehiculo, String dificultad) {
        super(name, vehiculo);
        this.dificultad = dificultad;
    }

    // CON ESTE METODO AUN FALTA REVISAR LAS PROBABILIDADES DE MOVIMIENTO, YA QUE NO SE SI ESTAN BIEN PUESTAZZZZZZZZ
    @Override
    public void decidirMovimiento() {
        random = new Random();
        double probabilidad = random.nextDouble();
        double distancia = 0.0;

        switch (dificultad) {
            case "Fácil" -> {
                if (probabilidad < 0.7) {
                    distancia = 1;
                } else {
                    distancia = 1;
                }
            }
            case "Normal" -> {
                if (probabilidad < 0.5) {
                    distancia = 1;
                } else {
                    distancia = 1;
                }
            }
            case "Difícil" -> {
                if (probabilidad < 0.3) {
                    distancia = 1;
                } else {
                    distancia = 1;
                }
            }
            default -> throw new IllegalArgumentException("Dificultad no válida: " + dificultad);
        }
        avanzar(distancia);
    }
}
