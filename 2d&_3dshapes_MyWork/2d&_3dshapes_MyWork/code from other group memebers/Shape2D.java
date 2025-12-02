import javax.swing.*;
import java.awt.*;

public class Shape2D {

    public static void circle(UltraShape.DrawPanel panel) {
        String input = JOptionPane.showInputDialog("Enter radius of circle:");
        double radius = Double.parseDouble(input);
        double area = Math.PI * radius * radius;
        JOptionPane.showMessageDialog(panel, "Area of Circle = " + area);
	
	panel.setShape("Circle (2D)", radius);
    }

    public static void rectangle(UltraShape.DrawPanel panel) {
        String w = JOptionPane.showInputDialog("Enter width of rectangle:");
        String h = JOptionPane.showInputDialog("Enter height of rectangle:");
        double width = Double.parseDouble(w);
        double height = Double.parseDouble(h);
        double area = width * height;
        JOptionPane.showMessageDialog(panel, "Area of Rectangle = " + area);
	
	panel.setShape("Rectangle (2D)", width, height);
    }

    public static void triangle(UltraShape.DrawPanel panel) {
        String b = JOptionPane.showInputDialog("Enter base of triangle:");
        String h = JOptionPane.showInputDialog("Enter height of triangle:");
        double base = Double.parseDouble(b);
        double height = Double.parseDouble(h);
        double area = 0.5 * base * height;
        JOptionPane.showMessageDialog(panel, "Area of Triangle = " + area);

        panel.setShape("Triangle (2D)", base, height);
    }

    public static void square(UltraShape.DrawPanel panel) {
        String s = JOptionPane.showInputDialog("Enter side length of square:");
        double side = Double.parseDouble(s);
        double area = side * side;
        JOptionPane.showMessageDialog(panel, "Area of Square = " + area);

        panel.setShape("Square (2D)", side);
    }

    public static void trapezoid(UltraShape.DrawPanel panel) {
        String a = JOptionPane.showInputDialog("Enter base1 of trapezoid:");
        String b = JOptionPane.showInputDialog("Enter base2 of trapezoid:");
        String h = JOptionPane.showInputDialog("Enter height of trapezoid:");
        double base1 = Double.parseDouble(a);
        double base2 = Double.parseDouble(b);
        double height = Double.parseDouble(h);
        double area = ((base1 + base2) / 2) * height;
        JOptionPane.showMessageDialog(panel, "Area of Trapezoid = " + area);

        panel.setShape("Trapezoid (2D)", base1, base2, height);
    }
}

