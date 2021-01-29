package swing.jPanel.menu;

import hilos.HiloMusica;
import principal.Menu;
import principal.Partida;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.concurrent.TimeUnit;

public class PanelMusica extends JPanel implements ActionListener, AdjustmentListener {
    private static final long serialVersionUID = 1L;
    //Partida
    private Partida partida;
    private HiloMusica playMusic;
    //Colores
    private Color newBlack 	= Color.decode("#222222");
    private Color newBlack3 = Color.decode("#3a3a3a");
    private Color newGreen  = Color.decode("#00b900");
    //Botones
    private JButton b1;
    private JButton mute;
    private JButton reset;
    //Panel de escoger volumen
    private JScrollBar barra;
    private JTextArea ta;
    private JLabel textSonidoM;
    private JLabel textSonido;
    private String text;
    private String textBoton;
    private String textArea;

    public PanelMusica(Partida partida, HiloMusica playMusic) {
        this.partida = partida;
        this.playMusic = playMusic;

        setLayout(null);
        setBackground(Color.black);

        int volumen = (int) this.partida.getMusic().getVolume() - 1;
        textArea = String.valueOf(volumen + 1);
        //Panel para mutear
        barra = new JScrollBar(JScrollBar.HORIZONTAL,volumen,1,0,100);
        barra.setBounds(10,177,170,20);
        barra.setBackground(newBlack3);
        barra.addAdjustmentListener(this);

        this.textSonido = new JLabel("<html>Escoge el volumen</html>");
        textSonido.setBounds(10,135,200,60);
        textSonido.setFont(new Font("Courier New",Font.PLAIN,13));
        textSonido.setForeground(Color.green);

        Border borderArea = BorderFactory.createLineBorder(newGreen, 1);
        ta = new JTextArea(textArea,1,1);
        ta.setBorder(borderArea);
        ta.setBounds(225,167,60,37);
        ta.setFont(new Font("Courier New",Font.PLAIN,32));
        ta.setForeground(Color.green);
        ta.setBackground(this.newBlack);
        ta.setEditable(false);
        //Botones para mutear/No mutear
        this.mute = new JButton();

        if (this.partida.getMusic().getMute()) {
            text = "<html>Ahora mismo tienes el audio muteado</html>";
            textBoton = "desmutear";
            mute.setBounds(202,215,108,40);
        }else {
            text = "<html>Ahora mismo tienes el audio desmuteado</html>";
            textBoton = "mutear";
            mute.setBounds(205,215,100,40);
        }

        mute.setText(textBoton);
        mute.setBackground(this.newBlack);
        mute.setForeground(Color.green);
        mute.addActionListener(this);

        this.textSonidoM = new JLabel(text);
        textSonidoM.setBounds(10,205,200,60);
        textSonidoM.setFont(new Font("Courier New",Font.PLAIN,13));
        textSonidoM.setForeground(Color.green);

        add(textSonidoM);
        add(mute);
        //Boton para recetar la musica
        this.reset = new JButton("Resetear musica");
        reset.setBounds(25,275,280,50);
        reset.setBackground(this.newBlack);
        reset.setForeground(Color.green);
        reset.addActionListener(this);
        add(reset);
        //Boton para volver al menu
        this.b1 = new JButton("Volver al menu");
        b1.setBounds(5,345,325,50);
        b1.setBackground(this.newBlack);
        b1.setForeground(Color.green);
        add(b1);
        b1.addActionListener(this);
        //label de la compa�ia
        JLabel img1 = new JLabel();
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

        img1.setIcon(new ImageIcon("res/images/logoMisiles.png"));
        img1.setBounds(20,0,340,220);

        Border border = BorderFactory.createLineBorder(Color.green, 2);
        l1.setBorder(border);
        l1.setBackground(this.newBlack3);
        l1.setOpaque(true);

        add(textSonido);
        add(barra);
        add(img1);
        add(ta);
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

        if(boton.getSource() == this.mute) {
            this.partida.getMusic().playBotonMenu();
            this.partida.getMusic().setMute(!this.partida.getMusic().getMute());

            if(mute.getBackground() != Color.green) {
                mute.setBackground(Color.green);
                mute.setForeground(this.newBlack);
            }else {
                mute.setBackground(this.newBlack);
                mute.setForeground(Color.green);
            }
        }

        if(boton.getSource() == this.reset) {
            this.partida.getMusic().playBotonMenu();
            this.playMusic.stopMusicaMenu();

            try {
                //Paramos el sistema para que se vea la transicion
                TimeUnit.SECONDS.sleep(1);
                this.playMusic = new HiloMusica(this.partida.getMusic());
                this.playMusic.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent event) {
        if(event.getSource() == barra) {
            int nuevoVolumen = barra.getValue() + 1;
            textArea = String.valueOf(nuevoVolumen);
            ta.setText(textArea);
            this.partida.getMusic().setVolume(nuevoVolumen);
        }
    }

}
