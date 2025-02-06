Feature: Bar functionment

  Background: Mr Pignon and Mr Leblanc go to the bar "Le Juste" which is a cocktail bar. There are only 10 seats in the bar.
    Given the bar exist
    And "Mr Pignon" exist
    And "Mr Leblanc" exist

  Scenario: Entry in the bar
    Given there is 3 people in the bar
    When Mr Pignon and Mr Leblanc enter the bar
    Then the bar contains 5 people
    
  Scenario: Command a cocktail
    Given Mr Pignon and Mr Leblanc are in the bar
    When they command the 10€ monthly cocktail
    Then the command is taken into account
  
  
  Scenario: Decide who pays
    Given Mr Pignon and Mr Leblanc are in the bar
    And they commanded the 10€ monthly cocktail
    When they pay for their own drink
    Then there is 2 additions
    
    
  --Scenario: Checking the addition
    Given Mr Pignon and Mr Leblanc are in the bar
    And they commanded the 10€ monthly cocktail
    And they decided who pays
    When they are done
    Then they will be checking the addition
    
   Scenario: Pay the addition
    Given Mr Pignon and Mr Leblanc are in the bar
    And they commanded the 10€ monthly cocktail
    And they both pay for their own drink
    And they are done drinking
    When Mr Pignon pays the addition
    Then the addition is paid
    And Mr Pignon's money will be reduced by the addition's amount.
    
  Scenario: Ask for another cocktail
    Given Mr Pignon and Mr Leblanc are in the bar
    And they commanded the 10€ monthly cocktail
    And they are done drinking
    When Mr Leblanc asks for another 10€ monthly cocktail
    Then another command is made 
    And the addition is updated
    
  Scenario: Decide who pays
    Given Mr Pignon and Mr Leblanc are in the bar
    And they commanded the 10€ monthly cocktail
    When Mr Leblanc pays for the command
    Then Mr Leblanc is the one who pays
    
  Scenario: Pay for the addition
    Given Mr Pignon and Mr Leblanc are in the bar
    And Mr Leblanc commanded 2 10€ monthly cocktail
    And Mr Leblanc pay for the drinks
    And they are done drinking
    When Mr Pignon pays the addition
    Then the addition is paid
    And Mr Pignon's money will be reduced by the addition's amount.
    
  --Scenario: Drink is finished
    When Mr Pignon and Mr Leblanc are in the bar
    And they commanded a cocktail
    And they are done
    Then they will be paying for the drink
    
