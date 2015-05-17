package com.reimaginebanking.api.java;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.reimaginebanking.api.java.Adapters.BillTypeAdapter;
import com.reimaginebanking.api.java.Models.ATM;
import com.reimaginebanking.api.java.Models.Account;
import com.reimaginebanking.api.java.Models.Bill;
import com.reimaginebanking.api.java.Models.Branch;
import com.reimaginebanking.api.java.Models.Customer;
import com.reimaginebanking.api.java.Models.RequestResponse;
import com.reimaginebanking.api.java.Models.Transaction;
import com.reimaginebanking.api.java.Requests.NessieService;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedByteArray;

/**
 * Created by kco942 on 4/9/15.
 */
public class NessieClient {

    private NessieService service;

    private String key;

    private static final NessieClient instance = new NessieClient();

    private NessieClient() {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Bill.class, new BillTypeAdapter())
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.reimaginebanking.com")
                .setConverter(new GsonConverter(gson))
                .build();

//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint("http://nessie.no-ip.org")
//                .build();

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

//    public void getCustomersAsEnterprise(final NessieResultsListener mlistener){
//        service.getCustomersAsEnterprise(this.key, new Callback<List<Customer>>() {
//            public void success(List<Customer> customers, Response response) {
//                mlistener.onSuccess(customers, null);
//            }
//
//            public void failure(RetrofitError error) {
//                mlistener.onSuccess(null, new NessieException(error));
//            }
//        });
//    }

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

    public void test(){

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

    public void getBills(String accountID, final NessieResultsListener mlistener){
        service.getBills(this.key, accountID, new Callback<List<Bill>>() {
            @Override
            public void success(List<Bill> bills, Response response) {
                mlistener.onSuccess(bills, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getBill(String accountID, String billID, final NessieResultsListener mlistener){
        service.getBill(this.key, accountID, billID, new Callback<Bill>() {
            @Override
            public void success(Bill bill, Response response) {
                mlistener.onSuccess(bill, null);
            }

            @Override
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

    public void deleteAccount(String accountID, final NessieResultsListener mlistener){
        service.deleteAccount(this.key, accountID, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                requestResponse = new RequestResponse(response.getStatus(), "Account Deleted");
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

//    public void getTransactionsAsEnterprise(final NessieResultsListener mlistener){
//        service.getTransactionsAsEnterprise(this.key, new Callback<List<Transaction>>() {
//            public void success(List<Transaction> transactions, Response response) {
//                mlistener.onSuccess(transactions, null);
//            }
//
//            public void failure(RetrofitError error) {
//                mlistener.onSuccess(null, new NessieException(error));
//            }
//        });
//    }

//    public void getTransactionsAsEnterprise(final NessieResultsListener mlistener){
//        service.getTransactionsAsEnterprise(this.key, new Callback<Object>() {
//            public void success(Object object, Response response) {
//                mlistener.onSuccess(object, null);
//            }
//
//            public void failure(RetrofitError error) {
//                mlistener.onSuccess(null, new NessieException(error));
//            }
//        });
//    }

    public void getCustomersAsEnterprise(final NessieResultsListener mlistener){
        service.getCustomersAsEnterprise(this.key, new Callback<List<Customer>>() {
            @Override
            public void success(List<Customer> customers, Response response) {
                mlistener.onSuccess(customers, null);
            }

            @Override
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

    public void getAccountsAsEnterprise(final NessieResultsListener mlistener){
        service.getAccountsAsEnterprise(this.key, new Callback<List<Account>>() {
            public void success(List<Account> accounts, Response response) {
                mlistener.onSuccess(accounts, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getBillsAsEnterprise(final NessieResultsListener mlistener){
        service.getBillsAsEnterprise(this.key, new Callback<List<Bill>>() {
            public void success(List<Bill> bills, Response response) {
                mlistener.onSuccess(bills, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getBillAsEnterprise(String billID, final NessieResultsListener mlistener){
        service.getBillAsEnterprise(this.key, billID, new Callback<Bill>() {
            public void success(Bill bill, Response response) {
                mlistener.onSuccess(bill, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getTransactionAsEnterprise(String transactionID, final NessieResultsListener mlistener){
        service.getTransactionAsEnterprise(this.key, transactionID, new Callback<Transaction>() {
            public void success(Transaction transaction, Response response) {
                mlistener.onSuccess(transaction, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void createDeposit(String accountId, Transaction deposit, final NessieResultsListener mlistener){
        service.createDeposit(this.key, accountId, deposit, new Callback<RequestResponse>() {

            @Override
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getDeposits(String accountId, final NessieResultsListener mlistener){
        service.getDeposits(this.key, accountId, new Callback<List<Transaction>>() {
            @Override
            public void success(List<Transaction> transactions, Response response) {
                mlistener.onSuccess(transactions, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getDeposit(String accountId, String depositId, final NessieResultsListener mlistener){
        service.getDeposit(this.key, accountId, depositId, new Callback<Transaction>() {
            @Override
            public void success(Transaction transaction, Response response) {
                mlistener.onSuccess(transaction, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void updateDeposit(String accountId, String depositId, Transaction deposit, final NessieResultsListener mlistener){
        service.updateDeposit(this.key, accountId, depositId, deposit, new Callback<RequestResponse>() {
            @Override
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void deleteDeposit(String accountId, String depositId, final NessieResultsListener mlistener){
        service.deleteDeposit(this.key, accountId, depositId, new Callback<RequestResponse>() {
            @Override
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void createWithdrawal(String accountId, Transaction withdrawal, final NessieResultsListener mlistener){
        service.createWithdrawal(this.key, accountId, withdrawal, new Callback<RequestResponse>() {

            @Override
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getWithdrawals(String accountId, final NessieResultsListener mlistener){
        service.getWithdrawals(this.key, accountId, new Callback<List<Transaction>>() {
            @Override
            public void success(List<Transaction> transactions, Response response) {
                mlistener.onSuccess(transactions, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getWithdrawal(String accountId, String withdrawalId, final NessieResultsListener mlistener){
        service.getWithdrawal(this.key, accountId, withdrawalId, new Callback<Transaction>() {
            @Override
            public void success(Transaction transaction, Response response) {
                mlistener.onSuccess(transaction, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void updateWithdrawal(String accountId, String withdrawalId, Transaction withdrawal, final NessieResultsListener mlistener){
        service.updateWithdrawal(this.key, accountId, withdrawalId, withdrawal, new Callback<RequestResponse>() {
            @Override
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void deleteWithdrawal(String accountId, String withdrawalId, final NessieResultsListener mlistener){
        service.deleteWithdrawal(this.key, accountId, withdrawalId, new Callback<RequestResponse>() {
            @Override
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }
}
