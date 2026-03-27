# ============================================================
# BDD FEATURE FILE — NoBroker: Post Your Property (Rental)
# ============================================================
# Application  : NoBroker (https://www.nobroker.in)
# Module       : Post Your Property – Residential Rental
# Author       : Projita Kar
# ============================================================
@LoginRequired
Feature: Post Your Property – Residential Rental on NoBroker
  As a registered property owner,
  I want to post my residential property for rent on NoBroker,
  So that potential tenants can find and contact me.

  Background:
    Given the user is on the NoBroker Homepage
    When the user clicks "Post Your Property"
    And the user clicks "Post Now"
    Then the user should be navigated to the "Post Your Property" page
    And the page should load successfully without errors

  # ---------------------------------------------------------------
  # SCENARIO 1 — Property Type & City: Valid Selection  [NON-PARAMETERISED] [POSITIVE]
  # TC_NoBroker_03 | TS_NoBroker_02
  # ---------------------------------------------------------------
 
  Scenario: SC_01 — Successfully select Property Type, Ad Type and City and navigate to Property Details
    Given the user is on the "Post Your Property" page
    When the user selects Residential as Property Type and Rent as Ad Type and "Bangalore" as City
    And the user clicks "Start Posting Your AD For Free"
    Then the user should be navigated to the "Property Details" page

  # ---------------------------------------------------------------
  # SCENARIO 2 — Property Details: Multiple Valid Configurations  [PARAMETERISED] [POSITIVE]
  # TC_NoBroker_07 | TS_NoBroker_03
  # ---------------------------------------------------------------
  @Smoke
  Scenario Outline: SC_02 — Submit valid Property Details with different apartment types and BHK configurations
    Given the user is on the "Property Details" page
    When the user selects "<apartmentType>" as Apartment Type and "<bhk>" as BHK
    And the user selects "<floor>" as Floor and "<propertyAge>" as Property Age
    And the user selects "<facing>" as Facing and enters "<builtUpArea>" as Built-up Area in sq ft
    And the user clicks "Save & Continue"
    Then all inputs should be accepted without validation errors on "Property Details" page
    And the user should be navigated to the "Locality Details" page

    Examples:
      | apartmentType           | bhk   | floor | propertyAge | facing | builtUpArea |
      | Independent House/Villa | 2 BHK | 3     | 5-10 years  | East   | 600        |
      | Apartment               | 3 BHK | 5     | 0-1 year    | North  | 800        |
      | Studio Apartment        | 1 BHK | 1     | 1-5 years   | West   | 1000         |
