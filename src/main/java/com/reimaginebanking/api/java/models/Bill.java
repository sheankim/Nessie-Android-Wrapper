package com.reimaginebanking.api.java.models;

/**
 * Created by kco942 on 4/9/15.
 */
public class Bill {
    private String _id;
    private String status;
    private String payee;
    private String nickename;
    private String creation_date;
    private String payment_date;
    private int recurring_date;
    private String upcoming_payment_date;
    private int payment_amount;

    public Bill(String _id, String status, String payee, String nickename, String creation_date, String payment_date, int recurring_date, String upcoming_payment_date, int payment_amount) {
        this._id = _id;
        this.status = status;
        this.payee = payee;
        this.nickename = nickename;
        this.creation_date = creation_date;
        this.payment_date = payment_date;
        this.recurring_date = recurring_date;
        this.upcoming_payment_date = upcoming_payment_date;
        this.payment_amount = payment_amount;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getNickename() {
        return nickename;
    }

    public void setNickename(String nickename) {
        this.nickename = nickename;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public int getRecurring_date() {
        return recurring_date;
    }

    public void setRecurring_date(int recurring_date) {
        this.recurring_date = recurring_date;
    }

    public String getUpcoming_payment_date() {
        return upcoming_payment_date;
    }

    public void setUpcoming_payment_date(String upcoming_payment_date) {
        this.upcoming_payment_date = upcoming_payment_date;
    }

    public int getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(int payment_amount) {
        this.payment_amount = payment_amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (recurring_date != bill.recurring_date) return false;
        if (payment_amount != bill.payment_amount) return false;
        if (_id != null ? !_id.equals(bill._id) : bill._id != null) return false;
        if (status != null ? !status.equals(bill.status) : bill.status != null) return false;
        if (payee != null ? !payee.equals(bill.payee) : bill.payee != null) return false;
        if (nickename != null ? !nickename.equals(bill.nickename) : bill.nickename != null)
            return false;
        if (creation_date != null ? !creation_date.equals(bill.creation_date) : bill.creation_date != null)
            return false;
        if (payment_date != null ? !payment_date.equals(bill.payment_date) : bill.payment_date != null)
            return false;
        return !(upcoming_payment_date != null ? !upcoming_payment_date.equals(bill.upcoming_payment_date) : bill.upcoming_payment_date != null);

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (payee != null ? payee.hashCode() : 0);
        result = 31 * result + (nickename != null ? nickename.hashCode() : 0);
        result = 31 * result + (creation_date != null ? creation_date.hashCode() : 0);
        result = 31 * result + (payment_date != null ? payment_date.hashCode() : 0);
        result = 31 * result + recurring_date;
        result = 31 * result + (upcoming_payment_date != null ? upcoming_payment_date.hashCode() : 0);
        result = 31 * result + payment_amount;
        return result;
    }
}
