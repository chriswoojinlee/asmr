package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SoundTest {
    private Sound sound;

    @BeforeEach
    void setup() {
        sound = new Sound("Wind");
    }

    @Test
    void increaseVolume() {
        assertEquals(50, sound.increaseVolume(50));
        assertEquals(100, sound.increaseVolume(51));
    }

    @Test
    void decreaseVolume() {
        sound.increaseVolume(100);
        assertEquals(50, sound.decreaseVolume(50));
        assertEquals(0, sound.decreaseVolume(51));
    }
}
