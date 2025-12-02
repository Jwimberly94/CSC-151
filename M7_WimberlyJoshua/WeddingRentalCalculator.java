// Wedding Rental Calculator
// Joshua Wimberly
// November 28, 2025
// This program calculates the rental cost for tables and chairs for a wedding.






/*
PSEUDOCODE:

PROGRAM WeddingRentalCalculator
    
    CONSTANTS:
        TABLE_PRICE = 20.00
        CHAIR_PRICE = 10.00
    
    MAIN:
        CREATE window
        SHOW welcome message
        DO
            WAIT for user action
            IF calculate button clicked THEN
                CALL calculateCost()
            ELSE IF clear button clicked THEN
                CALL clearForm()
            ELSE IF view info button clicked THEN
                CALL openPDF()
            ELSE IF exit button clicked THEN
                ASK "Are you sure?"
                IF yes THEN
                    EXIT program
                END IF
            END IF
        WHILE user hasn't exited
    END MAIN
    
    FUNCTION calculateCost():
        GET itemType from dropdown
        GET quantity from textfield
        
        IF quantity <= 0 THEN
            SHOW error "Enter positive number"
            RETURN
        END IF
        
        // Decision Structure - SWITCH
        SWITCH itemType:
            CASE "Tables":
                price = TABLE_PRICE
                BREAK
            CASE "Chairs":
                price = CHAIR_PRICE
                BREAK
        END SWITCH
        
        total = quantity * price
        DISPLAY results
    END FUNCTION
    
    FUNCTION clearForm():
        CLEAR quantity field
        CLEAR result area
        RESET dropdown to first option
    END FUNCTION
    
    FUNCTION openPDF():
        IF file exists THEN
            OPEN SeatingInfo.pdf
        ELSE
            SHOW error "File not found"
        END IF
    END FUNCTION

END PROGRAM
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;




public class WeddingRentalCalculator extends JFrame {
    
    // Prices
    private static final double TABLE_PRICE = 20.00;
    private static final double CHAIR_PRICE = 10.00;
    
    // GUI stuff
    private JComboBox<String> itemTypeCombo;
    private JTextField quantityField;
    private JTextArea resultArea;
    private JButton calculateButton;
    private JButton clearButton;
    private JButton exitButton;
    private JButton viewSeatingInfoButton;
    
    // Set up the window
    public WeddingRentalCalculator() {
        setTitle("Wedding Rental Calculator - Tables & Chairs");
        setSize(500, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Title
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(70, 130, 180));
        JLabel titleLabel = new JLabel("Wedding Rental Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        
        // Input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 8, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Rental Information"));
        
        JLabel itemLabel = new JLabel("Select Item Type:");
        itemLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        String[] itemTypes = {"Tables", "Chairs"};
        itemTypeCombo = new JComboBox<>(itemTypes);
        itemTypeCombo.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JLabel quantityLabel = new JLabel("Enter Quantity:");
        quantityLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        quantityField = new JTextField(10);
        quantityField.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JLabel priceInfoLabel = new JLabel("Pricing: Tables $" + TABLE_PRICE + " | Chairs $" + CHAIR_PRICE);
        priceInfoLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        priceInfoLabel.setForeground(new Color(100, 100, 100));
        
        inputPanel.add(itemLabel);
        inputPanel.add(itemTypeCombo);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("")); // Spacer
        inputPanel.add(priceInfoLabel);
        
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        
        // Results
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout(5, 5));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Calculation Results"));
        
        resultArea = new JTextArea(5, 35);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        resultArea.setBackground(new Color(245, 245, 245));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        resultPanel.add(scrollPane, BorderLayout.CENTER);
        
        mainPanel.add(resultPanel, BorderLayout.SOUTH);
        
        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 5));
        
        calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 11));
        calculateButton.setBackground(new Color(34, 139, 34));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        
        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.BOLD, 11));
        clearButton.setBackground(new Color(255, 165, 0));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 11));
        exitButton.setBackground(new Color(220, 20, 60));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);
        
        viewSeatingInfoButton = new JButton("View Info");
        viewSeatingInfoButton.setFont(new Font("Arial", Font.BOLD, 11));
        viewSeatingInfoButton.setBackground(new Color(70, 130, 180));
        viewSeatingInfoButton.setForeground(Color.WHITE);
        viewSeatingInfoButton.setFocusPainted(false);
        
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(viewSeatingInfoButton);
        buttonPanel.add(exitButton);
        
        // Add button panel to main panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.EAST);
        
        add(mainPanel);
        
        // Button actions
        calculateButton.addActionListener(new CalculateListener());
        clearButton.addActionListener(new ClearListener());
        exitButton.addActionListener(new ExitListener());
        viewSeatingInfoButton.addActionListener(new ViewSeatingInfoListener());
        quantityField.addActionListener(new CalculateListener());
    }
    
    // Calculate button - uses SWITCH for decision structure
    private class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String itemType = (String) itemTypeCombo.getSelectedItem();
                int quantity = Integer.parseInt(quantityField.getText().trim());
                
                if (quantity <= 0) {
                    JOptionPane.showMessageDialog(
                        WeddingRentalCalculator.this,
                        "Please enter a quantity greater than 0.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
                
                // SWITCH statement (Decision Structure)
                double pricePerItem = 0.0;
                String itemName = "";
                
                switch (itemType) {
                    case "Tables":
                        pricePerItem = TABLE_PRICE;
                        itemName = "Table(s)";
                        break;
                    case "Chairs":
                        pricePerItem = CHAIR_PRICE;
                        itemName = "Chair(s)";
                        break;
                    default:
                        JOptionPane.showMessageDialog(
                            WeddingRentalCalculator.this,
                            "Invalid item type selected.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                        );
                        return;
                }
                
                double totalCost = quantity * pricePerItem;
                
                // Show results
                StringBuilder result = new StringBuilder();
                result.append("=".repeat(50)).append("\n");
                result.append("RENTAL CALCULATION SUMMARY\n");
                result.append("=".repeat(50)).append("\n\n");
                result.append(String.format("Item Type:       %s\n", itemName));
                result.append(String.format("Quantity:        %d\n", quantity));
                result.append(String.format("Price Per Item:  $%.2f\n", pricePerItem));
                result.append("-".repeat(50)).append("\n");
                result.append(String.format("TOTAL COST:      $%.2f\n", totalCost));
                result.append("=".repeat(50)).append("\n\n");
                result.append("Thank you for using Wedding Rental Calculator!\n");
                
                resultArea.append(result.toString());
                resultArea.setCaretPosition(resultArea.getDocument().getLength());
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    WeddingRentalCalculator.this,
                    "Please enter a valid number for quantity.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
    // Clear button - resets everything
    private class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            quantityField.setText("");
            resultArea.setText("");
            itemTypeCombo.setSelectedIndex(0);
            quantityField.requestFocus();
        }
    }
    
    // Exit button - shows DO-WHILE loop (keeps running until user confirms exit)
    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int response = JOptionPane.showConfirmDialog(
                WeddingRentalCalculator.this,
                "Are you sure you want to exit?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (response == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(
                    WeddingRentalCalculator.this,
                    "Thank you for using Wedding Rental Calculator!\nGoodbye!",
                    "Goodbye",
                    JOptionPane.INFORMATION_MESSAGE
                );
                System.exit(0);
            }
        }
    }
    
    // View Info button - opens the PDF
    private class ViewSeatingInfoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                File pdfFile = new File("SeatingInfo.pdf");
                
                if (!pdfFile.exists()) {
                    JOptionPane.showMessageDialog(
                        WeddingRentalCalculator.this,
                        "SeatingInfo.pdf not found in the current directory.\n" +
                        "Please make sure the file is in the same folder as the program.",
                        "File Not Found",
                        JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
                
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    
                    if (desktop.isSupported(Desktop.Action.OPEN)) {
                        desktop.open(pdfFile);
                    } else {
                        JOptionPane.showMessageDialog(
                            WeddingRentalCalculator.this,
                            "Cannot open PDF files on this system.",
                            "Unsupported Operation",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                } else {
                    JOptionPane.showMessageDialog(
                        WeddingRentalCalculator.this,
                        "Desktop operations are not supported on this system.",
                        "Unsupported Operation",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                    WeddingRentalCalculator.this,
                    "Error opening SeatingInfo.pdf:\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
    // Main - start the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WeddingRentalCalculator calculator = new WeddingRentalCalculator();
                calculator.setVisible(true);
                
                // Display welcome message
                JOptionPane.showMessageDialog(
                    calculator,
                    "Welcome to the Wedding Rental Calculator!\n\n" +
                    "This program will help you calculate the cost\n" +
                    "of renting tables and chairs for your wedding.\n\n" +
                    "You can perform multiple calculations before exiting.",
                    "Welcome",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }
}
