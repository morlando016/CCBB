/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// Currently, the dice is rolling randomly. To use a test case,
// change the filepath in CSVReader and change the function call in Player.takeMyTurn
// Other functions are commented out there



package orlandogruss_ccbb;

/**
 *
 * @author orlando016
 */
public class Player {
    
    private String playerColor = "";
    private Space currentSpace = null;
    static private Die playerDie = new Die();;
    private int currentPosition = 0;
    private int currentRoute = 0;
    private static int caseCount = 1; // for testing numbering
    
    Player(){

    }
    
    // used by game
    Player(String color){
        playerColor = color;
    }
    
    public int getCurrentPosition(){
        return currentPosition;
       
    }
    
    String getPlayerColor() {
        return playerColor;
    }

    
    boolean takeMyTurn(Route[] myRoutes)
    {
        int roll; 
        
        // change the type of roll {CSVRoll, userRollDie, randRollDie,}
         roll = playerDie.userRollDie();
        // roll = playerDie.CSVRoll();
        //roll = playerDie.randRollDie();
        // -1 means the end of the CSV, thus this function returns false
        if (roll != -1)
        {
                System.out.println("** " + Player.caseCount + ": " + this.playerColor +  " rolled: " + roll + "\n"); //testing
                Player.caseCount++;
            
            currentSpace = myRoutes[currentRoute].movePlayer(roll, this.currentPosition);
            
            currentPosition = currentSpace.getRoutePos();
  
            landedOn(myRoutes[currentRoute].getMyButton(), myRoutes);
            
                //System.out.println(this.playerColor + " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
                
                return true;
        }
        else
        {
            return false;
        }
    }
    
    void landedOn(MagicButton myButton, Route[] myRoutes)
    {  
       
        //IF PLAYER LANDS ON BLACK AND BUTTON IS SET TO ANOTHER COLOR OR NO COLOR
        if(currentSpace.getSpaceType().equals("black") && !myButton.getButtonColor().equals(playerColor))
        {
            System.out.println(this.playerColor + " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
            myButton.setButtonColor(playerColor);
        }
        
        //IF PLAYER LANDS ON BLACK AND BUTTON IS SET TO THEIR COLOR
        else if(currentSpace.getSpaceType().equals("black") && myButton.getButtonColor().equals(playerColor))
        {
            advanceRoute(myRoutes);
        }
        
        //IF PLAYER LANDS ON BLUE AND BUTTON IS SET TO BLUE
        else if(currentSpace.getSpaceType().equals("blue") && myButton.getButtonColor().equals("blue"))
        {
            advanceRoute(myRoutes);
        }
        
        //IF PLAYER LANDS ON GREEN AND BUTTON IS SET TO GREEN
        else if(currentSpace.getSpaceType().equals("green") && myButton.getButtonColor().equals("green"))
        {
            advanceRoute(myRoutes);
        }
        
        //IF PLAYER LANDS ON RED AND BUTTON IS SET TO RED
        else if(currentSpace.getSpaceType().equals("red") && myButton.getButtonColor().equals("red"))
        {
            advanceRoute(myRoutes);
        }
        
        //IF PLAYER LANDS ON YELLOW AND BUTTON IS SET TO YELLOW
        else if(currentSpace.getSpaceType().equals("yellow") && myButton.getButtonColor().equals("yellow"))
        {
            advanceRoute(myRoutes);
        }
        
        //IF PLAYER LANDS ON SPOKE THAT GOES TO 1ST ROUTE
        else if(currentSpace.getSpaceType().equals("spoke1"))
        {
            movePlayerBack(myRoutes);
        }
        
        //IF PLAYER LANDS ON SPOKE THAT GOES TO 2ND ROUTE
        else if(currentSpace.getSpaceType().equals("spoke2"))
        {
            movePlayerBack(myRoutes);
        }

	//IF PLAYER LANDS ON ARROW THAT GOES TO 3RD ROUTE
	else if(currentSpace.getSpaceType().equals("arrow")){
	   advanceRoute(myRoutes);
	   //movePlayerForward(myRoutes);
	}
        
        else if(currentSpace.getSpaceType().equals("finish"))
        {
            Game.setWinner(this);
        }
        
        //DO NOTHING BECAUSE THE PLAYER LANDED ON A COLORED SPACE, AND THE BUTTON WAS NOT SET TO THAT COLOR OR ITS A PURPLE OR ORANGE SPACE
        else{
            
        }
    }
    
    void advanceRoute(Route[] routes)
    {   System.out.println(this.playerColor +  " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
        currentRoute++;
        currentSpace = routes[currentRoute].getFirstSpace();
        currentPosition = currentSpace.getRoutePos();
        System.out.println(this.playerColor + " moved to route  #"  + currentRoute + "\n"); // testing
    }
    
    void movePlayerBack(Route[] routes)
    {
        System.out.println(this.playerColor +  " moved to " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
        
        switch (currentSpace.getSpaceType()) {
        
            //MOVE TO START OF ROUTE 1
            case "spoke1":
                currentRoute = 1;
                currentSpace = routes[1].getFirstSpace();
                currentPosition = 0;
                System.out.println("Moved back to start of "  + currentRoute + "\n"); // testing
                break;
                
            //MOVE TO START OF ROUTE 3
            case "spoke2":
                currentRoute = 3;
                currentSpace = routes[3].getFirstSpace();
                currentPosition = 0;
                System.out.println("Moved back to start of "  + currentRoute + "\n"); // testing
                break;
        }
    
    }

    void movePlayerForward(Route[] routes){
	System.out.println(this.playerColor +  " moved to " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
                
            //MOVE TO START OF ROUTE 3
                currentRoute = 2;
                currentSpace = routes[3].getFirstSpace();
                currentPosition = 0;
                System.out.println("Moved forward to start of "  + currentRoute + "\n"); // testing
           
   }
    
}
