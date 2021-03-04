package persistence;

import model.Profile;
import model.ProfileManager;
import model.Sound;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Source: JsonSerializationDemo from CPSC 210
class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            ProfileManager pm = new ProfileManager();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyProfileManager() {
        try {
            ProfileManager pm = new ProfileManager();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyProfileManager.json");
            writer.open();
            writer.write(pm);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyProfileManager.json");
            pm = reader.read();
            assertEquals(0, pm.getProfileCount());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralProfileManager() {
        try {
            ProfileManager pm = new ProfileManager();
            pm.addProfile(new Profile("Profile1"));
            pm.addProfile(new Profile("Profile2"));
            pm.getListOfProfiles().get(0).addSound(new Sound("wind", "/wind.wav"));
            pm.getListOfProfiles().get(0).addSound(new Sound("rain", "/rain.wav"));
            pm.getListOfProfiles().get(1).addSound(new Sound("wind", "/wind.wav"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralProfileManager.json");
            writer.open();
            writer.write(pm);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralProfileManager.json");
            pm = reader.read();
            List<Profile> profiles = pm.getListOfProfiles();
            assertEquals(2, profiles.size());
            checkProfile("Profile1", profiles.get(0));
            checkProfile("Profile2", profiles.get(1));
            checkSound("wind",  profiles.get(0).getSounds().get(0));
            checkSound("rain",  profiles.get(0).getSounds().get(1));
            checkSound("wind",  profiles.get(1).getSounds().get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}