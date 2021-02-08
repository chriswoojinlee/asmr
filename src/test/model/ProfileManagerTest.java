package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileManagerTest {
    ProfileManager profileManager;
    private Profile profileOne;
    private Profile profileTwo;

    @BeforeEach
    void setup() {
        profileManager = new ProfileManager();
        profileOne = new Profile("Profile 1");
        profileTwo = new Profile("Profile 2");
    }

    @Test
    void testConstructor() {
       assertEquals(0, profileManager.getProfileCount());
    }

    @Test
    void testAddProfile() {
        ArrayList<Profile> listOfProfilesOne = new ArrayList<>();
        ArrayList<Profile> listOfProfilesTwo = new ArrayList<>();
        listOfProfilesOne.add(profileOne);
        listOfProfilesTwo.add(profileOne);
        listOfProfilesTwo.add(profileTwo);

        profileManager.addProfile(profileOne);                                 // Profile 1 is added to Profile manager
        assertEquals(listOfProfilesOne, profileManager.getListOfProfiles());   // Profile manager now has Profile 1
        profileManager.addProfile(profileTwo);                                 // Profile 2 is added to Profile manager
        assertEquals(listOfProfilesTwo, profileManager.getListOfProfiles());   // Profile manager now has Profile 1 and Profile 2
    }

    @Test
    void testDeleteProfile() {
        ArrayList<Profile> listOfProfilesOne = new ArrayList<>();
        ArrayList<Profile> listOfProfilesTwo = new ArrayList<>();
        ArrayList<Profile> listOfProfilesThree = new ArrayList<>();
        listOfProfilesOne.add(profileOne);
        listOfProfilesTwo.add(profileOne);
        listOfProfilesTwo.add(profileTwo);

        profileManager.addProfile(profileOne);
        profileManager.addProfile(profileTwo);

        assertEquals(listOfProfilesTwo, profileManager.getListOfProfiles());    // Profile manager has Profile 1 and Profile 2
        profileManager.deleteProfile(profileTwo);                               // Profile 2 is deleted from Profile manager
        assertEquals(listOfProfilesOne, profileManager.getListOfProfiles());    // Profile manager has only Profile 1
        profileManager.deleteProfile(profileOne);                               // Profile 1 is deleted from Profile manager
        assertEquals(listOfProfilesThree, profileManager.getListOfProfiles());  // Profile manager has no profiles
    }

    @Test
    void testGetListOfProfiles() {
        ArrayList<Profile> listOfProfiles = new ArrayList<>();
        assertEquals(listOfProfiles, profileManager.getListOfProfiles());
    }

    @Test
    void testGetProfileCount() {
        assertEquals(0, profileManager.getProfileCount());
        profileManager.addProfile(profileOne);
        assertEquals(1, profileManager.getProfileCount());
    }
}
