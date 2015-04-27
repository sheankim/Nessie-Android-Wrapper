package com.reimaginebanking.api.java.models;

/**
 * Created by kco942 on 4/9/15.
 */
public class Transaction {
    private String _id;
    private String transaction_date;
    private String status;
    private String transaction_type;
    private String payer_id;
    private String payee_id;
    private int amount;

    public Transaction(String _id, String transaction_date, String status, String transaction_type, String payer_id, String payee_id, int amount) {
        this._id = _id;
        this.transaction_date = transaction_date;
        this.status = status;
        this.transaction_type = transaction_type;
        this.payer_id = payer_id;
        this.payee_id = payee_id;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(String payer_id) {
        this.payer_id = payer_id;
    }

    public String getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(String payee_id) {
        this.payee_id = payee_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (amount != that.amount) return false;
        if (_id != null ? !_id.equals(that._id) : that._id != null) return false;
        if (transaction_date != null ? !transaction_date.equals(that.transaction_date) : that.transaction_date != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (transaction_type != null ? !transaction_type.equals(that.transaction_type) : that.transaction_type != null)
            return false;
        if (payer_id != null ? !payer_id.equals(that.payer_id) : that.payer_id != null)
            return false;
        return !(payee_id != null ? !payee_id.equals(that.payee_id) : that.payee_id != null);

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (transaction_date != null ? transaction_date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (transaction_type != null ? transaction_type.hashCode() : 0);
        result = 31 * result + (payer_id != null ? payer_id.hashCode() : 0);
        result = 31 * result + (payee_id != null ? payee_id.hashCode() : 0);
        result = 31 * result + amount;
        return result;
    }
}
