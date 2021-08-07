package ui;

import model.Profile;
import model.ProfileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccessProfileWindow {
    JFrame frame = new JFrame();
    JTextField profileToAccess = new JTextField();
    JLabel accessLabel = new JLabel("Enter the name for the profile to access:");

    public AccessProfileWindow(ProfileManager profileManager) {
        profileToAccess.setBounds(360, 0, 125, 50);
        accessLabel.setBounds(30, 0, 270, 50);
        frame.add(accessLabel);
        frame.add(profileToAccess);
        profileToAccess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Profile p : profileManager.getListOfProfiles()) {
                    if (profileToAccess.getText().equals(p.getProfileName())) {
                            ProfileWindow profileWindow = new ProfileWindow(p);
                    }
                }
            }
        });
        frame.setSize(500, 80);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
