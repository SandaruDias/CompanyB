package com.example.CompanyB.ManufacturingModule.Model;

import java.util.ArrayList;

public abstract class WorkStation {
    private ArrayList<String> onGoingOrdersIds = new ArrayList<>();
    public static  int fetch (OnGoingOrder onGoingOrder,int amount){
        return -1;
    };
    public abstract int pass(OnGoingOrder onGoingOrder,int amount);

}
