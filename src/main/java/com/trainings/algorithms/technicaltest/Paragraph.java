package com.trainings.algorithms.technicaltest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph {
    public static String changeFormat(String paragraph) {

        Pattern pattern = Pattern.compile("(.*((\\d{3})-(\\d{2})-(\\d{4})))+");

        Matcher matcher = pattern.matcher(paragraph);
        if (matcher.find()) {
            String policyNumber = matcher.group(2);

            String part1 = matcher.group(3);
            String part2 = matcher.group(4);
            String part3 = matcher.group(5);

            return paragraph.replace(policyNumber, part1 + "/" + part3 + "/" + part2);
        }

        return paragraph;
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        System.out.println(changeFormat("Please quote your policy number: 112-39-8552.Please quote your policy number: 113-39-8552."));
    }
}