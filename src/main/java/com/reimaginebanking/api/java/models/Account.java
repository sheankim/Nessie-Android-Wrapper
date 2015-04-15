package com.reimaginebanking.api.java.models;

import java.util.List;

/**
 * Created by kco942 on 4/9/15.
 */
public class Account {

    private String _id;
    private String type;
    private String nickname;
    private int rewards;
    private int balance;
    private List<String> bill_ids;
    private String customer_id;

    public Account(String _id, String type, String nickname, int rewards, int balance, List<String> bill_ids, String customer_id) {
        this._id = _id;
        this.type = type;
        this.nickname = nickname;
        this.rewards = rewards;
        this.balance = balance;
        this.bill_ids = bill_ids;
        this.customer_id = customer_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (rewards != account.rewards) return false;
        if (balance != account.balance) return false;
        if (!_id.equals(account._id)) return false;
        if (!type.equals(account.type)) return false;
        if (!nickname.equals(account.nickname)) return false;
        if (!bill_ids.equals(account.bill_ids)) return false;
        return customer_id.equals(account.customer_id);

    }

    @Override
    public int hashCode() {
        int result = _id.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + nickname.hashCode();
        result = 31 * result + rewards;
        result = 31 * result + balance;
        result = 31 * result + bill_ids.hashCode();
        result = 31 * result + customer_id.hashCode();
        return result;
    }
}
