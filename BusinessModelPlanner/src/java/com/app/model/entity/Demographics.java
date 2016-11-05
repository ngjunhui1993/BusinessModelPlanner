package com.app.model.entity;
/**
  * A demographic represents the particulars of a user.
  */
public class Demographics{
	
	private String name;
	private String password;
	private String email;
        private String userid;
  /**
  *The default constructor
  */
        public Demographics(){
            
        }

    public Demographics(String name, String password, String email, String userid) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }



/**
  * Gets the name of the user
  * @return name of the user
  */ 
	public String getName(){
		return name;
	}
/**
  * Gets the password of the user
  * @return password of the user
  */	
	public String getPassword(){
		return password;
	}
/**
  * Gets the email of the user
  * @return email of the user
  */	
	public String getEmail(){
		return email;
	}

  /**
  * validate the user's password.
  * @param password the user's password
  * @return true if the password is equals to the user's password , false if otherwise.
  */     
        public boolean authenticate(String password) {
            return password.equals(this.password);
        } // authenticate
	
}//end of class