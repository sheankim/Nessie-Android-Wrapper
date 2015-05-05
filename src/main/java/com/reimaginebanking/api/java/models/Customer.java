package com.reimaginebanking.api.java.models;

import java.util.List;

/**
 * Created by kco942 on 4/9/15.
 */
public class Customer {
    private String _id;
    private String first_name;
    private String last_name;
    private Address address;
    private List<String> account_ids;


    public Customer(String _id, String first_name, String last_name, Address address, List<String> account_ids) {
        this._id = _id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.account_ids = account_ids;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getAccount_ids() {
        return account_ids;
    }

    public void setAccount_ids(List<String> account_ids) {
        this.account_ids = account_ids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (_id != null ? !_id.equals(customer._id) : customer._id != null) return false;
        if (first_name != null ? !first_name.equals(customer.first_name) : customer.first_name != null)
            return false;
        if (last_name != null ? !last_name.equals(customer.last_name) : customer.last_name != null)
            return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null)
            return false;
        return !(account_ids != null ? !account_ids.equals(customer.account_ids) : customer.account_ids != null);

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (account_ids != null ? account_ids.hashCode() : 0);
        return result;
    }
}