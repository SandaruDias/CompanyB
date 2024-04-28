package com.example.CompanyB.ManufacturingModule.Model;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.OnGoingOrder;

import java.util.ArrayList;

public class WorkStationOne extends WorkStation {
    public ArrayList<String> onGoingOrdersIds = new ArrayList<>();
    public static int fetch(OnGoingOrder onGoingOrder, int amount) {
        int newWaitToOne = onGoingOrder.getWaitToOne() -amount;
        int newOnGoing = onGoingOrder.getOnGoingStationOne()+ amount;
        if (newWaitToOne >=0){
            onGoingOrder.setWaitToOne(newWaitToOne);
            onGoingOrder.setOnGoingStationOne(newOnGoing);
            return 0; // successfully fetched
        }
        else{
            return -1; // invalid amount
        }
    }

    public static int pass(OnGoingOrder onGoingOrder, int amount) {
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
