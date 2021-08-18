package io;

public class Test {
    public static void main(String[] args) throws Exception {
        
        Champions champs = new Champions();

        champs.addChamp("AAA");
        for (String string : champs.getAllChampions()) {
            System.out.println(string);
        }
        
        }
    }

