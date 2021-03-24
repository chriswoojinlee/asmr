package ui;

import model.Profile;
import model.ProfileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProfileNameWindow {
    JFrame frame = new JFrame();
    JTextField profileToEditField = new JTextField();
    JTextField newProfileNameField = new JTextField();
    JLabel deleteLabel = new JLabel("Enter the name of the profile to edit:");
    JLabel newNameLabel = new JLabel("Enter a new name for the selected profile:");

    public EditProfileNameWindow(ProfileManager profileManager) {
        profileToEditField.setBounds(360, 0, 125, 50);
        newProfileNameField.setBounds(360, 50, 125, 50);
        deleteLabel.setBounds(50, 0, 250, 50);
        newNameLabel.setBounds(50, 50, 275, 50);
        frame.add(deleteLabel);
        frame.add(profileToEditField);
        frame.add(newNameLabel);
        frame.add(newProfileNameField);
        profileToEditField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile profileToEdit = null;
                
                for (Profile p : profileManager.getListOfProfiles()) {
                    if (profileToEditField.getText().equals(p.getProfileName())) {
                        profileToEdit = p;
                    }
                }
                
                String newName = newProfileNameField.getText();
                profileToEdit.editProfileName(newName);
            }
        });
        frame.setSize(500, 160);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
