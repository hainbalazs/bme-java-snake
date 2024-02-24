package utils;

/**
 * The Position class represents a point in a 2D space with integer coordinates.
 */
public class Position {
    
    /** The x-coordinate of the position. */
    public int x;
    
    /** The y-coordinate of the position. */
    public int y;

    /**
     * Constructs a new Position object with the specified x and y coordinates.
     *
     * @param x_ The x-coordinate of the position.
     * @param y_ The y-coordinate of the position.
     */
    public Position(int x_, int y_){
        x = x_;
        y = y_;
    }

    /**
     * Sets the coordinates of the position to the specified values.
     *
     * @param x_ The new x-coordinate of the position.
     * @param y_ The new y-coordinate of the position.
     */
    public void set(int x_, int y_){
        x = x_;
        y = y_;
    }

}


