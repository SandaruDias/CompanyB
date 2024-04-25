package com.example.CompanyB.ManufacturingModule.Model;

import java.util.ArrayList;

public class WorkStationThree extends WorkStation {
    public ArrayList<String> onGoingOrdersIds = new ArrayList<>();

    public static int  fetch(OnGoingOrder onGoingOrder, int amount) {
        int newWaitToThree = onGoingOrder.getWaitToThree() -amount;
        int newOnGoing = onGoingOrder.getOnGoingStationThree()+ amount;
        if (newWaitToThree >0){
            onGoingOrder.setWaitToThree(newWaitToThree);
            onGoingOrder.setOnGoingStationThree(newOnGoing);
            return 0; // successfully fetched
        }
        else{
            return -1; // invalid amount
        }
    }

    @Override
    public int pass(OnGoingOrder onGoingOrder, int amount) {
        int newOnGoing = onGoingOrder.getOnGoingStationThree()-amount;
        int newCompleted = onGoingOrder.getCompletedNum() + amount;
        if (newOnGoing>0){
            onGoingOrder.setOnGoingStationThree(newOnGoing);
            onGoingOrder.setCompletedNum(newCompleted);
            return 0; //successfully passed
        }
        else {
            return -1; // invalid amount
        }
    }
}
