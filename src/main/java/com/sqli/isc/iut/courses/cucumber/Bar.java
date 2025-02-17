package com.sqli.isc.iut.courses.cucumber;

import java.util.ArrayList;

public class Bar{

    public ArrayList<Person> people;
    public int capacity;
    public String name;

    public Bar(String leName, int laCapacity){
        this.capacity = laCapacity;
        this.name = leName;
        this.people = new ArrayList<>();
    }

    public boolean enterInBar(Person p){
        if (people.size() == capacity){
            return false;
        } else{
            people.add(p);
            return true;
        }
    }

    public boolean groupEnterInBar(ArrayList<Person> clients){
        if (capacity < clients.size() + people.size()){
            return false;
        } else {
            for(Person client : clients){
                people.add(client);
            }
            return true;
        }
    }

    public int getNumberClients(){
        return people.size();
    }
}