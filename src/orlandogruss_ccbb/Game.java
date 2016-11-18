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
    private int numberOfPlayers = 1;
    static private Player winningPlayer = null;
    static private boolean gameOver = false;
    
    Game(){
        routes = new Route[4];
        routes[0] = new Route(0, 27);
        routes[1] = new Route(1, 19);
	routes[2] = new Route(2, 17);
        routes[3] = new Route(3, 18);
    }

    public void startGame() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to Chitty Chitty Bang Bang!" + "\n");

        System.out.println("How many players will be joining us?" + "\n"
        + "Please enter 1, 2, 3, or 4" + "\n");

        if(input.hasNextInt()){
            numberOfPlayers = input.nextInt();
                if(numberOfPlayers <= 4){
                    choosePlayerColor();
                }
                else{
                    System.err.println("You entered " + numberOfPlayers + ". Please Enter an integer value between 1 and 4.");
                    startGame();
                }
        }else{
            System.err.println("Please enter an integer value between 1 and 4.");
            input.next();
            startGame();
        }
    }
    
    private void choosePlayerColor(){
        int playerOrder = 0;
        String playerColor;
        List<String> playerColors = new ArrayList<String>(Arrays.asList("red", "green", "blue", "yellow"));
        List<String> usedPlayerColors = new ArrayList<String>();
        Scanner input = new Scanner(System.in);

        do{
            boolean playerSuccess = false;
            while(playerSuccess == false){
                System.out.println("Available Colors Are " + playerColors);
                System.out.println("Player " + (playerOrder+1) + ", please Choose a Color");

                playerColor = input.nextLine();
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
                            System.err.println("Invalid Input: " + playerColor + " does not exist as an available color");
                            break;
                    }
                }

            }

        }while(playerOrder < numberOfPlayers);

        playGame();
    }

    private void playGame(){
        Player playerRolling;
        playerRolling = players.get(0);

        while (!gameOver && winningPlayer == null)
        {
            playerRolling = takeTurn(playerRolling);
        }
        endGame();
        System.out.println("Game Over!");

    }
    
    private Player takeTurn(Player playerRolling){
        boolean moreRolls;

        moreRolls = playerRolling.takeMyTurn(routes);
        if (!moreRolls)
        {
            gameOver = true;
        }
        
        playerRolling = endTurn(playerRolling);
        return playerRolling;
    }

    private Player endTurn(Player playerRolling){

        if(playerRolling == players.get(numberOfPlayers -1))
        {
            playerRolling = players.get(0);
            //playerRolling.landedOn(playerRolling.getCurrentPosition(), routes);
        }
        else
        {
            playerRolling = players.get(players.indexOf(playerRolling) + 1);
        }
        
        return playerRolling;
    }

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

    static public void setWinner(Player winner){
        winningPlayer = winner;
        gameOver = true;
    }

    
}
