package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        Main me = new Main();
        me.doIt();
    }

    public static void doIt() throws Exception {

        LinkedList textList = new LinkedList();

        TextProcessor text = new TextProcessor("src/174.txt");

        String[] textArray = text.preProcess();

        for (String word : textArray) {
            textList.addToList(word);
        }

        String[] words = {"portrait", "persian", "dorian", "experimental", "magnetic"};

        for (String word : words) {
            System.out.println(textList.searchWordCount(word));
        }

        System.out.println(textList.getCount());
        textList.wordOver20Times();
        System.out.println(textList.findMostFreqWord());
        System.out.println(textList.findLongestWord());
        System.out.println(textList.searchPrevWord("irritating"));


    }
}
