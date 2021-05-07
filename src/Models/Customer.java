package Models;

import java.util.HashMap;
import java.util.Map;


//Daniel 10/09/2018

public class Customer extends User{

//Private Attributes    

private HashMap<Integer, Order> Orders;  

private String AddressLine1;
private String AddressLine2;
private String Town;
private String PostCode;
private boolean isRegistered;

//getters and setters    
    
    public String getAddressLine1() {
        return AddressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public String getTown() {
        return Town;
    }

    public String getPostCode() {
        return PostCode;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public HashMap<Integer, Order> getOrders() {
        return Orders;
    }

    public void setOrders(HashMap<Integer, Order> Orders) {
        this.Orders = Orders;
    }

    public void setAddressLine1(String AddressLine1) {
        this.AddressLine1 = AddressLine1;
    }

    public void setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
    }

    public void setTown(String Town) {
        this.Town = Town;
    }

    public void setPostCode(String PostCode) {
        this.PostCode = PostCode;
    }

    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
    
//Constructors

//Non parameter

    public Customer() {
        super();
        this.AddressLine1 = "Unspecified";
        this.AddressLine2 = "Unspecified";
        this.PostCode = "Unspecifed";
        this.Town = "Unspecifed";
        this.isRegistered = false;
        this.Orders = new HashMap();
    }

//parameter
    
    public Customer(String Username, String Password, String FirstName, String LastName,String AddressLine1, String AddressLine2, String Town, String PostCode) {
        super(Username,Password,FirstName,LastName);
        this.AddressLine1 = AddressLine1;
        this.AddressLine2 = AddressLine2;
        this.Town = Town;
        this.PostCode = PostCode;
        this.isRegistered = true;
        this.Orders = new HashMap();
    }
    
//Other methods
    
    //generates greeting message according to which customer is logged in
    
    public String displayGreeting(){
        String Greeting = "<html> Welcome " + this.getFirstName() + " " + this.getLastName() + "<br> You are logged as Customer. </html>";
        return Greeting;
    }
    
    //generates a unique id to process a new order
    
    public int generateUniqueOrderId()
    {
        int orderId = 0;
        for(Map.Entry<Integer, Order> orderEntry : Orders.entrySet())
        {
            if(Orders.containsKey(orderId))
            {
                orderId++;
            }
        }
        return orderId;
    }
    
    //adds new passed order to hashmap orders
    
    public void addOrder(Order o)
    {
        DBHandler db = new DBHandler();
        int orderId = db.addOrder(o, this.getUsername());
        
        Orders.put(orderId, o);
        Orders.get(orderId).setOrderID(orderId);
    }
    
    //finds previous order made by currently logged in user
    
    public Order findLatestOrder()
    {
        Order previousOrder = new Order();
        
        if(Orders.isEmpty())
        {
            addOrder(previousOrder);
        }
        else
        {
            previousOrder = Orders.entrySet().iterator().next().getValue();

            for(Map.Entry<Integer, Order> oEntry : Orders.entrySet())
            {
                Order foundOrder = oEntry.getValue();
                
                if(foundOrder.getOrderDate().after(previousOrder.getOrderDate())){
                    previousOrder = foundOrder;
                }
            }
            
            if(previousOrder.getStatus().equals("Complete")){
                previousOrder = new Order();
                addOrder(previousOrder);
            }
        }
        return previousOrder;
    }
}
