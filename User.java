/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;

/**
 * @author user
 */
public class User {
    private final String username;
    private final String password;
    private boolean status = false;//true-> login, false ->logout
    
    User(String username, String password){
        this.username = username;
        this.password = password;
    }
    String getUserName(){
        return this.username;
    }
    int login(String username, String password){
        if (this.username.equals(username))
            if(this.password.equals(password)){
                this.status = true;  
                return 0;
            } else
                return 1;
        else
            
            return -1;
    }
    
    int logout(){
        this.status = false;
        return -1;
    }
}

class Customer extends User {
    private final String name;
    private final String email;
    private final String phone;
    private String licenseNumber;
    private final String address;
    private List<Rent> rentedVehicles = new ArrayList<>();
    
    Customer(String name, String email,String Phone, String licenseNumber,
            String address, String username, String password){
        
        super(username, password);
        this.name = name;
        this.email = email;
        this.phone = Phone;
        this.licenseNumber = licenseNumber;
        this.address = address;
    }
    
    void setRentedVehicles(Rent rent){
        this.rentedVehicles.add(rent);
    }
    
    String getname(){
        return this.name;
    }
    String getphone(){
        return this.phone;
    }
    String getemail(){
        return this.email;
    }
    String getlicenseNumber(){
        return this.licenseNumber;
    }
    String getaddress(){
        return this.address;
    }
    
    void viewRentedVehicles() {
        
    }
}

final class Admin extends User{
    enum vecType {
        CAR,
        MOTOTRCYCLE
    }
    Admin(String username,String password){
        super(username, password);
    }
    
    Vehicle addVehicle(String vecType,  String transmission, int numbrtOfSeates,
            int numberOfDoors, String fuelType, String brand, String model,
            String licensePlate, String color, double pricePerday){
        
        if (vecType.equalsIgnoreCase("Car")){
            Vehicle car = new Car(transmission, numbrtOfSeates,numberOfDoors,
                    fuelType, brand, model,licensePlate, color, pricePerday);
            return car;
        }
        
       return null; 
    }
    
    
    Vehicle addVehicle(String vecType, int enginCapacity, double fuleCapacity,
                String bikeType,String brand, String model, String licensePlate,
                String color, double pricePerday){
        
        if (vecType.equalsIgnoreCase("Motorcylce")){
            Vehicle motorcycle = new Motorcycle(enginCapacity,fuleCapacity,bikeType,
                        brand,model,licensePlate,color,pricePerday);
            return motorcycle;
        }
        
       return null; 
    }
    
    
    boolean removeVehicle(List<Vehicle> vehicles, Vehicle vehicle){
            boolean status = false;
            if(vehicle.isAvilable()){
                status = vehicles.remove(vehicle);
            }
            return status;//0 - on success
            
    }
    
    
    void viewAllVehicles(List<Vehicle> vehicles) {
        String vecType;
        System.out.println("\tLIST OF ALL VEHICLES");
        System.out.println("------------------------------------------"
                + "-----------------------------------");
        System.out.printf("%-15s %-15s  %-15s %-15s %-15s %-15s%n",
            "TYPE", "BRAND", "MODEL", "LICENSE PLATE", "COLOR", "PRICE/DAY");
        System.out.println("------------------------------------------"
                + "-----------------------------------");
        
        for(Vehicle veh:vehicles){
            if(veh != null) {
                vecType = (veh instanceof Car)? "Car":"Motorcycle";
                
                System.out.printf(
                    "%-15s %-15s  %-15s %-15s %-15s %,-15.2f%n",
                    vecType,
                    veh.getmodel(),
                    veh.getbrand(),
                    veh.getlicenseplate(),
                    veh.getcolor(),
                    veh.getpriceperday()
                );
            }
            
        }
    }
    
    
    void viewCars(List<Vehicle> vehicles, int listType){
        //listType -> 0-all, 1-avilable, 2-rented
        Car car;
        
        if(listType == 0 || listType == 1 || listType == 2 ) {
            System.out.println("-----------------------------------------------"
                    + "----------------------------------------------------");
            System.out.printf("%-15s  %-15s %-15s %-15s %-15s %-5s %-5s %-15s %-15s%n",
                "BRAND", "MODEL", "LICENSE PLATE", "COLOR","TRANSMISSION",
                "NUM OF SEATES","NUM OF DOOR","FUELTYPE", "PRICE/DAY");
            System.out.println("-----------------------------------------------"
                    + "----------------------------------------------------");
            for(Vehicle veh:vehicles){
                if (!(veh instanceof Car)) continue;
                if (listType == 1 && !veh.isAvilable()) continue;
                if (listType == 2 && veh.isAvilable()) continue;

                car = (Car) veh;

                System.out.printf(
                    "%-15s  %-15s %-15s %-15s %-15s %-5d %-5d %-15s %,-15.2f%n",
                    car.getbrand(),
                    car.getmodel(),
                    car.getlicenseplate(),
                    car.getcolor(),
                    car.gettransmission(),
                    car.getnumbrtOfSeates(),
                    car.getnumberOfDoors(),
                    car.getfuelType(),
                    car.getpriceperday()
                );  
            }
        }
            
    }       
    
    
    void viewAMototrcycles(List<Vehicle> vehicles, int listType){
        //listType -> 0-all, 1-avilable, 2-rented
        Motorcycle bike;
        
        if(listType == 0 || listType == 1 || listType == 2 ) {
            System.out.println("-----------------------------------------------"
                    + "----------------------------------------------------");
            System.out.printf("%-15s  %-15s %-15s %-15s %-15s %-15s%n %-15s %-15s%n",
                "BRAND", "MODEL", "LICENSE PLATE", "COLOR","ENGIN CAPACITY",
                "FULE CAPACITY","BIKE TYPE", "PRICE/DAY");
            System.out.println("-----------------------------------------------"
                    + "----------------------------------------------------");
            for(Vehicle veh:vehicles){
                if (!(veh instanceof Motorcycle)) continue;
                if (listType == 1 && !veh.isAvilable()) continue;
                if (listType == 2 && veh.isAvilable()) continue;

                bike = (Motorcycle) veh;

                System.out.printf(
                    "%-15s  %-15s %-15s %-15s %-15d %-15.2f%n %-15s %,-15.2f%n",
                    bike.getbrand(),
                    bike.getmodel(),
                    bike.getlicenseplate(),
                    bike.getcolor(),
                    bike.getenginCapacity(),
                    bike.fuleCapacity(),
                    bike.getbikeType(),
                    bike.getpriceperday()
                );  
            }
        }
            
    }   
    
    void viewCustomers(List<Customer> customers){
        System.out.println("\tLIST OF ALL CUSTOMER");
        /*for(Customer var:customers) {
            System.out.println(var.getname()+" {");
            System.out.println("\tPhone:          "+var.getphone());
            System.out.println("\tEmail:          "+var.getemail());
            System.out.println("\tLicense Number: "+var.getlicenseNumber());
            System.out.println("\tAddress:        "+var.getaddress());
        }*/
        
        System.out.printf(
        "%-15s %-15s %-12s %-10s %-12s%n",
        "NAME", "PHONE", "EMAIL", "LICENSE NUMBER", "ADDRESS"
        );
        System.out.println("-------------------------------------------------------------");
        for(Customer cus:customers) {
            System.out.printf(
                "%-15s %-15s %-12s %-10s %-12s%n",
                cus.getname(),
                cus.getphone(),
                cus.getemail(),
                cus.getlicenseNumber(),
                cus.getaddress()
            );
            
        }
    }
    
    
    void viewAllRents(){
        
    }
}