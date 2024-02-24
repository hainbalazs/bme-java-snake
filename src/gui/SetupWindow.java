package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

import gui.actionlisteners.*;
import utils.Sizes;

/**
 * The SetupWindow class represents the setup window for configuring game settings.
 */
public class SetupWindow{

    /**
    * The SetupWindow class represents the setup window for configuring game settings.
    */
    private StartGameListener sgl;

    public SetupWindow(JFrame jwindow) throws IOException {
        ImageIcon logo;
        JComboBox<Integer> playersNum;
        JLabel selectPlayersNum_text, name1, name2;
        JTextField inputName1, inputName2;
        JButton play;

        // INITIAL SETUP

        //LOGO
        logo = new ImageIcon("img/header.png");
        JLabel logoHolder = new JLabel((Icon) logo);
        logoHolder.setBorder(new EmptyBorder(50, 0,50,0));

        // MID PANEL
        JPanel midElementsHolder = new JPanel();
        midElementsHolder.setLayout(new BoxLayout(midElementsHolder, BoxLayout.PAGE_AXIS));

        // selecting the amount of players playing the game {label, combobox}
        Box selectPlayersNum = Box.createHorizontalBox();
        selectPlayersNum_text = new JLabel("How many players are playing?");
        selectPlayersNum_text.setFont(new Font(selectPlayersNum_text.getFont().getFontName(), 1, 24));
        Integer[] nums = {1, 2};
        playersNum = new JComboBox<>(nums);
        playersNum.setMaximumSize(new Dimension(100, playersNum.getPreferredSize().height));
        selectPlayersNum.add(selectPlayersNum_text);
        selectPlayersNum.add(Box.createHorizontalGlue());
        selectPlayersNum.add(playersNum);

        // validator / error panel
        Box errorHolder = Box.createHorizontalBox();
        JLabel errPanel = new JLabel("You forgot to enter each player's name!");
        errPanel.setForeground(Colors.red_deep);
        errorHolder.add(errPanel);

        // 1st player name {label, textfield}
        Box nameHolder1 = Box.createHorizontalBox();
        name1 = new JLabel("1. Player's name");
        name1.setBorder(new EmptyBorder(0,0,0,20));
        nameHolder1.add(name1);
        /// KINULLAZNI A NEVET
        inputName1 = new JTextField("Balázs");
        inputName1.setColumns(20);
        nameHolder1.add(inputName1);

        // 2nd player name {label, textfield}
        Box nameHolder2 = Box.createHorizontalBox();
        name2 = new JLabel("2. Player's name");
        name2.setBorder(new EmptyBorder(0,0,0,20));
        nameHolder2.add(name2);
        inputName2 = new JTextField();
        inputName2.setColumns(20);
        nameHolder2.add(inputName2);

        // Size of snake {label, combobox}
        Box mapSize = Box.createHorizontalBox();
        JLabel selectSize = new JLabel("How big should the snake be?");
        Sizes[] sizes = {Sizes.small, Sizes.medium, Sizes.large};
        JComboBox<Sizes> sizeList = new JComboBox<>(sizes);
        sizeList.setMaximumSize(new Dimension(100, sizeList.getPreferredSize().height));
        Square snakeSizeDemo = new Square(Sizes.small);
        mapSize.add(selectSize);
        mapSize.add(Box.createHorizontalGlue());
        mapSize.add(snakeSizeDemo);
        mapSize.add(Box.createRigidArea(new Dimension(10, 0)));
        mapSize.add(sizeList);

        // adding boxes to center field
        midElementsHolder.add(selectPlayersNum);
        midElementsHolder.add(Box.createRigidArea(new Dimension(0,20)));
        midElementsHolder.add(errorHolder);
        midElementsHolder.add(nameHolder1);
        midElementsHolder.add(nameHolder2);
        midElementsHolder.add(Box.createRigidArea(new Dimension(0,40)));
        midElementsHolder.add(mapSize);

        //setting up sizes of individual elements
        mapSize.setMaximumSize(new Dimension(logoHolder.getPreferredSize().width, mapSize.getPreferredSize().height));
        nameHolder1.setMaximumSize(new Dimension(logoHolder.getPreferredSize().width, nameHolder1.getPreferredSize().height));
        nameHolder2.setMaximumSize(new Dimension(logoHolder.getPreferredSize().width, nameHolder2.getPreferredSize().height));
        errorHolder.setMaximumSize(errorHolder.getPreferredSize());
        selectPlayersNum.setMaximumSize(new Dimension(logoHolder.getPreferredSize().width, selectPlayersNum.getPreferredSize().height));

        //action listeners
        nameHolder2.setVisible(false);
        errPanel.setVisible(false);
        playersNum.addActionListener(new PlayerNumListener(playersNum, nameHolder2));
        sizeList.addActionListener(new SnakeSizeListener(sizeList, snakeSizeDemo, mapSize));

        // BUTTON
        JPanel buttonHolder = new JPanel();
        play = new JButton("Play");
        buttonHolder.add(play);
        sgl = new StartGameListener(errPanel, inputName1, inputName2, playersNum, sizeList);
        play.addActionListener(sgl);

        // adding panels to the main layout
        jwindow.add(logoHolder, BorderLayout.NORTH);
        jwindow.add(midElementsHolder, BorderLayout.CENTER);
        jwindow.add(buttonHolder, BorderLayout.SOUTH);

        jwindow.pack();
        jwindow.setVisible(true);
        jwindow.setLocationRelativeTo(null);
    }

    public StartGameListener getSGListener(){
        return sgl;
    }
}

