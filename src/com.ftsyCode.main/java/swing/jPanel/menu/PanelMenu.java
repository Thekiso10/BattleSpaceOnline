package swing.jPanel.menu;

import principal.Menu;
import principal.Partida;

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
    private Color newBlack 	= Color.decode("#222222");
    private Color newBlack2 = Color.decode("#444444");
    private Color newBlack3 = Color.decode("#3a3a3a");
    //Botones
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;

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

        this.b1=new JButton(menu.get(0));
        this.b2=new JButton(menu.get(1));
        this.b3=new JButton(menu.get(2));
        this.b4=new JButton(menu.get(3));
        this.b5=new JButton(menu.get(4));
        this.b6=new JButton(menu.get(5));
        b1.setBounds(5,70,325,50);
        b2.setBounds(5,125,325,50);
        b3.setBounds(5,180,325,50);
        b4.setBounds(5,235,325,50);
        b5.setBounds(5,290,325,50);
        b6.setBounds(5,345,325,50);
        b1.setBackground(this.newBlack);
        b1.setForeground(Color.green);
        b2.setBackground(this.newBlack);
        b2.setForeground(Color.green);
        b3.setBackground(this.newBlack);
        b3.setForeground(Color.green);
        b4.setBackground(this.newBlack);
        b4.setForeground(Color.green);
        b5.setBackground(this.newBlack);
        b5.setForeground(Color.green);
        b6.setBackground(this.newBlack);
        b6.setForeground(Color.green);

        Border borderButton = BorderFactory.createLineBorder(newBlack2, 2);
        b1.setBorder(borderButton);
        b2.setBorder(borderButton);
        b3.setBorder(borderButton);
        b4.setBorder(borderButton);
        b5.setBorder(borderButton);
        b6.setBorder(borderButton);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent boton) {
        //Cogemos el div padre
        JFrame jframe = (JFrame) SwingUtilities.getWindowAncestor(this);

        if(boton.getSource() == this.b1) {
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            PanelPreJuego prj = new PanelPreJuego(this.partida);

            jframe.add(prj);
            jframe.setVisible(true);
        }else if(boton.getSource() == this.b2){
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            PanelReglas pr = new PanelReglas(this.partida);

            jframe.add(pr);
            jframe.setVisible(true);

        }else if(boton.getSource() == this.b3){
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            PanelInfo pi = new PanelInfo(this.partida);

            jframe.add(pi);
            jframe.setVisible(true);
        }else if(boton.getSource() == this.b4){
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            PanelMusica pm = new PanelMusica(this.partida, this.partida.getHiloMusica());

            jframe.add(pm);
            jframe.setVisible(true);
        }else if(boton.getSource() == this.b5){
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            PanelHistorial ph = new PanelHistorial(this.partida);

            jframe.add(ph);
            jframe.setVisible(true);
        }else if(boton.getSource() == this.b6) {
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            System.exit(0);
        }

    }


}
