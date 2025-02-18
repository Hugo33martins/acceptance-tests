package com.sqli.isc.iut.courses.cucumber;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BarTest{

	public Bar bar = new Bar("Le Juste", 10);;
    public ArrayList<Person> people = new ArrayList<>();
    public boolean resultLeblanc;
    public boolean resultPignon;
    public boolean resultCapacityBar;
    public Person leblanc = new Person("Leblanc", 100);
    public Person pignon = new Person("Pignon", 100);

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
        resultCapacityBar = bar.groupEnterInBar(clients);
    }

    @Then("they are refused entry")
    public void they_are_refused_entry(){
        assertFalse(resultCapacityBar);
    }

    @Then("they are allowed entry")
    public void they_are_allowed_entry(){
        assertTrue(resultCapacityBar);
    }

    @Then("the bar contains {int} people")
    public void the_bar_contains_people(int capacity){
        assertEquals(capacity, bar.getNumberClients());
    }

    @Given("Mr Pignon and Mr Leblanc are in the bar")
    public void mr_pignon_and_mr_leblanc_are_in_the_bar(){
        bar.enterInBar(leblanc);
        bar.enterInBar(pignon);
    }

    @Given("they have commanded the {int}€ {string}")
    public void they_have_commanded_the_€(Integer cost, String name){
        pignon.addDrinkToCommand(new Drink(name, cost));
        leblanc.addDrinkToCommand(new Drink(name, cost));
    }

    @Given("Mr Leblanc have {int}€ in money")
    public void mr_Leblanc_have_€_in_money(Integer money){
        leblanc.setMoney(money);
    }

    @Given("Mr Pignon have {int}€ in money")
    public void mr_pignon_have_€_in_money(Integer money){
        pignon.setMoney(money);
    }

    @When("Mr Leblanc pays the addition")
    public void mr_leblanc_pays_the_addition(){
        for(Drink drink : pignon.getCommandList()){
            leblanc.addDrinkToAddition(drink);
        }
        for(Drink drink : leblanc.getCommandList()){
            leblanc.addDrinkToAddition(drink);
        }
        resultLeblanc = leblanc.paysAddition();
    }

    @When("Mr Leblanc pays his addition")
    public void mr_leblanc_pays_his_addition(){
        for(Drink drink : leblanc.getCommandList()){
            leblanc.addDrinkToAddition(drink);
        }
        resultLeblanc = leblanc.paysAddition();
    }

    @When("Mr Pignon pays his addition")
    public void mr_pignon_pays_his_addition(){
        for(Drink drink : pignon.getCommandList()){
            pignon.addDrinkToAddition(drink);
        }
        resultPignon = pignon.paysAddition();
    }


    @When("Mr Leblanc re-command {int} {int}€ {string}")
    public void mr_leblanc_re_command_€(Integer quantity, Integer cost, String name) {
        for(int i = 0; i < quantity; i++){
            leblanc.addDrinkToCommand(new Drink(name, cost));
        }
    }


    @Then("the addition is paid by Mr Leblanc")
    public void the_addition_is_paid_by_mr_leblanc(){
        assertTrue(resultLeblanc);
    }


    @Then("the addition is paid for Mr Pignon and Mr Leblanc")
    public void the_addition_is_paid_for_mr_pignon_and_mr_leblanc() {
        assertTrue(resultLeblanc);
        assertTrue(resultPignon);
    }


    @Then("Mr Leblanc's money will be reduced by the addition's amount to {int}.")
    public void mr_leblanc_s_money_will_be_reduced_by_the_addition_s_amount_to(Integer amountExcepted) {
        assertEquals(amountExcepted, leblanc.GetMoney());
    }

    @Then("Mr Pignon's money will be reduced by the addition's amount to {int}.")
    public void mr_pignon_s_money_will_be_reduced_by_the_addition_s_amount_to(Integer amountExcepted) {
        assertEquals(amountExcepted, pignon.GetMoney());
    }
}