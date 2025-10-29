package Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactData {

    private static String phoneData = """
            Charlie Brown, 3334445555
            Maid Marion, 1234567890
            Mickey Mouse, 9998887777
            Mickey Mouse, 1234123456
            Minnie Mouse, 5678123490
            Robin Hood, 3456789123
            Robin Hood, 12312345645
            Lucy Van Pelt, 5656564747
            Mickey Mouse, 9990001112
            """;
    private static String emailData = """
            Mickey Mouse, mckmouse@gmail.com
            Mickey Mouse, micky1@aws.com
            Minnie Mouse, minnie@verizon.net
            Robin Hood, rhood@gmail.com
            Linus Van Pelt, lvpelt2015@gmail.com
            Daffy Duck, daffy@google.com
            """;

    public static List<Contact> getData(String type){
        List<Contact> dataList = new ArrayList<>();
        Scanner scanner = new Scanner(type.equals("phone") ? phoneData : emailData);
        while (scanner.hasNext()){
            String[] data = scanner.nextLine().split(",");
            Arrays.asList(data).replaceAll(String::trim);
            if (type.equals("phone")){
                dataList.add(new Contact(data[0], Long.parseLong(data[1])));
            }else if (type.equals("email")){
                dataList.add(new Contact(data[0], data[1]));
            }
        }
        return dataList;
    }
}
