package Models;

//29/9/2018 Daniel russell

public class Footwear extends Product {
  
    //private variables
    
    private int Size;

    //getters
    
    public int getSize() {
        return Size;
    }

    //setters
    
    public void setSize(int Size) {
        this.Size = Size;
    }
    
    //constructors

    public Footwear(int Size, String ProductName, double Price, int StockLevel) {
        super(ProductName, Price, StockLevel);
        this.Size = Size;
    }

    public Footwear(int Size, int ProductID, String ProductName, double Price, int StockLevel) {
        super(ProductID, ProductName, Price, StockLevel);
        this.Size = Size;
    }

}
