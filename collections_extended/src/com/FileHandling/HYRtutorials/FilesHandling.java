package com.FileHandling.HYRtutorials;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FilesHandling {
    public static void main(String[] args){
        File f = new File("./src/com/jdbc");
        try{
            System.out.println("hi");
//            if (f.exists()){
//                System.out.println(f.delete());
//                System.out.println("file is deleted!");
//
//            }else{
//                System.out.println(f.createNewFile());
//                System.out.println("file is created!");
//
//            }

//            System.out.println(f.isHidden()); ----> to check if file is hidden or not.
//            System.out.println(f.canWrite()); ----> to check if file is in readonly more or not.
//            System.out.println(f.setWritable()); ----> to change from readonly mode to read and write
//            System.out.println(f.mkdir()); ---> to create a single folder/package
//            System.out.println(f.mkdirs()); ----> to create a multiple folder/package
            System.out.println(Arrays.toString(f.list())); //---> to print all the contents in the given folder, this will only return string names
            System.out.println(Arrays.toString(f.listFiles())); //----> to print all the contents in the given folder with complete path, this will return a file instance, we can perform all the operations of file
        }
        catch (Exception IO){
            System.out.println(IO);
        }
    }
}
