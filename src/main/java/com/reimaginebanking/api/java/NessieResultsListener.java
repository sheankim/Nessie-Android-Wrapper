package com.reimaginebanking.api.java;

/**
 * Created by hxp347 on 4/23/15.
 */
public interface NessieResultsListener {
    public void onSuccess(NessieType callbackType, Object result);
    public void onFailure(NessieException error);
}
