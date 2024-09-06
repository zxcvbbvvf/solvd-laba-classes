package org.CharlesBorabon.Apache_Libraries;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class Main {
    public static void main(String[] args) throws Exception {
        // Generate a random string with 200 words from the sample list
        String[] sampleWords = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew"};
        Random random = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        
        for (int i = 0; i < 200; i++) {
            randomStringBuilder.append(sampleWords[random.nextInt(sampleWords.length)]).append(" ");
        }
        String randomString = randomStringBuilder.toString().trim();

        // Save random string to file
        FileUtils.writeStringToFile(new File("randomString.txt"), randomString, StandardCharsets.UTF_8);

        // Read file and calculate unique words
        Set<String> words = new HashSet<>(Arrays.asList(FileUtils.readFileToString(new File("randomString.txt"), StandardCharsets.UTF_8).split("\\s+")));

        // Save number of unique words to another file
        FileUtils.writeStringToFile(new File("uniqueWordsCount.txt"), "Number of unique words: " + words.size(), StandardCharsets.UTF_8);
    }
}