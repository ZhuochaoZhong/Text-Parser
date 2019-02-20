package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TextProcessor {

    private String text;
    private String path;

    public TextProcessor(String path) throws Exception {

        this.path = path;
        this.text = new String(Files.readAllBytes(Paths.get(this.path)));

    }

    public String[] preProcess() {

        StringBuffer sb = new StringBuffer();
        String[] result;

        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)) {
                sb.append(Character.isLowerCase(c) ? c : Character.toLowerCase(c));
            }
        }

        result = sb.toString().split("\\s+");

        return result;



        //return this.text.toLowerCase().replace("\uFEFF", "").replaceAll("\\p{Punct}", "").split("\\s+");


    }

}
