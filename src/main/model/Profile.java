package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import java.util.ArrayList;

// Represents a sound profile (similar to a music playlist) having a name and list of sounds
public class Profile implements Writable {
    private String name;                    // name of the profile
    private ArrayList<Sound> listOfSounds;  // list of sounds currently in the profile

    /*
     * REQUIRES: profileName has a non-zero length
     * EFFECTS: name of Profile is set to profileName and a list for sounds to go in the profile is generated
     */
    public Profile(String profileName) {
        name = profileName;
        listOfSounds = new ArrayList<>();
    }

    /*
     * REQUIRES: newName has a non-zero length
     * MODIFIES: this
     * EFFECTS: name of profile is set to newName
     */
    public void editProfileName(String newName) {
        name = newName;
    }

    /*
     * REQUIRES: specified sound is not already in list of sounds
     * MODIFIES: this
     * EFFECTS: specified sound is added to list of sounds
     */
    public String addSound(Sound s) {
        listOfSounds.add(s);
        return "Added " + s.getSoundName() + " to " + name + "!";
    }

    /*
     * REQUIRES: specified sound is already in list of sounds
     * MODIFIES: this
     * EFFECTS: specified sound is removed from list of sounds
     */
    public String removeSound(Sound s) {
        listOfSounds.remove(s);
        return "Removed " + s.getSoundName() + " from " + name + "!";
    }

    public ArrayList<Sound> getSounds() {
        return listOfSounds;
    }

    public int getSoundCount() {
        return listOfSounds.size();
    }

    public String getProfileName() {
        return name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        return json;
    }

    // EFFECTS: returns sounds in this profile as a JSON array
    private JSONArray soundsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Sound s : listOfSounds) {
            jsonArray.put(s.toJson());
        }

        return jsonArray;
    }
}
