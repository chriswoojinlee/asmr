package persistence;

import model.Profile;
import model.ProfileManager;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ProfileManager pm = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyProfileManager() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyProfileManager.json");
        try {
            ProfileManager pm = reader.read();
            assertEquals(0, pm.getProfileCount());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralProfileManager() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralProfileManager.json");
        try {
            ProfileManager pm = reader.read();
            List<Profile> profiles = pm.getListOfProfiles();
            assertEquals(2, profiles.size());
            checkProfile("Profile1", profiles.get(0));
            checkProfile("Profile2", profiles.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}