package io;

public class Test {
    public static void main(String[] args) throws Exception {

        LoadData load = new LoadData();

        load.chamgePref("a,b,c");

        System.out.println(load.getPreferences());
        System.out.println(load.getBans());

    }
}
