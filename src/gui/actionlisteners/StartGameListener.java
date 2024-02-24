package gui.actionlisteners;

import gui.Colors;
import gui.Controller;
import gui.NameVerifier;
import io.Player;
import utils.Sizes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The StartGameListener class listens for events triggered when starting the game.
 */
public class StartGameListener implements ActionListener {
    private Controller controllerRef;
    private JLabel errP;
    private JTextField p1, p2;
    private JComboBox<Sizes> bSizeList;
    private JComboBox<Integer> pNumList;

    public StartGameListener(JLabel errorPanel, JTextField pName1, JTextField pName2, JComboBox<Integer> pNumSel, JComboBox<Sizes> snakeSizeSel){
        errP = errorPanel;
        p1 = pName1;
        p2 = pName2;
        bSizeList = snakeSizeSel;
        pNumList = pNumSel;
    }

    public void setController(Controller c){
        controllerRef = c;
    }

    /**
    * The StartGameListener class listens for events triggered when starting the game.
    * Stores the players' names and invokes the controller.
    */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String[] pNames = {p1.getText(), p2.getText()};

        for(int i = 0; i < pNumList.getItemAt(pNumList.getSelectedIndex()); i++ ){
            if(pNames[i].equals("")) {
                errP.setVisible(true);
                return;
            }
        }

        Player player1 = new Player(pNames[0]);
        Player player2 = new Player(pNames[1]);

        controllerRef.startGame(player1, player2, bSizeList.getItemAt(bSizeList.getSelectedIndex()));
    }

}
