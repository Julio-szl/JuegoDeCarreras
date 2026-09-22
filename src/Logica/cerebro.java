import javax.swing.*;
import java.awt.*;

public class PistaPanel extends JPanel implements CarreraListener {

    private Carrera carrera;

    private static final int MARGEN = 30;
    private static final int ALTO_GRASS = 55;
    private static final int ALTO_BORDE = 12;

    private static final Color COLOR_GRASS = new Color(0xD9, 0xA8, 0x4A);
    private static final Color COLOR_PISTA = new Color(0x8A, 0x8F, 0x98);
    private static final Color COLOR_ARBUSTO = new Color(0x4C, 0xA6, 0x4C);

    public PistaPanel() {
        setPreferredSize(new Dimension(900, 300));
        setBackground(COLOR_GRASS);
    }

    public <Carrera> void setCarrera(Carrera carrera) {
        this.carrera = (Carrera) (Carrera) carrera;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g0) {
        super.paintComponent(g0);
        Graphics2D g = (Graphics2D) g0;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        int ancho = getWidth();
        int alto = getHeight();

        dibujarFondo(g, ancho, alto);

        int yPistaInicio = ALTO_GRASS + ALTO_BORDE;
        int yPistaFin = alto - ALTO_GRASS - ALTO_BORDE;
        int altoPista = yPistaFin - yPistaInicio;

        dibujarBordeAjedrezado(g, 0, ALTO_GRASS, ancho, ALTO_BORDE);
        dibujarBordeAjedrezado(g, 0, yPistaFin, ancho, ALTO_BORDE);

        g.setColor(COLOR_PISTA);
        g.fillRect(0, yPistaInicio, ancho, altoPista);

        dibujarLineaSalida(g, MARGEN, yPistaInicio, altoPista);
        dibujarCarriles(g, yPistaInicio, altoPista, ancho);
        dibujarMeta(g, ancho - MARGEN, yPistaInicio, altoPista);

        if (carrera != null) {
            int yCarril1 = yPistaInicio + altoPista / 4 - 12;
            int yCarril2 = yPistaInicio + (altoPista * 3) / 4 - 12;

            dibujarVehiculo(g, carrera.getVehiculo1(), ancho, yCarril1, new Color(0xE8, 0x7B, 0x1E));
            dibujarVehiculo(g, carrera.getVehiculo2(), ancho, yCarril2, new Color(0x2A, 0x5C, 0xC9));
        }
    }

    private void dibujarFondo(Graphics2D g, int ancho, int alto) {
        g.setColor(COLOR_GRASS);
        g.fillRect(0, 0, ancho, alto);

        dibujarArbusto(g, 60, 15);
        dibujarArbusto(g, 260, 25);
        dibujarArbusto(g, ancho - 150, 18);
        dibujarArbol(g, ancho - 80, alto - 45);
        dibujarArbusto(g, 120, alto - 30);
    }

    private void dibujarArbusto(Graphics2D g, int x, int y) {
        g.setColor(COLOR_ARBUSTO);
        g.fillOval(x, y, 26, 16);
        g.fillOval(x + 14, y - 4, 22, 18);
    }

    private void dibujarArbol(Graphics2D g, int x, int y) {
        g.setColor(new Color(0x8B, 0x5A, 0x2B));
        g.fillRect(x + 8, y + 14, 6, 14);
        g.setColor(COLOR_ARBUSTO);
        g.fillOval(x, y, 24, 22);
    }

    private void dibujarBordeAjedrezado(Graphics2D g, int x, int y, int ancho, int alto) {
        int lado = alto;
        boolean rojo = true;
        for (int px = x; px < x + ancho; px += lado) {
            g.setColor(rojo ? Color.RED : Color.WHITE);
            g.fillRect(px, y, lado, alto);
            rojo = !rojo;
        }
    }

    private void dibujarLineaSalida(Graphics2D g, int x, int yInicio, int altoPista) {
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(4));
        g.drawLine(x, yInicio, x + 40, yInicio + altoPista);
    }

    private void dibujarCarriles(Graphics2D g, int yInicio, int altoPista, int ancho) {
        int yMedio = yInicio + altoPista / 2;
        g.setColor(Color.WHITE);
        for (int x = MARGEN; x < ancho - MARGEN; x += 30) {
            g.fillRect(x, yMedio - 2, 16, 4);
        }
    }

    private void dibujarMeta(Graphics2D g, int x, int yInicio, int altoPista) {
        int lado = 10;
        boolean negro = true;
        for (int y = yInicio; y < yInicio + altoPista; y += lado) {
            g.setColor(negro ? Color.BLACK : Color.WHITE);
            g.fillRect(x, y, lado, lado);
            negro = !negro;
        }
    }

    private void dibujarVehiculo(Graphics2D g, Vehiculo v, int anchoPanel, int y, Color color) {
        double progreso = carrera.getProgreso(v);
        int anchoAuto = 40;
        int recorridoDisponible = anchoPanel - MARGEN * 2 - anchoAuto;
        int x = MARGEN + (int) (progreso * recorridoDisponible);

        if (v.getVelocidadActual() > v.getVelocidadBase() + 0.3) {
            g.setColor(new Color(255, 255, 255, 160));
            g.fillRect(x - 10, y + 5, 6, 3);
            g.fillRect(x - 18, y + 12, 8, 3);
        }

        g.setColor(color);
        g.fillRoundRect(x, y, anchoAuto, 18, 6, 6);

        g.setColor(color.darker());
        g.fillRect(x + 10, y - 6, 16, 8);
        g.setColor(new Color(0xBF, 0xE6, 0xF5));
        g.fillRect(x + 12, y - 5, 6, 6);

        g.setColor(Color.BLACK);
        g.fillOval(x + 4, y + 14, 10, 10);
        g.fillOval(x + anchoAuto - 14, y + 14, 10, 10);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x + 7, y + 17, 4, 4);
        g.fillOval(x + anchoAuto - 11, y + 17, 4, 4);

        g.setColor(Color.BLACK);
        g.drawString(v.getNombre(), x, y - 10);
    }

    @Override
    public void onActualizacion(Carrera c) {
        repaint();
    }

    @Override
    public void onFinCarrera(Vehiculo ganador) {
        repaint();
    }
}