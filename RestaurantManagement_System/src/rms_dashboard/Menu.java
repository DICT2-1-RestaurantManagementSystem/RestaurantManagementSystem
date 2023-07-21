package rms_dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Menu extends JFrame implements ActionListener {
    private final JButton costBtn,clearBtn,exitBtn;
    private final JTextArea ordersDisplay;
    private final JTextArea totalarea,subtotalarea,payarea;
    private final JTextField menu2txt,menu3txt,menu1txt,menu4txt,menu5txt,menu6txt,menu7txt,menu8txt,menu9txt,menu10txt;

    private int m1txt, m2txt, m3txt, m4txt, m5txt, m6txt, m7txt, m8txt, m9txt, m10txt;
    private Connection connection;
    Menu () {
        setTitle("RMS MENU");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane();
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JPanel leftPanel = new JPanel(null);
        leftPanel.setBackground(Color.DARK_GRAY);
        leftPanel.setBounds(0, 0, 180, 600);
        add(leftPanel);

        // Create a right panel for the light gray background
        JPanel rightPanel = new JPanel(null);
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setBounds(100, 0, 850, 600);
        add(rightPanel);


        JLabel menu = new JLabel("Restaurant Management System");
        menu.setBounds(250, 20, 500, 50);
        Font rmsFont = menu.getFont().deriveFont(30f); // 16 is the new font size
        menu.setFont(rmsFont);
        add(menu);

        //----------------------------- Menu -----------------------------//

        JLabel menu1 = new JLabel("₱50 Adobo");
        menu1.setBounds(100, 100, 200, 20);
        Font newFont = menu.getFont().deriveFont(16f); // 16 is the new font size
        menu1.setFont(newFont);
        add(menu1);

        JLabel menu2 = new JLabel("₱75 Kaldereta");
        menu2.setBounds(100, 150, 200, 20);
        menu2.getFont().deriveFont(16f); // 16 is the new font size
        menu2.setFont(newFont);
        add(menu2);

        JLabel menu3 = new JLabel("₱70 Kare-Kare");
        menu3.setBounds(100, 200, 200, 20);
        menu3.getFont().deriveFont(16f); // 16 is the new font size
        menu3.setFont(newFont);
        add(menu3);

        JLabel menu4 = new JLabel("₱80 Puchero");
        menu4.setBounds(100, 250, 200, 20); // Adjust the bounds as needed
        menu4.getFont().deriveFont(16f); // 16 is the new font size
        menu4.setFont(newFont);
        add(menu4);

        JLabel menu5 = new JLabel("₱80 Mechado");
        menu5.setBounds(100, 300, 200, 20); // Adjust the bounds as needed
        menu5.getFont().deriveFont(16f); // 16 is the new font size
        menu5.setFont(newFont);
        add(menu5);

        JLabel menu6 = new JLabel("₱35 Halo-Halo");
        menu6.setBounds(338 , 100, 200, 20);
        menu6.getFont().deriveFont(16f); // 16 is the new font size
        menu6.setFont(newFont);
        add(menu6);

        JLabel menu7 = new JLabel("₱35 Leche Flan");
        menu7.setBounds(338, 150, 200, 20);
        menu7.getFont().deriveFont(16f); // 16 is the new font size
        menu7.setFont(newFont);
        add(menu7);

        JLabel menu8 = new JLabel("₱25 Samalamig");
        menu8.setBounds(338, 200, 200, 20);
        menu8.getFont().deriveFont(16f); // 16 is the new font size
        menu8.setFont(newFont);
        add(menu8);

        JLabel menu9 = new JLabel("₱20 Buko Juice");
        menu9.setBounds(338, 250, 200, 20); // Adjust the bounds as needed
        menu9.getFont().deriveFont(16f); // 16 is the new font size
        menu9.setFont(newFont);
        add(menu9);

        JLabel menu10 = new JLabel("₱25 Gulaman");
        menu10.setBounds(338, 300, 200, 20); // Adjust the bounds as needed
        menu10.getFont().deriveFont(16f); // 16 is the new font size
        menu10.setFont(newFont);
        add(menu10);

        //----------------------------- Quantity -----------------------------//

        menu1txt = new JTextField();
        menu1txt.setBounds(250, 100, 50, 20);
        add(menu1txt);

        menu2txt = new JTextField();
        menu2txt.setBounds(250, 150, 50, 20);
        add(menu2txt);

        menu3txt = new JTextField();
        menu3txt.setBounds(250, 200, 50, 20);
        add(menu3txt);

        menu4txt = new JTextField();
        menu4txt.setBounds(250, 250, 50, 20);
        add(menu4txt);

        menu5txt = new JTextField();
        menu5txt.setBounds(250, 300, 50, 20);
        add(menu5txt);

        menu6txt = new JTextField();
        menu6txt.setBounds(490, 100, 50, 20);
        add(menu6txt);

        menu7txt = new JTextField();
        menu7txt.setBounds(490, 150, 50, 20);
        add(menu7txt);

        menu8txt = new JTextField();
        menu8txt.setBounds(490, 200, 50, 20);
        add(menu8txt);

        menu9txt = new JTextField();
        menu9txt.setBounds(490, 250, 50, 20);
        add(menu9txt);

        menu10txt = new JTextField();
        menu10txt.setBounds(490, 300, 50, 20);
        add(menu10txt);

        //----------------------------- Buttons -----------------------------//

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(18, 300, 150, 50);
        clearBtn.setFocusable(false);
        clearBtn.addActionListener(this);
        add(clearBtn);

        costBtn = new JButton("Enter");
        costBtn.setBounds(18, 370, 150, 50);
        costBtn.setFocusable(false);
        costBtn.addActionListener(this);
        add(costBtn);


        exitBtn = new JButton("Exit");
        exitBtn.setBounds(18, 440, 150, 50);
        exitBtn.setFocusable(false);
        exitBtn.addActionListener(this);
        add(exitBtn);
        //----------------------------- Orders Prompt -----------------------------//

        JLabel orders = new JLabel(">>>>>>>>> Orders Display <<<<<<<<<");
        orders.setBounds(614, 80, 300, 20);
        add(orders);

        ordersDisplay = new JTextArea();
        ordersDisplay.setBounds(600, 100, 800, 300);
        add(ordersDisplay);

        //----------------------------- Total -----------------------------//

        JLabel subtotal = new JLabel("TOTAL: ");
        subtotal.setBounds(600, 425, 100, 30);
        subtotal.getFont().deriveFont(16f); // 16 is the new font size
        subtotal.setFont(newFont);
        add(subtotal);

        subtotalarea = new JTextArea();
        subtotalarea.setBounds(695, 425, 150, 30);
        add(subtotalarea);

        JLabel total = new JLabel("CHANGES: ");
        total.setBounds(600, 465, 100, 30);
        total.getFont().deriveFont(16f); // 16 is the new font size
        total.setFont(newFont);
        add(total);

        totalarea = new JTextArea();
        totalarea.setBounds(695, 465, 150, 30);
        add(totalarea);

        JLabel payment = new JLabel("| PAYMENT ");
        payment.setBounds(290, 350, 100, 30);
        payment.getFont().deriveFont(16f); // 16 is the new font size
        payment.setFont(newFont);
        add(payment);

        payarea = new JTextArea();
        payarea.setBounds(390, 350, 150, 30);
        add(payarea);

        // Add the nestedPanel to the right panel (light gray)
        getContentPane().setBackground(Color.LIGHT_GRAY);
        rightPanel.add(menu);
        rightPanel.add(menu1);
        rightPanel.add(menu2);
        rightPanel.add(menu3);
        rightPanel.add(menu4);
        rightPanel.add(menu5);
        rightPanel.add(menu6);
        rightPanel.add(menu7);
        rightPanel.add(menu8);
        rightPanel.add(menu9);
        rightPanel.add(menu10);
        rightPanel.add(menu1txt);
        rightPanel.add(menu2txt);
        rightPanel.add(menu3txt);
        rightPanel.add(menu4txt);
        rightPanel.add(menu5txt);
        rightPanel.add(menu6txt);
        rightPanel.add(menu7txt);
        rightPanel.add(menu8txt);
        rightPanel.add(menu9txt);
        rightPanel.add(menu10txt);
        rightPanel.add(orders);
        rightPanel.add(ordersDisplay);
        rightPanel.add(payment);
        rightPanel.add(payarea);
        rightPanel.add(total);
        rightPanel.add(totalarea);
        rightPanel.add(subtotal);
        rightPanel.add(subtotalarea);

        // Add the nested panel and other components to the left panel (dark gray)
        leftPanel.add(clearBtn);
        leftPanel.add(exitBtn);
        leftPanel.add(costBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == costBtn) {
            try {
                if (!menu1txt.getText().isEmpty()) {
                    m1txt = Integer.parseInt(menu1txt.getText());
                    if (m1txt < 0) {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException f) {
                if (!menu1txt.getText().isEmpty()) {
                    String errorText = " Invalid input for Menu.";
                    ordersDisplay.append(errorText + "\n");
                    menu1txt.setText("");
                    return; // Return to prevent further execution of this part for this item
                }
            }

            try {
                if (!menu2txt.getText().isEmpty()) {
                    m2txt = Integer.parseInt(menu2txt.getText());
                    if (m2txt < 0) {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException f) {
                if (!menu2txt.getText().isEmpty()) {
                    String errorText = " Invalid input for Menu.";
                    ordersDisplay.append(errorText + "\n");
                    menu2txt.setText("");
                    return; // Return to prevent further execution of this part for this item
                }
            }

            try {
                if (!menu3txt.getText().isEmpty()) {
                    m3txt = Integer.parseInt(menu3txt.getText());
                    if (m3txt < 0) {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException f) {
                if (!menu3txt.getText().isEmpty()) {
                    String errorText = " Invalid input for Menu.";
                    ordersDisplay.append(errorText + "\n");
                    menu3txt.setText("");
                    return; // Return to prevent further execution of this part for this item
                }
            }

            try {
                if (!menu4txt.getText().isEmpty()) {
                    m4txt = Integer.parseInt(menu4txt.getText());
                    if (m4txt < 0) {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException f) {
                if (!menu4txt.getText().isEmpty()) {
                    String errorText = " Invalid input for Menu.";
                    ordersDisplay.append(errorText + "\n");
                    menu4txt.setText("");
                    return; // Return to prevent further execution of this part for this item
                }
            }

            try {
                if (!menu5txt.getText().isEmpty()) {
                    m5txt = Integer.parseInt(menu5txt.getText());
                    if (m5txt < 0) {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException f) {
                if (!menu5txt.getText().isEmpty()) {
                    String errorText = "I nvalid input for Menu.";
                    ordersDisplay.append(errorText + "\n");
                    menu5txt.setText("");
                    return; // Return to prevent further execution of this part for this item
                }
            }

            try {
                if (!menu6txt.getText().isEmpty()) {
                    m6txt = Integer.parseInt(menu6txt.getText());
                    if (m6txt < 0) {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException f) {
                if (!menu6txt.getText().isEmpty()) {
                    String errorText = " Invalid input for Menu.";
                    ordersDisplay.append(errorText + "\n");
                    menu6txt.setText("");
                    return; // Return to prevent further execution of this part for this item
                }
            }

            try {
                if (!menu7txt.getText().isEmpty()) {
                    m7txt = Integer.parseInt(menu7txt.getText());
                    if (m7txt < 0) {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException f) {
                if (!menu7txt.getText().isEmpty()) {
                    String errorText = " Invalid input for Menu.";
                    ordersDisplay.append(errorText + "\n");
                    menu7txt.setText("");
                    return; // Return to prevent further execution of this part for this item
                }
            }

            try {
                if (!menu8txt.getText().isEmpty()) {
                    m8txt = Integer.parseInt(menu8txt.getText());
                    if (m8txt < 0) {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException f) {
                if (!menu8txt.getText().isEmpty()) {
                    String errorText = " Invalid input for Menu.";
                    ordersDisplay.append(errorText + "\n");
                    menu8txt.setText("");
                    return; // Return to prevent further execution of this part for this item
                }
            }

            try {
                if (!menu9txt.getText().isEmpty()) {
                    m9txt = Integer.parseInt(menu9txt.getText());
                    if (m9txt < 0) {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException f) {
                if (!menu9txt.getText().isEmpty()) {
                    String errorText = " Invalid input for Menu.";
                    ordersDisplay.append(errorText + "\n");
                    menu9txt.setText("");
                    return; // Return to prevent further execution of this part for this item
                }
            }

            try {
                if (!menu10txt.getText().isEmpty()) {
                    m10txt = Integer.parseInt(menu10txt.getText());
                    if (m10txt < 0) {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException f) {
                if (!menu10txt.getText().isEmpty()) {
                    String errorText = " Invalid input for Menu.";
                    ordersDisplay.append(errorText + "\n");
                    menu10txt.setText("");
                    return; // Return to prevent further execution of this part for this item
                }
            }

            // Calculate the total and update the total area accordingly
            double total1 = m1txt * 50;
            double total2 = m2txt * 75;
            double total3 = m3txt * 70;
            double total4 = m4txt * 80;
            double total5 = m5txt * 80;
            double total6 = m6txt * 35;
            double total7 = m7txt * 35;
            double total8 = m8txt * 25;
            double total9 = m9txt * 20;
            double total10 = m10txt * 25;

            // Display the order and update the total area accordingly
            if (m1txt > 0) {
                ordersDisplay.append(" Adobo order: " + m1txt + "| ₱" + total1 + "\n");
            }
            if (m2txt > 0) {
                ordersDisplay.append(" Kaldereta order: " + m2txt + "| ₱" + total2 + "\n");
            }
            if (m3txt > 0) {
                ordersDisplay.append(" Kare-Kare order: " + m3txt + "| ₱" + total3 + "\n");
            }
            if (m4txt > 0) {
                ordersDisplay.append(" Puchero order: " + m4txt + "| ₱" + total4 + "\n");
            }
            if (m5txt > 0) {
                ordersDisplay.append(" Mechado order: " + m5txt + "| ₱" + total5 + "\n");
            }
            if (m6txt > 0) {
                ordersDisplay.append(" Halo-Halo order: " + m6txt + "| ₱" + total6 + "\n");
            }
            if (m7txt > 0) {
                ordersDisplay.append(" Leche flan order: " + m7txt + "| ₱" + total7 + "\n");
            }
            if (m8txt > 0) {
                ordersDisplay.append(" Samalamig order: " + m8txt + "| ₱" + total8 + "\n");
            }
            if (m9txt > 0) {
                ordersDisplay.append(" Buko Jice order: " + m9txt + "| ₱" + total9 + "\n");
            }
            if (m10txt > 0) {
                ordersDisplay.append(" Gulaman order: " + m10txt + "| ₱" + total10 + "\n");
            }
            double subtotal = total1 + total2 + total3 + total4 + total5 + total6 + total7 + total8 + total9 + total10;
            subtotalarea.setText(" Pesos " + subtotal);

            String paymentText = payarea.getText();
            try {
                double payment = Double.parseDouble(paymentText);
                double total = subtotal - payment;
                totalarea.setText(" Pesos " + total);
            } catch (NumberFormatException ex) {
                // Handle invalid payment amount (non-numeric value)
                ordersDisplay.append(" Invalid payment amount enter a valid number.\n");
            }

        } else if (e.getSource() == clearBtn) {
            // Handle the clear button event here
            ordersDisplay.setText(""); // Clear the ordersDisplay text area
            totalarea.setText(""); // Clear the totalarea text area
            menu1txt.setText(""); // Clear the input text field
            payarea.setText("");
            subtotalarea.setText("");
            menu2txt.setText("");
            menu3txt.setText("");
            menu4txt.setText("");
            menu5txt.setText("");
            menu6txt.setText("");
            menu7txt.setText("");
            menu8txt.setText("");
            menu9txt.setText("");
            menu10txt.setText("");
        } else if (e.getSource() == exitBtn) {
            // Handle the exit button event here
            int confirmed = JOptionPane.showConfirmDialog(
                    this, "Are you sure you want to exit?", "Confirm Exit",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (confirmed == JOptionPane.YES_OPTION) {
                dispose(); // Close the JFrame
            }
        }
    }
}
