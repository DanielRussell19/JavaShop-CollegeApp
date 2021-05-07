package Models;


//29/9/2018 Daniel Russell

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;


public class Order {
    
    //private variables
    
    private int OrderID;
    private Date OrderDate;
    private double OrderTotal;
    private String Status;
    private HashMap<Integer, Orderline> OrderLines;

    //getters & setters
    
    public int getOrderID() {
        return OrderID;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public double getOrderTotal() {
        return OrderTotal;
    }

    public String getStatus() {
        return Status;
    }

    public HashMap<Integer, Orderline> getOrderLines() {
        return OrderLines;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public void setOrderTotal(double OrderTotal) {
        this.OrderTotal = OrderTotal;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setOrderLines(HashMap<Integer, Orderline> OrderLines) {
        this.OrderLines = OrderLines;
    }

    //constructors
    
    public Order() {
         this.OrderID = 00;
        this.OrderDate = new Date();
        this.OrderTotal = 0.00;
        this.Status = "not processed";
        
        this.OrderLines = new HashMap();
    }

    public Order(int OrderID, Date OrderDate, double OrderTotal, String Status) {
        this.OrderID = OrderID;
        this.OrderDate = OrderDate;
        this.OrderTotal = OrderTotal;
        this.Status = Status;
        
        this.OrderLines = new HashMap();
    }
    
    //additional methods
    
    //calculates total price of order
    
    public void calculateOrderTotal()
    {
        OrderTotal = 0;
        for(Map.Entry<Integer, Orderline> orderLineEntry : OrderLines.entrySet())
        {
            Orderline ol = orderLineEntry.getValue();
            OrderTotal = OrderTotal + ol.getLineTotal();
        }
        
        DBHandler db = new DBHandler();
        db.updateOrderTotal(OrderID, OrderTotal);
    }
    
    //adds orderline to order
    
    public void addOrderLine(Orderline ol)
    {
        DBHandler db = new DBHandler();
        int orderLineId = db.addOrderLine(ol, OrderID);
        
        OrderLines.put(orderLineId, ol);
        OrderLines.get(orderLineId).setOrderLineID(orderLineId);;
        
        calculateOrderTotal();
    }
    
    //generates unique Id to process orderline
    
    public int generateUniqueOrderLineId()
    {
        int orderLineId = 0;
        for(Map.Entry<Integer, Orderline> orderLineEntry : OrderLines.entrySet())
        {
            if(OrderLines.containsKey(orderLineId))
            {
                orderLineId++;
            }
        }
        return orderLineId;
    }
    
    //removes orderline from order
    
    public void removeOrderLine(int productid)
    {
        Iterator<Map.Entry<Integer, Orderline>> iter = OrderLines.entrySet().iterator();
        while(iter.hasNext())
        {
            Orderline actualOrderLine = iter.next().getValue();
            if(actualOrderLine.getProduct().getProductID() == productid)
            {
                int orderlineid = actualOrderLine.getOrderLineID();
                DBHandler DBH = new DBHandler();
                DBH.deleteOrderLine(orderlineid);
                
                iter.remove();
                
                OrderTotal = OrderTotal - actualOrderLine.getLineTotal();
                DBH.updateOrderTotal(OrderID, OrderTotal);
            }
        }
    }
    
    //updates stocklevel of product in order
    public void changeProductStockLevel(Product pro)
    {
    
        for(Map.Entry<Integer,Orderline> olEntry : OrderLines.entrySet())
        {
        Orderline actualOrderLine = olEntry.getValue();
        
        Product orderedProduct = actualOrderLine.getProduct();
        
         DBHandler DBH = new DBHandler();
         
         DBH.updateStockLevel(pro);;
        }
        
    }
    
    //retives products in order
    public Optional<Orderline> getProductsInBasket(int productid)
    {
        Optional<Orderline> foundorderline = Optional.empty();
        
        for(Map.Entry<Integer, Orderline> orderlineEntry : OrderLines.entrySet())
        {
            Orderline temporderline = orderlineEntry.getValue();
            Product product = temporderline.getProduct();
            
            if(product.getProductID() == productid)
            {
              foundorderline = Optional.of(temporderline);  
            }

        }
        return foundorderline;
    }
}
