package com.reimaginebanking.api.java;

import retrofit.RetrofitError;

/**
 * Created by hxp347 on 4/25/15.
 */
public class NessieException extends Exception {
    private String message = null;
    private int status = 0;

    public NessieException(RetrofitError retrofitError){
        this.message = retrofitError.getResponse().getReason();
        this.status = retrofitError.getResponse().getStatus();
    }

    @Override
    public String toString() {
        return Integer.toString(status) + " : " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
