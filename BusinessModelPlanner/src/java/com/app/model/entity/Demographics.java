package com.app.model.entity;
/**
  * A demographic represents the particulars of a user.
  */
public class Demographics{
	
	private String name;
	private String password;
	private String email;
    private String userid;
    private String type;
	private String sharedSecret;
	private boolean isActivated;
  /**
  *The default constructor
  */
        public Demographics(){
            
        }

    public Demographics(String name, String password, String email, String userid, String type, String sharedSecret, boolean isActivated) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.userid = userid;
        this.type=type;
		this.sharedSecret = sharedSecret;
		this.isActivated = isActivated;
    }

    public String getUserid() {
        return userid;
    }

    public String getType() {
        return type;
    }
	
	public String getSharedSecret() {
		return sharedSecret;
		
	}
	
	public boolean getIsActivated() {
		return isActivated;
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