package db;

import model.CustomerList;

public class DBConnection{
    private CustomerList customerList;
    private static DBConnection dbConnection;
    private DBConnection(){
        customerList=new CustomerList();
    }
    public static DBConnection getInstance(){
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }
    public CustomerList getCustomerList(){
        return customerList;
    }
}
