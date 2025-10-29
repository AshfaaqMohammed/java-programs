package com.FileHandling.HYRtutorials;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Assignments {
    public static void main(String[] args) throws IOException {
//        getNoOfLines();
//        getLengthyLine();
//        getWordCount();
//        String s = "hi how are you";
//        List<String> list = List.of(s.split(" "));
        wordOccurrence();
    }




    private static void getNoOfLines() throws IOException {
        File file = new File("./sampleWrite.txt");
        Scanner scanner = new Scanner(file);

        int noOfLines = 0;
        while (scanner.hasNext()){
            scanner.nextLine();
            noOfLines+=1;
        }
        scanner.close();
        System.out.println(noOfLines);
    }

    private static void getLengthyLine() throws IOException{
        File file = new File("./sampleWrite.txt");
        Scanner scanner = new Scanner(file);

        int lengthyLine = 0;
        int lineIdx = 0;
        int count = 0;

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            count++;
            if (lengthyLine < line.length()){
                lengthyLine = line.length();
                lineIdx = count;
            }
        }
        System.out.printf("Line number - %d is the lengthy line which has %d characters".formatted(lineIdx,lengthyLine));

    }

    private static void getWordCount() throws IOException{
        File file = new File("./sampleWrite.txt");
        Scanner scanner = new Scanner(file);
        int wordCount = 0;

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            wordCount += line.split(" ").length;
        }
        System.out.printf("word count of the file - %d".formatted(wordCount));

    }

    private static void wordOccurrence() throws IOException{
        File file = new File("./sampleWrite.txt");
        Scanner scanner = new Scanner(file);
        Map<String,Integer> map = new HashMap<>();

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            List<String> list = List.of(line.split(" "));
            for(String word : list){
                if (!map.containsKey(word)){
                    map.put(word,1);
                }else{
                    map.put(word,map.get(word)+1);
                }
            }
        }
        System.out.println(map);
    }
}
