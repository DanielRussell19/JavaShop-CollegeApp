package Models;


//29/9/2018 Daniel russell

public class Orderline {
   
    //private attibutes
    
    private int OrderLineID;
    private Product product;
    int Quantity;
    double LineTotal;

    //getters
    
    public int getOrderLineID() {
        return OrderLineID;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public double getLineTotal() {
        return LineTotal;
    }

    //setters
    
    public void setOrderLineID(int OrderLineID) {
        this.OrderLineID = OrderLineID;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setLineTotal(double LineTotal) {
        this.LineTotal = LineTotal;
    }

    //constructor
    
    public Orderline(int orderlineid, Product product,int quantity, double total) {
        this.OrderLineID = orderlineid;
        this.product = product;
        this.Quantity = quantity;
        
        this.LineTotal = total;
    }
    
    public Orderline(Order order, Product product,int quantity) {
        this.OrderLineID = order.getOrderID();
        this.product = product;
        this.Quantity = quantity;
        
        this.LineTotal = product.getPrice() * this.Quantity;
    }
    
    public Orderline(Order order, Product product, int Quantity, double linetotal) {
        this.OrderLineID = order.getOrderID();
        this.product = product;
        this.Quantity = Quantity;
        
        this.LineTotal = linetotal;
    }
    
}
