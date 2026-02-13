/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected String licensePlate;
    protected String color;
    protected double pricePerday;
    protected boolean available;
    

    Vehicle(String brand, String model, String licensePlate, String color, double pricePerday){
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.color = color;
        this.pricePerday = pricePerday;
        available = true;
    }
    
    String getbrand(){
        return this.brand;
    }
    
    String getmodel(){
        return this.model;
    }
    
    String getlicenseplate(){
        return this.licensePlate;
    }
    
    String getcolor(){
        return this.color;
    }
    
    double getpriceperday(){
        return this.pricePerday;
    }
 
    void setAvilable(boolean avilablity) {
        this.available = avilablity;
    }
    boolean isAvilable(){
        return this.available;
    }
    abstract void displayInfo();
    
}


class Car extends Vehicle{
    
    private String transmission;
    private int numbrtOfSeates;
    private int numberOfDoors;
    private String fuelType;
    
    Car(String transmission, int numbrtOfSeates,int numberOfDoors, String fuelType,
        String brand, String model, String licensePlate, String color, double pricePerday){
    
        super(brand, model, licensePlate, color, pricePerday);
        this.transmission = transmission;
        this.numbrtOfSeates = numbrtOfSeates;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }
    
    String gettransmission(){
        return this.transmission;
    }
    int getnumbrtOfSeates(){
        return this.numbrtOfSeates;
        
    }
    int getnumberOfDoors(){
        return this.numberOfDoors;
    }
    String getfuelType(){
        return this.fuelType;
    }
        
    @Override
    void displayInfo(){
        System.out.println("\n"+this.brand+("[")+this.model+("]\n"));
        System.out.println("\tFule Type: "+this.fuelType);
        System.out.println("\tTransmission: "+this.transmission);
        System.out.println("\tColor: "+this.color);
        System.out.println("\tNumber of Doors: "+this.numberOfDoors);
        System.out.println("\tNumber of Seates: "+this.numbrtOfSeates);
        System.out.println("\tLicense Plate: "+this.licensePlate);
        System.out.println("\t\t=======================");
        System.out.println("\t\t\t"+this.pricePerday+"birr/day");
        System.out.println("\t\t=======================");   
    }
}

class Motorcycle extends Vehicle {
    private int enginCapacity;
    private double fuleCapacity;
    private String bikeType;
    
    Motorcycle (int enginCapacity, double fuleCapacity,String bikeType,
        String brand, String model, String licensePlate, String color, double pricePerday){
    
        super(brand, model, licensePlate, color, pricePerday);
        this.enginCapacity = enginCapacity;
        this.fuleCapacity = fuleCapacity;
        this.bikeType= bikeType;

    }
    
    int getenginCapacity(){
        return this.enginCapacity;
    }
    
    double fuleCapacity(){
        return this.fuleCapacity;
    }
    
    String getbikeType(){
        return this.bikeType;
    }
        
    @Override
    void displayInfo(){
        System.out.println("\n"+this.brand+("[")+this.model+("]\n"));
        System.out.println("\tenginCapacity: "+this.enginCapacity);
        System.out.println("\tfuleCapacity: "+this.fuleCapacity+" Litter");
        System.out.println("\tColor: "+this.color);
        System.out.println("\tLicense Plate: "+this.licensePlate);
        System.out.println("\t\t=======================");
        System.out.println("\t\t\t"+this.pricePerday+"birr/day");
        System.out.println("\t\t=======================");
        
    }
}