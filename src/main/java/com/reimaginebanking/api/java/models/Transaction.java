package com.reimaginebanking.api.java.Models;

import com.reimaginebanking.api.java.Constants.TransactionMedium;
import com.reimaginebanking.api.java.Constants.TransactionType;

/**
 * Created by kco942 on 4/9/15.
 */
public class Transaction {
    private String _id;
    private String transaction_date;
    private String status;
    private TransactionType type;
    private TransactionMedium medium;
    private String payer_id;
    private String payee_id;
    private double amount;
    private String description;

    public Transaction(Builder builder){
        this.medium = builder.medium;
        this.payee_id = builder.payee_id;
        this.amount = builder.amount;
        this.description = builder.description;

    }

    public Transaction(String _id, String transaction_date, String status, TransactionType type, TransactionMedium medium, String payer_id, String payee_id, double amount, String description) {
        this._id = _id;
        this.transaction_date = transaction_date;
        this.status = status;
        this.type = type;
        this.medium = medium;
        this.payer_id = payer_id;
        this.payee_id = payee_id;
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String get_id() {
        return _id;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public String getStatus() {
        return status;
    }

    public TransactionType getType() {
        return type;
    }

    public TransactionMedium getMedium(){
        return medium;
    }

    public String getPayer_id() {
        return payer_id;
    }

    public String getPayee_id() {
        return payee_id;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "_id='" + _id + '\'' +
                ", transaction_date='" + transaction_date + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", payer_id='" + payer_id + '\'' +
                ", payee_id='" + payee_id + '\'' +
                ", amount=" + amount +
                ", description=" + description +
                '}';
    }

    public static class Builder{
        private TransactionType type;
        private String payee_id;
        private double amount;
        private TransactionMedium medium;
        private String description;

        public Builder(){}

        public Builder type(TransactionType type){
            this.type = type;
            return this;
        }

        public Builder medium(TransactionMedium medium){
            this.medium = medium;
            return this;
        }
        public Builder payee_id(String payee_id){
            this.payee_id = payee_id;
            return this;
        }

        public Builder amount(double amount){
            this.amount = amount;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Transaction build(){
            Transaction transaction = new Transaction(this);
            return transaction;
        }
    }
}
