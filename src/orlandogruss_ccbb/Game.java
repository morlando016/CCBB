/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package orlandogruss_ccbb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author orlando016
 */
public class Game {

    private ArrayList<Player> players = new ArrayList();
    private static Route[] routes;
    private int numberOfPlayers = 1; // default value of one
    static private Player winningPlayer = null;
    static private boolean gameOver = false;
    private final String[] colors = {"red", "green", "blue", "yellow"};
    List<String> playerColors = new ArrayList<String>(Arrays.asList("red", "green", "blue", "yellow"));
    List<String> usedPlayerColors = new ArrayList<String>();
    private Player playerRolling;
    Scanner in = new Scanner(System.in);
    Game(){
        routes = new Route[4];
        routes[0] = new Route(0, 27);
        routes[1] = new Route(1, 19);
	      routes[2] = new Route(2, 17);
        routes[3] = new Route(3, 18);
    }

    // starts a user game
    public int startGame() {
        System.out.println("Welcome to Chitty Chitty Bang Bang!" + "\n");
        // prompt user for number of players
        System.out.println("How many players will be joining us?" + "\n"
        + "Please enter 1, 2, 3, or 4" + "\n");
        //try{
            if(in.hasNextInt()){
                numberOfPlayers = in.nextInt();
                    if(numberOfPlayers <= 4){
                        choosePlayerColor();
                    }
                    else{
                        System.err.println("You entered " + numberOfPlayers + ". Please Enter a number between 1 and 4");
                        startGame();
                    }
            }else{
                System.err.println("Enter a valid Integer value");
                in.next();
                startGame();
            }
        //} catch (InputMismatchException e) {
          //  System.out.print("Please enter an Integer");
            //playGame();
        //}
        return numberOfPlayers;
    }

   // function to play through the game
    private void playGame(){
        //initializeAllPlayers();

        // redPlayer starts game, then green, then blue, then yellow
        playerRolling = players.get(0);

        while (!gameOver && winningPlayer == null)
        {
            takeTurn();
        }
        endGame();
        System.out.println("Game Over!");

    }

    // called when the game ends
    private static void endGame(){
        if (winningPlayer != null)
        {
            System.out.println("The winner is " + winningPlayer.getPlayerColor() + "\n");
        }
        else
        {
            System.out.println("No winner?...." + "\n");
        }
        gameOver = true;
    }

    // function that tells player to take his turn
    private void takeTurn()
    {
        boolean moreRolls;
                moreRolls = playerRolling.takeMyTurn(routes);
                if (!moreRolls)
                {
                    gameOver = true;
                }
                endTurn();
    }

    // function at the end of a turn. Queues next player as the rolling player
    private void endTurn(){

        if(playerRolling == players.get(numberOfPlayers -1))
        {
            playerRolling = players.get(0);
            //playerRolling.landedOn(playerRolling.getCurrentPosition(), routes);
        }
        else
        {
            playerRolling = players.get(players.indexOf(playerRolling) +1);
        }
    }

    /**
     *
     * @param winner
     */

    // sets winner of the game
    static public void setWinner(Player winner)
    {
        winningPlayer = winner;
        gameOver = true;
    }

    // creates all the players that will be playing
    private void initializeAllPlayers()
    {
        // create players in order
        for (int i = 0; i < numberOfPlayers; i++)
        {
            initializePlayer(colors[i]);
        }

    }

    // function to make a player, then add it to the players list in Game
    private void initializePlayer(String pColor)
    {
        switch (pColor) {
            case "red":
                Player redPlayer = new Player(pColor);
                players.add(0,redPlayer);
                break;
            case "green":
                Player greenPlayer = new Player(pColor);
                players.add(1, greenPlayer);
                break;
            case "blue":
                Player bluePlayer = new Player(pColor);
                players.add(2, bluePlayer);
                break;
            case "yellow":
                Player yellowPlayer = new Player(pColor);
                players.add(3, yellowPlayer);
                break;
        }

    }

    private void choosePlayerColor(){
        int playerOrder = 0;
        String playerColor;

        in.nextLine();
        do{
            boolean playerSuccess = false;
            while(playerSuccess == false){
                System.out.println("Available Colors Are " + playerColors);
                System.out.println("Player " + (playerOrder+1) + ", please Choose a Color");

                playerColor = in.nextLine();
                if(usedPlayerColors.contains(playerColor)){
                    System.err.println("You Entered " + playerColor + ". The Only available Colors are " + playerColors);
                }
                else{
                    switch (playerColor) {
                        case "red":
                            Player redPlayer = new Player(playerColor);
                            players.add(playerOrder, redPlayer);
                            usedPlayerColors.add(playerOrder, playerColor);
                            playerColors.removeAll(usedPlayerColors);
                            playerSuccess = true;
                            playerOrder++;
                            break;
                        case "green":
                            Player greenPlayer = new Player(playerColor);
                            players.add(playerOrder, greenPlayer);
                            usedPlayerColors.add(playerOrder, playerColor);
                            playerColors.removeAll(usedPlayerColors);
                            playerSuccess = true;
                            playerOrder++;
                            break;
                        case "blue":
                            Player bluePlayer = new Player(playerColor);
                            players.add(playerOrder, bluePlayer);
                            usedPlayerColors.add(playerOrder, playerColor);
                            playerColors.removeAll(usedPlayerColors);
                            playerSuccess = true;
                            playerOrder++;
                            break;
                        case "yellow":
                            Player yellowPlayer = new Player(playerColor);
                            players.add(playerOrder, yellowPlayer);
                            usedPlayerColors.add(playerOrder, playerColor);
                            playerColors.removeAll(usedPlayerColors);
                            playerSuccess = true;
                            playerOrder++;
                            break;
                        default:
                            System.err.println("Invalid Input " + playerColor + " does not exist as available colors");
                            break;
                    }
                }

            }

        }while(playerOrder < numberOfPlayers);

        playGame();
    }

}
