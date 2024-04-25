package com.example.CompanyB.ManufacturingModule.Model;

import java.util.ArrayList;

public class WorkStationOne extends WorkStation {
    public ArrayList<String> onGoingOrdersIds = new ArrayList<>();
    @Override
    public int fetch(OnGoingOrder onGoingOrder, int amount) {
        int newWaitToOne = onGoingOrder.getWaitToOne() -amount;
        int newOnGoing = onGoingOrder.getOnGoingStationOne()+ amount;
        if (newWaitToOne >0){
            onGoingOrder.setWaitToOne(newWaitToOne);
            onGoingOrder.setOnGoingStationOne(newOnGoing);
            return 0; // successfully fetched
        }
        else{
            return -1; // invalid amount
        }
    }

    @Override
    public int pass(OnGoingOrder onGoingOrder, int amount) {
        int newOnGoing = onGoingOrder.getOnGoingStationOne()-amount;
        int newWaitToTwo = onGoingOrder.getWaitToTwo() + amount;
        if (newOnGoing>=0){
            onGoingOrder.setOnGoingStationOne(newOnGoing);
            onGoingOrder.setWaitToTwo(newWaitToTwo);
            return 0; //successfully passed
        }
        else {
            return -1; // invalid amount
        }
    }
}
