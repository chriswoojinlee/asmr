package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import java.util.ArrayList;

// Represents the top-level of the multiple different sound profiles in the application
public class ProfileManager implements Writable {
    private static ArrayList<Profile> listOfProfiles;  // list of profiles currently in the app

    /*
     * EFFECTS: an empty list for profiles to go in the app is generated
     */
    public ProfileManager() {
        listOfProfiles = new ArrayList<>();
    }

    /*
     * REQUIRES: the profile manager does not already contain the specified profile
     * MODIFIES: this
     * EFFECTS: specified profile is added to list of profiles
     */
    public String addProfile(Profile p) {
        listOfProfiles.add(p);
        return "Added a new profile: " + p.getProfileName() + "!";
    }

    /*
     * REQUIRES: the profile manager already contains the specified profile
     * MODIFIES: this
     * EFFECTS: specified profile is deleted from list of profiles
     */
    public String deleteProfile(Profile p) {
        listOfProfiles.remove(p);
        return "Deleted profile " + p.getProfileName() + "!";
    }

    public ArrayList<Profile> getListOfProfiles() {
        return listOfProfiles;
    }

    public int getProfileCount() {
        return listOfProfiles.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("profiles", profilesToJson());
        return json;
    }

    // EFFECTS: returns profiles in the profile manager as a JSON array
    private JSONArray profilesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Profile p : listOfProfiles) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}
