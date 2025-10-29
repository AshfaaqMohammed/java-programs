package com.FileHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class PathListing {
    public static void main(String[] args) {

        Path path = Path.of("files/pathfile.txt");
//        printPathInfo(path);
//        logStatement(path);
        extraInfo(path);
    }
    private static void printPathInfo(Path path){
        System.out.println("Path: " + path);
        System.out.println("fileName = " + path.getFileName());
        System.out.println("Parent - " + path.getParent());
        Path absoultePath = path.toAbsolutePath();
        System.out.println("Absolute path = "+ absoultePath);
        System.out.println("Absolute Path root : " + absoultePath.getRoot());
        System.out.println("isAbsolute = " + path.isAbsolute());

        int pathParts = absoultePath.getNameCount();
        for(int i=0; i<pathParts;i++){
            System.out.println(".".repeat(i+1) + " " + absoultePath.getName(i));
        }

        System.out.println("-".repeat(25));

    }
    private static void logStatement(Path path){

        try{
            Path parent = path.getParent();
            if (!Files.exists(parent)){
                Files.createDirectory(parent);
            }
            Files.writeString(
                    path,
                    Instant.now() + ": hello file world\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND
            );
        }catch (IOException IO){
            IO.printStackTrace();
        }
    }

    private static void extraInfo(Path path){
        try {
            var atts = Files.readAttributes(path,"*");
            atts.entrySet().forEach(System.out::println);
            System.out.println(Files.probeContentType(path));
        }catch (IOException IO){
            System.out.println("Problem getting attributes");
        }

    }
}
