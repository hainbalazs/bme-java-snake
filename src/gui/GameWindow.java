package gui;

import gamemotor.Snake;
import gamemotor.Table;
import gui.actionlisteners.KeyPressListener;

import javax.swing.*;

/**
 * The GameWindow class represents the game window for displaying the game canvas.
 */
public class GameWindow {

    /**
     * Constructs a GameWindow object with the specified JFrame, table, and snakes.
     *
     * @param window The JFrame object representing the game window.
     * @param t The Table object representing the game table.
     * @param s1 The first Snake object.
     * @param s2 The second Snake object.
     */
    public GameWindow(JFrame window, Table t, Snake s1, Snake s2){
        window.getContentPane().removeAll();
        Canvas canvas = new Canvas(t);
        canvas.setPreferredSize(window.getSize());
        window.add(canvas);
        canvas.setFocusable(true);
        canvas.addKeyListener(new KeyPressListener(s1, s2, canvas));
        canvas.setFocusTraversalKeysEnabled(false);
        canvas.requestFocusInWindow();
        window.setResizable(false);
        window.pack();
    }
}
