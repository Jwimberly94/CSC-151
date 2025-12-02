/*Program will calculate and compare the area of five 2D shapes using JOption Pane and Methods
 * Mariah Mitchell
 *
 */

import javax.swing.*;
import java.awt.*;

public class JavaCode_2Dshape_3Dshape_MitchellMariah {
        //----Main Method----
    public static void main(String[] args)
     {
        double rectArea = rectangle();
        double circArea = circle();
        double squareArea = square();
        double triArea = triangle();
        double paraArea = parallelogram();

        showBarChart(rectArea, circArea, squareArea, triArea, paraArea);
        JOptionPane.showMessageDialog(null, "All calculations complete. Goodbye!");

        //Calculation Methods
     }
    public static double rectangleArea(double length, double width) {
        return length * width;
    }
    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }
    public static double squareArea(double width) {
        return width * width;
    }
    public static double triangleArea(double base, double height) {
        return 0.5 * base * height;
    }
     public static double parallelogramArea(double base, double height) {
        return base * height;
    }

      //Shape Modules 
    // Ask user to input the length and width
    public static double rectangle() {
        double length = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the length of the rectangle:")
        );
        double width = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the width of the rectangle:")
        );
        double area = rectangleArea(length, width);
        JOptionPane.showMessageDialog(null, "Area of rectangle: " + area);
        return area;
    }
    // Ask user to input the radius of a circle. Display area.
    public static double circle() {
        double radius = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the radius of the circle:")
        );
        double area = circleArea(radius);
        JOptionPane.showMessageDialog(null, "Area of circle: " + area);
        return area;
    }
    // Ask user to input the width of a square. Display area.
    public static double square() {
        double width = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the width of the square:")
        );
        double area = squareArea(width);
        JOptionPane.showMessageDialog(null, "Area of square: " + area);
        return area;
    }
    // Ask user to input base and height of a triangel. Display Area.
    public static double triangle() {
        double base = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the base of the triangle:")
        );
        double height = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the height of the triangle:")
        );
        double area = triangleArea(base, height);
        JOptionPane.showMessageDialog(null, "Area of triangle: " + area);
        return area;
    }
    // Ask user to input base and height of a parallelogram. Display Area.
        public static double parallelogram() {
        double base = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the base of the parallelogram:")
        );
        double height = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the height of the parallelogram:")
        );
        double area = parallelogramArea(base, height);
        JOptionPane.showMessageDialog(null, "Area of parallelogram: " + area);
        return area;
    }
    // Comparison Method using a bar chart
    public static void showBarChart(double rect, double circ, double square, double tri, double para) {
        // Names and areas
        String[] shapes = {"Rectangle", "Circle", "Square", "Triangle", "Parallelogram"};
        double[] areas = {rect, circ, square, tri, para};

        // Create JFrame
        JFrame frame = new JFrame("2D Shape Area Comparison");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create JPanel for drawing
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int panelWidth = getWidth();
                int panelHeight = getHeight();

                // Find max area for scaling
                double maxArea = 0;
                for (double a : areas) if (a > maxArea) maxArea = a;

                // Bar width and spacing
                int barWidth = panelWidth / (areas.length * 2);
                int spacing = barWidth / 2;

                // Draw bars
                for (int i = 0; i < areas.length; i++) {
                    int barHeight = (int)((areas[i] / maxArea) * (panelHeight - 50)); // scale to fit panel
                    g.setColor(Color.getHSBColor((float)i / areas.length, 0.8f, 0.8f));
                    g.fillRect(spacing + i * (barWidth + spacing), panelHeight - barHeight - 30, barWidth, barHeight);
                    g.setColor(Color.BLACK);
                    g.drawString(shapes[i], spacing + i * (barWidth + spacing), panelHeight - 10);
                    g.drawString(String.format("%.2f", areas[i]), spacing + i * (barWidth + spacing), panelHeight - barHeight - 35);
                }
            }
        };

        frame.add(panel);
        frame.setVisible(true);
}
    }

     