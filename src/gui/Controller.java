package gui;

import com.fasterxml.jackson.databind.JsonMappingException;
import gamemotor.Snake;
import gamemotor.Table;
import gui.actionlisteners.StartGameListener;
import gui.actionlisteners.TimeListener;
import io.Player;

import utils.Sizes;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * The Controller class manages game control and interactions between game elements. Transitions between stages of the game.
 */
public class Controller {

    /** The first and second player. */
    private Player player1, player2;

    /** The size of the game blocks. */
    private Sizes s;

    /** The first and second snake. */
    private Snake s1, s2 = null;

    /** The timers associated with snakes. */
    private HashMap<Snake, Timer> timers;

    /** The main game window. */
    private JFrame mainWindow;

    /** Constructor */
    public Controller(JFrame frame){
        timers = new HashMap<>();
        mainWindow = frame;
    }

    /**
     * Sets up the game.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void setUp() throws IOException {
        SetupWindow sw = new SetupWindow(mainWindow);
        StartGameListener sgl = sw.getSGListener();
        sgl.setController(this);
    }

    /**
     * Starts the game with the specified players and selected block size, by opening and constructing an GameWindow.
     *
     * @param p1 The first player.
     * @param p2 The second player.
     * @param blockSize The size of the game blocks.
     */
    public void startGame(Player p1, Player p2, Sizes blockSize){
        s = blockSize;
        Table table = new Table(mainWindow.getSize(), blockSize.getBlockSize_());
        player1 = p1;
        player2 = p2;

        s1 = new Snake(p1, Colors.yellow, table, this);
        if(p2.isPlaying())
            s2 = new Snake(p2, Colors.green, table, this);

        GameWindow gw = new GameWindow(mainWindow, table, s1, s2);

    }
    
    /**
     * Shows the results of the game by opening and constructing an EndWindow.
     *
     * @param player The winning player.
     * @throws InterruptedException If the current thread is interrupted.
     * @throws IOException If an I/O error occurs.
     */
    public void showResults(Player player) throws InterruptedException, IOException, JsonMappingException {
        TimeUnit.SECONDS.sleep(1);
        EndWindow ew = new EndWindow(this, mainWindow, s, player1, player2, player, player2.isPlaying(), new File("out/ranklist.json"));

    }

    /**
     * Adds a timer for the specified snake.
     *
     * @param s The snake to add a timer for.
     */
    public void addTimer(Snake s){
        if(timers.containsKey(s))
            return;

        timers.put(s, new Timer(200, new TimeListener(s, mainWindow)));
    }

    /**
     * Decreases the delay of the timer associated with the specified snake.
     *
     * @param s The snake whose timer delay to decrease.
     * @param percent The percentage by which to decrease the timer delay.
     */
    public void decreaseTimerDelay(Snake s, double percent){
        Timer toModify = timers.get(s);
        toModify.setDelay((int)((double)toModify.getDelay() * (1 - percent)));
        timers.put(s, toModify);
    }

    /**
     * Checks if the timer associated with the specified snake is running.
     *
     * @param s The snake to check.
     * @return True if the timer associated with the snake is running, false otherwise.
     */
    public boolean timerIsRunning(Snake s){
        return timers.get(s).isRunning();
    }

    /**
     * Starts the timer associated with the specified snake.
     *
     * @param s The snake whose timer to start.
     */
    public void startTimer(Snake s){
        timers.get(s).start();
    }

    /**
     * Stops timers of all players.
     */
    public void stopTimer(){
        timers.get(s1).stop();
        if(player2.isPlaying())
            timers.get(s2).stop();
    }
}
