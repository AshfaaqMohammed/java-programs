package com.jdbc.JDBCchallenges;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ReadCSV {
    public static void main(String[] args) throws IOException {
//        File currentDir = new File("./src/com");
//        String[] files = currentDir.list();
//
//        System.out.println(Arrays.toString(files));
        List<String> records = Files.readAllLines(Path.of("NewAlbums.csv"));
        for (String record : records){
            System.out.println(record);
            String[] columns = record.split(",");
            System.out.println(Arrays.toString(columns));
        }

    }
}
