package gamemotor;

/**
 * The RedApple class represents treat, which makes the snake grow. Always respawns after being eaten.
 */
public class RedApple extends Treats {
    public RedApple(Table t, String src) {
        super(t, src);
    }

    /**
     * Handles the event when the red apple is eaten by a snake.
     * When eaten, the snake grows by 1 block, and the apple is respawned at a random empty position on the table.
     *
     * @param s The snake that ate the red apple.
     */
    @Override
    public void eaten(Snake s) {
        s.grow(1);
        remove();
        setRandomEmptyPos();
        place();
    }

}
