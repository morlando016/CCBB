/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// Currently, the dice is rolling randomly. To use a test case,
// change the filepath in CSVReader and change the function call in Player.takeMyTurn
// Other functions are commented out there



package orlandogruss_ccbb;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import javax.swing.*;
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
        Object[] options = {"Roll"};
        JFrame rollFrame = new JFrame("roll");
                rollFrame.setLocation(600,400);
                rollFrame.setVisible(true);
                rollFrame.setAlwaysOnTop(true);
                rollFrame.setAlwaysOnTop(false);
                
                JOptionPane.showOptionDialog(rollFrame,
                    this.playerColor + ": Please click roll to take your turn",
                    this.playerColor + " Rolling",
                    JOptionPane.YES_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,     //do not use a custom Icon
                    options,  //the titles of buttons
                    options[0]); //default button title
    
                //Should close the app but doesn't
                
                
        // change the type of roll {CSVRoll, userRollDie, randRollDie,}
         roll = playerDie.randRollDie();
        // roll = playerDie.CSVRoll();
        //roll = playerDie.randRollDie();
         JOptionPane.showMessageDialog(rollFrame, this.playerColor + ": rolled a " + roll);
        rollFrame.dispose();
        
        // -1 means the end of the CSV, thus this function returns false
        if (roll != -1)
        {
                System.out.println("** " + Player.caseCount + ": " + this.playerColor +  " rolled: " + roll + "\n"); //testing
                Player.caseCount++;
            
            currentSpace = myRoutes[currentRoute].movePlayer(roll, this.currentPosition);
            
            currentPosition = currentSpace.getRoutePos();
  
            System.out.println("Current Route: " + currentRoute);
          
            landedOn(myRoutes[currentRoute].getMyButton(), myRoutes);
                    
                JFrame jf = new JFrame("tmp");
                jf.setLocation(600,400);
                jf.setVisible(true);
                jf.setAlwaysOnTop(true);
                jf.setAlwaysOnTop(false);
                JOptionPane.showMessageDialog(jf, this.playerColor +  " landed on position " + currentPosition + ": " + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
                jf.dispatchEvent(new WindowEvent(jf, WindowEvent.WINDOW_CLOSING));
                //System.out.println(this.playerColor + " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
                
                return true;
        }
        else
        {
            return false;
        }
    }
    
    
    void newRouteLandedOn(Route[] myRoutes){
    
    }
    
    void landedOn(MagicButton myButton, Route[] myRoutes)
    {  
       
        //IF PLAYER LANDS ON BLACK AND BUTTON IS SET TO ANOTHER COLOR OR NO COLOR
        if(currentSpace.getSpaceType().equals("black") && !myButton.getButtonColor().equals(playerColor))
        {
            //System.out.println(this.playerColor + " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
            myButton.setButtonColor(playerColor);
        }
        
        //IF PLAYER LANDS ON BLACK AND BUTTON IS SET TO THEIR COLOR
        else if(currentSpace.getSpaceType().equals("black") && myButton.getButtonColor().equals(playerColor))
        {
            //System.out.println(this.playerColor + " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
            advanceRoute(myRoutes);
        }
        
        //IF PLAYER LANDS ON BLUE AND BUTTON IS SET TO BLUE
        else if(currentSpace.getSpaceType().equals("blue") && myButton.getButtonColor().equals("blue"))
        {
            //System.out.println(this.playerColor + " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
            advanceRoute(myRoutes);
        }
        
        //IF PLAYER LANDS ON GREEN AND BUTTON IS SET TO GREEN
        else if(currentSpace.getSpaceType().equals("green") && myButton.getButtonColor().equals("green"))
        {
            //System.out.println(this.playerColor + " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
            advanceRoute(myRoutes);
        }
        
        //IF PLAYER LANDS ON RED AND BUTTON IS SET TO RED
        else if(currentSpace.getSpaceType().equals("red") && myButton.getButtonColor().equals("red"))
        {
            //System.out.println(this.playerColor + " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
            advanceRoute(myRoutes);
        }
        
        //IF PLAYER LANDS ON YELLOW AND BUTTON IS SET TO YELLOW
        else if(currentSpace.getSpaceType().equals("yellow") && myButton.getButtonColor().equals("yellow"))
        {
           // System.out.println(this.playerColor + " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
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
            System.out.println(this.playerColor + " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
            movePlayerBack(myRoutes);
        }

	//IF PLAYER LANDS ON ARROW THAT GOES TO 3RD ROUTE
	else if(currentSpace.getSpaceType().equals("arrow")){
	   //System.out.println(this.playerColor + " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
            advanceRoute(myRoutes);
	   //movePlayerForward(myRoutes);
	}
        
        else if(currentSpace.getSpaceType().equals("orange") && (currentSpace.getRoutePos() == 16)){
            //System.out.println(this.playerColor + " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
            //System.out.println("Should be advancing to 3, end of route 2");
            advanceRoute(myRoutes);
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
    {   
       JFrame jf = new JFrame("tmp");
       jf.setLocation(600,400);
       jf.setVisible(true);
       jf.setAlwaysOnTop(true);
       jf.setAlwaysOnTop(false);
       JOptionPane.showMessageDialog(jf, this.playerColor +  " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
       jf.dispose();
        //System.out.println(this.playerColor +  " landed on " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
        currentRoute++;
        currentSpace = routes[currentRoute].getFirstSpace();
        currentPosition = currentSpace.getRoutePos();

       jf.setLocation(600,400);
       jf.setVisible(true);
       jf.setAlwaysOnTop(true);
       jf.setAlwaysOnTop(false);
       JOptionPane.showMessageDialog(jf, this.playerColor + " moved to route  #"  + currentRoute + "\n");
       jf.dispose();
        //System.out.println(this.playerColor + " moved to route  #"  + currentRoute + "\n"); // testing
    }
    
    void movePlayerBack(Route[] routes)
    {
       JFrame jf = new JFrame("tmp");
       jf.setLocation(600,400);
       jf.setVisible(true);
       jf.setAlwaysOnTop(true);
       jf.setAlwaysOnTop(false);
       JOptionPane.showMessageDialog(jf, this.playerColor +  " moved to " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
       jf.dispose();
        //System.out.println(this.playerColor +  " moved to " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
        
        switch (currentSpace.getSpaceType()) {
        
            //MOVE TO START OF ROUTE 1
            case "spoke1":
                currentRoute = 1;
                currentSpace = routes[1].getFirstSpace();
                currentPosition = 0;
                jf.setLocation(600,400);
                jf.setVisible(true);
                jf.setAlwaysOnTop(true);
                jf.setAlwaysOnTop(false);
                JOptionPane.showMessageDialog(jf, "Moved back to start of "  + currentRoute + "\n");
                jf.dispose();
                //System.out.println("Moved back to start of "  + currentRoute + "\n"); // testing
                break;
                
            //MOVE TO START OF ROUTE 3
            case "spoke2":
                currentRoute = 3;
                currentSpace = routes[3].getFirstSpace();
                currentPosition = 0;
                jf.setLocation(600,400);
                jf.setVisible(true);
                jf.setAlwaysOnTop(true);
                jf.setAlwaysOnTop(false);
                JOptionPane.showMessageDialog(jf, "Moved back to start of "  + currentRoute + "\n");
                jf.dispose();
                //System.out.println("Moved back to start of "  + currentRoute + "\n"); // testing
                break;
        }
    
    }

    void movePlayerForward(Route[] routes){
        JFrame jf = new JFrame("tmp");
        jf.setLocation(600,400);
        jf.setVisible(true);
        jf.setAlwaysOnTop(true);
        jf.setAlwaysOnTop(false);
        JOptionPane.showMessageDialog(jf, this.playerColor +  " moved to " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
        jf.dispose();
	//System.out.println(this.playerColor +  " moved to " + currentPosition + ":" + currentSpace.getSpaceType() + " on route #" + currentRoute + "\n");
                
            //MOVE TO START OF ROUTE 3
                currentRoute = 2;
                currentSpace = routes[3].getFirstSpace();
                currentPosition = 0;
                jf.setLocation(600,400);
                jf.setVisible(true);
                jf.setAlwaysOnTop(true);
                jf.setAlwaysOnTop(false);
                JOptionPane.showMessageDialog(jf, "Moved forward to start of "  + currentRoute + "\n");
                jf.dispose();
                //System.out.println("Moved forward to start of "  + currentRoute + "\n"); // testing
           
   }
    
}
