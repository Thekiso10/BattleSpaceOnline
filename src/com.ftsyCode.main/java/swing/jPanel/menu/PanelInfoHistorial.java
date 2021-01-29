package swing.jPanel.menu;

import principal.Menu;
import principal.Partida;
import utils.Historial;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelInfoHistorial extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    //Partida
    private Partida partida;
    //Colores
    private Color newBlack 	= Color.decode("#222222");
    private Color newBlack3 = Color.decode("#3a3a3a");
    //Botones
    private JButton b1;
    //ArrayList
    private ArrayList<String> ganadores = new ArrayList<String>();

    public PanelInfoHistorial(boolean historial, Partida partida) {
        this.partida = partida;

        setLayout(null);
        setBackground(Color.black);

        JTextArea textArea = new JTextArea(1, 1);

        textArea.setEditable(false);

        Historial hist = new Historial();
        if(!historial) {
            ganadores = hist.MostrarRanking();
            textArea.append("\t<| --- Ranking --- |>\n");
            for (String win : ganadores) {
                textArea.append(win + "\n");
            }
        }else {
            ArrayList<Historial> listHistorial = new ArrayList<Historial>();
            listHistorial = hist.MostrarHistorial();
            if (listHistorial.size() != 0) {
                textArea.append("\t<| --- Historial de Ganadores --- |>\n");
                for (Historial lista : listHistorial) {
                    textArea.append(" ----------------------------------------"+"\n");
                    textArea.append(" |<Nombre de Equipo>  ->  "+lista.getNombreEquipo()+"\n");
                    textArea.append(" |<Nombre de Planeta> -> "+lista.getNombrePlaneta()+"\n");
                    textArea.append(" |<Numero de Equipos> -> "+lista.getNumeroEquipos()+"\n");
                    textArea.append(" |<Numero de Rondas>  -> "+lista.getNumeroRondas()+"\n");
                    textArea.append(" |<Fecha>  -> "+lista.getMostrarFecha()+"\n");
                    textArea.append(" ----------------------------------------"+"\n");
                }
            }else {
                textArea.append("\t<| --- No hay registro de ning�n ganador --- |>\n");
            }
        }

        Border borderArea = BorderFactory.createLineBorder(Color.green, 2);
        textArea.setBounds(5,70,325,60);
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.green);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(7,72,323,270);
        scrollPane.setBackground(Color.black);
        scrollPane.setBorder(borderArea);
        scrollPane.setOpaque(true);
        add(scrollPane);

        //Boton para volver al menu
        this.b1=new JButton("Volver atras");
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

            PanelHistorial ph = new PanelHistorial(this.partida);

            jframe.add(ph);
            jframe.setVisible(true);
        }
    }
}