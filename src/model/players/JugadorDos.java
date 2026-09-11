package model.players;
import model.Vehiculos.*;

public class JugadorDos extends Jugador {

    private int teclaArriba;
    private int teclaAbajo;

    public JugadorDos(String name, Vehiculo vehiculo, int teclaArriba, int teclaAbajo) {
        super(name, vehiculo);
        this.teclaArriba = teclaArriba;
        this.teclaAbajo = teclaAbajo;
    }

    private void manejarTecla(int tecla) {
        if (tecla == teclaArriba) {
            avanzar(1); // Distancia 1 porque se mueve un carril hacia arriba
        } else if (tecla == teclaAbajo) {
            avanzar(1); // Distancia 1 porque se mueve un carril hacia abajo
        }
    }

    @Override
    public void decidirMovimiento() {
        // Aquí se implementaría la lógica para decidir el movimiento del jugador uno
        // NO HAY CODIGO DE MOMENTO!!!!!!!!!!!   
    }
}
