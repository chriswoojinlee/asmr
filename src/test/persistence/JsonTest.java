package persistence;

import model.Profile;
import model.Sound;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkProfile(String name, Profile profile) {
        assertEquals(name, profile.getProfileName());
    }

    protected void checkSound(String name, Sound sound) {
        assertEquals(name, sound.getSoundName());
    }
}
