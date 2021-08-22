package io;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

import java.io.File;

import java.io.IOException;
import java.net.URISyntaxException;

import java.nio.file.Files;

public class LoadData {

    String preferences;
    String bans;

    public LoadData() throws Exception {

        File prefs = new File(Champions.class.getClassLoader().getResource("io\\Preferences.txt").toURI());
        File bans = new File(Champions.class.getClassLoader().getResource("io\\Bans.txt").toURI());

        this.preferences = Files.readString(prefs.toPath());
        this.bans = Files.readString(bans.toPath());

    }

    public List<String> getPreferences() {
        return Arrays.stream(preferences.split(",")).collect(Collectors.toList());
    }

    public List<String> getBans() {
        return Arrays.stream(bans.split(",")).collect(Collectors.toList());
    }

    public void chamgePref(String newprefs) throws IOException, URISyntaxException {

        File prefs = new File(Champions.class.getClassLoader().getResource("io\\Preferences.txt").toURI());
        prefs.delete();
        prefs.createNewFile();
        Files.writeString(prefs.toPath(), newprefs);
        


    }

}
