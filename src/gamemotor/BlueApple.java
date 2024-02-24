package gamemotor;

/**
 * The BlueApple class represents a treat which boosts the speed of the snake.
 */
public class BlueApple extends Treats {
    public BlueApple(Table t, String src) {
        super(t, src);
    }

    /**
     * Handles the event when the blue apple is eaten by a snake.
     * When eaten, the snake speeds up by 10%, grows by 1 block, and the apple is respawned at a random empty position on the table.
     *
     * @param s The snake that ate the blue apple.
     */
    @Override
    public void eaten(Snake s) {
        s.speedUp(0.10);
        s.grow(1);
        remove();
        setRandomEmptyPos();
        place();
    }
}
