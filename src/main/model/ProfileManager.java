package model;

import exceptions.AlreadyContainsException;
import exceptions.DoesntContainException;
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
     * MODIFIES: this
     * EFFECTS: specified profile is added to list of profiles;
     *          if specified profile is already in list of profiles, throw AlreadyContainsException
     */
    public String addProfile(Profile p) throws AlreadyContainsException {
        for (Profile profile : listOfProfiles) {
            if (p.getProfileName().equals(profile.getProfileName())) {
                throw new AlreadyContainsException();
            }
        }
        listOfProfiles.add(p);
        return "Added a new profile: " + p.getProfileName() + "!";
    }

    /*
     * MODIFIES: this
     * EFFECTS: specified profile is deleted from list of profiles
     *          if specified profile doesn't exist in list of profiles, throw DoesntContainsException
     */
    public String deleteProfile(Profile p) throws DoesntContainException {
        for (Profile profile : listOfProfiles) {
            if (p.getProfileName().equals(profile.getProfileName())) {
                listOfProfiles.remove(p);
                return "Deleted profile " + p.getProfileName() + "!";
            }
        }
        throw new DoesntContainException();
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
