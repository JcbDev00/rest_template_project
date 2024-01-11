package com.jakub_szalkowski.project.controllers.models;


public class Expense {

    private long id;
    private String title;
    private double  amount;

    public String getTitle() 
    {
        return title;
    }

    public long getId(){
        return id;
    }
    public void setId(long id) 
    {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() 
    {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
