package model;

import java.util.ArrayList;

// Represents a sound profile (similar to a music playlist) having a name and list of sounds
public class Profile {
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
     * MODIFIES: this
     * EFFECTS: specified sound is added to list of sounds
     */
    public String addSound(Sound s) {
        if (!listOfSounds.contains(s)) {
            listOfSounds.add(s);
            return "Added " + s.getSoundName() + " to " + name + "!";
        } else {
            return "Unable to add " + s.getSoundName() + " to " + name + "!";
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: specified sound is removed from list of sounds
     */
    public String removeSound(Sound s) {
        if (listOfSounds.contains(s)) {
            listOfSounds.remove(s);
            return "Removed " + s.getSoundName() + " from " + name + "!";
        } else {
            return "Unable to remove " + s.getSoundName() + " from " + name + "!";
        }
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
}
