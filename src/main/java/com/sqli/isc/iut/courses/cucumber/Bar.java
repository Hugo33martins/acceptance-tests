package com.sqli.isc.iut.courses.cucumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bar{

    public ArrayList<Person> people;
    public int capacity;
    public String name;
    public Map<Person, ArrayList<Drink>> command;
    public Map<Person, ArrayList<Drink>> addition;

    public Bar(String leName, int laCapacity){
        this.capacity = laCapacity;
        this.name = leName;
        this.people = new ArrayList<>();
        this.command = new HashMap<>();
        this.addition = new HashMap<>();
    }

    public boolean enterInBar(Person p){
        if (people.size() == capacity || people.contains(p)){
            return false;
        } else{
            people.add(p);
            command.put(p, new ArrayList<>());
            addition.put(p, new ArrayList<>());
            return true;
        }
    }

    public boolean groupEnterInBar(ArrayList<Person> clients){
        if (capacity < clients.size() + people.size()){
            return false;
        } else {
            for(Person client : clients){
                if (people.contains(client)){
                    return false;
                }
                people.add(client);
                command.put(client, new ArrayList<>());
                addition.put(client, new ArrayList<>());
            }
            return true;
        }
    }

    public int getNumberClients(){
        return people.size();
    }
}