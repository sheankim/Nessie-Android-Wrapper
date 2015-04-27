package com.reimaginebanking.api.java;

/**
 * Created by kco942 on 4/9/15.
 */
public class Main {
    public static void main(String[] args) {
        String enterpriseKey = "ENT179388d26418860c1f843d36f3445445";
        String customerKey = "CUST179388d26418860c1f843d36f3445445";
        System.out.println("hello world");
        System.out.println("MAIN");
        System.out.println(Thread.currentThread().getId());
        NessieClient nessieClient = NessieClient.getInstance();
        NessieClientImpl test = new NessieClientImpl();
        nessieClient.setAPIKey(customerKey);
        nessieClient.setNessieResultsListener(test);

        //nessieClient.getATMs();
        //nessieClient.getATMs();
        nessieClient.getATM("10485023845702");
    }

}
