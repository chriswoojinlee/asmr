package ui;

import model.Profile;
import model.Sound;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class DeleteSoundWindow {
    JFrame frame = new JFrame();
    JTextField soundToDeleteField = new JTextField();
    JLabel deleteLabel = new JLabel("Enter the name for the sound to delete:");
    String wavLocation = "data/trash.wav";

    // MODIFIES: this
    // EFFECTS: creates sound deletion label; deletes sound with matching entered name;
    //          plays trash sound upon deletion of a sound
    public DeleteSoundWindow(Profile profile) {
        soundToDeleteField.setBounds(360, 0, 125, 50);
        deleteLabel.setBounds(50, 0, 250, 50);
        frame.add(deleteLabel);
        frame.add(soundToDeleteField);
        soundToDeleteField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Sound s : profile.getSounds()) {
                    if (soundToDeleteField.getText().equals(s.getSoundName())) {
                        profile.removeSound(s);
                        playSound(wavLocation);
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
