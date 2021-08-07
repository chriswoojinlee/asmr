package ui;

import model.Profile;
import model.Sound;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSoundWindow implements ActionListener {
    Profile profile;
    JFrame frame = new JFrame();
    JLabel soundsLabel = new JLabel("Choose a sound to add:");
    JButton windButton = new JButton("Wind");
    JButton rainButton = new JButton("Rain");
    JButton thunderButton = new JButton("Thunder");
    JButton fireButton = new JButton("Fire");

    // MODIFIES: this
    // EFFECTS: creates new profile name label; adds new profile with entered name to profile manager
    public AddSoundWindow(Profile profile) {
        this.profile = profile;
        soundsLabel.setBounds(50, 0, 250, 50);
        windButton.setBounds(50,50,200,50);
        windButton.setFocusable(true);
        windButton.addActionListener(this);
        rainButton.setBounds(250,50,200,50);
        rainButton.setFocusable(true);
        rainButton.addActionListener(this);
        thunderButton.setBounds(50,100,200,50);
        thunderButton.setFocusable(true);
        thunderButton.addActionListener(this);
        fireButton.setBounds(250,100,200,50);
        fireButton.setFocusable(true);
        fireButton.addActionListener(this);
        frame.add(soundsLabel);
        frame.add(windButton);
        frame.add(rainButton);
        frame.add(thunderButton);
        frame.add(fireButton);
        frame.setSize(500, 200);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: provides conditional actions upon button press for each button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windButton) {
            profile.addSound(new Sound("Wind", "data/wind.wav"));
        } else if (e.getSource() == rainButton) {
            profile.addSound(new Sound("Rain", "data/rain.wav"));
        } else if (e.getSource() == thunderButton) {
            profile.addSound(new Sound("Thunder", "data/thunder.wav"));
        } else if (e.getSource() == fireButton) {
            profile.addSound(new Sound("Fire", "data/fire.wav"));
        }
    }
}

