package gui.actionlisteners;

import gamemotor.Snake;
import gui.Canvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The TimeListener class listens for timer events and triggers snake movement and UI updates.
 */
public class TimeListener implements ActionListener {
    private Snake snake;
    private JFrame frame;

    public TimeListener(Snake s, JFrame f){
        snake = s;
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        snake.move();
        frame.repaint();
    }
}
