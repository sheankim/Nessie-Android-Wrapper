package com.reimaginebanking.api.java;

import com.reimaginebanking.api.java.models.ATM;

import java.util.ArrayList;

/**
 * Created by hxp347 on 4/24/15.
 */
public class NessieClientImpl implements NessieResultsListener {

    public NessieClientImpl(){
    }


    public void onSuccess(NessieType callbackType, Object result) {
        if(callbackType == NessieType.ATMS){
            System.out.println("CLIENT IMPL");
            System.out.println(Thread.currentThread().getId());
            ArrayList<ATM> atms = (ArrayList<ATM>) result;
            System.out.println(atms.size());
        }

        if(callbackType == NessieType.ATM){
            ATM atm = (ATM) result;
            System.out.println(atm.get_id() + " - " + atm.getAddress());
        }
    }

    public void onFailure(NessieException error) {
        //System.out.println(((RetrofitError) error).getResponse().getReason());
        //System.out.println(((RetrofitError) error).getMessage());
        System.out.println(error.toString());
    }
}
