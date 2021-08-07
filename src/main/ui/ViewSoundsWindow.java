package ui;

import model.Profile;
import model.Sound;

import javax.swing.*;

public class ViewSoundsWindow {
    Profile profile;
    JFrame frame = new JFrame();
    JLabel names;
    String listOfSounds = "Sounds:";

    // MODIFIES: this
    // EFFECTS: creates sounds label; afterwards, lists out every sound in profile
    public ViewSoundsWindow(Profile profile) {
        this.profile = profile;
        for (Sound s : profile.getSounds()) {
            listOfSounds = listOfSounds + " " + s.getSoundName();
        }
        names = new JLabel(listOfSounds);
        names.setBounds(50, 0, 250, 50);
        frame.add(names);
        frame.setSize(400, 80);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
