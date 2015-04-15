package com.reimaginebanking.api.java.models;

import java.util.List;

/**
 * Created by kco942 on 4/9/15.
 */
public class Branch {
    private String _id;
    private String name;
    private Address address;
    private String phone_number;
    private List<String> hours;

    public Branch(String _id, String name, Address address, String phone_number, List<String> hours) {
        this._id = _id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        if (!_id.equals(branch._id)) return false;
        if (!name.equals(branch.name)) return false;
        if (address != null ? !address.equals(branch.address) : branch.address != null) return false;
        if (phone_number != null ? !phone_number.equals(branch.phone_number) : branch.phone_number != null)
            return false;
        return !(hours != null ? !hours.equals(branch.hours) : branch.hours != null);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * _id.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone_number != null ? phone_number.hashCode() : 0);
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        return result;
    }
}
