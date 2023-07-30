package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account {
    private String Username;
    private String Password;
    private String Email;
    private String Name;
    private String DateOfBirth;
    private long ID;
    private timeslot slot;
    //Default constructor
    public Account(){
        Username = null;
        Password = null;
        Name = null;
        DateOfBirth = null;
        ID = 0;
    }
    //Constructor: initialize all the variables
    public Account(String theUsername, String thePassword, String theEmail, String theName, String theDate){
        Username = theUsername;
        Password = thePassword;
        Name = theName;
        DateOfBirth = theDate;
        Email = theEmail;
        ID = generateID();
        //timeslot slot = new timeslot(ID);
    }
    //Constructor for using post LOGIN
    public Account(String theUsername, String thePassword, String theEmail, String theName, String theDate, double theID){
        Username = theUsername;
        Password = thePassword;
        Name = theName;
        DateOfBirth = theDate;
        Email = theEmail;
        ID = (long) theID;
        //timeslot slot = new timeslot(ID);
    }
    public long generateID(){
        int digits = 8;
        long min = (long)Math.pow(10,digits-1);
        long max = (long)Math.pow(10,digits)-1;
        List<Long> previousNumber = new ArrayList<>();
        Random random = new Random();
        long number;
        do {
            number = random.nextInt((int) (max-min+1))+min;
        }while(previousNumber.contains(number));//generate different random numbers

        return number;
    }
    public void setUsername(String theUsername) {
        Username = theUsername;
    }
    public String getUsername(){
        return Username;
    }
    public void setPassword(String thePassword){
        Password = thePassword;
    }
    public String getPassword(){
        return Password;
    }
    public void setEmail(String theEmail){
        Email = theEmail;
    }
    public String getEmail(){
        return Email;
    }
    public void setName(String theName){
        Name = theName;
    }
    public String getName(){
        return Name;
    }
    public void setDateOfBirth(String theDate){
        DateOfBirth = theDate;
    }
    public String getDateOfBirth(){
        return DateOfBirth;
    }
    public void setID(long theID){
        ID = theID;
    }

    public long getID() {
        return ID;
    }

    public timeslot getSlot() {
        return slot;
    }

    public void setSlot(timeslot slot) {
        this.slot = slot;
    }
}
