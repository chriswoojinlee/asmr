package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SoundTest {
    private Sound sound;

    @BeforeEach
    void setup() {
        sound = new Sound("Wind", "./data/wind.wav");
    }

    @Test
    void testConstructor() {
        assertEquals("Wind", sound.getSoundName());
        assertEquals(0, sound.getVolume());
    }

    @Test
    void testIncreaseVolume() {
        assertEquals(50, sound.increaseVolume(50));
        assertEquals(100, sound.increaseVolume(51));
    }

    @Test
    void testDecreaseVolume() {
        sound.increaseVolume(100);
        assertEquals(50, sound.decreaseVolume(50));
        assertEquals(0, sound.decreaseVolume(51));
    }

    @Test
    void testPlaySound() {
        sound.playSound();
    }

    @Test void testPlaySoundWrongPath() {
       Sound windSound = new Sound("Wind", "data/wind.wa");
       windSound.playSound();
    }

    @Test
    void testGetters() {
        assertEquals(0, sound.getVolume());
        assertEquals("Wind", sound.getSoundName());
        assertEquals("./data/wind.wav", sound.getSoundAudio());
    }
}
