package org.example;

public class Account {
    private String Username;
    private String Password;
    private String Name;
    private String DateOfBirth;
    private String ID;
    //Default constructor
    public Account(){
        Username = null;
        Password = null;
        Name = null;
        DateOfBirth = null;
        ID = null;
    }
    //Constructor: initialize all the variables
    public Account(String theUsername, String thePassword, String theName, String theDate, String theID){
        Username = theUsername;
        Password = thePassword;
        Name = theName;
        DateOfBirth = theDate;
        ID = theID;
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
    public void setID(String theID){
        ID = theID;
    }

    public String getID() {
        return ID;
    }
}
