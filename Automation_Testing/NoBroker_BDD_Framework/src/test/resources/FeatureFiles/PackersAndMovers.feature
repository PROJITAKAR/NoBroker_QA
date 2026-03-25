@LoginRequired
Feature: Packers and Movers

  Scenario: Verify user can select "Within City" shifting type and search invalid item in inventory
    Given user navigates to Packers and Movers Page
    And user selects a city, pickup and drop location
    When user selects "Within city" option 
    And navigates to inventory Page
    Then user searches for item "Pen"  
    And no relevant results should be displayed
    
  Scenario: Verify user can search, add an item and selects a valid slot 
     Given user navigates to Packers and Movers Page
     And user selects a city, pickup and drop location
     When user selects the category "Bedroom"
     And adds item "King Size Bed - With Storage" and continues 
     And selects a valid pickup date 
     And selects a valid slot and confirms
     Then Order summary page should open
     
   Scenario: Verify user can add and update an item
      Given user navigates to Packers and Movers Page
      And user selects a city, pickup and drop location
      When user updates the added item and continues
      And selects a valid pickup date 
      And selects a valid slot and confirms
      Then Order summary page should open
     

     
     
