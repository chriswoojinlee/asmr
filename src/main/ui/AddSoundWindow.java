package ui;

import model.Profile;
import model.Sound;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSoundWindow {
    JFrame frame = new JFrame();
    JTextField newSoundNameField = new JTextField();
    JLabel nameLabel = new JLabel("Enter a name for the new profile:");

    // MODIFIES: this
    // EFFECTS: creates new profile name label; adds new profile with entered name to profile manager
    public AddSoundWindow(Profile profile) {
        newSoundNameField.setBounds(260, 0, 125, 50);
        nameLabel.setBounds(50, 0, 250, 50);
        frame.add(nameLabel);
        frame.add(newSoundNameField);
        newSoundNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newSoundName = newSoundNameField.getText();
                Sound sound = new Sound(newSoundName, "data/rain.wav");
                profile.addSound(sound);
            }
        });
        frame.setSize(400, 80);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

