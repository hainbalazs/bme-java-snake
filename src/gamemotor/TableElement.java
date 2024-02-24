package gamemotor;

import utils.Position;
import java.awt.*;
import java.util.Random;

/**
 * The TableElement class represents an element on the game table.
 */
public abstract class TableElement {
    /** The table containing the element. */
    protected Table table;

    /** The position of the element on the table. */
    protected Position position;

    /** Indicates whether the element is occupied. */
    protected boolean occupied;

    /** The color of the element. */
    protected Color color;

    /** The size of a block on the table. */
    protected static int block_size;

    /**
     * Draws the table element.
     *
     * @param g The graphics context.
     */
    public abstract void draw(Graphics g);

    /**
     * Sets the size of a block on the table.
     *
     * @param blocksize The size of a block.
     */
    public static void setBlockSize(int blocksize){
        block_size = blocksize;
    }

    /**
     * Places the element on the table.
     */
    public void place(){
        table.setElement(position, this);
    }

    /**
     * Removes the element from the table.
     */
    public void remove(){
        table.setElement(position, new EmptyField(position));
    }

    /**
     * Sets a random (truly) empty position for the element on the table.
     * The engine keeps sampling new positions until the previously sampled one is occupied.
     *
     * @return The random empty position.
     */
    public Position setRandomEmptyPos(){
        Random r = new Random();
        Position p = new Position(r.nextInt(table.getWidth()), r.nextInt(table.getHeight()));
        while(table.getElement(p).occupied)
            p = new Position(r.nextInt(table.getWidth()), r.nextInt(table.getHeight()));

        position = p;
        return p;
    }

    /**
     * Handles the event when the element is eaten by a snake.
     *
     * @param s The snake that ate the element.
     */
    public abstract void eaten(Snake s);
}
