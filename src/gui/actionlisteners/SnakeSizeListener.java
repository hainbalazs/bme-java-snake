package gui.actionlisteners;

import gui.Square;
import utils.Sizes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SnakeSizeListener class listens for events triggered when selecting the size of the snake.
 */
public final class SnakeSizeListener implements ActionListener {
    private Square p;
    private JComboBox<Sizes> s;
    private Box b;
    public SnakeSizeListener(JComboBox<Sizes> selector, Square panel, Box box) {
        s = selector;
        p = panel;
        b = box;
    }

    /**
     * Performs the action (saving the selected size and triggering UI updates) when the snake size selection event occurs.
     *
     * @param ae The event triggered by selecting the snake size.
     */
    public void actionPerformed(ActionEvent ae) {
        p.setSide(s.getItemAt(s.getSelectedIndex()));
        p.repaint();
        b.repaint();
    }
}