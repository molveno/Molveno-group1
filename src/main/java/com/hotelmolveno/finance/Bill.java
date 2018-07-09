package com.hotelmolveno.finance;

import com.hotelmolveno.user.Guest;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bill {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double roomCost;
    private double restaurantCost;
    private double barCost;
    private double otherCost;
    private double totalCost;
    private double remainingAmount;

    @ManyToOne
    private Guest guest;

    @OneToMany(mappedBy = "person") // person is the private Person instance var in the phone class
    private Set<Payment> payments = new HashSet<>();

    public Set<Payment> getPayment() {
        return this.payments;
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);

    }

    public Bill() {
        }


        public double calculateTotalCost () {
            totalCost = roomCost + restaurantCost + barCost + otherCost;
            System.out.println("The total cost is " + totalCost);
            return totalCost;
        }

//    public double calculateRemainingAmount() {
//        remainingAmount = totalCost - paymentDone.getPaymentAmount();
//        return remainingAmount;
//    }


        public long getId () {
            return id;
        }

        public void setId ( long id){
            this.id = id;
        }

        public double getRoomCost () {
            return roomCost;
        }

        public void setRoomCost ( double roomCost){
            this.roomCost = roomCost;
        }

        public double getRestaurantCost () {
            return restaurantCost;
        }

        public void setRestaurantCost ( double restaurantCost){
            this.restaurantCost = restaurantCost;
        }

        public double getBarCost () {
            return barCost;
        }

        public void setBarCost ( double barCost){
            this.barCost = barCost;
        }

        public double getOtherCost () {
            return otherCost;
        }

        public void setOtherCost ( double otherCost){
            this.otherCost = otherCost;
        }

        public double getTotalCost () {
            return totalCost;
        }

        public void setTotalCost ( double totalCost){
            this.totalCost = totalCost;
        }

        public double getRemainingAmount () {
            return remainingAmount;
        }

        public void setRemainingAmount ( double remainingAmount){
            this.remainingAmount = remainingAmount;
        }


    }
