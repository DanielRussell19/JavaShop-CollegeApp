package Models;


//Daniel 10/09/2018

public class Staff extends User {
    
    //private attributes
    
    private String Position;
    private double Salary;
    
    //getters and setters

    public String getPosition() {
        return Position;
    }

    public double getSalary() {
        return Salary;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }
    
        //constructors
    
    //non parameter
    
    public Staff() {
        super();
        this.Position = "Unspecified";
        this.Salary = 0.00;
    }

    //with parameters
    
    public Staff(String Username, String Password, String FirstName, String LastName, String Position, double Salary) {
        super(Username, Password, FirstName, LastName);
        this.Position = Position;
        this.Salary = Salary;
    }
    
    //other methods
    
    //generates greeting message for staff home greeting
    public String displayGreeting(){
        String greeting = "<html> Welcome " + this.getFirstName() + " " + this.getLastName() + "<br> You are logged in as Administator. </html>";
        return greeting;
    }
    
}
