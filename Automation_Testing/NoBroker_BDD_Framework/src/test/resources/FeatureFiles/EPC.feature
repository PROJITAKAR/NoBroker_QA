Feature: NoBroker Home Services Booking Flow

  Background:
    Given User is on the NoBroker homepage

  Scenario: Navigate from Homepage to Service tiles and verify empty cart validation
    When User clicks on Painting and Cleaning option
    Then Home Services landing page should be displayed with all service tiles
    When User clicks on Electrician tile
    Then Electrician sub-services page should be displayed with name and price
    When User does not select any service
    Then Proceed button should not be visible

  Scenario: Add service verify order summary and navigate to address page
    When User clicks on Painting and Cleaning option
    And User clicks on Electrician tile
    And User adds a service
    Then Order summary should be visible with Proceed button active
    When User clicks Proceed
    Then Address page should be displayed with location search bar

  Scenario: Complete full booking flow from address entry to payment portal
    When User clicks on Painting and Cleaning option
    And User clicks on Electrician tile
    And User adds a service
    And User clicks Proceed
    And User searches and selects location "Indiranagar, Bangalore"
    And User enters flat no "12B" and landmark "Near Metro Station"
    And User clicks Proceed on address page
    Then Date and slot selection page should be displayed
    When User selects date and slot
    And User clicks Proceed on date slot page
    And User clicks Pay Now on order summary
    Then Payment portal page should be displayed