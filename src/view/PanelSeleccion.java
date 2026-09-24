package view;
import javax.swing.*;
import java.awt.*;

public class PanelSeleccion extends JPanel {

    private JComboBox<String> jugador1;
    private JComboBox<String> jugador2;


    public PanelSeleccion(VentanaPrincipal ventana){
        setLayout(new BorderLayout());
        setBackground(new Color(25,30,40));

        JLabel titulo = new JLabel("SELECCION DE VEHICULOS", SwingConstants.CENTER);

        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 35));

        add(titulo, BorderLayout.NORTH);

        JPanel seleccion = new JPanel(new GridLayout(1,2,40,20));

        seleccion.setOpaque(false);
        String[] carros = {
            "Rojo", "Azul", "Amarrillo", 
            "Verde"
        };

        jugador1 = new JComboBox<>(carros);
        jugador2 = new JComboBox<>(carros);

        JPanel panel1 = crearPanelJugador("JUGADOR 1", jugador1);

        JPanel panel2 = crearPanelJugador("JUGADOR 2", jugador2);

        seleccion.add(panel1);
        seleccion.add(panel2);
        

        add(seleccion, BorderLayout.CENTER);

        JButton comenzar = new JButton("COMENZAR CARRERA");
        comenzar.setFont(new Font("Arial", Font.BOLD, 20));


        comenzar.addActionListener(e -> {
            String carro1 = jugador1.getSelectedItem().toString();

            String carro2 = jugador2.getSelectedItem().toString();

            System.out.println("Jugador 1: " + carro1);

            System.out.println("Jugador 2: " + carro2);

            ventana.mostrarCarrera();
        });

        add(comenzar, BorderLayout.SOUTH);

    }

    private JPanel crearPanelJugador(String nombre, JComboBox<String> combo) {

        JPanel panel = new  JPanel();
        panel.setOpaque(false);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JLabel titulo = new JLabel(nombre);

        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 25));

        combo.setMaximumSize(new Dimension(200,40));
        combo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(titulo);
        panel.add(Box.createVerticalStrut(30));

        panel.add(combo);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

}
