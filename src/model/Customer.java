package model;

public class Customer{
    private String id;
    private String name;
    private String address;
    private String company;
    private double salary;
    private String birthday;

    public Customer(String id,String name,String address,String company,double salary,String birthday){
        this.id = id;
        this.name = name;
        this.address=address;
        this.company=company;
        this.salary = salary;
        this.birthday=birthday;
    }

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getCompany(){
        return this.company;
    }
    public double getSalary(){
        return this.salary;
    }
    public String getBirthday(){
        return this.birthday;
    }

    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setCompany(String company){
        this.company=company;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setBirthday(String birthday){
        this.birthday=birthday;
    }

    @Override
    public String toString() {
        return id+"-"+name+"-"+address+"-"+salary;
    }
    public boolean equals(Customer customer){
        return this.id.equalsIgnoreCase(customer.id);
    }
}

