package ui;

import model.Profile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileWindow implements ActionListener {
    JFrame frame = new JFrame();
    JButton addNewSoundButton = new JButton("Add a new sound");
    JButton playSoundButton = new JButton("Play a sound");
    Profile profile;

    public ProfileWindow(Profile profile) {
        this.profile = profile;
        playSoundButton.setBounds(50,150,200,50);
        playSoundButton.setFocusable(true);
        playSoundButton.addActionListener(this);
        addNewSoundButton.setBounds(250,150,200,50);
        addNewSoundButton.setFocusable(true);
        addNewSoundButton.addActionListener(this);

        frame.add(playSoundButton);
        frame.add(addNewSoundButton);
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playSoundButton) {
            PlaySoundWindow playSoundButton = new PlaySoundWindow(profile);
        } else if (e.getSource() == addNewSoundButton) {
            AddSoundWindow addNewSoundWindow = new AddSoundWindow(profile);
        }
    }

}
