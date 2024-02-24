package gui;

import gamemotor.Table;

import javax.swing.*;
import java.awt.*;

/**
 * The Canvas class represents a panel for drawing the game elements.
 */
public class Canvas extends JPanel {
    private Table table;

    public Canvas(Table t){
        table = t;
        setBackground(Colors.grey);
        setOpaque(true);
    }

    @Override
    public void paintComponent(Graphics g){
        table.draw(g);
    }
    @Override
    public boolean isFocusable(){return true;}

}
