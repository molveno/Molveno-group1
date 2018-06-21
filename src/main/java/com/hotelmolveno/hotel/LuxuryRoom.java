package com.hotelmolveno.hotel;



public class LuxuryRoom extends Room{
    private double ratePercentage = 25.0;

    public LuxuryRoom(int setID){
        super(0, 0, 4, 100.0);
        this.ratePercentage = setID;
    }

    @Override
    public void showMessage(){
       // super.showMessage();
        System.out.println("Welcome to your luxury room");
    }


    public double getRatePercentage() {
        return ratePercentage;
    }

    public void setRatePercentage(double ratePercentage) {
        this.ratePercentage = ratePercentage;
    }



}

