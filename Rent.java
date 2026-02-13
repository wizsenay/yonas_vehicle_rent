/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDate;
/**
 *
 * @author user
 */
public class Rent {
    private String rentId;
    private int rentDate;//LocalDate.of(1990, 5, 15)(y,m,day)
    private int returnDate;
    private int rentmonth;
    private int returnmonth;
    private double totalCost;
    private Vehicle vehicle;
    private Customer customer;
    private Payment payment;
    
    Rent (int rentDate, int returnDate,int rentmonth,int returnmonth,
            Vehicle vehicle, Customer customer){
        
        
        this.rentId = vehicle.getlicenseplate();
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.rentmonth = rentmonth;
        this.returnmonth = returnmonth;
        this.vehicle = vehicle;
        this.customer = customer;
    }
    
    public int totalrantedate(){
        int monthToDate = 30 * (returnmonth - rentmonth);
        int numOfDay;
        if (this.returnDate != this.rentDate){
            numOfDay = returnDate - rentDate;
        }else{
            numOfDay = 1;
        }
        
        int totalDay = numOfDay + monthToDate;
        return totalDay;
    }   
    
    void calcuTotalCost(){
        
        double totalDay = totalrantedate();
        double costPerDay = this.vehicle.getpriceperday();
        
        this.totalCost = totalDay * costPerDay;   
    }
    
    void rentProcess(int paymentMethod){
        
        final boolean RENTED = false;
        final int PAYED = 1, PANDING = 2;
        
        
        calcuTotalCost();
        System.out.println("Toatal amount = "+this.totalCost);
        
        this.payment = new Payment(this.totalCost, paymentMethod, 2);
        payment.processPayment();
        
        
        if(this.payment.getStatus() == PAYED){
            this.vehicle.setAvilable(RENTED);    
        }else if(this.payment.getStatus() == PANDING) {
            System.out.println("Your payment is on pending");
            System.out.println("Please Make your payment");
            payment.processPayment();
            if(this.payment.getStatus() == PAYED){
                this.vehicle.setAvilable(RENTED);
            }
        }
        
    }
    
    
}
