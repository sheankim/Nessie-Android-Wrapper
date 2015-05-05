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

    private NessieService service;

    private String key;

    private static final NessieClient instance = new NessieClient();

    private NessieClient() {

//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint("http://api.reimaginebanking.com")
//                .build();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://nessie.no-ip.org")
                .build();

        service = restAdapter.create(NessieService.class);

    }

    public static NessieClient getInstance(){
        return instance;
    }

    public void setAPIKey(String key){
        this.key = key;
    }

    public void getCustomers(final NessieResultsListener mlistener){
        service.getCustomers(this.key, new Callback<List<Customer>>() {
            public void success(List<Customer> customers, Response response) {
                mlistener.onSuccess(customers, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getCustomersAsEnterprise(final NessieResultsListener mlistener){
        service.getCustomersAsEnterprise(this.key, new Callback<List<Customer>>() {
            public void success(List<Customer> customers, Response response) {
                mlistener.onSuccess(customers, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getCustomer(String customerID, final NessieResultsListener mlistener){
        service.getCustomer(this.key, customerID, new Callback<Customer>() {
            public void success(Customer customer, Response response) {
                mlistener.onSuccess(customer, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getCustomerAsEnterprise(String customerID, final NessieResultsListener mlistener){
        service.getCustomerAsEnterprise(this.key, customerID, new Callback<Customer>() {
            public void success(Customer customer, Response response) {
                mlistener.onSuccess(customer, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }
    public void getCustomerAccounts(String customerID, final NessieResultsListener mlistener){
        service.getCustomerAccounts(this.key, customerID, new Callback<List<Account>>() {
            public void success(List<Account> accounts, Response response) {
                mlistener.onSuccess(accounts, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getCustomerAccountsAsEnterprise(String customerID, final NessieResultsListener mlistener){
        service.getCustomerAccountsAsEnterprise(this.key, customerID, new Callback<List<Account>>() {
            public void success(List<Account> accounts, Response response) {
                mlistener.onSuccess(accounts, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getCustomerBills(String customerID, final NessieResultsListener mlistener){
        service.getCustomerBills(this.key, customerID, new Callback<List<Bill>>() {
            public void success(List<Bill> bills, Response response) {
                mlistener.onSuccess(bills, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getCustomerBillsAsEnterprise(String customerID, final NessieResultsListener mlistener){
        service.getCustomerBillsAsEnterprise(this.key, customerID, new Callback<List<Bill>>() {
            public void success(List<Bill> bills, Response response) {
                mlistener.onSuccess(bills, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getCustomerBill(String customerID, String billID, final NessieResultsListener mlistener){
        service.getCustomerBill(this.key, customerID, billID, new Callback<Bill>() {
            public void success(Bill bill, Response response) {
                mlistener.onSuccess(bill, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getCustomerBillAsEnterprise(String customerID, String billID, final NessieResultsListener mlistener){
        service.getCustomerBillAsEnterprise(this.key, customerID, billID, new Callback<Bill>() {
            public void success(Bill bill, Response response) {
                mlistener.onSuccess(bill, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void updateCustomer(String customerID, Customer updatedCustomer, final NessieResultsListener mlistener){
        service.updateCustomer(this.key, customerID, updatedCustomer, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void createAccount(String customerID, Account newAccount, final NessieResultsListener mlistener){
        service.createAccount(this.key, customerID, newAccount, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getBranches(final NessieResultsListener mlistener){
        service.getBranches(this.key, new Callback<List<Branch>>() {
            public void success(List<Branch> branches, Response response) {
                mlistener.onSuccess(branches, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getBranch(String branchID, final NessieResultsListener mlistener){
        service.getBranch(this.key, branchID, new Callback<Branch>() {
            public void success(Branch branch, Response response) {
                mlistener.onSuccess(branch, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }
    public void getATMs(final NessieResultsListener mlistener){
        service.getATMs(this.key, new Callback<List<ATM>>() {
            public void success(List<ATM> atms, Response response) {
                mlistener.onSuccess(atms, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getATM(String atmID, final NessieResultsListener mlistener){
        service.getATM(this.key, atmID, new Callback<ATM>() {
            public void success(ATM atm, Response response) {
                mlistener.onSuccess(atm, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getAccount(String accountID, final NessieResultsListener mlistener){
        service.getAccount(this.key, accountID, new Callback<Account>() {
            public void success(Account account, Response response) {
                mlistener.onSuccess(account, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getAccountAsEnterprise(String accountID, final NessieResultsListener mlistener){
        service.getAccountAsEnterprise(this.key, accountID, new Callback<Account>() {
            public void success(Account account, Response response) {
                mlistener.onSuccess(account, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getAccountCustomer(String accountID, final NessieResultsListener mlistener){
        service.getAccountCustomer(this.key, accountID, new Callback<Customer>() {
            public void success(Customer customer, Response response) {
                mlistener.onSuccess(customer, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getAccountCustomerAsEnterprise(String accountID, final NessieResultsListener mlistener){
        service.getAccountCustomerAsEnterprise(this.key, accountID, new Callback<Customer>() {
            public void success(Customer customer, Response response) {
                mlistener.onSuccess(customer, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void deleteAccount(String accountID, final NessieResultsListener mlistener){
        service.deleteAccount(this.key, accountID, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void createBill(String accountID, Bill newBill, final NessieResultsListener mlistener){
        service.createBill(this.key, accountID, newBill, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void updateBill(String accountID, String billID, Bill updatedBill, final NessieResultsListener mlistener){
        service.updateBill(this.key, accountID, billID, updatedBill, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void createTransaction(String accountID, Transaction newTransaction, final NessieResultsListener mlistener){
        service.createTransaction(this.key, accountID, newTransaction, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getTransactions(String accountID, final NessieResultsListener mlistener){
        service.getTransactions(this.key, accountID, new Callback<List<Transaction>>() {
            public void success(List<Transaction> transactions, Response response) {
                mlistener.onSuccess(transactions, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getTransactionsAsEnterprise(String accountID, final NessieResultsListener mlistener){
        service.getTransactionsAsEnterprise(this.key, accountID, new Callback<List<Transaction>>() {
            public void success(List<Transaction> transactions, Response response) {
                mlistener.onSuccess(transactions, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getTransaction(String accountID, String transactionID, final NessieResultsListener mlistener){
        service.getTransaction(this.key, accountID, transactionID, new Callback<Transaction>() {
            public void success(Transaction transaction, Response response) {
                mlistener.onSuccess(transaction, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getTransactionAsEnterprise(String accountID, String transactionID, final NessieResultsListener mlistener){
        service.getTransactionAsEnterprise(this.key, accountID, transactionID, new Callback<Transaction>() {
            public void success(Transaction transaction, Response response) {
                mlistener.onSuccess(transaction, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void updateTransaction(String accountID, String transactionID, Transaction updatedTransaction, final NessieResultsListener mlistener){
        service.updateTransaction(this.key, accountID, transactionID, updatedTransaction, new Callback<Transaction>() {
            public void success(Transaction transaction, Response response) {
                mlistener.onSuccess(transaction, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void deleteTransaction(String accountID, String transactionID, final NessieResultsListener mlistener){
        service.deleteTransaction(this.key, accountID, transactionID, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }
}
