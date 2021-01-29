package swing.componentes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ButtonMenu{

    //Caracteristicas basicas de los botones
    private int x;
    private int y;
    private int width;
    private int height;
    private String text;

    public ButtonMenu (int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public JButton getButtonBlackMenu(){
        //Definir colores
        Color baseColor = Color.decode("#222222");
        Color borderColor = Color.decode("#444444");
        Color letterBase = Color.green;
        //Devolver los botones
        return generateButton(baseColor, borderColor, letterBase, 2);
    }

    private JButton generateButton(Color baseColor, Color borderColor, Color letterBase, int valueBorder){

        JButton button = new JButton(this.text);
        button.setBounds(this.x,this.y,this.width,this.height);
        button.setBackground(baseColor);
        button.setForeground(letterBase);
        button.setBorder(BorderFactory.createLineBorder(borderColor, valueBorder));

        return button;
    }
}
