Feature: OpenAccount

  @test1
  Scenario Outline: Open Account for Existing Customer
    Given user in open account page
    When user selects '<customer>' and '<currency>'
    Then click process button

    Examples:
      | customer      | currency   |
      | Iftekhar Khan   | Dollar     |