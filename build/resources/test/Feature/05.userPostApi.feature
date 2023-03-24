Feature: User Registration
  @Test
  Scenario Outline: check user registration successfully
    Given user got the api '<path>'
    When user hit '<name>' and '<job>'
    And call the api with body
    Then it will return valid response

    Examples:
      | path  | name    | job |
      | users | riyadh  | qa  |

