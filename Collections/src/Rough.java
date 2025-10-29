import java.util.*;
public class Rough {
    public static void main(String[] args) {

        Contact newContact = new Contact("Sumith","9812345876");
        MobilePhone mp = new MobilePhone("9999999999");
        Contact newContact2 = new Contact("Sumith","9812345876");
        System.out.println(mp.addNewContact(newContact));
        System.out.println(mp.addNewContact(newContact2));
        mp.printContacts();
    }
}

class MobilePhone {
    // write code here
    private String myNumber;
    List<Contact> myContacts;

    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) == -1){
            this.myContacts.add(contact);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean updateContact(Contact con1, Contact con2){
        if (findContact(con1.getName()) == -1){
            return false;
        }
        else{
            int oldIndex = this.myContacts.indexOf(con1);
            this.myContacts.set(oldIndex,con2);
            return true;
        }
    }

    public boolean removeContact(Contact contact){
        if (findContact(contact.getName()) != -1){
            this.myContacts.remove(contact);
            return true;
        }
        else{
            return false;
        }
    }

    public int findContact(Contact contact){
        if (findContact(contact.getName()) != -1){
            return this.myContacts.indexOf(contact);
        }
        else{
            return -1;
        }
    }

    private int findContact(String name){
        for (Contact contact : this.myContacts){
            if (contact.getName().equals(name)){
                return this.myContacts.indexOf(contact);
            }
        }
        return -1;
    }

    public Contact queryContact(String name){
        for (Contact contact : this.myContacts){
            if (contact.getName().equals(name)){
                return contact;
            }
        }
        return null;
    }

    public void printContacts(){
        this.myContacts.forEach(s -> System.out.println(s));
    }

}

class Contact {
    // write code here
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return this.name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public static Contact createContact(String name, String ph){
        return new Contact(name,ph);
    }
}
