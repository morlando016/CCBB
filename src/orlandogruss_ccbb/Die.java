/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package orlandogruss_ccbb;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author orlando016
 */

public class Die {
    private final int dieSide = 6;
    private int rollValue;
    //CSVReader myReader;
    
    Die(){
        //myReader = new CSVReader();
    }
    
    int userRollDie() {
        //Allows user to input rolls for testing
        int newRoll;
        boolean temp;
        do {
        System.out.println("Please input a roll: ");
        Scanner scan = new Scanner(System.in);
        newRoll = scan.nextInt();
        temp = setRoll(newRoll);
        } while (!temp);

        return rollValue;
    }
    
    // automated random roller
    int randRollDie()
    { 
        Random randomGenerator = new Random();
        int randomRoll = randomGenerator.nextInt(dieSide);

        setRoll((randomRoll + 1));
        //System.out.println("You rolled " + rollValue + "\n");
        return rollValue;
    }
    
    // passes CSV roll value as the current roll;
    //int CSVRoll()
    //{
    //  setRoll(myReader.getNextCSVRoll());
       
    //  return rollValue;
    //}
    
 // sets the rolValue
    boolean setRoll(int newRoll)
    {
         if (newRoll <= dieSide && newRoll > 0)
        {
            rollValue = newRoll;
            return true;
        }
        else if(newRoll == -1)
         {
             rollValue = -1;
             System.out.println("End of CSV rolls" + "\n");
             return false;
         }
         
        else
        {
            System.out.println("Roll value too large, please roll no more than " + dieSide + "\n");
            return false;
        }

    }

}
    
    
