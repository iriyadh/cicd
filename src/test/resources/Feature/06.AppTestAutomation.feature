Feature: AppTest

  @Test
  Scenario Outline: user login
    Given app apk is there
    When user enters '<username>'and '<password>'
    Then user will navigate to home screen

    Examples:
      | username | password|
      | company  | company |