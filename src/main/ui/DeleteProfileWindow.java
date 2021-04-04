package ui;

import exceptions.DoesntContainException;
import model.Profile;
import model.ProfileManager;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class DeleteProfileWindow {
    JFrame frame = new JFrame();
    JTextField profileToDeleteField = new JTextField();
    JLabel deleteLabel = new JLabel("Enter the name for the profile to delete:");
    String wavLocation = "data/trash.wav";

    // MODIFIES: this
    // EFFECTS: creates profile deletion label; deletes profile with matching entered name;
    //          plays trash sound upon deletion of a profile
    public DeleteProfileWindow(ProfileManager profileManager) {
        profileToDeleteField.setBounds(360, 0, 125, 50);
        deleteLabel.setBounds(50, 0, 250, 50);
        frame.add(deleteLabel);
        frame.add(profileToDeleteField);
        profileToDeleteField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Profile p : profileManager.getListOfProfiles()) {
                    if (profileToDeleteField.getText().equals(p.getProfileName())) {
                        try {
                            profileManager.deleteProfile(p);
                            playSound(wavLocation);
                        } catch (DoesntContainException ex) {
                            System.out.println("Profile doesn't exist!");
                        }
                    }
                }
            }
        });
        frame.setSize(500, 80);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // Source: https://stackoverflow.com/questions/39085830/how-to-play-a-wav-file-using-java
    // EFFECTS: plays audio of trashcan sound using audio file
    public void playSound(String wavLocation) {
        String audio = wavLocation;

        try {
            Clip sound = AudioSystem.getClip();
            sound.open(AudioSystem.getAudioInputStream(new File(audio)));
            sound.start();
        } catch (IllegalArgumentException | SecurityException | LineUnavailableException e) {
            System.err.println(e.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } catch (Exception genE) {
            System.err.println(genE.getMessage());
        }
    }
}
