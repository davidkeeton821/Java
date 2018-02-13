/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempconvert;

import java.util.Scanner;
//import java.util.*    //only brings in classes actually being used
/**
 *
 * @author Douglas Atkinson
 */
public class TempConvert {

    private double fahrenheit; //class variable, cant be used with static classes
    /**
     * @param args the command line arguments
     */
    
    //In java if its not a primitive type, its an object
    //All variables are references variables
    public static void main(String[] args) {
        double c;
        double f;
        
        Scanner in = new Scanner(System.in); //creates the input stream
        
        System.out.print("Enter the degrees in celcius: ");
        c = in.nextDouble();
        f = celciusToFahrenheit(c);
        System.out.println("" + c + " degrees celcius is " + f + " degrees fahrenheit");
        
        System.out.print("Enter the degrees in fahrenheit: ");
        f = in.nextDouble();
        TempConvert tc = new TempConvert();//creating instance of the class
        c = tc.fahrenheitToCelcius(f);
        System.out.println(tc.fahrenheit);
        System.out.println("" + f + " degrees fahrenheit is " + c + " degrees celcius");
    }
    
    static double celciusToFahrenheit(double celc) {
         //fahrenheit = 9.0 / 5.0 * celc + 32.0
         return 9.0 / 5.0 * celc + 32.0;
    }
    
    double fahrenheitToCelcius(double fahr) {
        fahrenheit = fahr; //class variable can be used in instantiated class
        return 5.0 / 9.0 * (fahr - 32.0);
    }
    
}