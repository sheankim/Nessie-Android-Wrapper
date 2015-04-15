package com.reimaginebanking.api.java.models;

/**
 * Created by kco942 on 4/9/15.
 */
public class Bill {
    private String _id;
    private String status;
    private String creation_date;
    private String payment_date;
    private int recurring_date;
    private String upcoming_payment_date;
    private int payment_amount;

    public Bill(String _id, String status, String creation_date, String payment_date, int recurring_date, String upcoming_payment_date, int payment_amount) {
        this._id = _id;
        this.status = status;
        this.creation_date = creation_date;
        this.payment_date = payment_date;
        this.recurring_date = recurring_date;
        this.upcoming_payment_date = upcoming_payment_date;
        this.payment_amount = payment_amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (recurring_date != bill.recurring_date) return false;
        if (payment_amount != bill.payment_amount) return false;
        if (!_id.equals(bill._id)) return false;
        if (!status.equals(bill.status)) return false;
        if (!creation_date.equals(bill.creation_date)) return false;
        if (!payment_date.equals(bill.payment_date)) return false;
        return upcoming_payment_date.equals(bill.upcoming_payment_date);

    }

    @Override
    public int hashCode() {
        int result = _id.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + creation_date.hashCode();
        result = 31 * result + payment_date.hashCode();
        result = 31 * result + recurring_date;
        result = 31 * result + upcoming_payment_date.hashCode();
        result = 31 * result + payment_amount;
        return result;
    }
}
