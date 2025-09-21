/*
My Pseudocode for Rectangle and Circle Calculator:

1. Start program
2. Make an array with 3 choices: "Rectangle Calculator", "Circle Calculator", "Exit"
3. Keep looping until user picks exit:
   - Show menu with the 3 options
   - Get what the user picked
   - If they picked Rectangle (0):
     * Ask for length
     * Ask for width  
     * Calculate area and perimeter
     * Show results
   - If they picked Circle (1):
     * Ask for radius
     * Calculate area and circumference
     * Show results
   - If they picked Exit (2) or closed the window:
     * Say goodbye and quit
4. For Rectangle calculations:
   - Get length from user
   - Get width from user
   - Do math: area = length * width, perimeter = 2 * (length + width)
   - Display the results nicely
   - Handle errors if they type letters instead of numbers
5. For Circle calculations:
   - Get radius from user
   - Do math: area = pi * radius^2, circumference = 2 * pi * radius
   - Display the results nicely
   - Handle errors if they type letters instead of numbers
6. Keep going back to main menu until they exit
*/

import javax.swing.JOptionPane;

public class rectangle_Circle_Caculator 
{
    public static void main(String[] args) 
    {
        // Show menu to user
        String[] options = {"Rectangle Calculator", "Circle Calculator", "Exit"};
        
        while (true) {
            int choice = JOptionPane.showOptionDialog(
                null,
                "What would you like to calculate?",
                "Shape Calculator",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );
            
            switch (choice) {
                case 0: // Rectangle Calculator
                    calculateRectangle();
                    break;
                case 1: // Circle Calculator
                    calculateCircle();
                    break;
                case 2: // Exit
                case JOptionPane.CLOSED_OPTION:
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                    break;
            }
        }
    }
    
    public static void calculateRectangle() {
        try {
            String lengthStr = JOptionPane.showInputDialog("Enter the length of the rectangle:");
            String widthStr = JOptionPane.showInputDialog("Enter the width of the rectangle:");
            
            double length = Double.parseDouble(lengthStr);
            double width = Double.parseDouble(widthStr);
            
            double area = length * width;
            double perimeter = 2 * (length + width);
            
            String result = String.format(
                "Rectangle Results:\nLength: %.2f\nWidth: %.2f\nArea: %.2f\nPerimeter: %.2f",
                length, width, area, perimeter
            );
            
            JOptionPane.showMessageDialog(null, result, "Rectangle Results", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            // User cancelled input
        }
    }
    
    public static void calculateCircle() {
        try {
            String radiusStr = JOptionPane.showInputDialog("Enter the radius of the circle:");
            
            double radius = Double.parseDouble(radiusStr);
            
            double area = Math.PI * radius * radius;
            double circumference = 2 * Math.PI * radius;
            
            String result = String.format(
                "Circle Results:\nRadius: %.2f\nArea: %.2f\nCircumference: %.2f",
                radius, area, circumference
            );
            
            JOptionPane.showMessageDialog(null, result, "Circle Results", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            // User cancelled input
        }
    }
}