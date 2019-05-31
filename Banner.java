package Lab5CabreraE;

/***************************************************
 * SE1021
 * Purpose: Create a welcome message with
 *          information on project and instructions
 * @author CabreraE
 * @version 1.0 Created on 4/29/2015 at 3:36 PM
 ***************************************************/

import java.util.Date;

public class Banner{
    private String message;
    public Banner(String message){
        Date today = new Date();
        this.message = message + "\nBy CabreraE for SE1021-011 Lab 5" + "\nRan on " + today + "\n";
    }
    public String getMessage(){
        return message;
    }
    public static void main(String[] args){
    }
}