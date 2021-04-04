package persistence;

import model.Profile;
import model.ProfileManager;
import model.Sound;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Source: JsonSerializationDemo from CPSC 210
// Represents a reader that reads ProfileManager from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads profile manager from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ProfileManager read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseProfileManager(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses profile manager from JSON object and returns it
    private ProfileManager parseProfileManager(JSONObject jsonObject) {
        ProfileManager pm = new ProfileManager();;
        addProfiles(pm, jsonObject);
        return pm;
    }

    // MODIFIES: pm
    // EFFECTS: parses profiles from JSON object and adds them to profile manager
    private void addProfiles(ProfileManager pm, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("profiles");
        for (Object json : jsonArray) {
            JSONObject nextProfile = (JSONObject) json;
            addProfile(pm, nextProfile);
        }
    }

    // MODIFIES: pm
    // EFFECTS: parses profile from JSON object and adds it to profile manager;
    //          parses profile's list of sounds and adds each sound to profile
    private void addProfile(ProfileManager pm, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        JSONArray sounds = jsonObject.getJSONArray("sounds");
        Profile profile = new Profile(name);
        pm.getListOfProfiles().add(profile);
        for (Object json: sounds) {
            JSONObject nextSound = (JSONObject) json;
            addSound(profile, nextSound);
        }

    }

    // MODIFIES: p
    // EFFECTS: parses sound from JSON object and adds it to given profile
    private void addSound(Profile p, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String audio = jsonObject.getString("audio");
        Sound s = new Sound(name, audio);
        p.addSound(s);
    }
}