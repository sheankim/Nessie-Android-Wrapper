package com.reimaginebanking.api.java.Requests;

import com.reimaginebanking.api.java.Models.ATM;
import com.reimaginebanking.api.java.Models.Account;
import com.reimaginebanking.api.java.Models.Bill;
import com.reimaginebanking.api.java.Models.Branch;
import com.reimaginebanking.api.java.Models.Customer;
import com.reimaginebanking.api.java.Models.RequestResponse;
import com.reimaginebanking.api.java.Models.Transaction;

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
    //working
    @GET("/customers")
    void getCustomers(@Query("key") String key, Callback<List<Customer>> cb);
    //working
    @GET("/customers/{id}")
    void getCustomer(@Query("key") String key, @Path("id") String id, Callback<Customer> cb);
    //working
    @GET("/customers/{id}/accounts")
    void getCustomerAccounts(@Query("key") String key, @Path("id") String id, Callback<List<Account>> cb);
    //working
    @GET("/customers/{id}/bills")
    void getCustomerBills(@Query("key") String key, @Path("id") String id, Callback<List<Bill>> cb);
    //working
    @GET("/customers/{customer_id}/bills/{bill_id}")
    void getCustomerBill(@Query("key") String key, @Path("customer_id") String customer_id, @Path("bill_id") String bill_id, Callback<Bill> cb);
    //working
    @Headers("Content-Type: application/json")
    @PUT("/customers/{id}")
    void updateCustomer(@Query("key") String key, @Path("id") String id, @Body Customer customer, Callback<RequestResponse> cb);
    //working
    @Headers("Content-Type: application/json")
    @POST("/customers/{id}/accounts")
    void createAccount(@Query("key") String key, @Path("id") String id, @Body Account account, Callback<RequestResponse> cb);
    //working
    @GET("/branches")
    void getBranches(@Query("key") String key, Callback<List<Branch>> cb);
    //working
    @GET("/branches/{id}")
    void getBranch(@Query("key") String key, @Path("id") String id, Callback<Branch> cb);
    //working
    @GET("/atms")
    void getATMs(@Query("key") String key, Callback<List<ATM>> cb);
    //working
    @GET("/atms/{id}")
    void getATM(@Query("key") String key,@Path("id") String id, Callback<ATM> cb);
    //working
    @GET("/accounts/{id}")
    void getAccount(@Query("key") String key, @Path("id") String id, Callback<Account> cb);
    //working
    @GET("/accounts/{id}/customer")
    void getAccountCustomer(@Query("key") String key, @Path("id") String id, Callback<Customer> cb);
    //working
    @DELETE("/accounts/{id}")
    void deleteAccount(@Query("key") String key, @Path("id") String id, Callback<RequestResponse> cb);
    //working
    @Headers("Content-Type: application/json")
    @POST("/accounts/{id}/bills")
    void createBill(@Query("key") String key, @Path("id") String id, @Body Bill bill, Callback<RequestResponse> cb);
    //working
    @GET("/accounts/{account_id}/bills")
    void getBills(@Query("key") String key, @Path("account_id") String id, Callback<List<Bill>> cb);
    //working
    @GET("/accounts/{account_id}/bills/{bill_id}")
    void getBill(@Query("key") String key, @Path("account_id") String id, @Path("bill_id") String bill_id, Callback<Bill> cb);
    //working
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

    @GET("/enterprise/customers")
    void getCustomersAsEnterprise(@Query("key") String key, Callback<List<Customer>> cb);
    //working
    @GET("/enterprise/accounts")
    void getAccountsAsEnterprise(@Query("key") String key, Callback<List<Account>> cb);
    //working
    @GET("/enterprise/bills")
    void getBillsAsEnterprise(@Query("key") String key, Callback<List<Bill>> cb);
    //working
    @GET("/enterprise/transactions")
    void getTransactionsAsEnterprise(@Query("key") String key, Callback<List<Object>> cb);
    //working
    @GET("/enterprise/customers/{id}")
    void getCustomerAsEnterprise(@Query("key") String key, @Path("id") String id, Callback<Customer> cb);
    //working
    @GET("/enterprise/accounts/{id}")
    void getAccountAsEnterprise(@Query("key") String key, @Path("id") String id, Callback<Account> cb);
    //working
    @GET("/enterprise/bills/{id}")
    void getBillAsEnterprise(@Query("key") String key, @Path("id") String id, Callback<Bill> cb);
    //working
    @GET("/enterprise/transactions/{id}")
    void getTransactionAsEnterprise(@Query("key") String key, @Path("id") String id, Callback<Transaction> cb);
    //working
    @POST("/accounts/{accountId}/deposits")
    void createDeposit(@Query("key") String key, @Path("accountId") String accountId, @Body Transaction transaction, Callback<RequestResponse> cb);

    @GET("/accounts/{accountId}/deposits")
    void getDeposits(@Query("key") String key, @Path("accountId") String accountId, Callback<List<Transaction>> cb);

    @GET("/accounts/{accountId}/deposits/{depositId}")
    void getDeposit(@Query("key") String key, @Path("accountId") String accountId, @Path("depositId") String depositId, Callback<Transaction> cb);

    @PUT("/accounts/{accountId}/deposits/{depositId}")
    void updateDeposit(@Query("key") String key, @Path("accountId") String accountId, @Path("depositId") String depositId, @Body Transaction transaction, Callback<RequestResponse> cb);

    @DELETE("/accounts/{accountId}/deposits/{depositId}")
    void deleteDeposit(@Query("key") String key, @Path("accountId") String accountId, @Path("depositId") String depositId, Callback<RequestResponse> cb);

    @POST("/accounts/{accountId}/withdrawals")
    void createWithdrawal(@Query("key") String key, @Path("accountId") String accountId, @Body Transaction transaction, Callback<RequestResponse> cb);

    @GET("/accounts/{accountId}/withdrawals")
    void getWithdrawals(@Query("key") String key, @Path("accountId") String accountId, Callback<List<Transaction>> cb);

    @GET("/accounts/{accountId}/withdrawals/{withdrawalId}")
    void getWithdrawal(@Query("key") String key, @Path("accountId") String accountId, @Path("withdrawalId") String withdrawalId, Callback<Transaction> cb);

    @PUT("/accounts/{accountId}/withdrawals/{withdrawalId}")
    void updateWithdrawal(@Query("key") String key, @Path("accountId") String accountId, @Path("withdrawalId") String withdrawalId, @Body Transaction transaction, Callback<RequestResponse> cb);

    @DELETE("/accounts/{accountId}/withdrawals/{withdrawalId}")
    void deleteWithdrawal(@Query("key") String key, @Path("accountId") String accountId, @Path("withdrawalId") String depositId, Callback<RequestResponse> cb);
}
