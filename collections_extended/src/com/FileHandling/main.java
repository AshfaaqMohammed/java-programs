package com.FileHandling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class main {
    public static void main(String[] args) {
        System.out.println("Current working directory (cwd) = " + new File("").getAbsolutePath());
        useFile("testfile.txt");
        usePath("pathfile.txt");
    }

    private static void useFile(String fileName){
        File file = new File(fileName);
        boolean fileExists = file.exists();

        System.out.printf("File '%s' %s%n",fileName, fileExists ? "exists." : "does not exist.");

        if (fileExists){
            System.out.println("Deleting File: " + fileName);
            fileExists = !file.delete();
        }

        else if (!fileExists){
            try{
                file.createNewFile();
            }catch (Exception e){
                System.out.println("Something went wrong.");
            }

            System.out.println("Created File " + fileName);
            if (file.canWrite()){
                System.out.println("Would write to file here");
            }
        }

    }


    private static void usePath(String fileName){

        Path path = Path.of(fileName);

        boolean fileExists = Files.exists(path);

        System.out.printf("File '%s' %s%n",fileName, fileExists ? "exists." : "does not exist.");

        if (fileExists){
            System.out.println("Deleting File: " + fileName);
            try{
                Files.delete(path);
                fileExists = false;
            }catch (IOException IO){
                System.out.println(IO);
            }

        }

        else if (!fileExists){
            try{
                Files.createFile(path);
                if (Files.isWritable(path)){
                    Files.writeString(path, """
                            Here is some data, for my file just to prove using the files class and path are better!
                            """);
                }
            }catch (Exception e){
                System.out.println("Something went wrong.");
            }

        }

    }
}
