package gamemotor;

import gui.Colors;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The Treats class represents treats on the game table.
 * It is abstract as different treats have different abilities.
 */
public abstract class Treats extends TableElement {
    private Image img;

    /**
     * Constructs a Treats object with the specified table and image source.
     * Spawns the treat to a random empty position on the table.
     * @param t The table.
     * @param imgSrc The image source.
     */
    public Treats(Table t, String imgSrc) {
        occupied = true;
        table = t;

        try {
            img = ImageIO.read(new File(imgSrc)).getScaledInstance(block_size, block_size, Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }

        setRandomEmptyPos();
        place();
    }

    /**
     * Draws the treat on the table. Treats are grey squares.
     *
     * @param g The graphics context.
     */
    public void draw(Graphics g) {
        g.setColor(Colors.grey);
        g.drawImage(img, position.x*block_size, position.y*block_size, null);
    }
}
