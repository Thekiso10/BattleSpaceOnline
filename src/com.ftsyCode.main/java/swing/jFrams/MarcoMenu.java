package swing.jFrams;

import principal.Partida;
import swing.jPanel.menu.PanelMenu;
import utils.Config;

import javax.swing.*;
import java.awt.*;

public class MarcoMenu extends JFrame {
    private static final long serialVersionUID = 1L;

    public MarcoMenu(Config config, Partida partida) {
        //Colocar los valores por defecto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Integer.parseInt(config.getProperty("battleSpaceOnline.config.menu.marco.size.width", "1")),Integer.parseInt(config.getProperty("battleSpaceOnline.config.menu.marco.size.height", "1")));
        //Bloquear que no se pueda redimencionar la ventana
        setResizable(false);
        //Colocar en medio de la pantalla
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        PanelMenu pm = new PanelMenu(partida);

        add(pm);
        setVisible(true);
    }
}
