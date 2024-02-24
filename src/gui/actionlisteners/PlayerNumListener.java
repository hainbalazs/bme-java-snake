package gui.actionlisteners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The PlayerNumListener class listens for events triggered when selecting the number of players.
 */
public final class PlayerNumListener implements ActionListener {
    private Box b;
    private JComboBox<Integer> s;
    public PlayerNumListener(JComboBox<Integer> selector, Box nameHolder2) {
        s = selector;
        b = nameHolder2;
    }

    /**
     * Performs the action (saving the selected the selected parameter and triggering UI updates) when the player number selection event occurs.
     */
    public void actionPerformed(ActionEvent ae) {
        b.setVisible(s.getItemAt(s.getSelectedIndex()) == 2);
        b.repaint();
    }
}