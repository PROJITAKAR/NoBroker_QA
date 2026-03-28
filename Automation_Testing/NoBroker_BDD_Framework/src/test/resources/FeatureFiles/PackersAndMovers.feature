@LoginRequired
Feature: Packers and Movers

  Scenario Outline: Verify user can select "Within City" shifting type and search invalid item in inventory
    Given user loads test data "<TC_ID>"
    And user navigates to Packers and Movers Page
    And user selects a city, pickup and drop location
    When user selects shifting type
    And navigates to inventory Page
    Then user searches for item
    And no relevant results should be displayed

   Examples:
| TC_ID |
| TC01  |
| TC02  |


  Scenario Outline: Verify user can search, add item and select valid slot
  Given user loads test data "<TC_ID>"
  And user navigates to Packers and Movers Page
  And user selects a city, pickup and drop location
  And navigates to inventory Page
  When user selects category and adds item
  And selects a valid pickup date
  And selects a valid slot and confirms
  Then Order summary page should open

Examples:
| TC_ID |
| TC03  |

  Scenario Outline: Verify user can add and update an item
    Given user loads test data "<TC_ID>"
    And user navigates to Packers and Movers Page
    And user selects a city, pickup and drop location
    And navigates to inventory Page
    When user updates the added item and continues
    And selects a valid pickup date 
    And selects a valid slot and confirms
    Then Order summary page should open

    Examples:
      | TC_ID |
      | TC04  |