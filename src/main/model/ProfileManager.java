package model;

import java.util.ArrayList;

// Represents the top-level of the multiple different sound profiles in the application
public class ProfileManager {
    private static ArrayList<Profile> listOfProfiles;  // list of profiles currently in the app

    /*
     * EFFECTS: an empty list for profiles to go in the app is generated
     */
    public ProfileManager() {
        listOfProfiles = new ArrayList<>();
    }

    /*
     * MODIFIES: this
     * EFFECTS: specified profile is added to list of profiles
     */
    public String addProfile(Profile p) {
        if (!listOfProfiles.contains(p)) {
            listOfProfiles.add(p);
            return "Added a new profile: " + p.getProfileName() + "!";
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

    public ArrayList<Profile> getListOfProfiles() {
        return listOfProfiles;
    }

    public int getProfileCount() {
        return listOfProfiles.size();
    }

}
