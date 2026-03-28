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
      | Independent House/Villa | 2 BHK | 3     | 5-10 years  | East   | 600         |

  # ---------------------------------------------------------------
  # SCENARIO 3 — Rental Details: Valid Rent & Deposit Combinations  [PARAMETERISED] [POSITIVE]
  # TC_NoBroker_17 | TS_NoBroker_05
  # ---------------------------------------------------------------
  Scenario Outline: SC_03 — Successfully submit Rental Details with valid rent and deposit values
    Given the user is on the "Rental Details" page
    When the user enters "<rent>" in the Rent field and "<deposit>" in the Deposit field
    And the user fills in Tenant Preference as "Family", Furnishing as "Semi-furnished", Parking as "Car" and Maintenance as "Maintenance Included"
    And the user selects "31 March 2026" as Availability Date
    And the user clicks "Save & Continue"
    Then all inputs should be accepted without validation errors on "Rental Details" page
    And the user should be navigated to the "Amenities" page

    Examples:
      | rent  | deposit |
      | 15000 | 45000   |
      | 25000 | 75000   |
      | 8000  | 24000   |

  # ---------------------------------------------------------------
  # SCENARIO 4 — Photo Upload: Valid Image & Video Formats  [PARAMETERISED] [POSITIVE]
  # TC_NoBroker_23 + TC_NoBroker_25 | TS_NoBroker_07
  # ---------------------------------------------------------------
  Scenario Outline: SC_04 — Upload valid photos and videos in different formats and verify preview thumbnails
    Given the user is on the "Photo Upload" page
    When the user uploads "<file1>" and "<file2>" (each under 5MB)
    Then the file should be uploaded successfully and preview thumbnail should be visible
    When the user clicks "Save & Continue"
    Then the user should be navigated to the "Schedule" page

    Examples:
      | file1        | file2       |
      | image_2.jpg  | video_1.mp4 |
      | image_3.jpeg | video_2.mp4 |

  # ---------------------------------------------------------------
  # SCENARIO 5 — Property Details: Empty Mandatory Fields  [NON-PARAMETERISED] [NEGATIVE]
  # TC_NoBroker_08 | TS_NoBroker_03
  # ---------------------------------------------------------------
  Scenario: SC_05 — Show validation errors when Property Details mandatory fields are empty
    Given the user is on the "Property Details" page
    When the user leaves all mandatory fields empty
    And the user clicks "Save & Continue"
    Then validation messages should be shown for all empty mandatory fields
    And the user should remain on the "Property Details" page

  # ---------------------------------------------------------------
  # SCENARIO 6 — Rental Details: Deposit Less Than Rent  [NON-PARAMETERISED] [NEGATIVE]
  # TC_NoBroker_18 | TS_NoBroker_05
  # ---------------------------------------------------------------
  @Smoke
  Scenario: SC_06 — Show validation error when deposit amount is less than rent
    Given the user is on the "Rental Details" page
    When the user enters "15000" in the Rent field and "10000" in the Deposit field
    And the user fills in Tenant Preference as "Family", Furnishing as "Semi-furnished", Parking as "Car" and Maintenance as "Maintenance Included"
    And the user selects "31 March 2025" as Availability Date
    And the user clicks "Save & Continue"
    Then a validation error should be displayed: "Deposit can not be less than Rent !"
    And the user should remain on the "Rental Details" page

  # ---------------------------------------------------------------
  # SCENARIO 7 — End-to-End Happy Path  [NON-PARAMETERISED] [POSITIVE]
  # TC_NoBroker_01, 03, 07, 12, 17, 21, 23, 27, 29
  # ---------------------------------------------------------------
  Scenario: SC_07 — End-to-End: Complete full property posting journey and verify success
    # --- STEP 1: Property Type & City Selection ---
    Given the user is on the "Post Your Property" page
    When the user selects Residential as Property Type and Rent as Ad Type and "Bangalore" as City
    And the user clicks "Start Posting Your AD For Free"
    Then the user should be navigated to the "Property Details" page
    # --- STEP 2: Property Details ---
    When the user selects "Independent House/Villa" as Apartment Type and "2 BHK" as BHK
    And the user selects "3" as Floor and "5-10 years" as Property Age
    And the user selects "East" as Facing and enters "1200" as Built-up Area in sq ft
    And the user clicks "Save & Continue"
    Then the user should be navigated to the "Locality Details" page
    # --- STEP 3: Locality Details ---
    When the user selects "Mumbai" as City and "Andheri West" as Locality
    And the user enters "Near Metro Station" in the Landmark field
    And the user clicks "Save & Continue"
    Then the user should be navigated to the "Rental Details" page
    # --- STEP 4: Rental Details ---
    When the user enters "15000" in the Rent field and "45000" in the Deposit field
    And the user fills in Tenant Preference as "Family", Furnishing as "Semi-furnished", Parking as "Car" and Maintenance as "Maintenance Included"
    And the user selects "01 May 2025" as Availability Date
    And the user clicks "Save & Continue"
    Then the user should be navigated to the "Amenities" page
    # --- STEP 5: Amenities ---
    When the user sets Bathroom count to "2" and Balcony count to "2"
    And the user selects "Borewell" as Water Supply and sets "Pet Allowed", "Gym", "Non-Veg Allowed" and "Gated Security" to Yes
    And the user selects "Neighbours" for "Who will show the property?" and "New Property" as Property Condition
    And the user selects amenities "Lift" and "Swimming Pool"
    And the user clicks "Save & Continue"
    Then the user should be navigated to the "Photo Upload" page
    # --- STEP 6: Visit Schedule ---
    When the user selects "Everyday" as availability and sets Start Time "09:00 AM" and End Time "06:00 PM"
    And the user clicks "Save & Continue"
    Then the user should be navigated to the "Final Submission" page
    # --- STEP 7: Post & Success ---
    When the user clicks "Finish Posting"
    Then a success message should be displayed: "Your property has been posted successfully!"
    And the success screen should show options for "Edit Listing" and "Preview Listing"
