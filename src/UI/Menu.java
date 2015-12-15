package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author José Cortez
 */
public class Menu {
    
    private ArrayList<String> lines;
    int option;


        public Menu (String[] l)
        {
            lines = new ArrayList<String>();
            for(String s : l)
                lines.add(s);
            this.option = 0;
        }

        /*Getters and Setters*/
        public int getOption () { return this.option; }



        /***
         * This method will print this instance's menu.
         */
        public void ShowMenu()
        {
            System.out.println("##############################");
            int i = 1;
            for (String s : lines)
            {
                 System.out.println(i + " - " + s);
                i++;
            }
             System.out.println("0 - Leave");
             System.out.print("---------\nOption: ");
            
        }

        /**
         * Method which shows the menu (by calling @ShowMenu) and parses the user's option.
         *It checks if the option is between the possible range.
         */
        public void ExecuteMenu()
        {
            try {
                String line;
                do
                {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    ShowMenu();
                    line = br.readLine();
                    int x = Integer.parseInt(line);
                    System.out.println("##############################");
                }
                while (this.option == -1);
            }
            catch (IOException e) {System.out.println(e.toString());}
        
            
        }
    
}
