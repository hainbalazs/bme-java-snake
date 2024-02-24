package gamemotor;

/**
 * The GreenApple class represents a toxic treat.
 */
public class GreenApple extends Treats {
    public GreenApple(Table t, String src) {
        super(t, src);
    }

    /**
     * Handles the event when the green apple is eaten by a snake.
     * When eaten, the snake dies.
     *
     * @param s The snake that ate the green apple.
     */
    @Override
    public void eaten(Snake s) {
        s.die();
    }
}
