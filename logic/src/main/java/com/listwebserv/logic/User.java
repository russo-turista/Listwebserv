package com.listwebserv.logic;

public class User {
    private String firstname;
    private String lastname;
 
    public User() {
    }
 
    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
 
    }
 
    //Add Getter and Setter methods
   public String getLastname(){
    	return lastname;
    }
   public String getFirstname(){
   	return firstname;
   }
 
}
