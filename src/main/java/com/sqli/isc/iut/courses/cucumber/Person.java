package com.sqli.isc.iut.courses.cucumber;

import java.util.ArrayList;

public class Person{

    public String lastName;
    public int money;
    public ArrayList<Drink> addition = new ArrayList<>();
    public ArrayList<Drink> commands = new ArrayList<>();

    public Person(String leLastName, int laMoney){
        this.lastName = leLastName;
        this.money = laMoney;
    }

    public void addDrinkToAddition(Drink drink){
        addition.add(drink);
    }

    public void addDrinkToCommand(Drink drink){
        commands.add(drink);
    }

    public int getCostAddition(){
        int sumAddition = 0;
        for(Drink d : this.addition){
            sumAddition += d.getCost();
        }
        return sumAddition;
    }

    public boolean paysAddition(){
        int sumAddition = getCostAddition();
        
        if (sumAddition > this.money) return false;

        int index = 0;
        while(addition.size() < 0){
            addition.remove(index);
            index+=1;
        }

        this.money -= sumAddition;
        return true;
    }

    public String getName(){
        return this.lastName;
    }

    public int GetMoney(){
        return this.money;
    }

    public void setMoney(int laMoney){
        this.money = laMoney;
    }

    public ArrayList<Drink> getAdditionList(){
        return this.addition;
    }

    public ArrayList<Drink> getCommandList(){
        return this.commands;
    }
}