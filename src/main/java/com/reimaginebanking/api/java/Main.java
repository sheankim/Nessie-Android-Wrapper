package com.reimaginebanking.api.java;

import com.reimaginebanking.api.java.models.ATM;
import com.reimaginebanking.api.java.models.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kco942 on 4/9/15.
 */
public class Main {
    public static void main(String[] args) {
        //String enterpriseKey = "ENT179388d26418860c1f843d36f3445445";
        String key = "c3f7f751db5dc04db17a1aed58d319e9";
        NessieClient nessieClient = NessieClient.getInstance();

        nessieClient.setAPIKey(key);

        nessieClient.getCustomers(new NessieResultsListener() {
            @Override
            public void onSuccess(Object result, NessieException e) {
                if (e == null) {
                    ArrayList<Customer> customers = (ArrayList<Customer>) result;
                    System.out.println("THIS IS THE FIRST");
                    System.out.println(customers.size());
                    System.out.println(customers.get(0).getFirst_name());
                }
            }
        });

        nessieClient.getCustomersAsEnterprise(new NessieResultsListener() {
            @Override
            public void onSuccess(Object result, NessieException e) {
                if (e == null) {
                    ArrayList<Customer> customers = (ArrayList<Customer>) result;
                    System.out.println("THIS IS THE SECOND");
                    System.out.println(customers.size());
                    System.out.println(customers.get(0).getFirst_name());
                }
            }
        });

        nessieClient.getCustomers(new NessieResultsListener() {
            @Override
            public void onSuccess(Object result, NessieException e) {
                if (e == null) {
                    ArrayList<Customer> customers = (ArrayList<Customer>) result;
                    System.out.println("THIS IS THE THIRD");
                    System.out.println(customers.size());
                    System.out.println(customers.get(1).getFirst_name());
                }
            }
        });

        System.out.println("HELLO");
    }

}
