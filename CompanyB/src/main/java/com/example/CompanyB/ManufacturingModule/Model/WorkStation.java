package com.example.CompanyB.ManufacturingModule.Model;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.OnGoingOrder;

import java.util.ArrayList;

public abstract class WorkStation {
    private ArrayList<String> onGoingOrdersIds = new ArrayList<>();
<<<<<<< Updated upstream
    public static  int fetch (OnGoingOrder onGoingOrder,int amount){
        return -1;
    };
    public abstract int pass(OnGoingOrder onGoingOrder,int amount);
=======
    public abstract int fetch (OnGoingOrder onGoingOrder,int amount);
    public abstract int pass(OnGoingOrder onGoingOrder, int amount);
>>>>>>> Stashed changes

}
