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
public class MagicButton {
    String buttonColor = "";

    MagicButton(){
        
    }
    
    public void setButtonColor(String myString){
       buttonColor = myString;
       System.out.println("Button Color set to " + buttonColor + "\n");
    }
    
    public String getButtonColor(){
        return buttonColor;
    }
    
}
