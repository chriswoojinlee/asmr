package ui;

import model.ProfileManager;
import model.Profile;
import model.Sound;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// White noise player application
public class WhiteNoiseApp {
    private static final String JSON_STORE = "./data/profilemanager.json";
    private Scanner input;
    private ProfileManager pm = new ProfileManager();
    private final Sound rain = new Sound("Rain", "data/rain.wav");
    private final Sound wind = new Sound("Wind", "data/wind.wav");
    private final Sound thunder = new Sound("Thunder", "data/thunder.wav");
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the white noise application
    public WhiteNoiseApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runWhiteNoise();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runWhiteNoise() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        init();

        while (keepGoing) {
            mainMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("c")) {
            doCreateProfile();
        } else if (command.equals("d")) {
            doDeleteProfile();
        } else if (command.equals("a")) {
            accessProfile();
        } else if (command.equals("e")) {
            doEditProfileName();
        } else if (command.equals("k")) {
            saveProfileManager();
        } else if (command.equals("l")) {
            loadProfileManager();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes scanner
    private void init() {
        input = new Scanner(System.in);
    }

    // EFFECTS: displays menu of options to user
    private void mainMenu() {
        System.out.println("\nChoose from:");
        System.out.println("\tc -> Create a new profile");
        System.out.println("\td -> Delete a profile");
        System.out.println("\ta -> Access a profile");
        System.out.println("\te -> Edit a profile's name");
        System.out.println("\ts -> Save the current profiles");
        System.out.println("\tl -> Load the previously saved profiles");
        System.out.println("\tq -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: creates a new profile and adds it to the profile manager
    private void doCreateProfile() {
        System.out.println("Enter name for new profile");
        String name = input.next();
        Profile p = new Profile(name);
        pm.addProfile(p);
        System.out.println("A new profile named " + name + " has been created!");
    }


    // MODIFIES: this
    // EFFECTS: removes a profile from the profile manager
    private void doDeleteProfile() {
        System.out.println("\nDelete a profile by pressing the corresponding number:");

        List<String> profileNames = new ArrayList<>();
        for (Profile p : pm.getListOfProfiles()) {
            profileNames.add(p.getProfileName());
        }

        int i = 0;
        for (Profile p : pm.getListOfProfiles()) {
            System.out.println(i + ") " + profileNames.get(i));
            i++;
        }

        int profileToDelete = input.nextInt();
        System.out.println(pm.getListOfProfiles().get(profileToDelete).getProfileName() + " has been deleted!");
        pm.deleteProfile(pm.getListOfProfiles().get(profileToDelete));
    }

    // MODIFIES: this
    // EFFECTS: edits the name of a profile currently in the profile manager
    private void doEditProfileName() {
        System.out.println("\nEdit a profile's name by pressing its corresponding number:");

        int i = 0;
        for (Profile p : pm.getListOfProfiles()) {
            System.out.println(i + ") " + pm.getListOfProfiles().get(i).getProfileName());
            i++;
        }

        int selectedProfile = input.nextInt();
        String oldName = pm.getListOfProfiles().get(selectedProfile).getProfileName();
        System.out.println("\nEnter a new name for " + oldName + ":");
        String newName = input.next();
        System.out.println("The name of the profile " + oldName + " has now been changed to " + newName + "!");
        pm.getListOfProfiles().get(selectedProfile).editProfileName(newName);
    }

    // MODIFIES: this
    // EFFECTS: enters into a profile currently in the profile manager
    private void accessProfile() {
        System.out.println("\nAccess a profile by pressing the corresponding number");
        System.out.println("Or press b -> Back to main menu");

        int i = 0;
        for (Profile p : pm.getListOfProfiles()) {
            System.out.println(i + ") " + pm.getListOfProfiles().get(i).getProfileName());
            i++;
        }

        int select = input.nextInt();
        profileMenu(pm.getListOfProfiles().get(select));

        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        init();

        while (keepGoing) {
            profileMenu(pm.getListOfProfiles().get(select));
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("b")) {
                keepGoing = false;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: menu for options when inside a profile
    private void profileMenu(Profile p) {
        System.out.println("\nChoose from:");
        System.out.println("\ta -> Add a sound");
        System.out.println("\tr -> Remove a sound");
        System.out.println("\tv -> View sounds");
        System.out.println("\tp -> Play sounds");
        System.out.println("\tb -> Back to main menu");

        String command = input.next();
        if (command.equals("a")) {
            doAddSound(p);
        } else if (command.equals("r")) {
            doRemoveSound(p);
        } else if (command.equals("v")) {
            doViewSounds(p);
        } else if (command.equals("p")) {
            doPlaySound(p);
        } else if (command.equals("b")) {
            runWhiteNoise();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a sound to the current profile
    private void doAddSound(Profile p) {
        System.out.println("\nAdd a sound by pressing the corresponding number");
        System.out.println("Or press b -> Back to profile menu");

        ArrayList<Sound> availableSounds = new ArrayList<>();
        availableSounds.add(rain);
        availableSounds.add(wind);
        availableSounds.add(thunder);

        int i = 0;
        for (Sound s : availableSounds) {
            System.out.println(i + ") " + availableSounds.get(i).getSoundName());
            i++;
        }

        int soundToAdd = input.nextInt();
        String soundToAddName = availableSounds.get(soundToAdd).getSoundName();
        System.out.println("Added " + soundToAddName + " to " + p.getProfileName() + "!");
        p.addSound(availableSounds.get(soundToAdd));
    }

    // MODIFIES: this
    // EFFECTS: removes a sound from the current profile
    private void doRemoveSound(Profile p) {
        System.out.println("\nRemove a sound by pressing the corresponding number");

        int i = 0;
        for (Sound s : p.getSounds()) {
            System.out.println(i + ") " + p.getSounds().get(i).getSoundName());
            i++;
        }

        int soundToRemove = input.nextInt();
        System.out.println("Removed " + p.getSounds().get(soundToRemove) + " from " + p.getProfileName() + "!");
        p.removeSound(p.getSounds().get(soundToRemove));
    }

    // EFFECTS: view the sounds in current profile
    private void doViewSounds(Profile p) {
        int i = 0;
        for (Sound s : p.getSounds()) {
            System.out.println(i + ") " + p.getSounds().get(i).getSoundName());
            i++;
        }
    }

    // EFFECTS: play a sound in current profile
    private void doPlaySound(Profile p) {
        System.out.println("\nPlay a sound by pressing the corresponding number");

        int i = 0;
        for (Sound s : p.getSounds()) {
            System.out.println(i + ") " + p.getSounds().get(i).getSoundName());
            i++;
        }

        int soundToPlay = input.nextInt();
        Sound audio = p.getSounds().get(soundToPlay);
        audio.playSound();
    }

    // EFFECTS: saves the app to file
    private void saveProfileManager() {
        try {
            jsonWriter.open();
            jsonWriter.write(pm);
            jsonWriter.close();
            System.out.println("Saved app to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads app from file
    private void loadProfileManager() {
        try {
            pm = jsonReader.read();
            System.out.println("Loaded app from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}

