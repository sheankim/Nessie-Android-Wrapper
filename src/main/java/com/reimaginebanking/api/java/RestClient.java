package com.reimaginebanking.api.java;

import com.reimaginebanking.api.java.models.ATM;
import com.reimaginebanking.api.java.requests.NessieService;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by kco942 on 4/9/15.
 */
public class RestClient implements NessieCallback {

    private final String enterpriseKey;
    private final String customerKey;

    public RestClient(String enterpriseKey, String customerKey) {
        this.enterpriseKey = enterpriseKey;
        this.customerKey = customerKey;

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.reimaginebanking.com")
                .build();

        NessieService service = restAdapter.create(NessieService.class);


        service.getATMs("abc123", new Callback<List<ATM>>() {
            public void success(List<ATM> atms, Response response) {
                NessieType.getCallback().onSuccess(NessieType.SUCCESS_ATM, atms)
            }

            public void failure(RetrofitError error) {

            }
        });

        List<ATM> atms = service.getATMs("abc123");

        service.getATMs("Fdsfdsf"), new NessieCallback() {
    }


    public void onSuccess(int callbackType, Object result) {
        NessieType.ERROR
                NessieType.ATM
    }
}
