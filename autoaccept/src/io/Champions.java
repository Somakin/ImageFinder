package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Champions {

    private static HashSet<String> allChampions;
    private static List<String> allChampList;

    public Champions() throws Exception {

        String content;
        String[] line;
        allChampions = new HashSet<String>();
        

        Scanner scan = new Scanner(Paths.get("autoaccept\\src\\io\\AllChampions.txt").toFile());

        content = scan.nextLine();
        line = content.split(";");
        for (String string : line) {
            allChampions.add(string);
        }

    }

    public List<String> getAllChampions() {
        return allChampList;
    }

    public void addChamp(String champ) throws IOException {
        // check if champ ist allready there
        if (!allChampions.contains(champ)) {
            allChampions.add(champ);
            // imports
            File champions = Paths.get("autoaccept\\src\\io\\AllChampions.txt").toFile();
            champions.createNewFile();
            FileWriter fw = new FileWriter(champions);
            BufferedWriter bw = new BufferedWriter(fw);
            // logic

            allChampList = new ArrayList<>(allChampions);
            Collections.sort(allChampList);
            for (String string : allChampList) {
                bw.write(string + ";");
            }
            
            // close connections
            bw.close();
            fw.close();
        }
        else{System.out.println("nicht möglich");}
    }
}
