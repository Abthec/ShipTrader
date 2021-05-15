package me.charlie.Gui;

import javax.swing.*;

public class ShipSelector extends JFrame{
    private JPanel mainPanel;
    private JLabel lblViewShipProperties;
    private JButton buttonShipOption3;
    private JButton buttonShipOption1;
    private JButton buttonGoBack;
    private JButton buttonShipOption2;
    private JButton buttonShipOption4;
    private JLabel lblChooseShip;

    public ShipSelector(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame jFrame = new ShipSelector("Ship Selector");
        jFrame.setVisible(true);
    }

}
