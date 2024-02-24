package gamemotor;


import utils.Position;

import java.awt.*;

/**
 * The Table class represents the game table.
 */
public class Table {
    /** The width of the table. */
    private static int width;

    /** The height of the table. */
    private static int height;

    /** The elements on the table. */
    private TableElement[][] table;

    public Table(Dimension windowsize, int blockSize){
        if(windowsize.width % blockSize != 0 || windowsize.height % blockSize != 0)
            throw new IllegalArgumentException("The size of the board must be a multiple of 120 px!");
        if(windowsize.width > 1920 || windowsize.height > 720)
            throw new IllegalArgumentException("The table size is too large!");

        width = windowsize.width / blockSize;
        height= windowsize.height / blockSize;
        table = new TableElement[width][height];

        TableElement.setBlockSize(blockSize);

        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                setElement(new Position(i, j), new EmptyField(new Position(i, j)));

        Treats[] apples = {new RedApple(this, "img/redapple.png"), new GreenApple(this, "img/greenapple.png"), new BlueApple(this, "img/blueapple.png")};

    }

    /**
     * Guides the position to stay within the table boundaries.
     *
     * @param p The position to guide.
     */
    public static void guide(Position p){
        p.set((p.x + width) % width, (p.y + height) % height);
    }

    /**
     * Gets the height of the table.
     *
     * @return The height of the table.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the width of the table.
     *
     * @return The width of the table.
     */
    public int getWidth() {
        return width;
    }


    /**
     * Draws the table and its elements.
     *
     * @param g The graphics context.
     */
    public void draw(Graphics g){
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                (table[i][j]).draw(g);
    }

    /**
     * Sets an element at the nearest valid position to the requested position on the table.
     *
     * @param pos The position to set the element.
     * @param e The element to set.
     */
    public void setElement(Position pos, TableElement e){
        guide(pos);
        table[pos.x][pos.y] = e;
    }

    /**
     * Gets the element at the nearest valid position to the requested position on the table.
     *
     * @param pos The position to get the element.
     * @return The element at the specified position.
     */
    public TableElement getElement(Position pos){
        guide(pos);
        return table[pos.x][pos.y];
    }
}
