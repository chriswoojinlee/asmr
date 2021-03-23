package ui;

import model.Profile;
import model.ProfileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProfileWindow {
    Profile profile;
    JFrame frame = new JFrame();
    JTextField newProfileNameField = new JTextField();
    JLabel nameLabel = new JLabel("Enter a name for the new profile:");

    public CreateProfileWindow(ProfileManager profileManager) {
        newProfileNameField.setBounds(260, 0, 125, 50);
        nameLabel.setBounds(50, 0, 250, 50);
        frame.add(nameLabel);
        frame.add(newProfileNameField);
        newProfileNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profile = new Profile(newProfileNameField.getText());
                profileManager.addProfile(profile);
            }
        });
        frame.setSize(400, 80);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
