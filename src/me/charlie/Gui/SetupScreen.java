package me.charlie.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupScreen extends JFrame{
    private JTextField textFieldEnterName;
    private JLabel lblWelcome;
    private JLabel lblEnterName;
    private JPanel mainPanel;
    private JLabel lblNameConditions;
    private JSlider sliderGameDuration;
    private JLabel lblGameDuration;
    private JLabel lblGameDurationConditions;
    private JButton readyButton;
    String traderName;
    int gameDuration;

    public SetupScreen(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        readyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // grab the text from the enter name text field
                // grab the value from the slider
                // run checks to make sure they meet our conditions
                // if conditions are met open ship selector
                traderName = textFieldEnterName.getText();
                gameDuration = sliderGameDuration.getValue();
                System.out.println(traderName + gameDuration);
            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new SetupScreen("Ship Trader - Setup");
        jFrame.setVisible(true);
    }
}
