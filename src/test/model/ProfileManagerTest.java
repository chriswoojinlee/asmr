package model;

import exceptions.AlreadyContainsException;
import exceptions.DoesntContainException;
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
    void testAddProfileNoIssues() {
        ArrayList<Profile> listOfProfilesOne = new ArrayList<>();
        listOfProfilesOne.add(profileOne);

        try {
            profileManager.addProfile(profileOne);
            assertEquals(listOfProfilesOne, profileManager.getListOfProfiles());
        } catch(AlreadyContainsException e) {
            fail("Unexpected AlreadyContainsException");
        }
    }

    @Test
    void testAddProfileAlreadyHasProfile() {
        try {
            profileManager.addProfile(profileOne);
            profileManager.addProfile(profileOne);
            fail("Expected AlreadyContainsException");
        } catch(AlreadyContainsException e) {
            // expected
        }
    }

    @Test
    void testDeleteProfileNoIssues() {
        ArrayList<Profile> listOfProfiles = new ArrayList<>();

        try {
            profileManager.addProfile(profileOne);
            profileManager.deleteProfile(profileOne);
            assertEquals(listOfProfiles, profileManager.getListOfProfiles());
        } catch(DoesntContainException e) {
            fail("Unexpected DoesntContainException");
        } catch(AlreadyContainsException e) {
            fail("Unexpected AlreadyContainsException");
        }

    }

    @Test
    void testDeleteProfileNoProfile() {
        try {
            profileManager.deleteProfile(profileOne);
            fail("Expected DoesntContainException");
        } catch(DoesntContainException e) {
            // expected
        }
    }

    @Test
    void testGetListOfProfiles() {
        ArrayList<Profile> listOfProfiles = new ArrayList<>();
        assertEquals(listOfProfiles, profileManager.getListOfProfiles());
    }

    @Test
    void testGetProfileCount() {
        try {
            assertEquals(0, profileManager.getProfileCount());
            profileManager.addProfile(profileOne);
            assertEquals(1, profileManager.getProfileCount());
        } catch (AlreadyContainsException e) {
            fail("Unexpected AlreadyContainsException");
        }

    }
}
