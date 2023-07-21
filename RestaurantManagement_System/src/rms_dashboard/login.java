package rms_dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public login() {
        setTitle("Login Page");
        setSize(400, 250); // Increase height to accommodate the new label
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE); // Set background color to white
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding

        JLabel loginLabel = new JLabel("Log In");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font size and style
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span two columns
        panel.add(loginLabel, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset gridwidth to 1
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField(15); // Set preferred width
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(15); // Set preferred width
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Make the button span two columns
        gbc.fill = GridBagConstraints.HORIZONTAL; // Stretch the button horizontally
        panel.add(loginButton, gbc);

        loginButton.setBackground(Color.GREEN); // Set the button color to green
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                if (isValidCredentials(username, password)) {
                    // If login is successful, close the login page and open the Menu page
                    Menu menu = new Menu();
                    menu.setVisible(true);
                    dispose(); // This will close the login page
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                }
            }
        });

        add(panel);
    }

    private boolean isValidCredentials(String username, String password) {
        // Check the credentials against your stored values (e.g., in a database)
        String validUsername = "user";
        String validPassword = "pass";
        return username.equals(validUsername) && password.equals(validPassword);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                login loginPage = new login();
                loginPage.setVisible(true);
            }
        });
    }
}