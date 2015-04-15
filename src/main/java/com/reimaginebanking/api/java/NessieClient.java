package com.reimaginebanking.api.java;


import com.reimaginebanking.api.java.models.ATM;
import com.reimaginebanking.api.java.models.Account;

import java.util.List;

/**
 * Created by kco942 on 4/9/15.
 */
public class NessieClient {

    private final String enterpriseKey;
    private final String customerKey;

    public NessieClient(String enterpriseKey, String customerKey) {
        this.enterpriseKey = enterpriseKey;
        this.customerKey = customerKey;
    }

}
