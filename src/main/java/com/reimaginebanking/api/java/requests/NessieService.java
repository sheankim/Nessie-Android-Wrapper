package com.reimaginebanking.api.java.requests;

import com.reimaginebanking.api.java.models.ATM;
import com.reimaginebanking.api.java.models.Account;
import com.reimaginebanking.api.java.models.Bill;
import com.reimaginebanking.api.java.models.Branch;
import com.reimaginebanking.api.java.models.Customer;
import com.reimaginebanking.api.java.models.RequestResponse;
import com.reimaginebanking.api.java.models.Transaction;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by kco942 on 4/9/15.
 */
public interface NessieService {

    @GET("/customers")
    void getCustomers(@Query("key") String key, Callback<List<Customer>> cb);

    @GET("/customers/{id}")
    void getCustomer(@Query("key") String key, @Path("id") String id, Callback<Customer> cb);

    @GET("/customers/{id}/accounts")
    void getCustomerAccounts(@Query("key") String key, @Path("id") String id, Callback<List<Account>> cb);

    @GET("/customers/{id}/bills")
    void getCustomerBills(@Query("key") String key, @Path("id") String id, Callback<List<Bill>> cb);

    @GET("/customers/{customer_id}/bills/{bill_id}")
    void getCustomerBill(@Query("key") String key, @Path("customer_id") String customer_id, @Path("bill_id") String bill_id, Callback<Bill> cb);

    @Headers("Content-Type: application/json")
    @PUT("/customers/{id}")
    void updateCustomer(@Query("key") String key, @Path("id") String id, @Body Customer customer, Callback<RequestResponse> cb);

    @Headers("Content-Type: application/json")
    @POST("/customers/{id}/accounts")
    void createAccount(@Query("key") String key, @Path("id") String id, @Body Account account, Callback<RequestResponse> cb);

    @GET("/branches")
    void getBranches(@Query("key") String key, Callback<List<Branch>> cb);

    @GET("/branches/{id}")
    void getBranch(@Query("key") String key, @Path("id") String id, Callback<Branch> cb);

    @GET("/atms")
    void getATMs(@Query("key") String key, Callback<List<ATM>> cb);

    @GET("/atms/{id}")
    void getATM(@Query("key") String key,@Path("id") String id, Callback<ATM> cb);

    @GET("/accounts/{id}")
    void getAccount(@Query("key") String key, @Path("id") String id, Callback<Account> cb);

    @GET("/accounts/{id}/customer")
    void getAccountCustomer(@Query("key") String key, @Path("id") String id, Callback<Customer> cb);

    @DELETE("/accounts/{id}")
    void deleteAccount(@Query("key") String key, @Path("id") String id, Callback<RequestResponse> cb);

    @Headers("Content-Type: application/json")
    @POST("/accounts/{id}/bills")
    void createBill(@Query("key") String key, @Path("id") String id, @Body Bill bill, Callback<RequestResponse> cb);

    @Headers("Content-Type: application/json")
    @PUT("/accounts/{account_id}/bills/{bill_id}")
    void updateBill(@Query("key") String key, @Path("account_id") String id, @Path("bill_id") String bill_id, @Body Bill bill, Callback<RequestResponse> cb);

    @Headers("Content-Type: application/json")
    @POST("/accounts/{id}/transactions")
    void createTransaction(@Query("key") String key, @Path("id") String id, @Body Transaction transaction, Callback<RequestResponse> cb);

    @GET("/accounts/{id}/transactions")
    void getTransactions(@Query("key") String key, @Path("id") String id, Callback<List<Transaction>> cb);

    @GET("/accounts/{account_id}/transactions/{transaction_id}")
    void getTransaction(@Query("key") String key, @Path("account_id") String account_id, @Path("transaction_id") String transaction_id, Callback<Transaction> cb);

    @Headers("Content-Type: application/json")
    @PUT("/accounts/{account_id}/transactions/{transaction_id}")
    void updateTransaction(@Query("key") String key, @Path("account_id") String account_id, @Path("transaction_id") String transaction_id, @Body Transaction transaction, Callback<Transaction> cb);

    @DELETE("/accounts/{account_id}/transactions/{transaction_id}")
    void deleteTransaction(@Query("key") String key, @Path("account_id") String account_id, @Path("transaction_id") String transaction_id, Callback<RequestResponse> cb);
}
