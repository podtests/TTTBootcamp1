Feature: Validate Logic functionality

  Background:
    Given User opens the URL

  Scenario Outline: : Validate user able to login successfully
    When User fills username as "<username>"
    And User fills password as "<password>"
    And User clicks on Submit
    Then User should be able to login successfully
    Scenarios:
      | username | password |
      | akhiljda@gmail.com | Password |

  Scenario: Validate user able to login2 successfully
    When User fills credentials as "akhiljda@gmail.com" and "Password"
    Then User should be able to login successfully




