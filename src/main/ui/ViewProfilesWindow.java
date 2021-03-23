package ui;

import model.Profile;
import model.ProfileManager;

import javax.swing.*;

public class ViewProfilesWindow {
    ProfileManager profileManager;
    JFrame frame = new JFrame();
    JLabel names;
    String listOfProfiles = "Profiles:";

    public ViewProfilesWindow(ProfileManager profileManager) {
        this.profileManager = profileManager;
        for (Profile p : profileManager.getListOfProfiles()) {
            listOfProfiles = listOfProfiles + " " + p.getProfileName();
        }
        names = new JLabel(listOfProfiles);
        names.setBounds(50, 0, 250, 50);
        frame.add(names);
        frame.setSize(400, 80);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
