package exception_handling;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Handling {

    public static void main(String[] args) throws IOException {
        int num1 = 9;
        int num2 = 0;
        int result;
        try{
            result = num1/num2;
            File file = new File("");
            FileReader fileReader = new FileReader(file);
        }catch (ArithmeticException b){
            throw new MyException("Stop dividing with 0 and check your variable");
        }
        finally{
            System.out.println("inside final.");
            System.out.println("Sumth mg.");
        }
    }
}
