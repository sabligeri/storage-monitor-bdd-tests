Feature: User Registration

  Scenario Outline: Successful and unsuccessful registration attempts
    Given I open the register page
    When I register with username "<username>" and password "<password>"
    Then registration result should be "<expectedResult>"

    Examples:
      | username | password          | expectedResult |
      |          |                   | false          |
      | John     | Doe               | false          |
      | Jane     |                   | false          |
      |          | password          | false          |
      | Jason    | CorrectPassword1  | true           |


  Scenario Outline: Password validation messages
    Given I open the register page
    When I register with username "baseUser" and password "<password>"
    Then I should see a password validation message containing "<expectedMessagePart>"

    Examples:
      | password        | expectedMessagePart                                   |
      | short           | Password must be at least 8 characters long           |
      | alllowercase1   | Password must include at least one uppercase letter    |
      | ALLUPPERCASE    | Password must include at least one number             |

  Scenario: “Login here” link navigates to login page
    Given I open the register page
    When I click the login-here link
    Then I should be redirected to login page
