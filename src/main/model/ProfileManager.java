package model;

import java.util.ArrayList;

// Represents the top-level view of the multiple different sound profiles in the application
public class ProfileManager {
    private ArrayList<Profile> listOfProfiles;  // list of profiles currently in the app

    public ProfileManager() {
        listOfProfiles = new ArrayList<>();
    }

    /*
     * MODIFIES: this
     * EFFECTS: specified profile is added to list of profiles
     */
    public String createProfile(Profile p) {
        if (!listOfProfiles.contains(p)) {
            listOfProfiles.add(p);
            return "Created a new profile: " + p.getProfileName() + "!";
        } else {
            return "Unable to create " + p.getProfileName() + ". " + p.getProfileName() + " already exists!";
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: specified profile is deleted from list of profiles
     */
    public String deleteProfile(Profile p) {
        if (listOfProfiles.contains(p)) {
            listOfProfiles.remove(p);
            return "Deleted profile " + p.getProfileName() + "!";
        } else {
            return "Unable to delete " + p.getProfileName() + ". " + p.getProfileName() + " doesn't exist!";
        }
    }

}
