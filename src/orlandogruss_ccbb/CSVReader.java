/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
package orlandogruss_ccbb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlando016
 */

/*
public class CSVReader {
    private BufferedReader br;
    private final String cvsSplitBy = ",";
    private final ArrayList<Integer> rollsArr;
    private final String filePath = "";
    private int count = 0;
    CSVReader(){
        rollsArr = new ArrayList();
        try {
            br = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        readFromCSV();
    }
    
    // reads roll values from CSV and puts them in a ListArray
    private void readFromCSV() {
        String integers = "";
        try {
            while ((integers = br.readLine()) != null) {
                
                String[] rollsStr;
                rollsStr = integers.split(cvsSplitBy);
                
                for (int i = 0; i < rollsStr.length; i++)
                {
                    rollsArr.add(Integer.parseInt(rollsStr[i])); 
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Gives the next roll that was read in
    int getNextCSVRoll()
    {
        if (count < rollsArr.size())
        {
            int roll = rollsArr.get(count);
            count++;
            return roll;
        }
        else 
        {
            return -1;
        }
    }

}
*/

