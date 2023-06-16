package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int sum = 0;
        for (AccountRecord record : charges) {
            sum += record.getCharge();
        }
        return sum;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
//        return "Customer ID" + id + name + this.getBalance();
        return "Customer ID: " + id + "\n" + "Customer Name: " + name + "\n" + "Balance: " + this.getBalance();
    }
}
