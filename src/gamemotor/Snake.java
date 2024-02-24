package gamemotor;

import gui.Controller;
import io.Player;
import utils.*;
import gui.Colors;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;


/**
 * The Snake class represents a snake in the game.
 */
public class Snake {
    private LinkedList<SnakeBlock> snake;
    private SnakeBlock head;
    private Direction direction;
    private Player player;
    private Controller controller;
    private Color color;
    private Table table;

    public Snake(Player p, Color c, Table t, Controller control){
        table = t;
        controller = control;
        player = p;
        color = c;

        direction = new Direction(1,0);
        snake = new LinkedList<>();

        head = new SnakeBlock(table, Colors.getDarker(c));
        head.setRandomEmptyPos();
        head.place();
        snake.add(head);
        grow(3);

    }

    /**
     * Moves the snake one step forward.
     * Eats whatever might be on the new TableElement, spawns a new head block and removes the last according to the given direction.
     */
    public void move(){
        SnakeBlock b = snake.removeLast();
        b.remove();
        TableElement whatsThere = b.front(snake.getFirst(), direction);
        eat(whatsThere);
        b.place();
        head.recolor(color);
        snake.set(0, head);
        snake.addFirst(b);
        head = b;
    }

    /**
     * Changes the direction of the snake. (Also used for starting the game.)
     *
     * @param d The new direction.
     */
    public void changeDir(Direction d){
        controller.addTimer(this);
        if(!controller.timerIsRunning(this))
            controller.startTimer(this);

        if(d.x != direction.x * -1 || d.y != direction.y * -1)
            direction = d;
    }

    /**
     * Eats an element on the table.
     *
     * @param element The element to be eaten.
     */
    private void eat(TableElement element){
        element.eaten(this);
    }

    /**
     * Gets the length of the snake.
     *
     * @return The length of the snake.
     */
    private int getLength(){
        return snake.size();
    }

    /**
     * Grows the snake by the specified number of blocks.
     *
     * @param times The number of blocks by which the snake should grow.
     */
    public void grow(int times){
        SnakeBlock last = snake.get(snake.size() - 1);
        for(int i = 0; i < times; i++) {
            SnakeBlock block = new SnakeBlock(table ,color);
            block.followPrevPos(last, direction);
            block.place();
            snake.add(block);
            last = block;
        }
        if(getLength() % 5 == 0)
            speedUp(0.20);
    }

    /**
     * Speeds up the snake movement by the specified percentage.
     *
     * @param percent The percentage by which to speed up the snake.
     */
    public void speedUp(double percent){
        controller.decreaseTimerDelay(this, percent);
    }

    /**
     * Handles the event when the snake dies.
     * Save the current scores, stop the timmers, and trigger the controller.
     */
    public void die() {
        controller.stopTimer();
        player.setScore(getLength());
        try {
            controller.showResults(player);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the current direction of the snake.
     *
     * @return The direction of the snake.
     */
    public Direction getDirection() {
        return direction;
    }
}
