package com.hotelmolveno.hotel;

public class BudgetRoom extends Room{

private boolean tvAvailable;

    public BudgetRoom(int setRoomID, boolean setReserved, boolean tvAvailable) {
        super(setRoomID);
        this.tvAvailable = tvAvailable;
    }

    public boolean isTvAvailable() {
        return tvAvailable;
    }

    public void setTvAvailable(boolean tvAvailable) {
        this.tvAvailable = tvAvailable;
    }
}


