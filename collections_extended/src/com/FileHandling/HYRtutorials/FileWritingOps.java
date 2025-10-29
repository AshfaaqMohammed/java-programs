package com.FileHandling.HYRtutorials;

/*
    Different ways of reading the data from text file
        1. FileOutputStream - append character by character.
        2. FileWriter - append the entire string at one time.
        3. BufferedWriter - append the entire string at one time.
 */

import java.io.*;
import java.util.Properties;

public class FileWritingOps {
    public static void main(String[] args) throws IOException {

//        FileOsOps();
//        FileWriterOps();
        String line = "srinija";
        BufferWriterOps(line);
    }


    private static void FileOsOps() throws IOException {
        File file =new File("./sampleWrite.txt");
        if (file.exists()){
            file.delete();
        }else {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        String text = "this is a string";
//        fos.write(72);
//        fos.write(69);
//        fos.write(76);
//        fos.write(76);
//        fos.write(79);
        for (char ch : text.toCharArray()){
            System.out.println(ch);
            fos.write((int) ch);
        }


        fos.close();
    }

    private static void FileWriterOps() throws IOException {
        File file =new File("./sampleWrite.txt");
        if (file.exists()){
            file.delete();
        }else {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        String text = """
                hi,
                this is sumith
                and iam from IIIt.
                """;
//        char[] charArray = text.toCharArray();
//        System.out.println(charArray.length);
        System.out.println(text);
        fw.write(text.toCharArray());

        fw.close();
    }


    private static void BufferWriterOps(String line) throws IOException {
        File file =new File("./sampleWrite.txt");
        if (file.exists()){
            file.delete();
        }else {
            file.createNewFile();
        }
        String text = """
                hi,
                this text is from 
                %s
                """.formatted(line);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(text);
//        bw.append(line);
        bw.close();
    }






}
