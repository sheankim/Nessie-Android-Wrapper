package com.reimaginebanking.api.java.models;

import java.util.List;

/**
 * Created by kco942 on 4/9/15.
 */
public class ATM {
    private String _id;
    private String accessibility;
    private String name;
    private List<String> language_list;
    private List<String> hours;
    private Address address;
    private long amount_left;
    private Geocode geocode;

    public ATM(String _id, String accessibility, String name, List<String> language_list, List<String> hours, Address address, long amount_left, Geocode geocode) {
        this._id = _id;
        this.accessibility = accessibility;
        this.name = name;
        this.language_list = language_list;
        this.hours = hours;
        this.address = address;
        this.amount_left = amount_left;
        this.geocode = geocode;
    }

    public String get_id() {
        return _id;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public String getName() {
        return name;
    }

    public List<String> getLanguage_list() {
        return language_list;
    }

    public List<String> getHours() {
        return hours;
    }

    public Address getAddress() {
        return address;
    }

    public long getAmount_left() {
        return amount_left;
    }

    public Geocode getGeocode() {
        return geocode;
    }

    public void setGeocode(Geocode geocode) {
        this.geocode = geocode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ATM atm = (ATM) o;

        if (amount_left != atm.amount_left) return false;
        if (_id != null ? !_id.equals(atm._id) : atm._id != null) return false;
        if (accessibility != null ? !accessibility.equals(atm.accessibility) : atm.accessibility != null) return false;
        if (name != null ? !name.equals(atm.name) : atm.name != null) return false;
        if (language_list != null ? !language_list.equals(atm.language_list) : atm.language_list != null) return false;
        if (hours != null ? !hours.equals(atm.hours) : atm.hours != null) return false;
        return address.equals(atm.address);

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (accessibility != null ? accessibility.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (language_list != null ? language_list.hashCode() : 0);
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + address.hashCode();
        result = 31 * result + (int) (amount_left ^ (amount_left >>> 32));
        return result;
    }


}
