/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author user
 */

public class RentalSystem {
    public static enum Session{
        ON,
        OFF,
        ERROR
    }
    
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<User> users = new ArrayList<>();;
    private List<Rent> rent = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();
    private Session session;
    private String username;
    private Vehicle vehicleCho;
    
    
    
    void setadmin(){
        User adminuser = new Admin("admin", "1234");
        this.users.add(adminuser);
    }
    
    void setVehicleCho(String platenumber){
        this.vehicleCho = findVehicle(platenumber);
    }
    
    String getUsername(){
        return this.username;
    }
    int getSession(){
        int status;
        if(this.session == Session.ON)
            status = 1;
        else if(this.session == Session.OFF)
            status = 0;
        else
            status = -1;
        
        return status;
    }
    Vehicle getVehicleCho(){
        return this.vehicleCho;
    }
    
    User findUser(String username){
        
        for(User user:users) {
            if(user != null){
                if (user.getUserName().equals(username)) {
                    return user;
                }
            }
        }
        return null;
    }
    
    boolean isUserNameThire(String username){
        for(User user:users) {
            if(user != null){
                if (user.getUserName().equalsIgnoreCase(username)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean isVechileThire(String plateNumber){
        for(Vehicle veh:vehicles) {
            if(veh != null){
                if (veh.getlicenseplate().equals(plateNumber)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    Vehicle findVehicle(String plateNumber) {
        for (Vehicle veh : vehicles) {
            if(veh != null){
                if (veh.getlicenseplate().equals(plateNumber)) {
                    return veh;
                }
            }
        }
        return null;
    }

    
    
    Session loginStauts(String username, String password){
        int status;
        User user = findUser(username);
        
        if (user != null){
            status = user.login(username, password);
            if (status == 0){
                this.username = username;
                this.session = Session.ON;
                return this.session;
            }
        }
        this.session = Session.ERROR;
        return this.session;
    }
    
    Session logoutStatus(User user){
        user.logout();
        this.username = null;
        this.session = Session.OFF;
        return this.session;
    }
    
    
    void ListVechiles(String username, int input){
        User user = findUser(username);
        
        if(user instanceof Admin){
            Admin usr = (Admin) user;
            if(input == 1)
                usr.viewAllVehicles(vehicles);
            else if(input == 2)
                usr.viewCars(vehicles, 0);
            else if(input == 3)
                usr.viewAMototrcycles(vehicles, 0);
            else if(input == 4)
                usr.viewCars(vehicles, 2);
            else if(input == 5)
                usr.viewAMototrcycles(vehicles, 2);
            else if(input == 6)
                usr.viewCars(vehicles, 1);
            else if(input == 7)
                usr.viewAMototrcycles(vehicles, 1);
        }
    }
    
    int AddCar(String username, String transmission, int numbrtOfSeates,
            int numberOfDoors, String fuelType, String brand, String model,
            String licensePlate, String color, double pricePerday){
        
        User user = findUser(username);
        if(!isVechileThire(licensePlate)){
            if(user instanceof Admin){
                Admin usr = (Admin) user;

                vehicles.add(usr.addVehicle("Car", transmission, numbrtOfSeates,
                    numberOfDoors, fuelType, brand, model,licensePlate, color, pricePerday));
                return 1;
            }
        }
        return -1;
        
    }
    
    
    int Motorcycle(String username, int enginCapacity, double fuleCapacity,
                String bikeType,String brand, String model, String licensePlate,
                String color, double pricePerday){
        
        User user = findUser(username);
        if(!isVechileThire(licensePlate)) {
            if(user instanceof Admin){
                Admin usr = (Admin) user;

                vehicles.add(usr.addVehicle("Motorcycle", enginCapacity, fuleCapacity,
                    bikeType, brand, model, licensePlate, color, pricePerday));
                return 1;
            }
        }
        return -1;
    }
    
    int removeVehicle(String username, String licensePlateNum){
            
        Vehicle removeVeh = findVehicle(licensePlateNum);
        User user = findUser(username);
        if(removeVeh == null){
            return 0;
        }
        if(user instanceof Admin){
            Admin usr = (Admin) user;
            boolean isRemoved = usr.removeVehicle(vehicles, removeVeh);
            
            if (!isRemoved){
                return -1;
            }
        }
        return 1;
        
    }
    
    //-------------------------------------------------------------
    
    void listAvilableVechile(String vehcType, int start, int end){
        int count = 0;
        
        for (Vehicle veh : vehicles) {
            if (vehcType.equalsIgnoreCase("Car")){
                
                if (veh instanceof Car && veh.isAvilable()) {

                    if (count >= start && count < end) {
                        veh.displayInfo();
                    }

                    count++;
                }
            } else if (vehcType.equalsIgnoreCase("Mototrcycle")){
                
                if (veh instanceof Car && veh.isAvilable()) {

                    if (count >= start && count < end) {
                        veh.displayInfo();
                    }

                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("No available cars found.");
        }
    }
    
    int creatCustomer(String name, String email,String Phone, String licenseNumber,
            String address, String username, String password){
        
        
        User customer = new Customer(name,email,Phone,licenseNumber,
            address,username,password);
        
        users.add(customer);
        return 1;
    }
    
    void vehicleChoice(String plateNumber){
        this.vehicleCho = findVehicle(plateNumber);
    }
    
    void rentalprocess(int rentDate, int returnDate, int rentMonth,
            int returnMonth, int paymetMethod){
        
        User user = findUser(this.username);
        if(user != null && user instanceof Customer){
            
            Customer customer = (Customer) user;

            Rent rent = new Rent(rentDate, returnDate,rentMonth,returnMonth,
                        this.vehicleCho, customer);
            rent.rentProcess(paymetMethod);
            customer.setRentedVehicles(rent);
            
        }
    }
}
