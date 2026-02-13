/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.util.Scanner;

/**
 *
 * @author user
 */

public class Vehicle_rent {
    static Scanner user_input = new Scanner(System.in);
    static RentalSystem rental_system = new RentalSystem();
   

    public static void main(String[] args) {
        run();
    }
    
    static void run(){
        int choice;
        rental_system.setadmin();
        do {
            System.out.println("""
                                
                        ----------[WELCOME TO YONAS CAR RENT]----------

                                   1. CUSTOMER
                                   2. ADMIN
                                   3. EXIT
                               """);
            System.out.println("Enter Your Choice: ");
            
            choice = user_input.nextInt();
            user_input.nextLine();
            
            
            switch(choice){
                case 1:
                   customer(); 
                   break;                   
                case 2:
                    admin();
                    break;
                case 3:
                    System.out.println("END OF THE PROGRAM!!!!");
                    break;
                default:
                    System.out.println("Incorect Input please Try again");
            }
        } while(choice != 3);
    }
    
    static int login() {
        String username, password;
        
        System.out.print("UserName: ");
        username = user_input.nextLine();
        
        System.out.print("Password: ");
        password = user_input.nextLine();
        
        RentalSystem.Session status = rental_system.loginStauts(username, password);
        
        if (status == RentalSystem.Session.ON){
            System.out.println("Successfully Loged in!!");
            return 1;
        } else if (status == RentalSystem.Session.ERROR){
            System.out.println("Incorect Username or Password\nPleas try again");
            System.out.println("---  ---  ----  ---  ---  ---  ---  ---  ---");
            return -1;
        }
        return 0;
    }    
    
    static void customer(){
        int choice;
        
        do {
            System.out.print("""
                             ------[welcome]-------
                                 WHAT DO YOU WANT?
                                1. CAR
                                2. MOTORCYCLE
                                3. Back
                               """);
            System.out.print("Enter Your Choice: ");
            choice = user_input.nextInt();
            user_input.nextLine();
            
            switch(choice){
                    case 1:
                       car();
                       break;
                    case 2:
                       motorcycle();
                       
                       rent();
                       break;
                    case 3:
                        return;
                    default:
                        System.out.println("Incorect Input please Try again");
                }
        } while(true);
        
    }
    
    static int motorcycle(){
        int input, start = 0, end = 10;
            
        System.out.println("""
                           ----------[     ]-------------
                           Current avillable Motorcycle
                           -----------------------------
                           """);
        do {
            rental_system.listAvilableVechile("Motorcycle", start, end);
             
            System.out.println("Do you want to see more bikes(1 = yes, other = no");
            input = user_input.nextInt();
            user_input.nextLine();
            if(input == 1){
                start += 10;
                end += 10;
            }
        } while(input == 1);

            
        System.out.println("Do you wanto to continue?(1 = yes, other = Back to Menu):");
        input = user_input.nextInt();
        user_input.nextLine();
        
        if(input != 1){
            return 0;
        }
        
        
        System.out.println("which one would you like?please enter the license pleate number: ");
        String licensePlate = user_input.nextLine();
        boolean carExist = rental_system.isVechileThire(licensePlate);
        
        if (!carExist){
            System.out.println("Incorect pleate Number! Please try adain");
            return 0;
        } else {
            rental_system.setVehicleCho(licensePlate);
        }
        
        System.out.println("Befor renting plase login to the system");
        customerlogin();
        
        if(rental_system.getSession() == 1){
            rent();
        }
        return 0;
    }

    static int car(){
        int input, start = 0, end = 10;
            
        System.out.println("""
                           ----------[     ]-------------
                           Current avillable cars
                           -----------------------------
                           """);
        do {
            rental_system.listAvilableVechile("Car", start, end);
             
            System.out.println("Do you want to see more cars(1 = yes, other = no");
            input = user_input.nextInt();
            user_input.nextLine();
            if(input == 1){
                start += 10;
                end += 10;
            }
        } while(input == 1);

            
        System.out.println("Do you wanto to continue?(1 = yes, other = Back to Menu):");
        input = user_input.nextInt();
        user_input.nextLine();
        
        if(input != 1){
            return 0;
        }
        
        
        System.out.println("which one would you like?please enter the license pleate number: ");
        String licensePlate = user_input.nextLine();
        boolean carExist = rental_system.isVechileThire(licensePlate);
        
        if (!carExist){
            System.out.println("Incorect pleate Number! Please try adain");
            return 0;
        } else {
            rental_system.setVehicleCho(licensePlate);
        }
        
        System.out.println("Befor renting plase login to the system");
        customerlogin();
        
        if(rental_system.getSession() == 1){
            rent();
        }
        return 0;
    }
    
    static void customerlogin(){
        int input;
        System.out.println("""
                           ---------[     ]--------------
                           1.Login
                           2.Create Account
                           Enter Your choice:
                           """);
        input = user_input.nextInt();
        user_input.nextLine();
        
        if (input == 1){
            int status = login();
            
            if (status != 1) {
                int i = 0;
                do {
                   status = login();
                   i++;
                   if(i == 5){
                       System.out.println("You reach the limit!!!");
                   }
                }while(status != 1 && i!=5);
            }
        } else {
            createAccount();
        }
    }
    
    static void createAccount() {
        String name,email,Phone,licenseNumber,
             address,username,password;
        
        System.out.println("Name: ");
        name = user_input.nextLine();
        
        System.out.println("Phone: ");
        Phone = user_input.nextLine();
        
        System.out.println("license Number: ");
        licenseNumber = user_input.nextLine();
        
        System.out.println("email: ");
        email = user_input.nextLine();
        
        System.out.println("Address(Format: city-subcity-woroda) : ");
        address = user_input.nextLine();
        
        System.out.println("UserName: ");
        username = user_input.nextLine();
        boolean usernameExistes = rental_system.isUserNameThire(username);
        do {
                if(usernameExistes){
                    System.out.println("UserName: ");
                    username = user_input.nextLine();
                    usernameExistes = rental_system.isUserNameThire(username);
                }
        } while(usernameExistes);
        
        
        System.out.println("Password: ");
        password = user_input.nextLine();
        
        int i = rental_system.creatCustomer(name, email, Phone, licenseNumber, address, username, password);
        if (i == 1){
            System.out.println("Successfully Registerd!!");
            RentalSystem.Session status = rental_system.loginStauts(username, password);
        
            if (status == RentalSystem.Session.ON){
                System.out.println("Successfully Loged in!!");
            }
        }
    }
    
    static void rent(){
        Vehicle chosenVehicle = rental_system.getVehicleCho();
        int choice;
        System.out.println("--------[rent your choice]--------");
        System.out.println("Your choice is: ");
        if(chosenVehicle != null){
            chosenVehicle.displayInfo();
            System.out.println("Enter rent starting date(1-30) : ");
            int rentdate = user_input.nextInt();
            user_input.nextLine();
            System.out.println("Enter rent starting month(1-12): ");
            int rentmonth = user_input.nextInt();
            user_input.nextLine();
            System.out.println("Enter returning date(1-30) : ");
            int returndate = user_input.nextInt();
            user_input.nextLine();
            System.out.println("Enter returning month(1-12): ");
            int returnmonth = user_input.nextInt();
            user_input.nextLine();
            
            System.out.println("""
                               chose your Payment Method
                               1. TeleBirr
                               2. CBE
                               3. Cash
                               Enter your choice;
                               """);
            int payMethod = user_input.nextInt();
            user_input.nextLine();
            
            
            rental_system.rentalprocess(rentdate, returndate, rentmonth, returnmonth, payMethod);
        }  
    }
    
    
    static void admin(){
        int choice, status;
        user_input.nextLine();
        status = login();
        
        if (status != 1) {
            int i = 0;
            do {
               status = login();
               i++;
               if(i == 5){
                   System.out.println("You reach the limit!!!");
               }
            }while(status != 1 && i!=5);
        }
        if (status == 1){
            do {
                System.out.println("""
                                   -------------[welcome]-------------
                                     What do you want to do

                                   1. View/Manage vechile
                                   2. View/Manage customer
                                   3. Back
                                   Enter your choice: 
                                   """);
                choice = user_input.nextInt();
                user_input.nextLine();

                switch(choice){
                    /*case 1:
                        addVehicle();
                        break;*/
                    case 1:
                        viewAndManageVechile();
                        
                        manageVechile();
                        break;
                    case 2:
                        manageCustomer();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.print("incorect input please try again!!!");
                }

            }while(choice != 3);
        }
        
    }
    
    static void viewAndManageVechile(){
        int c;
        do {
            System.out.println("""
                               --------[   ]---------
                                1. View vechile
                                2. Manage vechile
                                3. Back
                                Enter your choice: 
                                """);
            c = user_input.nextInt();
            user_input.nextLine();

            switch(c){
                case 1:
                    viewVechileReport();
                    break;
                case 2:
                    manageVechile();
                    break;
                case 3:
                    break;
                default:
                    System.out.print("incorect input please try again!!!");    
            }
        } while(c != 3);
    }

    static void viewVechileReport() {
        int c;
            System.out.println("""
                               --------[   ]---------
                                1. List All Vechile
                                2. List All Cars
                                3. List All Motorcycle
                                4. List All Rented Cars
                                5. List All Rented Motorcycle
                                6. List All Avilable Cars
                                7. List All Avilable Motorcycle
                                Enter your choice:
                                """);
            c = user_input.nextInt();
            user_input.nextLine();
            
            if (c >= 1 && c <= 7){
                rental_system.ListVechiles(rental_system.getUsername(), c);
            } else {
                System.out.print("incorect input please try again!!!");
            }
    }
   
    static void manageVechile(){
        int choice;
        System.out.println("""
                           --------[   ]---------
                            1. Add Car
                            2. Add Motorcycle
                            3. Remove Car
                            4. Remove Motorcycle
                            5. Back
                           """);
        choice = user_input.nextInt();
        user_input.nextLine();
        
        switch(choice){
            case 1:
                addCar();
                break;
            case 2:
                addMotorcycle();
                break;
            case 3:
                removeVehicle();
                break;
            case 4:
                removeVehicle();
                break;
            case 5:
                break;
            default:
                    System.out.print("incorect input please try again!!!");          
        }
        
    }
    
    static void addCar(){
        System.out.println("\n--- [Add New Car] ---");
        System.out.println("Please enter the vehicle details:\n");

        
        System.out.print("Brand:");
        String brand = user_input.nextLine();
        
        System.out.print("Model:");
        String model = user_input.nextLine();
        
        System.out.print("Transmission type(Manual, Automatic):");
        String transmission = user_input.nextLine();
        
        System.out.print("Fule Type(Gasoline/Diesile/Hybrid...):");
        String fuelType = user_input.nextLine();
        
        System.out.println("Number of Seates: ");
        int numbrtOfSeates = user_input.nextInt();
        user_input.nextLine();
        
        System.out.println("Number of Dorres: ");
        int numberOfDoors = user_input.nextInt();
        user_input.nextLine();
        
        System.out.println("Color: ");
        String color = user_input.nextLine();
        
        System.out.println("license Plate Number: ");
        String licensePlate = user_input.nextLine();
        
        System.out.println("Price Per Day: ");
        double pricePerday = user_input.nextDouble();
        user_input.nextLine();
        
        int i = rental_system.AddCar(rental_system.getUsername(),transmission,
                numbrtOfSeates,numberOfDoors,fuelType,brand,model,
                licensePlate, color, pricePerday);
        if (i == 1) {
            System.out.println("Successfully Added!!!");
        } else {
            System.out.println("The car is Already Exist");
        }
        
  
    } 

    static void addMotorcycle(){
        System.out.println("\n--- [Add New Motorcycle] ---");
        System.out.println("Please enter the vehicle details:\n");

        
        System.out.print("Brand:");
        String brand = user_input.nextLine();
        
        System.out.print("Model:");
        String model = user_input.nextLine();
        
        System.out.print("Bike Type(Sport/Cruiser/Chopper...):");
        String bikeType = user_input.nextLine();
        
        System.out.println("Engin Capacity: ");
        int enginCapacity = user_input.nextInt();
        user_input.nextLine();
        
        System.out.println("Fulecapacity(2000 litter): ");
        double fuleCapacity = user_input.nextDouble();
        user_input.nextLine();
        
        System.out.println("Color: ");
        String color = user_input.nextLine();
        
        System.out.println("license Plate Number: ");
        String licensePlate = user_input.nextLine();
        
        System.out.println("Price Per Day: ");
        double pricePerday = user_input.nextDouble();
        user_input.nextLine();
        
        int i = rental_system.Motorcycle(rental_system.getUsername(), enginCapacity,fuleCapacity,
                bikeType,brand,model,licensePlate,color, pricePerday);
        if (i == 1) {
            System.out.println("Successfully Added!!!");
        } else {
            System.out.println("The car is Already Exist");
        }
  
    }
    
    static void removeVehicle(){
        System.out.println("------[Remove Vehicle]------");
        System.out.println("Enter the License Plate Number: ");
        String licensePlateNum = user_input.nextLine();
        
        int i = rental_system.removeVehicle(rental_system.getUsername(), licensePlateNum);
        
        if (i == -1){
            System.out.println("This Vehicle is alrady renated");
            System.out.println("Please wait till it backs to store");
        } else if (i == 0){
            System.out.println("There is no any vechile with this number");
        } else {
            System.out.println("Successfully Removed");
        }
    }

        
    static void addVehicle(){
        int choice;
        System.out.println("""
                                what type of vehichle?
                            1. Motorcycle
                            2. Car
                            3. back
                           """);
        choice = user_input.nextInt();
        
        switch(choice){
            case 1:
                System.out.println("insert motorcycle info");
                run();
                break;
            case 2:
                System.out.println("insert car info");
                run();
                break;
            case 3:
                admin();
                break; 
        }
    }
    
    static void manageCustomer(){
        int choice;
        System.out.println("""
                                what do you want to do?
                            1. see custormer data
                            2. update customer status
                            3. back
                           """);
        choice = user_input.nextInt();
        
        switch(choice){
            case 1:
                System.out.println("print custormer data");
                run();
                break;
            case 2:
                System.out.println("update customer status");
                run();
                break;
            case 3:
                admin();
                break; 
        }
    }
}