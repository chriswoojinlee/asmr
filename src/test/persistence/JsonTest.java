package persistence;

import model.Profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkProfile(String name, Profile profile) {
        assertEquals(name, profile.getProfileName());
    }
}
