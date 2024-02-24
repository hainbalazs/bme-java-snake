package gamemotor;

import gui.Colors;
import utils.Position;

import java.awt.*;

public class EmptyField extends TableElement {

    public EmptyField(Position p){
        occupied = false;
        position = p;
        color = Colors.grey;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(position.x * block_size, position.y * block_size, block_size, block_size);
    }

    @Override
    public void eaten(Snake s) {
        /* noop */
    }
}
