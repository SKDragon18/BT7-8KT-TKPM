/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai1;

class Address{
    private String address;
    
    private Address(String address){
        this.address=address;
    }
    public static Address createAddress(String address){
        return new Address(address);
    }
    
    public void display(){
        System.out.println("Address: "+ this.address);
    }
}

class PhoneNum{
    private String phone;
    
    private PhoneNum(String phone){
        this.phone=phone;
    }
    public static PhoneNum createPhoneNum(String phone){
        return new PhoneNum(phone);
    }
    
    public void display(){
        System.out.println("Phone number: "+ this.phone);
    }
}

class Name{
    private String name;
    
    private Name(String name){
        this.name=name;
    }
    public static Name createName(String name){
        return new Name(name);
    }
    
    public void display(){
        System.out.println("Name: "+ this.name);
    }
}

class Person{
    
    Address address;
    PhoneNum phone;
    Name name;
    
    public Person(){
        
    }
    public Person(String address, String phone, String name){
        this.address = Address.createAddress(address);
        this.phone=PhoneNum.createPhoneNum(phone);
        this.name=Name.createName(name);
    }
    public void displayPersonInfo(){
        this.name.display();
        this.address.display();
        this.phone.display();
    }
}

public class Bai1 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person person = new Person("Tran Gia Long", "TP.HCM", "0909010101");
        person.displayPersonInfo();
    }
    
}
