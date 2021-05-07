
//Daniel Russell 22/10/2018

package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DBHandler {
    
    //Constants
    
    private final String Driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    //connectionstring initalisers
    
    /*College Debugging Directory*/
    //private final String ConnectionString = "jdbc:ucanaccess://Z:\\SD-OOP\\Assessment_30232974\\data\\ShopDB.accdb";
    
    /*Personal Debugging Directory*/
    private final String ConnectionString = "jdbc:ucanaccess://E:\\Onedrive\\college year2 assesments\\OOP Assesment\\Assessment_30232974\\data\\ShopDB.accdb";
    
    
    //DataBase Methods
    
    //loads customer records
    public HashMap<String, Customer> loadCustomer(){
        
        HashMap<String,Customer> Customers = new HashMap();
        
        try{
            
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        ResultSet RS = ST.executeQuery("Select * From Customers");
        
        while(RS.next()){
            
            String username = RS.getString("Username");
            String password = RS.getString("Password");
            String firstname = RS.getString("FirstName");
            String lastname = RS.getString("LastName");
            String addressline = RS.getString("AddressLine1");
            String addressline2 = RS.getString("AddressLine2");
            String town = RS.getString("Town");
            String postcode = RS.getString("Postcode");
            
            Customer customer = new Customer(username,password,firstname,lastname,addressline,addressline2,town,postcode);
            Customers.put(username, customer);
            
        }
        
        Conn.close();
        
        }
        catch(Exception e)
        {
            
            System.out.println("Error occured: " + e);
            
        }
        finally
        {
            Customers = loadOrder(Customers);
            Customers = loadOrderLine(Customers);
            return Customers;
        }
        
    }
    
    //checks validity of customer with records
    public Customer loginCustomer(String username, String password){
                
        HashMap<String,Customer> Customers = this.loadCustomer();
        
        if(Customers.containsKey(username)){
            
            Customer CU = Customers.get(username);
            
            if(CU.getPassword().equals(password)){
                return CU;
            }
            else
            {
               return null; 
            }
            
        }
        else
        {
           return null; 
        }
        
    }
    
    //adds a customer in customers table
    
    public boolean registerCustomer(Customer Cu){
        try{
        Customer customer = Cu;
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        
        ST.executeUpdate("Insert INTO Customers(Username,Password,FirstName,LastName,AddressLine1,AddressLine2,Town,Postcode) " + "VALUES('" + customer.getUsername() + "', '" + customer.getPassword() + "', '" + customer.getFirstName() + "', '" + customer.getLastName() + "', '" + customer.getAddressLine1() + "', '" + customer.getAddressLine2() + "', '" + customer.getTown() + "', '" + customer.getPostCode() + "')");

        Conn.close();
        return true;
        }
        catch(Exception e)
        {
        return false;
        }
    }
    
    //updates details of a customer in customers table
    
    public boolean editCustomer(Customer Cu){
        try{
        Customer customer = Cu;
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        
        ST.executeUpdate("Update Customers Set Username = " + "'" + customer.getUsername() + "'" + ",Password = " + "'" + customer.getPassword() + "'" + ",FirstName = " + "'" + customer.getFirstName() + "'" + ",LastName = " + "'" + customer.getLastName() + "'" + ",AddressLine1 = " + "'" + customer.getAddressLine1() + "'" + ",AddressLine2 = " + "'" + customer.getAddressLine2() + "'" + ",Town = " + "'" + customer.getTown() + "'" + ",Postcode = " + "'" + customer.getPostCode() + "'" + "Where Username = " + "'" + customer.getUsername() + "'" + ";");

        Conn.close();
        return true;
        }
        catch(Exception e)
        {
        return false;
        }
    }
      
    //removes customer from customers table in database
        
    public boolean deleteCustomer(Customer Cu){
     try{
        Customer customer = Cu;
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        
        ST.executeUpdate("DELETE FROM Customers WHERE Username = '" + customer.getUsername() + "'");

        Conn.close();
        return true;
        }
        catch(Exception e)
        {
        return false;
        } 
        }
    
    //loads staff records from database
    public HashMap<String, Staff> loadStaff(){
        
             HashMap<String,Staff> Staffs = new HashMap();
        
        try{
            
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        ResultSet RS = ST.executeQuery("Select * From Staff");
        
        while(RS.next()){
            
            String username = RS.getString("Username");
            String password = RS.getString("Password");
            String firstname = RS.getString("FirstName");
            String lastname = RS.getString("LastName");
            String position = RS.getString("Position");
            double salary = RS.getDouble("Salary");
           
            Staff staff = new Staff(username,password,firstname,lastname,position,salary);
            Staffs.put(username, staff);
            
        }
        
        Conn.close();
        
        }
        catch(Exception e)
        {
            
            System.out.println("Error occured: " + e);
            
        }
        finally
        {
            return Staffs;
        }
        
    }
    
    //checks validity of staff with staff records
    public Staff loginStaff(String username, String password){
                
        HashMap<String,Staff> Staffs = this.loadStaff();
        
        if(Staffs.containsKey(username)){
            
            Staff ST = Staffs.get(username);
            
            if(ST.getPassword().equals(password)){
                return ST;
            }
            else
            {
               return null; 
            }
            
        }
        else
        {
           return null; 
        }
        
    }
    
    //loads products from products table
    
    public HashMap<Integer,Product> loadProducts(){
       
        HashMap<Integer,Product> Products = new HashMap();
        
        try{
            
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        ResultSet RS = ST.executeQuery("Select * From Products");
        
        while(RS.next()){
            
            int productid = RS.getInt("ProductID");
            String productname = RS.getString("ProductName");
            double cost = RS.getDouble("Price");
            int stock = RS.getInt("StockLevel");
            String measurement = RS.getString("Measurement");
            int size = RS.getInt("Size");
            
            if(measurement.isEmpty()){
                
                Footwear Foot = new Footwear(size,productid, productname, cost, stock);
                Products.put(productid, Foot);
                
            }
            else
            {
                
                Clothing Cloth = new Clothing(measurement, productid, productname, cost, stock);
                Products.put(productid, Cloth);
                
            }
            
            }
        
        Conn.close();
        
        }
        catch(Exception e)
        {
            
            System.out.println("Error occured: " + e);
            
        }
        finally
        {
            return Products;
        }
    }
    
    //adds product to products table
    
    public boolean addProduct(Product pro){
     try{
        
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        
        if(pro.getClass().getName().equals("Models.Clothing"))
        {
            
         Clothing clothing = (Clothing)pro;
         String measurement = clothing.getMeasurement();
         ST.executeUpdate("Insert INTO Products(ProductId,ProductName,Price,StockLevel,Measurement,Size) " + "VALUES('" + clothing.getProductID() + "', '" + clothing.getProductName() + "', '" + clothing.getPrice() + "', '" + clothing.getStockLevel() + "', '" + measurement + "', '" + 0 + "');");

        }
        else
        {
            
         Footwear footwear = (Footwear)pro;
         int size = footwear.getSize();
         ST.executeUpdate("Insert INTO Products(ProductId,ProductName,Price,StockLevel,Measurement,Size) " + "VALUES('" + footwear.getProductID() + "', '" + footwear.getProductName() + "', '" + footwear.getPrice() + "', '" + footwear.getStockLevel() + "', '" + "" + "', '" + size + "');");

        }
        
        Conn.close();
        return true;
        }
        catch(Exception e)
        {
        System.out.println("Error: " + e);
        return false;
        }
    }
    
    //updates details of a product in products table
    
    public boolean editProduct(Product Pro){
     try{
        
        Product product = Pro;
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        
        if(product.getClass().getName().equals("Models.Clothing"))
        {
            
         Clothing clothing = (Clothing)product;
         String measurement = clothing.getMeasurement();
         ST.executeUpdate("Update Products Set ProductName = " + "'" + clothing.getProductName() + "'" + ",Price = " + "'" + clothing.getPrice() + "'" + ",StockLevel = " + "'" + clothing.getStockLevel() + "'" + ",Measurement = " + "'" + measurement + "'" + " Where ProductId = " + "'" + clothing.getProductID() + "'" + ";");

        }
        else
        {
            
         Footwear footwear = (Footwear)product;
         int size = footwear.getSize();
         ST.executeUpdate("Update Products Set ProductName = " + "'" + footwear.getProductName() + "'" + ",Price = " + "'" + footwear.getPrice() + "'" + ",StockLevel = " + "'" + footwear.getStockLevel() + "'" + ",Size = " + "'" + size + "'" + " Where ProductId = " + "'" + footwear.getProductID() + "'" + ";");

        }
        
        Conn.close();
        return true;
        
        }
        catch(Exception e)
        {
            
        System.out.println("Error: " + e);
        return false;
        
        }
    }
    
    //deletes product from products table
    
    public boolean deleteProduct(Product Pro){
     try{
        
        Product product = Pro;
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        
        if(product.getClass().getName().equals("Models.Clothing"))
        {
            
         Clothing clothing = (Clothing)product;
         ST.executeUpdate("DELETE FROM Products WHERE ProductId = '" + clothing.getProductID() + "';");

        }
        else
        {
            
         Footwear footwear = (Footwear)product;
         ST.executeUpdate("DELETE FROM Products WHERE ProductId = '" + footwear.getProductID() + "';");

        }
        
        Conn.close();
        return true;
        
        }
        catch(Exception e)
        {
            
        System.out.println("Error: " + e);
        return false;
        
        }
    }
    
    //retrives all order instances from database to return as a customer hashmap
    
    public HashMap<String, Customer> loadOrder(HashMap<String, Customer> customers){
                
        try{
            
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        ResultSet RS = ST.executeQuery("Select * From Orders");
        
        while(RS.next()){
            
            int orderID = RS.getInt("OrderId");
            
            String stringOrderDate = RS.getString("OrderDate");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date orderDate = format.parse(stringOrderDate);
            
            String username = RS.getString("Username");
            double orderTotal = RS.getDouble("OrderTotal");
            String status = RS.getString("Status");
            
            Customer tempcustomer = customers.get(username);
            Order tempOrder = new Order(orderID,orderDate,orderTotal,status);
            
            tempcustomer.getOrders().put(orderID, tempOrder);
        }
        
        Conn.close();
        
        }
        catch(Exception e)
        {
            
            System.out.println("Error occured: " + e);
            
        }
        finally
        {
            return customers;
        }
        
    }
    
    //retrives all orderline instances relating to an orderid to return as a customer hashmap
    
    public HashMap<String, Customer> loadOrderLine(HashMap<String, Customer> customers){
            
        try{
            
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        ResultSet RS = ST.executeQuery("Select * From OrderLines");
        
        while(RS.next()){
            
            int orderlineid = RS.getInt("OrderLineId");
            int productid = RS.getInt("ProductId");
            int quantity = RS.getInt("Quantity");
            double total = RS.getDouble("LineTotal");
            int orderid = RS.getInt("OrderId");
            
            for(Map.Entry<String, Customer> customerentry : customers.entrySet())
                {
                    Customer customer = customerentry.getValue();
                    if(customer.getOrders().containsKey(orderid))
                    {
                        Order order = customer.getOrders().get(orderid);
                        
                        Product orderproduct = loadProducts().get(productid);
                        Orderline temporderline = new Orderline(orderlineid, orderproduct, quantity, total);
                        
                        order.getOrderLines().put(orderlineid, temporderline);
                    }
                }
        }
        
        Conn.close();
        
        }
        catch(Exception e)
        {
            
            System.out.println("Error occured: " + e);
            
        }
        finally
        {
            return customers;
        }
        
    }
    
    //retives all instances of Orders from database
    
    public HashMap<Integer,Order> loadAllOrders(){
        
        HashMap<Integer,Order> orders = new HashMap<Integer,Order>();
        
        try{    
            
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        ResultSet RS = ST.executeQuery("Select * From Orders");
        
        while(RS.next()){
            
            int orderID = RS.getInt("OrderId");
            
            String stringOrderDate = RS.getString("OrderDate");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date orderDate = format.parse(stringOrderDate);
            
            String username = RS.getString("Username");
            double orderTotal = RS.getDouble("OrderTotal");
            String status = RS.getString("Status");
            
            Order tempOrder = new Order(orderID,orderDate,orderTotal,status);
            
            orders.put(orderID, tempOrder);
        }
        
        Conn.close();
        
        }
        catch(Exception e)
        {
            
            System.out.println("Error occured: " + e);
            
        }
        finally
        {
            return orders;
        }
        
    }
    
    //retreaves all instances of orderlines relating to an orderid from database
    
    public HashMap<Integer,Orderline> loadAllOrderlines(int oId){
        
        HashMap<Integer,Orderline> orderlines = new HashMap<Integer,Orderline>();
        
        try{
            
        Class.forName(Driver);
        Connection Conn = DriverManager.getConnection(ConnectionString);
        Statement ST = Conn.createStatement();
        ResultSet RS = ST.executeQuery("Select * From OrderLines Where OrderId =" + oId);
        
        while(RS.next()){
            
            int orderlineid = RS.getInt("OrderLineId");
            int productid = RS.getInt("ProductId");
            int quantity = RS.getInt("Quantity");
            double total = RS.getDouble("LineTotal");
            int orderid = RS.getInt("OrderId");
            
            Product orderproduct = loadProducts().get(productid);
            Orderline temporderline = new Orderline(orderlineid, orderproduct, quantity, total);
            
            orderlines.put(orderlineid, temporderline);
            
        }
        
        Conn.close();
        
        }
        catch(Exception e)
        {
            
            System.out.println("Error occured: " + e);
            
        }
        finally
        {
            return orderlines;
        }
    }
    
    //updates instance of orderline in database
    
    public void editOrderLine(Orderline ol)
    {
        try
        {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(ConnectionString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE OrderLines SET Quantity = '" + ol.getQuantity() + "', LineTotal = '" + ol.getLineTotal() + "' WHERE OrderLineId = '" + ol.getOrderLineID()+ "'");
                                                                         
            conn.close();
            
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    //adds orderline to orderlines in database
    
     public int addOrderLine(Orderline Ol, int orderId){
        int orderLineId = 0;
        try
        {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(ConnectionString);
            Statement stmt = conn.createStatement();
                                                                        
            stmt.executeUpdate("INSERT INTO OrderLines(OrderLineId,ProductId,Quantity,LineTotal,OrderId)" + " Values('" + Ol.getOrderLineID() + "', '" + Ol.getProduct().getProductID() + "', '" + Ol.getQuantity() + "', '" + Ol.getLineTotal() + "', '" + orderId + "');");
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if (rs.next())
            {
                orderLineId = rs.getInt(1);
            }     
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
        return orderLineId;
     }
    
     //adds order to orders in database
     
     public int addOrder(Order O, String customerEmail){
        int orderId = 0;
        try
        {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(ConnectionString);
            Statement stmt = conn.createStatement();
                                                                        
            stmt.executeUpdate("INSERT INTO Orders(OrderId,OrderDate,Username,OrderTotal,Status)" + " Values('" + O.getOrderID() + "', '" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(O.getOrderDate()) + "', '" + customerEmail + "', '" + O.getOrderTotal() + "', '" + O.getStatus() + "');");
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if (rs.next())
            {
                orderId = rs.getInt(1);
            }     
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
        return orderId;
     }
     
   //updates total price of order  
     
   public void updateOrderTotal(int orderid, double total)
    {
        try
        {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(ConnectionString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Orders SET OrderTotal = '" + total + "' WHERE OrderId = '" + orderid + "'");
                                                                        
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
   
   //changes order status to complete
   
    public void completeOrder(int orderId) {
        try
        {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(ConnectionString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Orders SET Status = '" + "Complete" + "' WHERE OrderId = '" + orderId + "'");
                                                                        
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    //deletes instance of orderline from database
    public void deleteOrderLine(int orderlineid)
    {
        try
        {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(ConnectionString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM OrderLines WHERE OrderLineId = '" + orderlineid + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    //updates stocklevel of product instance in database
    public void updateStockLevel(Product pro)
    {
        try
        {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(ConnectionString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Products SET StockLevel = "+ pro.getStockLevel() +" WHERE ProductId = '" + pro.getProductID() + "'");
                                                                        
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
}
