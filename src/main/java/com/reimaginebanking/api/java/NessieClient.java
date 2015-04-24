package com.reimaginebanking.api.java;


import com.reimaginebanking.api.java.models.ATM;
import com.reimaginebanking.api.java.models.Customer;
import com.reimaginebanking.api.java.requests.NessieService;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by kco942 on 4/9/15.
 */
public class NessieClient {

    private final String enterpriseKey;
    private final String customerKey;
    private NessieResultsListener mlistener;
    private NessieService service;
    public NessieClient(String enterpriseKey, String customerKey) {
        this.enterpriseKey = enterpriseKey;
        this.customerKey = customerKey;

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.reimaginebanking.com")
                .build();

        service = restAdapter.create(NessieService.class);

    }

    public void setNessieResultsListener(NessieResultsListener observer){
        mlistener = observer;
    }

    public void getCustomers(){
        service.getCustomers(this.customerKey, new Callback<List<Customer>>() {
            public void success(List<Customer> customers, Response response) {
                mlistener.onSuccess(NessieType.CUSTOMER, customers);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(error);
            }
        });
    }

    public void getATMs(){
        service.getATMs(this.customerKey, new Callback<List<ATM>>() {
            public void success(List<ATM> atms, Response response) {
                mlistener.onSuccess(NessieType.ATM, atms);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(error);
            }
        });
    }

    public void getATM(String atmID){
        service.getATM(this.customerKey, atmID, new Callback<ATM>() {
            public void success(ATM atm, Response response) {
                mlistener.onSuccess(NessieType.ATM, atm);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(error);
            }
        });
    }

}
