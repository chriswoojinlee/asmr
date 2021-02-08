package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {
    private Profile profile;
    private Sound wind;
    private Sound rain;
    private Sound thunder;

    @BeforeEach
    void setup() {
        profile = new Profile("Profile 1");
        wind = new Sound("Wind");
        rain = new Sound("Rain");
        thunder = new Sound("Thunder");
    }

    @Test
    void testConstructor() {
        assertEquals("Profile 1", profile.getProfileName());
        assertEquals(0, profile.getSoundCount());
    }

    @Test
    void testEditProfileName() {
        profile.editProfileName("MyProfile");
        assertEquals("MyProfile", profile.getProfileName());
    }

    @Test
    void testAddSound() {
        ArrayList<Sound> listOfSounds = new ArrayList<>();
        listOfSounds.add(wind);
        listOfSounds.add(rain);

        profile.addSound(wind);
        assertEquals("Added Rain to Profile 1!", profile.addSound(rain)); // Profile 1 now contains Wind and Rain
        assertEquals(2, profile.getSoundCount());
        assertEquals(listOfSounds, profile.getSounds());
    }

    @Test
    void testRemoveSound() {
        ArrayList<Sound> listOfSounds = new ArrayList<>();
        listOfSounds.add(thunder);
        listOfSounds.add(rain);
        listOfSounds.add(wind);

        profile.addSound(thunder);
        profile.addSound(rain);
        profile.addSound(wind);                                                                    // Profile 1 contains Thunder, Rain, and Wind

        assertEquals("Removed Rain from Profile 1!", profile.removeSound(rain));          // Removed Rain from Profile 1
        listOfSounds.remove(rain);

        assertEquals(2, profile.getSoundCount());                                         // Profile 1 contains Thunder and Wind
        assertEquals(listOfSounds, profile.getSounds());
    }

    @Test
    void testGetters() {
        ArrayList<Sound> listOfSounds = new ArrayList<>();

        assertEquals(listOfSounds, profile.getSounds());
        assertEquals(0, profile.getSoundCount());
        assertEquals("Profile 1", profile.getProfileName());
    }
}