package view;

import javax.swing.*;
import  javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelMenu extends JPanel {

    public PanelMenu(VentanaPrincipal ventana){
        setLayout(new BorderLayout());
        setBackground(new Color(20,24,35));

        JLabel titulo = new JLabel("TURBO RACE", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 45));
        titulo.setForeground(Color.WHITE);

        titulo.setBorder(new EmptyBorder(80,0,40,0));

        add(titulo, BorderLayout.NORTH);

        JPanel botones = new JPanel();
        botones.setOpaque(false);

        botones.setLayout(new BoxLayout(botones, BoxLayout.Y_AXIS));
        
        JButton btnJugar = crearBoton("JUGAR");

        JButton btnInstrucciones = crearBoton("INSTRUCCIONES");

        JButton btnSalir = crearBoton("SALIR");
        
        btnJugar.addActionListener(e -> ventana.mostrarSeleccion());


        btnInstrucciones.addActionListener(e -> JOptionPane.showMessageDialog(this,"""
                JUGADOR 1 
                w = Arriba
                S = Abajdo

                JUGADOR 2
                Flecha Arriba = Arriba
                Flecha Abajo = Abajo

                ¡El primero en llegar a la meta gana!
                """
            )
        );

        btnSalir.addActionListener(e -> System.exit(0));

        botones.add(btnJugar);
        botones.add(Box.createVerticalStrut(20));

        botones.add(btnInstrucciones);
        botones.add(Box.createVerticalStrut(20));

        botones.add(btnSalir);

        add(botones, BorderLayout.CENTER);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 20));

        boton.setAlignmentX(Component.CENTER_ALIGNMENT);

        boton.setMaximumSize(new Dimension(250, 55));

        boton.setFocusPainted(false);

        return boton;
    }

}
