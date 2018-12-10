package org.rlz.dataModel;

public class UserAccount {
	 
	   public static final String GENDER_MALE ="M";
	   public static final String GENDER_FEMALE = "F";
	   public static String userNameStat = "";
	    
	   private String userName;
	   private String gender;
	   private String password;
	    
	 
	   public UserAccount() {
	        
	   }
	    
	   public String getUserName() {
	       return userName;
	   }
	   	 
	   public void setUserName(String userName) {
	       this.userName = userName;
	   }
	   
	   public static String getUserNameStat() {
	       return userNameStat;
	   }
	   
	   public void setUserNameStat(String userName) {
	       UserAccount.userNameStat = userName;
	   }
	 
	   public String getGender() {
	       return gender;
	   }
	 
	   public void setGender(String gender) {
	       this.gender = gender;
	   }
	 
	   public String getPassword() {
	       return password;
	   }
	 
	   public void setPassword(String password) {
	       this.password = password;
	   }
	 
	}