package ui;

import model.Profile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileWindow implements ActionListener {
    Profile profile;
    JFrame frame = new JFrame();
    JLabel currentProfile;
    JButton addNewSoundButton = new JButton("Add a new sound");
    JButton playSoundButton = new JButton("Play a sound");
    JButton deleteSoundButton = new JButton("Delete a sound");
    JButton viewSoundsButton = new JButton("View sounds");

    public ProfileWindow(Profile profile) {
        this.profile = profile;
        currentProfile = new JLabel("Current profile: " + profile.getProfileName());
        currentProfile.setBounds(200, 0, 200, 50);
        playSoundButton.setBounds(50,50,200,50);
        playSoundButton.setFocusable(true);
        playSoundButton.addActionListener(this);
        addNewSoundButton.setBounds(250,50,200,50);
        addNewSoundButton.setFocusable(true);
        addNewSoundButton.addActionListener(this);
        deleteSoundButton.setBounds(50,100,200,50);
        deleteSoundButton.setFocusable(true);
        deleteSoundButton.addActionListener(this);
        viewSoundsButton.setBounds(250,100,200,50);
        viewSoundsButton.setFocusable(true);
        viewSoundsButton.addActionListener(this);

        frame.add(currentProfile);
        frame.add(playSoundButton);
        frame.add(addNewSoundButton);
        frame.add(deleteSoundButton);
        frame.add(viewSoundsButton);
        frame.setSize(500, 200);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playSoundButton) {
            PlaySoundWindow playSoundButton = new PlaySoundWindow(profile);
        } else if (e.getSource() == addNewSoundButton) {
            AddSoundWindow addNewSoundWindow = new AddSoundWindow(profile);
        } else if (e.getSource() == deleteSoundButton) {
            DeleteSoundWindow deleteSoundWindow = new DeleteSoundWindow(profile);
        } else if (e.getSource() == viewSoundsButton) {
            ViewSoundsWindow viewSoundsWindow = new ViewSoundsWindow(profile);
        }
    }

}
