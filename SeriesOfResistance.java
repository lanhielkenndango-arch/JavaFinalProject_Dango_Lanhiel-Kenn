/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafinalproject;

/**
 *
 * @author Asus
 */
public class SeriesOfResistance {

    private double totalResistance;

    // mo run automatic inig tawag sa new SeriesOfResistance sa main class
    public SeriesOfResistance(String rawInput) { 
        this.totalResistance = 0; // initialize the value
        computeSum(rawInput);   // icall ang method
    }

    // private method ni para ma separate ang mga numbers using comma
    private void computeSum(String input) {
        String[] parts = input.split(",");  
        
        for (String part : parts) {
            try {
                this.totalResistance += Double.parseDouble(part.trim());
            } catch (NumberFormatException e) {
                System.out.println("Error");  // this will show up if dili number ang iinput
            }
        }
    }

    public double getResult() {     // since total resistance is private and dili ma touched, ang public method acts as messenger to return the value of total resistance
        return this.totalResistance;
    }

}
