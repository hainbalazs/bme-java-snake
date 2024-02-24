package utils;

/**
 * The Direction class represents a 2D direction with x and y components.
 */
public class Direction extends Position{

    /**
     * Constructs a new Direction object with the specified x and y components.
     *
     * @param x_ The x-component of the direction.
     * @param y_ The y-component of the direction.
     */
    public Direction(int x_, int y_) {
        super(x_ , y_ );
    }
    
    /**
     * Reverses the direction by negating both x and y components.
     *
     * @return A new Direction object representing the reversed direction.
     */
    public Direction reverse(){
        return new Direction(-x, -y);
    }
}
