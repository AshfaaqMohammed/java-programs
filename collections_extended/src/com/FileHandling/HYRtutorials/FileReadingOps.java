package com.FileHandling.HYRtutorials;

import java.io.*;
import java.util.Scanner;

/*
    Different ways of reading the data from text file
        1. FileInputStream - uses asciiCode
        2. Scanner - iterate using line
        3. FileReader - uses asciiCode
        4. BufferedReader - iterate using line
 */

public class FileReadingOps {
    public static void main(String[] args) throws IOException {


//        FileIS();
//        ScannerOps();
//        FileReaderOps();
        BufferReader();

    }
    private static void FileIS(){
        File file = new File("./sample.txt");

        try{
            if (!file.exists()){
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream(file);

            int asciiCode;
            String text = "";
            while((asciiCode = fis.read()) != -1){
                text += (char) asciiCode;
                System.out.print((char)asciiCode);
            }
            System.out.println();
            System.out.println(text);
            fis.close();

        }catch (IOException IO){

            System.out.println("Io exception has occurred.");
        }
    }


    private static void ScannerOps(){
        File file = new File("./sample.txt");

        try{
            if (!file.exists()){
                file.createNewFile();
            }
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
            scanner.close();

        }catch (IOException IO){
            System.out.println("Io exception has occurred.");
        }
    }

    private static void FileReaderOps(){
        File file = new File("./sample.txt");

        try{
            if (!file.exists()){
                file.createNewFile();
            }
            FileReader fr = new FileReader(file);

            int asciiCode;
            while ((asciiCode = fr.read()) != -1){
                System.out.print((char) asciiCode);
            }
            System.out.println();
            fr.close();

        }catch (IOException IO){
            System.out.println("Io exception has occurred.");
        }
    }


    private static void BufferReader() throws IOException{
        File file = new File("./sample.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String text = "";
        String line = "";

        while((line = br.readLine()) != null){
            text += line + "\n";
        }
        System.out.println(text.length());
        System.out.println(text);
        fileReader.close();
        br.close();
    }
}
