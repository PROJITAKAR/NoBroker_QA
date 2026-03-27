Feature: NoBroker Core Property Search and Filtering

  Background:
    Given user opens NoBroker website


  @Smoke @Positive
  Scenario: Search property with valid inputs
    When user selects city "Hyderabad"
    And user enters locality "Bandra" and selects suggestion
    And user clicks search button
    Then user should be navigated to results page
    And property listings should be displayed

  @Smoke @Negative
  Scenario: Search without entering locality
    When user clicks search without entering locality
    Then validation error should be displayed


  @Buy @Positive
  Scenario: Verify Buy Full House flow
    When user selects Buy tab
    And user selects Full House option
    Then BHK dropdown should be visible
    And Property Status dropdown should be visible


  @Rent @PG @Positive
  Scenario: Apply PG filters
    When user selects Rent tab
    And user selects PG/Hostel option
    And user selects city and locality
    And user clicks search
    Then PG results should be displayed

    When user applies PG filters
    Then filtered PG listings should be displayed


  @Rent @Flatmate @Positive
  Scenario: Apply Flatmate filters
    When user selects Rent tab
    And user selects Flatmate option
    And user searches with valid inputs
    Then Flatmate results should be displayed

    When user handles popup and applies filters
    Then filtered Flatmate listings should be displayed


  @Regression @Positive
  Scenario: Reset filters functionality
    Given user has applied filters
    When user clicks reset button
    Then all filters should be cleared