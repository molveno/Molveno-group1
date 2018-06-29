package com.hotelmolveno.finance;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private static int nextBillNumber = 1;
    private int BillNumber;
    private double roomCost;
    private double restaurantCost;
    private double barCost;
    private double otherCost;
    private double totalCost;
    private double remainingAmount;
    private Payment paymentDone;



    public Bill() {
        this.BillNumber = nextBillNumber;
        nextBillNumber++;
            }

    public double calculateTotalCost(){
       totalCost = roomCost + restaurantCost + barCost + otherCost;
        System.out.println("The total cost is " + totalCost);
        return totalCost;
    }

    public double calculateRemainingAmount(){
        remainingAmount = totalCost - paymentDone.getPaymentAmount();
        return remainingAmount;
}


    public static List<Bill> bills = new ArrayList<>();

    public static void addBillToList(Bill bill) {
        bills.add(bill);
    }








    public static int getNextBillNumber() {
        return nextBillNumber;
    }

    public static void setNextBillNumber(int nextBillNumber) {
        Bill.nextBillNumber = nextBillNumber;
    }

    public int getBillNumber() {
        return BillNumber;
    }

    public void setBillNumber(int billNumber) {
        BillNumber = billNumber;
    }

    public double getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(double roomCost) {
        this.roomCost = roomCost;
    }

    public double getRestaurantCost() {
        return restaurantCost;
    }

    public void setRestaurantCost(double restaurantCost) {
        this.restaurantCost = restaurantCost;
    }

    public double getBarCost() {
        return barCost;
    }

    public void setBarCost(double barCost) {
        this.barCost = barCost;
    }

    public double getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(double otherCost) {
        this.otherCost = otherCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public Payment getPaymentDone() {
        return paymentDone;
    }

    public void setPaymentDone(Payment paymentDone) {
        this.paymentDone = paymentDone;
    }

}
