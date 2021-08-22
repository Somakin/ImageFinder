package io;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

import java.io.File;

import java.io.IOException;
import java.net.URISyntaxException;

import java.nio.file.Files;

public class LoadData {

    public List<String> getPreferences() throws IOException, URISyntaxException {

        File prefs = new File(Champions.class.getClassLoader().getResource("io\\Preferences.txt").toURI());

        return Arrays.stream(Files.readString(prefs.toPath()).split(",")).collect(Collectors.toList());
    }

    public List<String> getBans() throws IOException, URISyntaxException {
        File bans = new File(Champions.class.getClassLoader().getResource("io\\Bans.txt").toURI());

        return Arrays.stream(Files.readString(bans.toPath()).split(",")).collect(Collectors.toList());
    }

    public void chamgePref(String newprefs) throws IOException, URISyntaxException {

        File prefs = new File(Champions.class.getClassLoader().getResource("io\\Preferences.txt").toURI());
        prefs.delete();
        prefs.createNewFile();
        Files.writeString(prefs.toPath(), newprefs);
    }

}