package com.hotelmolveno.rooms;



public class LuxuryRoom extends Room{
    private double ratePercentage = 25.0;

    public LuxuryRoom(int setID){
        super(0, false);
        this.ratePercentage = setID;
    }

    LuxuryRoom newLux = new LuxuryRoom(10);

    public double getRatePercentage() {
        return ratePercentage;
    }

    public void setRatePercentage(double ratePercentage) {
        this.ratePercentage = ratePercentage;
    }

    public LuxuryRoom getNewLux() {
        return newLux;
    }

    public void setNewLux(LuxuryRoom newLux) {
        this.newLux = newLux;
    }
}

