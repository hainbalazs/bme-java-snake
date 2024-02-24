package gui;

import utils.Sizes;

import javax.swing.*;
import java.awt.*;

/**
 * The Square class is a UI representation of a snake block.
 */
public class Square extends JPanel {

    private Sizes side_;

    public Square(Sizes side){
        side_ = side;
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(Sizes.small.getBlockSize_(), Sizes.small.getBlockSize_());
    }

    @Override
    public Dimension getPreferredSize() {
        return getMaximumSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(Sizes.large.getBlockSize_()+1, Sizes.large.getBlockSize_()+2);
    }

    public void setSide (Sizes s){
        side_ = s;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Colors.green);
        g.fillRect(0, (Sizes.large.getBlockSize_() - side_.getBlockSize_()) / 2, side_.getBlockSize_(), side_.getBlockSize_());
        g.setColor(Colors.grey_deep);
        g.drawRect(0, (Sizes.large.getBlockSize_() - side_.getBlockSize_()) / 2, side_.getBlockSize_(), side_.getBlockSize_());
    }
}
