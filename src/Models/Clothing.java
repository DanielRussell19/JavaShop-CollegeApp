package Models;


//daniel Russell 24/9/2018

public class Clothing extends Product {

    //private variables
    
    private String Measurement;

    //getters and setters
    
    public String getMeasurement() {
        return Measurement;
    }

    public void setMeasurement(String Measurement) {
        this.Measurement = Measurement;
    }

    //constructors
    
    public Clothing(String Measurement, String ProductName, double Price, int StockLevel) {
        super(ProductName, Price, StockLevel);
        this.Measurement = Measurement;
    }

    public Clothing(String Measurement, int ProductID, String ProductName, double Price, int StockLevel) {
        super(ProductID, ProductName, Price, StockLevel);
        this.Measurement = Measurement;
    }
 
}
