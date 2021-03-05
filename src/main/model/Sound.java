package model;

import org.json.JSONObject;
import persistence.Writable;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.io.IOException;

// Represents an individual sound that can be played alone or in a profile that has a volume and name
public class Sound implements Writable {

    private static int DEFAULT_VOLUME = 0; // volume of every sound upon first play before volume is manually adjusted
    private int volume;  // volume of the sound
    private String name; // name of the sound
    private String audio; // path of .wav audio file of the sound

    /*
     * REQUIRES: soundName has a non-zero length; soundVolume is a whole number and is >= 0
     * EFFECTS: name of Sound is set to soundName
     */
    public Sound(String soundName, String soundAudio) {
        name = soundName;
        volume = DEFAULT_VOLUME;
        audio = soundAudio;
    }

    // Source: https://stackoverflow.com/questions/39085830/how-to-play-a-wav-file-using-java
    // EFFECTS: plays audio of sound using audio file
    public void playSound() {
        try {
            Clip sound = AudioSystem.getClip();
            sound.open(AudioSystem.getAudioInputStream(new File(audio)));
            sound.start();
            sound.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (IllegalArgumentException | SecurityException | LineUnavailableException e) {
            System.err.println(e.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } catch (Exception genE) {
            System.err.println(genE.getMessage());
        }
    }

    /*
     * REQUIRES: adjust is >= 0
     * MODIFIES: this
     * EFFECTS: adjust is added to volume and volume is updated;
     *          if (adjust + volume) > 100, volume is set to 100;
     * 			volume is returned;
     */
    public int increaseVolume(int adjust) {
        if ((volume + adjust) > 100) {
            volume = 100;
        } else {
            volume += adjust;
        }
        return volume;
    }

    /*
     * REQUIRES: adjust is >= 0
     * MODIFIES: this
     * EFFECTS: adjust is subtracted from volume and volume is updated;
     *          if (volume - adjust) < 0, volume is set to 0;
     * 			volume is returned
     */
    public int decreaseVolume(int adjust) {
        if ((volume - adjust) < 0) {
            volume = 0;
        } else {
            volume -= adjust;
        }
        return volume;
    }

    public int getVolume() {
        return volume;
    }

    public String getSoundName() {
        return name;
    }

    public String getSoundAudio() {
        return audio;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("volume", volume);
        json.put("name", name);
        json.put("audio", audio);
        return json;
    }
}
