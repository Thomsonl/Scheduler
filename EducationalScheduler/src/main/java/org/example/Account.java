package org.example;

public class Account {
    private String Username;
    private String Password;
    private String Email;
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
    public Account(String theUsername, String thePassword, String theEmail, String theName, String theDate){
        Username = theUsername;
        Password = thePassword;
        Name = theName;
        DateOfBirth = theDate;
        Email = theEmail;
        ID = null; //TODO: Create function to make a random int (8 digits)
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
    public void setID(String theID){
        ID = theID;
    }

    public String getID() {
        return ID;
    }
}
