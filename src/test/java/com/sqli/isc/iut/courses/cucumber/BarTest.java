package com.sqli.isc.iut.courses.cucumber;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BarTest{

	private Bar bar;
    private ArrayList<Person> people = new ArrayList<>();
    private boolean result;

    @Given("the bar exist")
    public void the_bar_exist() {
        bar = new Bar("Le Juste", 10);
    }

    @Given("Mr {string} exist")
    public void mr_exist(String name) {
        people.add(new Person(name, 30));
    }

    @Given("there are {int} people in the bar")
    public void there_are_people_in_the_bar(int number){
        for(int i = 0; i < number; i++){
            bar.enterInBar(new Person("Mr"+i, 10));
        }
    }

    @When("Mr Pignon and Mr Leblanc try to enter the bar")
    public void mr_pignon_and_mr_leblanc_try_to_enter() {
        ArrayList<Person> clients = new ArrayList<>();
        clients.add(new Person("Pignon", 10));
        clients.add(new Person("Leblanc", 10));
        result = bar.groupEnterInBar(clients);
    }

    @Then("they are refused entry")
    public void they_are_refused_entry(){
        assertFalse(result);
    }

    @Then("they are allowed entry")
    public void they_are_allowed_entry(){
        assertTrue(result);
    }

    @Then("the bar contains {int} people")
    public void the_bar_contains_people(int capacity){
        assertEquals(capacity, bar.getNumberClients());
    }

}