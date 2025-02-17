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
      | 0              | allowed         | 2                   |
      | 7              | allowed         | 9                   |
      | 9              | refused         | 9                   |
      | 10             | refused         | 10                  |