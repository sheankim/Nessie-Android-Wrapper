package com.reimaginebanking.api.java.models;

/**
 * Created by kco942 on 4/9/15.
 */
public class Address {

    private String state;
    private String street_number;
    private String city;
    private String street_name;
    private String zip;

    public Address(String state, String street_number, String city, String street_name, String zip) {
        this.state = state;
        this.street_number = street_number;
        this.city = city;
        this.street_name = street_name;
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!state.equals(address.state)) return false;
        if (!street_number.equals(address.street_number)) return false;
        if (!city.equals(address.city)) return false;
        if (!street_name.equals(address.street_name)) return false;
        return zip.equals(address.zip);

    }

    @Override
    public int hashCode() {
        int result = state.hashCode();
        result = 31 * result + street_number.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street_name.hashCode();
        result = 31 * result + zip.hashCode();
        return result;
    }
}
