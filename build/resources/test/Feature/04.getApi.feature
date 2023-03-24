Feature: API
  @Test
  Scenario Outline: api check for pages
    Given user has the base url
    When user call the '<paramsName>' and '<paramsValue>'
    Then it will return valid data
    Examples:
      |paramsName | paramsValue |
      |?page      | 2           |

