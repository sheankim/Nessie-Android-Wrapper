package com.reimaginebanking.api.java;

import retrofit.RestAdapter;

/**
 * Created by kco942 on 4/9/15.
 */
public class RestClient {

    private final String enterpriseKey;
    private final String customerKey;

    public RestClient(String enterpriseKey, String customerKey) {
        this.enterpriseKey = enterpriseKey;
        this.customerKey = customerKey;

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.reimaginebanking.com")
                .build();

    }
}
