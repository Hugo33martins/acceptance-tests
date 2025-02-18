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
    private Person leblanc = new Person("Leblanc", 100);
    private Person pignon = new Person("Pignon", 100);

    @Given("the bar exist")
    public void the_bar_exist() {
        bar = new Bar("Le Juste", 10);
    }

    @Given("Mr {string} exist")
    public void mr_exist(String name) {
        people.add(new Person(name, 30));
    }

    /**
     * Test for capacity of the bar and if they are allowed to enter
     */

    @Given("there are {int} people in the bar")
    public void there_are_people_in_the_bar(int number){
        for(int i = 0; i < number; i++){
            bar.enterInBar(new Person("Mr"+i, 10));
        }
    }

    @When("Mr Pignon and Mr Leblanc try to enter the bar")
    public void mr_pignon_and_mr_leblanc_try_to_enter() {
        ArrayList<Person> clients = new ArrayList<>();
        clients.add(pignon);
        clients.add(leblanc);
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

    /**
     * Test for commanding a drink
     */

    @Given("Mr Pignon and Mr Leblanc are in the bar")
    public void mr_pignon_and_mr_leblanc_are_in_the_bar(){
        bar.enterInBar(leblanc);
        bar.enterInBar(pignon);
    }

    @When("they commanded the {int}€ {string}")
    public void they_commanded_the_€(Integer cost, String name) {
        pignon.addDrinkToCommand(new Drink(name, cost));
        leblanc.addDrinkToCommand(new Drink(name, cost));
    }

    @Then("the command is taken into both account")
    public void the_command_is_taken_into_both_account() {
        ArrayList<Drink> drinksCommandLeblanc = leblanc.getCommandList();
        assertTrue(drinksCommandLeblanc.get(drinksCommandLeblanc.size()-1).getName().equals("monthly cocktail"));

        ArrayList<Drink> drinksCommandPignon = pignon.getCommandList();
        assertTrue(drinksCommandPignon.get(drinksCommandPignon.size()-1).getName().equals("monthly cocktail"));
    }

    /**
     * Test for paying the addition
     */

    @Given("they have commanded the {int}€ {string}")
    public void they_have_commanded_the_€(Integer cost, String name){
        pignon.addDrinkToCommand(new Drink(name, cost));
        leblanc.addDrinkToCommand(new Drink(name, cost));
    }

    @Given("decided that Mr Leblanc will pay the addition")
    public void decided_that_mr_leblanc_will_pay_the_addition(){
        for(Drink drink : pignon.getCommandList()){
            leblanc.addDrinkToAddition(drink);
        }
        for(Drink drink : leblanc.getCommandList()){
            leblanc.addDrinkToAddition(drink);
        }
    }

    @When("Mr Leblanc pays the addition")
    public void mr_leblanc_pays_the_addition(){
        result = leblanc.paysAddition();
    }

    @Then("the addition is paid")
    public void the_addition_is_paid(){
        assertTrue(result);
    }

    @Then("Mr Leblanc's money will be reduced by the addition's amount.")
    public void mr_leblanc_s_money_will_be_reduced_by_the_addition_s_amount() {
        assertEquals(80, leblanc.GetMoney());
    }
}