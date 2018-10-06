package com.nullpointers.nomanleft;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("No Man Left");
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setContentPane(new MainPanel().getMainPanel());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
