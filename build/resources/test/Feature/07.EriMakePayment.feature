Feature: AppAutomation

  @Test
  Scenario Outline: User make payment
    Given Click Make Payment Button
    When User input '<Phone>' and '<Name>' and '<Amount>'
    And click select button
    And click Send payment button
    Then Go to next page

    Examples:
      |Phone  |Name   |Amount |
      |01611  |Riyadh |50     |



