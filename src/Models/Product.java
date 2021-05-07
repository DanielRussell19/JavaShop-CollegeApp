package Models;


//written by Daniel
//03/09/2018

public class Product {
    
    //Private Attributes
    
    private int ProductID;
    private String ProductName;
    private double Price;
    private int StockLevel;

    //Getters and Setters
    
    public int getProductID() {return ProductID;}

    public String getProductName() {return ProductName;}

    public double getPrice() {return Price;}

    public int getStockLevel() {return StockLevel;}

    public void setProductID(int ProductID) {this.ProductID = ProductID;}

    public void setProductName(String ProductName) {this.ProductName = ProductName;}

    public void setPrice(double Price) {this.Price = Price;}

    public void setStockLevel(int StockLevel) {this.StockLevel = StockLevel;}
    
       //Constructors
    
    //No Parameter
    
    public Product() {
        this.ProductID = 0;
        this.ProductName = "Unknown";
        this.Price = 0.00;
        this.StockLevel = 0;
    }

    //Without ID
    public Product(String ProductName, double Price, int StockLevel) {
        this.ProductName = ProductName;
        this.Price = Price;
        this.StockLevel = StockLevel;
    }
    
    public Product(int ProductID, int newstock)
    {
        this.ProductID = ProductID;
        this.StockLevel = StockLevel + newstock;
    }

    //All Parameters
    public Product(int ProductID, String ProductName, double Price, int StockLevel) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Price = Price;
        this.StockLevel = StockLevel;
    }
    
    //Additonal Methods
    
    
    //Overrides
    @Override
    public String toString()
    {
        String output = ProductName;
        return output;
    }
}
