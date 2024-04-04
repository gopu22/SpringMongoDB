package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bankdata")
public class Banking {

    @Id
    private int accno;
    private String name;
    private double balance;
    private String address;

    public Banking() {
    }

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Banking{" +
                "accno=" + accno +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", address='" + address + '\'' +
                '}';
    }

}
