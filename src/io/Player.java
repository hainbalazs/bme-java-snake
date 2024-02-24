package io;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Player class represents a player with a name and a score.
 */
public class Player {
    
    /** The name of the player. */
    private String name;
    
    /** The score of the player. */
    private int score;

    /** Default Player constructor */
    public Player(){}

    /**
     * Constructs a new Player object with the specified name and initializes the score to 0.
     * @param name_ The name of the player.
     */
    public Player(String name_){
        name = name_;
        score = 0;
    }

    /**
     * Retrieves the name of the player.
     * @return The name of the player.
     */
    public String getName(){ return name; }

    /**
     * Retrieves the score of the player.
     * @return The score of the player.
     */
    public int getScore(){ return score; }

    /**
     * Sets the name of the player.
     * @param name_ The new name of the player.
     */
    public void setName(String name_){
        name = name_;
    }

    /**
     * Sets the score of the player.
     * @param score_ The new score of the player.
     */
    public void setScore(int score_){
        score = score_;
    }

    /**
     * Checks if the player is currently playing, which is represented by assinging a name to the Player. 
     * (I.e.: in single player mode, player2 has no name)
     * @return True if the player is currently playing, false otherwise.
     */
    @JsonIgnore
    public boolean isPlaying(){
        return !name.equals("");
    }
}