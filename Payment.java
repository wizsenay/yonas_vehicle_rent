/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author user
 */
class Payment {
    static Scanner user_input = new Scanner(System.in);
    enum Method {
        TELEBIRR,
        CBE,
        CASH
    }

    enum Status {
        PENDING,
        PAID,
        UNPAID
    }
    
    
    private final int paymentId;
    private double amount;
    private Method paymnetMethod;
    private Status paymentStatus = Status.UNPAID;
    static int idSpecify = 0;
    
    Payment(double amount, int paymentMethod, int paymentStatus){
        idSpecify++;
        this.paymentId = idSpecify;
        this.amount = amount;
        this.paymnetMethod = paymentMethod == 1? Method.TELEBIRR : 
                              (paymentMethod == 2 ? Method.CBE: Method.CASH);
        
        this.paymentStatus = paymentStatus == 1? Status.PAID : 
                              (paymentStatus == 2 ? Status.PENDING: Status.UNPAID);      
    }
    
    int getStatus(){
        
        if(this.paymentStatus == Status.PAID)
            return 1;

        return 0;
    }
    
    int getPaymentId(){
        return this.paymentId;
    }
    
    void processPayment(){
        
        if (this.paymnetMethod == Method.TELEBIRR){
            System.out.println("-------[Welcom to TeleBirr]-------");
            System.out.print("Phone Number: ");
            String phoneNum = user_input.nextLine();
            System.out.print("PIN number: ");
            String pinNum = user_input.nextLine();
            
            System.out.println("Successfuly payed!!!");   
        } else if (this.paymnetMethod == Method.CBE){
            System.out.println("-------[Welcom to CBE]-------");
            System.out.print("Account Number: ");
            String phoneNum = user_input.nextLine();
            System.out.print("PIN number: ");
            String pinNum = user_input.nextLine();
            
            System.out.println("Successfuly payed!!!");   
        } else if (this.paymnetMethod == Method.CASH){
            System.out.println("Please pay "+ this.amount+" For the casheri");
            System.out.println("The system will approved your payment");
            System.out.println("Please wait...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println("Wait...");
            }
            System.out.println("Successfuly payed!!!");                       
        }
        
        this.paymentStatus = Status.PAID;
    }   
}
