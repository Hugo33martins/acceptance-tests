Feature: Bar functionment

    Scenario: First story : Entry in the bar
      Given there are <current_client> people in the bar
      When Mr Pignon and Mr Leblanc try to enter the bar
      Then they are <expected_result> entry
      And the bar contains <new_capacity_client> people

    Examples:
      | current_client | expected_result | new_capacity_client |
      | 3              | allowed         | 5                   |
      | 8              | allowed         | 10                  |
      | 9              | refused         | 9                   |
    
    Scenario: Second story : Pay individually the addition
      Given Mr Pignon and Mr Leblanc are in the bar
      And they have commanded the 10€ 'monthly cocktail'
      And Mr Leblanc have 100€ in money
      When Mr Leblanc pays the addition
      Then the addition is paid by Mr Leblanc
      And Mr Leblanc's money will be reduced by the addition's amount to 80.

    Scenario: Third story : Pat a new command after always paid one
      Given Mr Pignon and Mr Leblanc are in the bar
      And they have commanded the 10€ 'monthly cocktail'
      And Mr Pignon have 50€ in money
      And Mr Leblanc have 50€ in money
      When Mr Pignon pays his addition
      And Mr Leblanc re-command 2 10€ 'monthly cocktail'
      And Mr Leblanc pays his addition
      Then the addition is paid for Mr Pignon and Mr Leblanc
      And Mr Leblanc's money will be reduced by the addition's amount to 20.
      And Mr Pignon's money will be reduced by the addition's amount to 40.
