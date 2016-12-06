/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package orlandogruss_ccbb;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        
        JFrame jf = new JFrame("tmp");
        jf.setLocation(600,400);
        jf.setVisible(true);
        jf.setAlwaysOnTop(true);
        jf.setAlwaysOnTop(false);
        JOptionPane.showMessageDialog(jf, "Button Color set to " + buttonColor + "\n");
        jf.dispatchEvent(new WindowEvent(jf, WindowEvent.WINDOW_CLOSING));
        
       
       System.out.println("Button Color set to " + buttonColor + "\n");
    }
    
    public String getButtonColor(){
        return buttonColor;
    }
    
}
