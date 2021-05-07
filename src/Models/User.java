package Models;


//written by Daniel
//03/09/2018

public class User {
    
    //Private Attributes
    
    private String Username;
    private String Password;
    private String FirstName;
    private String LastName;

    //Getters and Setters
    
    public String getUsername() {return Username;}

    public String getPassword() {return Password;}

    public String getFirstName() {return FirstName;}

    public String getLastName() {return LastName;}

    public void setUsername(String Username) {this.Username = Username;}

    public void setPassword(String Password) {this.Password = Password;}

    public void setFirstName(String FirstName) {this.FirstName = FirstName;}

    public void setLastName(String LastName) {this.LastName = LastName;}
    
        //Constructors
    
    //Non parameter
    public User() {
        this.Username = "Unknown";
        this.Password = "Undefined";
        this.FirstName = "Unknown";
        this.LastName = "Unknown";
    }

    //All parameters
    public User(String Username, String Password, String FirstName, String LastName) {
        this.Username = Username;
        this.Password = Password;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }
    
    //Additional methods
    
}
