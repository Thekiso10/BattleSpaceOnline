package swing.jPanel.menu;

import principal.Menu;
import principal.Partida;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelReglas extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    //Partida
    private Partida partida;
    //Colores
    private Color newBlack 	= Color.decode("#222222");
    private Color newBlack3 = Color.decode("#3a3a3a");
    //Botones
    private JButton b1;

    public PanelReglas(Partida partida) {
        this.partida = partida;

        setLayout(null);
        setBackground(Color.black);

        //Panel de las reglas
        JLabel img1	= new JLabel();
        JLabel rgl1 = new JLabel(partida.ObtenerMenuReglas().get(0));

        img1.setIcon(new ImageIcon("res/images/logoMisiles.png"));
        img1.setBounds(20,0,340,220);

        rgl1.setBounds(-15,125,340,200);
        rgl1.setFont(new Font("Courier New",Font.PLAIN,13));
        rgl1.setForeground(Color.green);

        //Boton para volver al menu
        this.b1=new JButton("Volver al menu");
        b1.setBounds(5,345,325,50);
        b1.setBackground(this.newBlack);
        b1.setForeground(Color.green);
        add(b1);
        b1.addActionListener(this);
        //label de la compa�ia
        JLabel l1 = new JLabel("Bienvenido a War Planet");
        JLabel l2 = new JLabel("Diogo entertainment�");
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

        add(img1);
        add(rgl1);

        add(l1);
        add(l2);
    }
    @Override
    public void actionPerformed(ActionEvent boton) {
        //Cogemos el div padre
        JFrame jframe = (JFrame) SwingUtilities.getWindowAncestor(this);

        if(boton.getSource() == this.b1) {
            this.partida.getMusic().playBotonMenu();
            jframe.remove(this);

            PanelMenu pm = new PanelMenu(this.partida);

            jframe.add(pm);
            jframe.setVisible(true);
        }
    }

}
