import javax.swing.*;
import java.awt.*;

public class Shape3D {

    public static void sphere(UltraShape.DrawPanel panel) {
        String r = JOptionPane.showInputDialog("Enter radius of sphere:");
        double radius = Double.parseDouble(r);
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        JOptionPane.showMessageDialog(panel, "Volume of Sphere = " + volume);

        panel.setShape("Sphere (3D)", radius);
    }

    public static void cube(UltraShape.DrawPanel panel) {
        String s = JOptionPane.showInputDialog("Enter side length of cube:");
        double side = Double.parseDouble(s);
        double volume = Math.pow(side, 3);
        JOptionPane.showMessageDialog(panel, "Volume of Cube = " + volume);

        panel.setShape("Cube (3D)", side);
    }

    public static void cylinder(UltraShape.DrawPanel panel) {
        String r = JOptionPane.showInputDialog("Enter radius of cylinder:");
        String h = JOptionPane.showInputDialog("Enter height of cylinder:");
        double radius = Double.parseDouble(r);
        double height = Double.parseDouble(h);
        double volume = Math.PI * radius * radius * height;
        JOptionPane.showMessageDialog(panel, "Volume of Cylinder = " + volume);

        panel.setShape("Cylinder (3D)", radius, height);
    }

    public static void cone(UltraShape.DrawPanel panel) {
        String r = JOptionPane.showInputDialog("Enter radius of cone:");
        String h = JOptionPane.showInputDialog("Enter height of cone:");
        double radius = Double.parseDouble(r);
        double height = Double.parseDouble(h);
        double volume = (Math.PI * radius * radius * height) / 3.0;
        JOptionPane.showMessageDialog(panel, "Volume of Cone = " + volume);

        panel.setShape("Cone (3D)", radius, height);
    }

    public static void rectangularPrism(UltraShape.DrawPanel panel) {
        String l = JOptionPane.showInputDialog("Enter length of prism:");
        String w = JOptionPane.showInputDialog("Enter width of prism:");
        String h = JOptionPane.showInputDialog("Enter height of prism:");
        double length = Double.parseDouble(l);
        double width = Double.parseDouble(w);
        double height = Double.parseDouble(h);
        double volume = length * width * height;
        JOptionPane.showMessageDialog(panel, "Volume of Rectangular Prism = " + volume);

        panel.setShape("Rectanglar Prism (3D)", length, width, height);
    }
}

