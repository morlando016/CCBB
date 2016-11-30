/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Currently, the dice is rolling randomly. To use a test case,
// change the filepath in CSVReader and change the function call in Player.takeMyTurn
// Other functions are commented out there
// Marco Orlando and James Gruss, Jr
// Software Design and Testing Final Project: Chitty Chitty Bang Bang

package orlandogruss_ccbb;

/**
 *
 * @author orlando016
 */
public class OrlandoGruss_CCBB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Game thisGame = new Game();
        
        thisGame.startGame();
        
    }
    
}
