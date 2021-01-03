package edu.neu.csye6200.model;

public class Parent extends Person{
    private String address;
    private String phone;
    
    public Parent(){
    }
    
    public Parent(String name, String address, String phone){
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
    }
    
    public String getAddress() {
	    return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }
    
    public String getPhone(){

        return phone;
    }
    
    public void setPhone(String phone){

        this.phone = phone;
    }
    
    @Override
    public String toString(){

        return this.getName() + "," + this.getAddress() + "," + this.getPhone();
    }
    
}
