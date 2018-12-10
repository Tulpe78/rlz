package org.rlz.dataModel;

public class Athlet {
	
    protected int id;
    protected String lastName;
    protected String firstName;
    protected int year;
    protected String gender;
    protected int contactId;
    protected int clubId;
    
	public Athlet() {
	}
    
	public Athlet(int id) {
		this.id = id;
	}
	
    public Athlet(int id, String lastName, String firstName, int year, String gender, int contactId, int clubId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.year = year;
        this.gender = gender;
        this.contactId = contactId;
        this.clubId = clubId;
    }
     
    public Athlet(String lastName, String firstName, int year, String gender, int contactId, int clubId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.year = year;
        this.gender = gender;
        this.contactId = contactId;
        this.clubId = clubId;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public int getYear() {
        return year;
    }
 
    public void setYear(int year) {
        this.year = year;
    }
 
    public String getGender() {
        return gender;
    }
 
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public int getContactId() {
        return contactId;
    }
 
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
    
    public int getClubId() {
        return clubId;
    }
 
    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

}
