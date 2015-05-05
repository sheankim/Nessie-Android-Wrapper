package com.reimaginebanking.api.java;

import com.reimaginebanking.api.java.models.ATM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kco942 on 4/9/15.
 */
public class Main {
    public static void main(String[] args) {
        String enterpriseKey = "ENT179388d26418860c1f843d36f3445445";
        String key = "c3f7f751db5dc04db17a1aed58d319e9";
        NessieClient nessieClient = NessieClient.getInstance();

        nessieClient.setAPIKey(enterpriseKey);

//        nessieClient.getATMs(new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//
//                if(e == null){
//                    ArrayList<ATM> atms = (ArrayList<ATM>) result;
//                    System.out.println(atms.size());
//                    System.out.println(atms.get(0).get_id());
//                }else {
//                    System.out.println("THERE IS AN ERROR");
//                    System.out.println(e.toString());
//                }
//            }
//        });
        //nessieClient.getATMs();
        //nessieClient.getATM("10485023845702");

        System.out.println("HELLO");
    }

}
