package rms_main;

import rms_dashboard.login;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                login login = new login();
                login.setVisible(true);
            }
        });

    }
}   