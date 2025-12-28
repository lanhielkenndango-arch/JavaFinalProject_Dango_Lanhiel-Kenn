/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafinalproject;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Asus
 */
public class JavaFinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean loops = true;

        while (loops) {  // while true ang loop magbalik balik ra sa format and ma end lang if false ang run sa  loops
            // as for basic ohm's law formula V = I*R , I = V/R , and R = V/I ; where V is the voltage, I is the current, and R iis the resistance          
            // options to choose
            System.out.println(); // skips the entire line in here
            System.out.println("1. Voltage ");
            System.out.println("2. Current ");
            System.out.println("3. Resistance");
            System.out.println("4. GUI (Optional)");
            System.out.println("5. Exit");
            System.out.print("Choose what you want to solve: ");

            try {
                int choice = input.nextInt();
                double number1;
                double number2;

                if (choice == 1) {
                    System.out.print("\nCurrent(I): ");
                    number1 = input.nextDouble();   // number1 and number2 kay gina store ang input sa user
                    input.nextLine();
                    number2 = getResistanceSum(input);

                    System.out.println("\nResult:");
                    System.out.println("Voltage = " + totalvoltage(number1, number2) + " V ");  // to answer the total voltage with the users input of current and resistance

                } else if (choice == 2) {
                    System.out.print("\nVoltage(V): ");
                    number1 = input.nextDouble();
                    input.nextLine();
                    number2 = getResistanceSum(input);

                    System.out.println("\nResult:");
                    System.out.println("Current = " + totalcurrent(number1, number2) + " A ");  // to answer the total current with the users input of voltage and resistance

                } else if (choice == 3) {
                    System.out.print("\nVoltage(V): ");
                    number1 = input.nextDouble();
                    System.out.print("Current(I): ");
                    number2 = input.nextDouble();

                    System.out.println("\nResult:");
                    System.out.println("Resistance = " + totalresistance(number1, number2) + " Ohms"); // to answer the total resistance with the users input of voltage and current
                } else if (choice == 4) {
                    showGUI();   // icall ang void method to print the message
                } else if (choice == 5) {
                    loops = false;    // since false  ang loops then ang loop will stop and will show the println below
                    System.out.println("\nThank you for using my final java project.");
                } else {
                    System.out.println("Invalid choice.");  // if ang user mo attempt og put nga less than 1 and greater than 5, this message  will show up
                }

            } catch (InputMismatchException e) {   // if ma catch na wrong ang input then it is an error
                System.out.println("Error, invalid input.");
                input.nextLine();
            }

        }

        input.close();

    }

    // COMPUTATIONS INSIDE THE METHODS
    // this connects to the main class
    public static double getResistanceSum(java.util.Scanner input) {
        // the input below in this line  will be automatically added depends sa user's input
        System.out.print("Resistance(Ohms) (use comma for multiple resistance): "); // the code \u03A9 won't work because it prints as "?", instead I use the  word Ohms

        // get the text line from user
        String rawLine = input.nextLine();

        SeriesOfResistance seriesCircuit = new SeriesOfResistance(rawLine);

        // get thhe result using the objects method
        double total = seriesCircuit.getResult();

        return total;  // return the computation
    }

    // gi change nako ang variable name inside  para di kaayo libog and easy to determine lang
    public static double totalvoltage(double current, double resistance) {
        return current * resistance;    // ibalik sa main ang computaion diria, as well as sa totalcurrent and totalresistance, but based only on the users choice kung unsa ilang gi pick
    }

    public static double totalcurrent(double voltage, double resistance) {
        return voltage / resistance;
    }

    public static double totalresistance(double voltage, double current) {
        return voltage / current;
    }

    public static void showGUI() {
        // Use a block of code instead of one line so we can add settings
        java.awt.EventQueue.invokeLater(() -> {
            Physics gui = new Physics();

            gui.setVisible(true);   // to show the GUI
            gui.setAlwaysOnTop(true);  // force to make the GUI at the front instead of clicking it at the taskbar
            gui.toFront();
            gui.requestFocus();
        });

    }

} 