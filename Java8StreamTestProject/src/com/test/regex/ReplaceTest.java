package com.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTest {
    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();

        String test = "배를 먹습니다. <br />사과를 먹습니다. 배를 먹습니다. <br />사과를 먹습니다";
        Pattern pattern = Pattern.compile("<[^<>]*>");
        // Matcher matcher = pattern.matcher("배를 먹습니다. <br />사과를 먹습니다");
        Matcher matcher = pattern.matcher(test);

        boolean found = false;
        while(matcher.find()) {
            sb.append("text \"")
                .append(matcher.group())
                .append("\"를 찾았습니다. \n")
                .append("index ")
                .append(matcher.start())
                .append("에서 시작, ")
                .append(matcher.end())
                .append("에서 끝 \n");
            found = true;
        }

        if (!found) {
            sb.append("Not founded! ");
        }
        System.out.println(sb.toString());
    }
}