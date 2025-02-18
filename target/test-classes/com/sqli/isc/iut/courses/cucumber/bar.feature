Feature: Bar functionment

  Background: Mr Pignon and Mr Leblanc go to the bar "Le Juste" which is a cocktail bar. There are only 10 seats in the bar.
    Given the bar exist
    And Mr 'Pignon' exist
    And Mr 'Leblanc' exist

    Scenario: Entry in the bar
      Given there are <current_client> people in the bar
      When Mr Pignon and Mr Leblanc try to enter the bar
      Then they are <expected_result> entry
      And the bar contains <new_capacity_client> people

    Examples:
      | current_client | expected_result | new_capacity_client |
      | 3              | allowed         | 5                   |
      | 8              | allowed         | 10                  |
      | 9              | refused         | 9                   |

    Scenario: Command a cocktail
      Given Mr Pignon and Mr Leblanc are in the bar
      When they commanded the 10€ 'monthly cocktail'
      Then the command is taken into both account
    
    Scenario: Pay the addition
      Given Mr Pignon and Mr Leblanc are in the bar
      And they have commanded the 10€ 'monthly cocktail'
      And decided that Mr Leblanc will pay the addition
      When Mr Leblanc pays the addition
      Then the addition is paid
      And Mr Leblanc's money will be reduced by the addition's amount.