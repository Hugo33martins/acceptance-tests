package com.sqli.isc.iut.courses.cucumber;

public class Drink{

    public String name;
    public int cost;

    public Drink(String leName, int leCost){
        this.name = leName;
        this.cost = leCost;
    }

    public String getName(){
        return this.name;
    }

    public int getCost(){
        return this.cost;
    }
}