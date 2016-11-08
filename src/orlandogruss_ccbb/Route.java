/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package orlandogruss_ccbb;


/**
 *
 * @author orlando016
 */
public class Route {
    
    private final Space[] myRoute;
    private final int routeNum;
    private final int routeSize;
    private MagicButton myButton;

    
    // constructor called by startGame()
    Route(int newRouteNum, int numSpaces)
    {
        routeNum = newRouteNum;
        routeSize = numSpaces;
        
        // create this route's route (AKA Space Array)
        myRoute = new Space[routeSize];

        // create button for route 1 & 2 only
        if (routeNum != 3 && routeSize != 18)
        {
            myButton = new MagicButton();
        }
        // fill spaces with data
        initalizeSpaces();
    }
    // maps a route to its correct initializer
    private void initalizeSpaces()
    {
	switch(routeNum){
	case 0:
		constructZeroth();		
		break;
	case 1: 
		constructFirst();
		break;
	case 2:
		constructNew();
		break;
	case 3: 
		constructSecond();
		break;
	default:
		System.out.println("Problem constructing routes"); // testing
	}
        
    }
    
    public Space movePlayer(int roll, int currentPos)
    {
        //THIS CODE ONLY WORKS FOR ROUTES 1 AND 2
        int newPos = currentPos + roll;
        if(routeNum == 0 || routeNum == 1){
            if(newPos >= routeSize){
              //ADD ONE TO SKIP THE "START" SPACE
              newPos = (newPos % routeSize) + 1;
            }
        }
        else{
            //IF ON LAST ROUTE AND ROLL GREATER THAN FINISH, STAY AT SAME SPOT
            if(newPos >= routeSize){
                newPos = currentPos;
            }
        }
        // return space player is on before any space / magic button actions

        return myRoute[newPos];
    }
       
    
    public Space getFirstSpace(){
       return myRoute[0];
    }
    
    public MagicButton getMyButton()
    {
        return this.myButton;
    }
    
    private void constructZeroth()
    {
            //FIRST SPACE IS NULL, BECAUSE YOU START BETWEEN SPACES
            myRoute[0] = new Space("start", this, 0);
            myRoute[1] = new Space("black", this, 1);
            myRoute[2] = new Space("black", this, 2);
            myRoute[3] = new Space("black", this, 3);
            myRoute[4] = new Space("yellow", this, 4);
            myRoute[5] = new Space("black", this, 5);
            myRoute[6] = new Space("green", this, 6);
            myRoute[7] = new Space("black", this, 7);
            myRoute[8] = new Space("blue", this, 8);
            myRoute[9] = new Space("black", this, 9);
            myRoute[10] = new Space("red", this, 10);
            myRoute[11] = new Space("black", this, 11);
            myRoute[12] = new Space("yellow", this, 12);
            myRoute[13] = new Space("green", this, 13);
            myRoute[14] = new Space("red", this, 14);
            myRoute[15] = new Space("blue", this, 15);
            myRoute[16] = new Space("red", this, 16);
            myRoute[17] = new Space("black", this, 17);
            myRoute[18] = new Space("red", this, 18);
            myRoute[19] = new Space("black", this, 19);
            myRoute[20] = new Space("yellow", this, 20);
            myRoute[21] = new Space("black", this, 21);
            myRoute[22] = new Space("green", this, 22);
            myRoute[23] = new Space("black", this, 23);
            myRoute[24] = new Space("blue", this, 24);
            myRoute[25] = new Space("black", this, 25);
            myRoute[26] = new Space("red", this, 26);

    }
    
     private void constructFirst()
    {
            //FIRST SPACE IS NULL, BECAUSE YOU START BETWEEN SPACES
            myRoute[0] = new Space("start", this, 0);
            myRoute[1] = new Space("black", this, 1);
            myRoute[2] = new Space("black", this, 2);
            myRoute[3] = new Space("red", this, 3);
            myRoute[4] = new Space("black", this, 4);
            myRoute[5] = new Space("green", this, 5);
            myRoute[6] = new Space("black", this, 6);
            myRoute[7] = new Space("yellow", this, 7);
            myRoute[8] = new Space("black", this, 8);
            myRoute[9] = new Space("blue", this, 9);
            myRoute[10] = new Space("black", this, 10);
            myRoute[11] = new Space("red", this, 11);
            myRoute[12] = new Space("black", this, 12);
            myRoute[13] = new Space("green", this, 13);
            myRoute[14] = new Space("black", this, 14);
            myRoute[15] = new Space("yellow", this, 15);
            myRoute[16] = new Space("black", this, 16);
            myRoute[17] = new Space("blue", this, 17);
            myRoute[18] = new Space("black", this, 18);
            
    }
     
    private void constructNew()
    {
            //FIRST SPACE IS NULL, BECAUSE YOU START BETWEEN SPACES
            myRoute[0] = new Space("start", this, 0);
            myRoute[1] = new Space("orange", this, 1);
            myRoute[2] = new Space("orange", this, 2);
            myRoute[3] = new Space("orange", this, 3);
            myRoute[4] = new Space("orange", this, 4);
            myRoute[5] = new Space("orange", this, 5);
            myRoute[6] = new Space("orange", this, 6);
            myRoute[7] = new Space("orange", this, 7);
            myRoute[8] = new Space("orange", this, 8);
            myRoute[9] = new Space("orange", this, 9);
            myRoute[10] = new Space("orange", this, 10);
            myRoute[11] = new Space("arrow", this, 11);
            myRoute[12] = new Space("orange", this, 12);
            myRoute[13] = new Space("orange", this, 13);
            myRoute[14] = new Space("orange", this, 14);
            myRoute[15] = new Space("orange", this, 15);
            myRoute[16] = new Space("orange", this, 16);

    } 
     
     private void constructSecond()
    {
            //FIRST SPACE IS NULL, BECAUSE YOU START BETWEEN SPACES
            myRoute[0] = new Space("start", this, 0);
            myRoute[1] = new Space("purple", this, 1);
            myRoute[2] = new Space("purple", this, 2);
            myRoute[3] = new Space("purple", this, 3);
            myRoute[4] = new Space("purple", this, 4);
            myRoute[5] = new Space("purple", this, 5);
            myRoute[6] = new Space("spoke1", this, 6);
            myRoute[7] = new Space("purple", this, 7);
            myRoute[8] = new Space("purple", this, 8);
            myRoute[9] = new Space("purple", this, 9);
            myRoute[10] = new Space("purple", this, 10);
            myRoute[11] = new Space("spoke2", this, 11);
            myRoute[12] = new Space("purple", this, 12);
            myRoute[13] = new Space("purple", this, 13);
            myRoute[14] = new Space("purple", this, 14);
            myRoute[15] = new Space("purple", this, 15);
            myRoute[16] = new Space("purple", this, 16);
            myRoute[17] = new Space("finish", this, 17);

    } 
    
    
}
