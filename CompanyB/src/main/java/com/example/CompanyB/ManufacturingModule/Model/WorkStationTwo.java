package com.example.CompanyB.ManufacturingModule.Model;

import java.util.ArrayList;

public class WorkStationTwo extends WorkStation {
    public ArrayList<String> onGoingOrdersIds = new ArrayList<>();

    public static int fetch(OnGoingOrder onGoingOrder, int amount) {
        int newWaitToTwo = onGoingOrder.getWaitToTwo() -amount;
        int newOnGoing = onGoingOrder.getOnGoingStationTwo()+ amount;
        if (newWaitToTwo >0){
            onGoingOrder.setWaitToOne(newWaitToTwo);
            onGoingOrder.setOnGoingStationTwo(newOnGoing);
            return 0; // successfully fetched
        }
        else{
            return -1; // invalid amount
        }
    }

    @Override
    public int pass(OnGoingOrder onGoingOrder, int amount) {
        int newOnGoing = onGoingOrder.getOnGoingStationTwo()-amount;
        int newWaitToThree = onGoingOrder.getWaitToThree() + amount;
        if (newOnGoing>0){
            onGoingOrder.setOnGoingStationTwo(newOnGoing);
            onGoingOrder.setWaitToThree(newWaitToThree);
            return 0; //successfully passed
        }
        else {
            return -1; // invalid amount
        }
    }
}
