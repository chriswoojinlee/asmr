package ui;

import model.ProfileManager;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// GUI for White Noise APP
public class WhiteNoiseGUI implements ActionListener {
    private static final String JSON_STORE = "data/profilemanager.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    ProfileManager profileManager = new ProfileManager();
    JFrame frame = new JFrame();
    JButton createNewProfileButton = new JButton("Create new profile");
    JButton viewProfilesButton = new JButton("View existing profiles");
    JButton saveProfilesButton = new JButton("Save existing profiles");
    JButton loadProfilesButton = new JButton("Load saved profiles");
    JButton deleteProfileButton = new JButton("Delete a profile");
    JButton editProfileNameButton = new JButton("Edit a profile's name");
    JButton accessProfileButton = new JButton("Access a profile");

    // MODIFIES: this
    // EFFECTS: adds various buttons onto frame and closes windows upon exit
    public WhiteNoiseGUI() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        createNewProfileButton.setBounds(50,150,200,50);
        createNewProfileButton.setFocusable(true);
        createNewProfileButton.addActionListener(this);
        viewProfilesButton.setBounds(250,150,200,50);
        viewProfilesButton.setFocusable(true);
        viewProfilesButton.addActionListener(this);
        saveProfilesButton.setBounds(50,200,200,50);
        saveProfilesButton.setFocusable(true);
        saveProfilesButton.addActionListener(this);
        loadProfilesButton.setBounds(250,200,200,50);
        loadProfilesButton.setFocusable(true);
        loadProfilesButton.addActionListener(this);
        deleteProfileButton.setBounds(250,250,200,50);
        deleteProfileButton.setFocusable(true);
        deleteProfileButton.addActionListener(this);
        editProfileNameButton.setBounds(50,250,200,50);
        editProfileNameButton.setFocusable(true);
        editProfileNameButton.addActionListener(this);
        accessProfileButton.setBounds(150,300,200,50);
        accessProfileButton.setFocusable(true);
        accessProfileButton.addActionListener(this);

        constructorPart2();
    }

    private void constructorPart2() {
        frame.add(createNewProfileButton);
        frame.add(viewProfilesButton);
        frame.add(saveProfilesButton);
        frame.add(loadProfilesButton);
        frame.add(deleteProfileButton);
        frame.add(editProfileNameButton);
        frame.add(accessProfileButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: provides conditional actions upon button press for each button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createNewProfileButton) {
            CreateProfileWindow createProfileWindow = new CreateProfileWindow(profileManager);
        } else if (e.getSource() == viewProfilesButton) {
            ViewProfilesWindow viewProfilesWindow = new ViewProfilesWindow(profileManager);
        } else if (e.getSource() == saveProfilesButton) {
            saveProfiles();
        } else if (e.getSource() == loadProfilesButton) {
            try {
                profileManager = jsonReader.read();
                System.out.println("Loaded app from " + JSON_STORE);
            } catch (IOException ex) {
                System.out.println("Unable to read from file: " + JSON_STORE);
            }
        } else if (e.getSource() == deleteProfileButton) {
            DeleteProfileWindow deleteProfileWindow = new DeleteProfileWindow(profileManager);
        } else if (e.getSource() == editProfileNameButton) {
            EditProfileNameWindow editProfileNameWindow = new EditProfileNameWindow(profileManager);
        } else if (e.getSource() == accessProfileButton) {
            AccessProfileWindow accessProfileWindow = new AccessProfileWindow(profileManager);
        }
    }

    private void saveProfiles() {
        try {
            jsonWriter.open();
            jsonWriter.write(profileManager);
            jsonWriter.close();
            System.out.println("Saved app to " + JSON_STORE);
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    public static void main(String[] args) {
        WhiteNoiseGUI whiteNoiseGUI = new WhiteNoiseGUI();
    }
}
