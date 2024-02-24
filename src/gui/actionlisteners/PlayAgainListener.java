package gui.actionlisteners;

import gui.Controller;
import io.Player;
import utils.Sizes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The PlayAgainListener class listens for events triggered when restarting the game.
 */
public class PlayAgainListener implements ActionListener {
    private Controller c;
    private Player player1, player2;
    private Sizes s;

    public PlayAgainListener(Controller controller, Player p1, Player p2, Sizes blocksize){
        c = controller;
        player1 = p1;
        player2 = p2;
        s = blocksize;
    }

    /**
     * Restarts the game when the play again event occurs.
     *
     * @param actionEvent The event triggered by restarting the game.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        c.startGame(player1, player2, s);
    }
}
