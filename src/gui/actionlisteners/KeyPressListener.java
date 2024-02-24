package gui.actionlisteners;

import gamemotor.Snake;
import utils.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The KeyPressListener class listens for keyboard events to control the snakes in the game.
 */
public class KeyPressListener implements KeyListener {

    private Snake snake1, snake2;
    private gui.Canvas canvas;
    private boolean mode;

    public KeyPressListener(Snake s1, Snake s2, gui.Canvas c){
        snake1 = s1;
        snake2 = s2;
        canvas = c;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    /**
     * Handles the key pressed event to change the direction of the snakes.
     *
     * @param keyEvent The event triggered by pressing a key.
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        Direction direction1 = snake1.getDirection();
        Direction direction2 = null;
        if(snake2 != null)
            direction2 = snake2.getDirection();


        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_LEFT:
                direction1 = new Direction(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                direction1 = new Direction(1, 0);
                break;
            case KeyEvent.VK_UP:
                direction1 = new Direction(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                direction1 = new Direction(0, 1);
                break;
            case KeyEvent.VK_A:
                direction2 = new Direction(-1, 0);
                break;
            case KeyEvent.VK_D:
                direction2 = new Direction(1, 0);
                break;
            case KeyEvent.VK_W:
                direction2 = new Direction(0, -1);
                break;
            case KeyEvent.VK_S:
                direction2 = new Direction(0, 1);
                break;
            default:
                return;
        }

        snake1.changeDir(direction1);
        if(snake2 != null)
            snake2.changeDir(direction2);

        canvas.repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
