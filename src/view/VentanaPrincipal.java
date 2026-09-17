package view;

import javax.swing.*;
import java.awt.*;



public class VentanaPrincipal extends JFrame {

    private CardLayout cardLayout;
    private JPanel panelContenedor;
    
    private PanelMenu panelMenu;
    private PanelSeleccion panelSeleccion;
    private PanelCarrera panelCarrera;
    private PanelResultados panelResultados;

    public VentanaPrincipal(){
        setTitle("Turbo Race");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);

        panelMenu = new PanelMenu(this);
        panelSeleccion = new PanelSeleccion(this);
        panelCarrera = new PanelCarrera(this);
        panelResultados = new PanelResultados(this);

        panelContenedor.add(panelMenu, "MENU");
        panelContenedor.add(panelSeleccion, "SELECCION");
        panelContenedor.add(panelCarrera, "CARRERA");
        panelContenedor.add(panelResultados, "RESULTADOS");

        add(panelContenedor);

        mostrarMenu();

    }
    public void  mostrarMenu(){
        cardLayout.show(panelContenedor, "MENU");
    }

    public void mostrarSeleccion(){
        cardLayout.show(panelContenedor, "SELECCION");
    }
    public void mostrarCarrera(){
        cardLayout.show(panelContenedor, "CARRERA");

        SwingUtilities.invokeLater(() -> panelCarrera.requestFocusInWindow());

    }
    public void mostrarResultado(String ganador){
        panelResultados.setGanador(ganador);
        cardLayout.show(panelContenedor, "RESULTADOS");
    }
    
}
