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
import java.util.ArrayList;

public class PlaySoundWindow {
    Profile profile;
    JFrame frame = new JFrame();
    JTextField soundNameField = new JTextField();
    JLabel nameLabel = new JLabel("Enter the name of a sound to play:");

    // MODIFIES: this
    // EFFECTS: creates new profile name label; adds new profile with entered name to profile manager
    public PlaySoundWindow(Profile profile) {
        this.profile = profile;
        soundNameField.setBounds(260, 0, 125, 50);
        nameLabel.setBounds(10, 0, 250, 50);
        frame.add(nameLabel);
        frame.add(soundNameField);
        soundNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String soundName = soundNameField.getText();
                if(soundName.equals("Wind") && containsSound(soundName)) {
                    playSound("data/wind.wav");
                } else if(soundName.equals("Rain") && containsSound(soundName)) {
                    playSound("data/rain.wav");
                } else if(soundName.equals("Thunder") && containsSound(soundName)) {
                    playSound("data/thunder.wav");
                } else if(soundName.equals("Fire") && containsSound(soundName)) {
                    playSound("data/fire.wav");
                }
            }
        });
        frame.setSize(400, 80);
        frame.setLayout(null);
        frame.setVisible(true);
    }

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

    public boolean containsSound(String soundName) {
        ArrayList<Sound> sounds = profile.getSounds();

        for(int i = 0; i < profile.getSoundCount(); i++) {
            if(sounds.get(i).getSoundName().equals(soundName)) {
                return true;
            }
        }

        return false;
    }
}
