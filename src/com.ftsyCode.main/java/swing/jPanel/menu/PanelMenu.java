package swing.jPanel.menu;

import principal.Menu;
import principal.Partida;
import swing.componentes.ButtonMenu;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelMenu extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    //Partida
    private Partida partida;
    private ArrayList<String> menu;
    //Colores
    private Color newBlack3 = Color.decode("#3a3a3a");
    //Botones
    private ArrayList<JButton> listButtons = new ArrayList<JButton>();

    public PanelMenu(Partida partida) {
        this.partida = partida;
        this.menu = partida.ObtenerMenu();
        //Cargar atributos
        setLayout(null);
        setBackground(Color.black);
        JLabel l1 = new JLabel("Bienvenido a War Planet");
        JLabel l2 = new JLabel("Diogo entertainment");
        l1.setBounds(5,5,325,60);
        l2.setBounds(0,385,340,50);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(new Font("Courier New",Font.PLAIN,21));
        l2.setFont(new Font("Courier New",Font.PLAIN,13));
        l1.setForeground(Color.green);
        l2.setForeground(Color.green);

        Border border = BorderFactory.createLineBorder(Color.green, 2);
        l1.setBorder(border);
        l1.setBackground(this.newBlack3);
        l1.setOpaque(true);

        add(l1);
        add(l2);
        //Generar los botones
        int y = 70;
        for (String text : menu){
            ButtonMenu button = new ButtonMenu(5, y, 325, 50, text);
            listButtons.add(button.getButtonBlackMenu());
            //Aumentamos la Y
            y += 55;
        }
        //Agremamos los botones
        for (JButton button : listButtons){
            add(button);
            button.addActionListener(this);
        }
    }


    @Override
    public void actionPerformed(ActionEvent boton) {
        //Cogemos el div padre
        JFrame jframe = (JFrame) SwingUtilities.getWindowAncestor(this);

        if(boton.getSource() == listButtons.get(0)) {
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            PanelPreJuego prj = new PanelPreJuego(this.partida);

            jframe.add(prj);
            jframe.setVisible(true);
        }else if(boton.getSource() == listButtons.get(1)){
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            PanelReglas pr = new PanelReglas(this.partida);

            jframe.add(pr);
            jframe.setVisible(true);

        }else if(boton.getSource() == listButtons.get(2)){
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            PanelInfo pi = new PanelInfo(this.partida);

            jframe.add(pi);
            jframe.setVisible(true);
        }else if(boton.getSource() == listButtons.get(3)){
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            PanelMusica pm = new PanelMusica(this.partida, this.partida.getHiloMusica());

            jframe.add(pm);
            jframe.setVisible(true);
        }else if(boton.getSource() == listButtons.get(4)){
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            PanelHistorial ph = new PanelHistorial(this.partida);

            jframe.add(ph);
            jframe.setVisible(true);
        }else if(boton.getSource() == listButtons.get(5)) {
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            System.exit(0);
        }

    }


}
