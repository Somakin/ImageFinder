package io;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;



public class LoadData {

    private List<String> preferences;
    private List<String> bans;

    public LoadData() throws Exception {

        String pickpref;
        String banpref;

        String[] picksArray, bansArray;

        preferences = new ArrayList<>();
        bans = new ArrayList<>();

        Scanner scan = new Scanner(
                Champions.class.getClassLoader().getResource("io\\Preferences.txt").toURI().toURL().openStream());

        pickpref = scan.nextLine();
        banpref = scan.nextLine();
        picksArray = pickpref.split(";");
        for (String string : picksArray) {
            preferences.add(string);
        }

        bansArray = banpref.split(";");
        for (String string : bansArray) {
            bans.add(string);
        }

    }
    public List<String> getPreferences(){
        return this.preferences;
    }
    public List<String> getBans(){
        return this.bans;
    }
    
    public void chamgePref(String pref) throws IOException, URISyntaxException {

        // old data
        Scanner scan = new Scanner(
                Champions.class.getClassLoader().getResourceAsStream("io\\Preferences.txt"));
        
        String oldData = scan.nextLine().trim();
        String[] oldDataString = oldData.split(",");
        // imports
        File prefs = new File(Champions.class.getClassLoader().getResource("io\\Preferences.txt").toURI());
        prefs.createNewFile();
        FileWriter fw = new FileWriter(prefs);
        BufferedWriter bw = new BufferedWriter(fw);
        // logic

        String[] eingabe = pref.trim().split(",");

        for (String string : eingabe) {
            bw.write(string + ",");
        }
        bw.newLine();
        for (String string : oldDataString) {
            bw.write(string + ",");
        }

        // close connections
        bw.close();
        fw.close();
    }

}
