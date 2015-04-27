package com.reimaginebanking.api.java;


import com.reimaginebanking.api.java.models.ATM;
import com.reimaginebanking.api.java.models.Account;
import com.reimaginebanking.api.java.models.Bill;
import com.reimaginebanking.api.java.models.Branch;
import com.reimaginebanking.api.java.models.Customer;
import com.reimaginebanking.api.java.models.RequestResponse;
import com.reimaginebanking.api.java.models.Transaction;
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

    //private final String enterpriseKey;
    //private final String customerKey;
    private NessieResultsListener mlistener;
    private NessieService service;

    private String key;

    private static final NessieClient instance = new NessieClient();

    private NessieClient() {
        /**this.enterpriseKey = enterpriseKey;
        this.customerKey = customerKey;
        this.key = customerKey;**/

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.reimaginebanking.com")
                .build();

        service = restAdapter.create(NessieService.class);

    }

    public static NessieClient getInstance(){
        return instance;
    }

    public void setNessieResultsListener(NessieResultsListener observer){
        mlistener = observer;
    }

    public void setAPIKey(String key){
        this.key = key;
    }
    public void getCustomers(){
        service.getCustomers(this.key, new Callback<List<Customer>>() {
            public void success(List<Customer> customers, Response response) {
                mlistener.onSuccess(NessieType.CUSTOMERS, customers);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void getCustomer(String customerID){
        service.getCustomer(this.key, customerID, new Callback<Customer>() {
            public void success(Customer customer, Response response) {
                mlistener.onSuccess(NessieType.CUSTOMER, customer);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void getCustomerAccounts(String customerID){
        service.getCustomerAccounts(this.key, customerID, new Callback<List<Account>>() {
            public void success(List<Account> accounts, Response response) {
                mlistener.onSuccess(NessieType.ACCOUNTS, accounts);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void getCustomerBills(String customerID){
        service.getCustomerBills(this.key, customerID, new Callback<List<Bill>>() {
            public void success(List<Bill> bills, Response response) {
                mlistener.onSuccess(NessieType.BILLS, bills);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void getCustomerBill(String customerID, String billID){
        service.getCustomerBill(this.key, customerID, billID, new Callback<Bill>() {
            public void success(Bill bill, Response response) {
                mlistener.onSuccess(NessieType.BILL, bill);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void updateCustomer(String customerID, Customer updatedCustomer){
        service.updateCustomer(this.key, customerID, updatedCustomer, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(NessieType.RESPONSE, requestResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void createAccount(String customerID, Account newAccount){
        service.createAccount(this.key, customerID, newAccount, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(NessieType.RESPONSE, requestResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void getBranches(){
        service.getBranches(this.key, new Callback<List<Branch>>() {
            public void success(List<Branch> branches, Response response) {
                mlistener.onSuccess(NessieType.BRANCHES, branches);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void getBranch(String branchID){
        service.getBranch(this.key, branchID, new Callback<Branch>() {
            public void success(Branch branch, Response response) {
                mlistener.onSuccess(NessieType.BRANCH, branch);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }
    public void getATMs(){
        System.out.println("CLIENT");
        System.out.println(Thread.currentThread().getId());
        service.getATMs(this.key, new Callback<List<ATM>>() {
            public void success(List<ATM> atms, Response response) {
                System.out.println("CLIENT CALLBACK");
                System.out.println(Thread.currentThread().getId());
                mlistener.onSuccess(NessieType.ATMS, atms);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void getATM(String atmID){
        service.getATM(this.key, atmID, new Callback<ATM>() {
            public void success(ATM atm, Response response) {
                mlistener.onSuccess(NessieType.ATM, atm);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void getAccount(String accountID){
        service.getAccount(this.key, accountID, new Callback<Account>() {
            public void success(Account account, Response response) {
                mlistener.onSuccess(NessieType.ACCOUNT, account);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void getAccountCustomer(String accountID){
        service.getAccountCustomer(this.key, accountID, new Callback<Customer>() {
            public void success(Customer customer, Response response) {
                mlistener.onSuccess(NessieType.CUSTOMER, customer);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void deleteAccount(String accountID){
        service.deleteAccount(this.key, accountID, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(NessieType.RESPONSE, requestResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void createBill(String accountID, Bill newBill){
        service.createBill(this.key, accountID, newBill, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(NessieType.RESPONSE, requestResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void updateBill(String accountID, String billID, Bill updatedBill){
        service.updateBill(this.key, accountID, billID, updatedBill, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(NessieType.RESPONSE, requestResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void createTransaction(String accountID, Transaction newTransaction){
        service.createTransaction(this.key, accountID, newTransaction, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(NessieType.RESPONSE, requestResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void getTransactions(String accountID){
        service.getTransactions(this.key, accountID, new Callback<List<Transaction>>() {
            public void success(List<Transaction> transactions, Response response) {
                mlistener.onSuccess(NessieType.TRANSACTIONS, transactions);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void getTransaction(String accountID, String transactionID){
        service.getTransaction(this.key, accountID, transactionID, new Callback<Transaction>() {
            public void success(Transaction transaction, Response response) {
                mlistener.onSuccess(NessieType.TRANSACTION, transaction);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void updateTransaction(String accountID, String transactionID, Transaction updatedTransaction){
        service.updateTransaction(this.key, accountID, transactionID, updatedTransaction, new Callback<Transaction>() {
            public void success(Transaction transaction, Response response) {
                mlistener.onSuccess(NessieType.TRANSACTION, transaction);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }

    public void deleteTransaction(String accountID, String transactionID){
        service.deleteTransaction(this.key, accountID, transactionID, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(NessieType.RESPONSE, requestResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieException(error));
            }
        });
    }
}
