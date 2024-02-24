package gui;

import com.fasterxml.jackson.databind.JsonMappingException;
import gui.actionlisteners.PlayAgainListener;
import io.Player;
import io.RanklistModel;
import utils.Sizes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The EndWindow class represents the window displayed at the end of the game.
 */
public class EndWindow {

/**
 * Constructs an EndWindow screen displaying the results of the game.
 *
 * @param c The Controller object for game control.
 * @param window The JFrame object representing the game window.
 * @param s The size of the game.
 * @param p1 The first player.
 * @param p2 The second player.
 * @param winner The winner player. (to be set)
 * @param twoplayer True if the game is in two-player mode, false otherwise.
 * @param src The source file for storing ranklist data. (to be written)
 * @throws IOException If an I/O error occurs.
 */
   public EndWindow(Controller c, JFrame window, Sizes s, Player p1, Player p2, Player winner, boolean twoplayer, File src) throws IOException, JsonMappingException {
       JPanel leftPanel, rightPanel;
       JButton playAgain;

       window.getContentPane().removeAll();

       leftPanel = new JPanel();
       leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
       rightPanel = new JPanel();
       rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));

       JLabel youLost = new JLabel("You have lost!");
       youLost.setFont(new Font(youLost.getFont().getName(), youLost.getFont().getStyle(), 32));
       youLost.setBorder(new EmptyBorder(50,0,150,50));
       JLabel xyWon = new JLabel(winner.getName() + " won!");
       xyWon.setBorder(new EmptyBorder(50,0,30,80));
       xyWon.setFont(new Font(youLost.getFont().getName(), youLost.getFont().getStyle(), 32));
       if(twoplayer)
           leftPanel.add(xyWon);
       else
           leftPanel.add(youLost);

       Box scoreHolder = Box.createHorizontalBox();
       JLabel yourScore = new JLabel("SCORE: ");
       yourScore.setBorder(new EmptyBorder(0,80,0,0));
       JLabel scoreNum = new JLabel(String.valueOf(winner.getScore()));
       scoreNum.setForeground(Colors.blue_deep);
       scoreHolder.add(yourScore);
       scoreHolder.add(scoreNum);

       leftPanel.add(scoreHolder);

       playAgain = new JButton("Play again!");
       playAgain.addActionListener(new PlayAgainListener(c, p1, p2, s));
       leftPanel.add(Box.createVerticalGlue());
       leftPanel.add(playAgain);
       window.add(leftPanel, BorderLayout.WEST);


       JLabel top10 = new JLabel("TOP 10");
       top10.setFont(new Font(youLost.getFont().getName(), youLost.getFont().getStyle(), 32));
       top10.setBorder(new EmptyBorder(50,0,30,0));
       JTable ranklist = new JTable(new RanklistModel(src));
       ranklist.setPreferredSize(ranklist.getPreferredSize());
       ((RanklistModel)(ranklist.getModel())).addNewRow(winner);
       TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(ranklist.getModel());
       ranklist.setRowSorter(sorter);
       List<RowSorter.SortKey> sortKeys = new ArrayList<>(1);
       sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
       sorter.setSortKeys(sortKeys);

        if(ranklist.getRowCount() > 10)
            ((RanklistModel)(ranklist.getModel())).removeLastRow();

       rightPanel.add(top10);
       rightPanel.add(ranklist);
       window.add(rightPanel, BorderLayout.CENTER);


       ((RanklistModel)(ranklist.getModel())).store(src);
       window.pack();
       window.setVisible(true);
   }

}
