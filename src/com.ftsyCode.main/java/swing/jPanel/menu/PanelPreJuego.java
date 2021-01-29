package swing.jPanel.menu;

import principal.CrearEquipos;
import principal.Menu;
import principal.Partida;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPreJuego extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    //Partida
    private Partida partida;
    //Colores
    private Color newBlack 	= Color.decode("#222222");
    private Color newBlack3 = Color.decode("#3a3a3a");
    //Botones
    private JButton play;
    private JButton b1;
    private JRadioButton b3;
    private JRadioButton b4;
    private JRadioButton b5;
    private JRadioButton b6;
    private JRadioButton b7;
    private JRadioButton b8;
    private JRadioButton b9;
    private JRadioButton b10;
    private ButtonGroup group;

    public PanelPreJuego(Partida partida) {

        this.partida = partida;

        setLayout(null);
        setBackground(Color.black);

        //Imagen
        JLabel img1	= new JLabel();
        img1.setIcon(new ImageIcon("res/images/logoMisiles.png"));
        img1.setBounds(20,0,340,220);
        //Seleccionar numeros de equipos
        b3 = new JRadioButton("3 Equipos",true);
        b4 = new JRadioButton("4 Equipos");
        b5 = new JRadioButton("5 Equipos");
        b6 = new JRadioButton("6 Equipos");
        b7 = new JRadioButton("7 Equipos");
        b8 = new JRadioButton("8 Equipos");
        b9 = new JRadioButton("9 Equipos");
        b10 = new JRadioButton("10 Equipos");
        //Para poder obtener el numero de equipos
        b3.setActionCommand("3"); b4.setActionCommand("4");
        b5.setActionCommand("5"); b6.setActionCommand("6");
        b7.setActionCommand("7"); b8.setActionCommand("8");
        b9.setActionCommand("9"); b10.setActionCommand("10");

        b3.setBounds(45,155,105,25);
        b4.setBounds(45,190,105,25);
        b5.setBounds(45,225,105,25);
        b6.setBounds(45,260,105,25);
        b7.setBounds(200,155,105,25);
        b8.setBounds(200,190,105,25);
        b9.setBounds(200,225,105,25);
        b10.setBounds(200,260,105,25);

        b3.setBackground(Color.black); b4.setBackground(Color.black);
        b5.setBackground(Color.black); b6.setBackground(Color.black);
        b7.setBackground(Color.black); b8.setBackground(Color.black);
        b9.setBackground(Color.black); b10.setBackground(Color.black);

        b3.setForeground(Color.green); b4.setForeground(Color.green);
        b5.setForeground(Color.green); b6.setForeground(Color.green);
        b7.setForeground(Color.green); b8.setForeground(Color.green);
        b9.setForeground(Color.green); b10.setForeground(Color.green);

        b3.setFont(new Font("Courier New",Font.PLAIN,13)); b4.setFont(new Font("Courier New",Font.PLAIN,13));
        b5.setFont(new Font("Courier New",Font.PLAIN,13)); b6.setFont(new Font("Courier New",Font.PLAIN,13));
        b7.setFont(new Font("Courier New",Font.PLAIN,13)); b8.setFont(new Font("Courier New",Font.PLAIN,13));
        b9.setFont(new Font("Courier New",Font.PLAIN,13)); b10.setFont(new Font("Courier New",Font.PLAIN,13));

        group = new ButtonGroup();
        group.add(b3);
        group.add(b4);
        group.add(b5);
        group.add(b6);
        group.add(b7);
        group.add(b8);
        group.add(b9);
        group.add(b10);

        add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9);add(b10);

        this.play = new JButton("jugar");
        play.setBounds(55,298,235,40);
        play.setBackground(this.newBlack);
        play.setForeground(Color.green);
        play.addActionListener(this);
        add(play);

        //Boton para volver al menu
        this.b1=new JButton("Volver al menu");
        b1.setBounds(5,345,325,50);
        b1.setBackground(this.newBlack);
        b1.setForeground(Color.green);
        add(b1);
        b1.addActionListener(this);
        //label de la compañia
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

        add(img1);
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
        }else if(boton.getSource() == this.play) {
            this.partida.getMusic().playBotonMenu();
            try {
                int numEquipos = Integer.parseInt(group.getSelection().getActionCommand());
                //ocultamos el JFrame del menu para invocar al de crear equipos
                jframe.setVisible(false);
                jframe.remove(this);
                //Cargamos al de crear Equipos
                CrearEquipos ce = new CrearEquipos(numEquipos, this.partida.getMusic());

            } catch (Exception e) {
                e.printStackTrace();
                JLabel label = new JLabel("Ha ocurido un error inesperado. Has clic en si para volver a intentar");
                JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
