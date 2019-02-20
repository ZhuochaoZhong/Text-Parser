package com.company;

public class LinkedList {


    private Node head;
    private int count;

    public LinkedList() {
        head = null;
        count = 0;
    }

    public void addToList(String word) {

        Node n = searchForWord(word);

        if (n != null) {
            n.setWordCount(n.getWordCount() + 1);
        } else {
            Node newWord = new Node();
            newWord.setWord(word);
            newWord.setWordCount(1);
            newWord.setNext(head);

            this.head = newWord;
            count++;
        }
    }

    public Node searchForWord(String word) {

        Node temp = head;

        while (temp != null) {
            if (temp.getWord().equals(word)) {
                return temp;
            } else {
                temp = temp.getNext();
            }
        }
        return null;
    }

    public String searchPrevWord(String word) {

        Node prev = null;
        Node temp = head;

        while (temp != null) {
            if (temp.getWord().equals(word)) {
                if (prev != null) {
                    return "The word before " + word + " is <" + prev.getWord() + ">";
                }
            }
            prev = temp;
            temp = temp.getNext();
        }
        return "Can not find word " + word + " in text";
    }

    public String searchWordCount(String word) {
        int count = 0;

        Node searchWord = searchForWord(word);

        if (searchWord != null) {
            count = searchWord.getWordCount();
        }

        return "Word <" + word + "> appears " + count + " times in the text";
    }

    public void wordOver20Times() {

        StringBuffer sb = new StringBuffer();

        String rtn = "Words occur more than 20 times are: \n";

        int countOver20 = 0;

        if (head == null) {
            System.out.println("Empty");
        }

        Node temp = head;

        while (temp != null) {
            if (temp.getWordCount() > 20) {
                sb.append(temp.getWord()).append("(").append(temp.getWordCount()).append(" times)\n");
                countOver20++;
            }
            temp = temp.getNext();
        }
        System.out.println(rtn + "There are " + countOver20 + " words over 20 times:\n" + sb.toString());
    }

    public String findMostFreqWord() {

        int max = 0;
        String mostFreqWord = "";

        Node temp = head;

        while (temp != null) {
            if (temp.getWordCount() > max) {
                max = temp.getWordCount();
                mostFreqWord = temp.getWord();
            }
            temp = temp.getNext();
        }
        return "Most frequently occurs word is: " + mostFreqWord + " (" + max + " times)";
    }

    public String findLongestWord() {

        int max = 0;
        String longestWord = "";

        Node temp = head;

        while (temp != null) {
            if (temp.getWord().length() > max) {
                max = temp.getWord().length();
                longestWord = temp.getWord();
            }
            temp = temp.getNext();
        }
        return "Longest word in the book is: " + longestWord;
    }

//    public String toString() {
//
//        String rtn = "";
//
//        if (head == null) {
//            return "<Empty List>";
//        }
//
//        Node temp = head;
//
//        while (temp != null) {
//            rtn += "<" + temp.getWord() + " - count:" + temp.getWordCount() + "> ";
//            temp = temp.getNext();
//            if (temp != null) {
//                rtn += "-> ";
//            } else {
//                rtn += "-> null";
//            }
//        }
//        return rtn;
//    }

    public String toString() {

        String rtn = "";

        if (head == null) {
            return "<Empty List>";
        }

        Node temp = head;

        while (temp != null) {
            rtn += temp.getWord() + "\n";
            temp = temp.getNext();
        }
        return rtn;
    }

    public String getCount() {
        return "There are " + count + " entries in the Linked List";
    }
}
