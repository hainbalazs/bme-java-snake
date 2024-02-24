package gamemotor;
import gui.Colors;
import utils.Direction;
import utils.Position;

import java.awt.*;
import java.io.IOException;

/**
 * The SnakeBlock class represents a block of the snake on the game table.
 */
public class SnakeBlock extends TableElement {

    public SnakeBlock (Table t, Color c){
        table = t;
        color = c;
        occupied = true;
    }

    /**
     * Translates a snake block with d direction.
     *
     * @param last The previous snake block.
     * @param d The direction of movement.
     */
    public void followPrevPos(SnakeBlock last, Direction d){
        position = new Position(last.position.x - d.x,
                                last.position.y - d.y);
    }

    /**
     * Translates and gets the front element of the snake.
     * Front element of the snake is used to represent different states of the snake (eating a treat, collision with an object).
     * Thus the front element is always displayed distinctly.
     *
     * @param head The head of the snake.
     * @param d The direction of movement.
     * @return The element in front of the head.
     */
    public TableElement front(SnakeBlock head, Direction d){
        color = Colors.getDarker(color);
        followPrevPos(head, d.reverse());

        return table.getElement(position);
    }

    /**
     * Recolors the snake block with the specified color.
     *
     * @param c The new color.
     */
    public void recolor(Color c){
        color = c;
    }

    /**
     * Draws the snake block on the table with a border.
     *
     * @param g The graphics context.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(position.x * block_size, position.y * block_size, block_size, block_size);
        g.setColor(Colors.grey_deep);
        g.drawRect(position.x * block_size, position.y * block_size, block_size - 1, block_size - 1);
        g.setColor(Colors.grey);
    }

    /**
     * Handles the event when the snake block is eaten by a snake. (The snake dies.)
     *
     * @param s The snake that ate the block.
     */
    @Override
    public void eaten(Snake s) {
        s.die();
    }
}
