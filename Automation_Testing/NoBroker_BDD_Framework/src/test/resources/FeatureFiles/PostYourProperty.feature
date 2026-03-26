@LoginRequired
Feature: Post Your Property – Residential Rental on NoBroker

  # ---------------------------------------------------------------
  Scenario: SC_01 — Navigate to Post Your Property page from Homepage
    Given the user is on the NoBroker Homepage
    When the user clicks "Post Your Property" in the header
    Then the user should be redirected to the "Post Your Property" page
    And the page should load successfully without errors

  # ---------------------------------------------------------------
  Scenario: SC_02 — Submit valid Property Details and navigate to Locality Details page
    Given the user clicks "Post Your Property" in the header
    And the user selects property type "Residential" and ad type "Rent"
    And the user selects city "Bangalore"
    And the user clicks "Start Posting Your AD For Free"
    And the user is on the "Property Details" page
    When the user selects "Independent House/Villa" as Apartment Type
    And the user selects "2 BHK" as BHK and "3" as Floor
    And the user selects "5-10 years" as Property Age
    And the user selects "East" as Facing
    And the user enters "1200" as Built-up Area
    And the user clicks "Save & Continue"
    Then all inputs should be accepted without validation errors
    And the user should be navigated to the "Locality Details" page

  # ---------------------------------------------------------------
  Scenario: SC_03 — Show validation errors when fields are empty
    Given the user clicks "Post Your Property" in the header
    And the user selects property type "Residential" and ad type "Rent"
    And the user selects city "Bangalore"
    And the user clicks "Start Posting Your AD For Free"
    And the user is on the "Property Details" page
    When the user clicks "Save & Continue"
    Then validation messages should be displayed for all empty mandatory fields
    And the user should remain on the "Property Details" page

  # ---------------------------------------------------------------
  Scenario: SC_04 — Show validation error for mismatched city and locality
    Given the user clicks "Post Your Property" in the header
    And the user selects property type "Residential" and ad type "Rent"
    And the user selects city "Bangalore"
    And the user clicks "Start Posting Your AD For Free"
    When the user completes Property Details and clicks "Save & Continue"
    And the user is on the "Locality Details" page
    And the user selects "Gurgaon" from the City dropdown
    And the user selects "Kolkata" from the Locality dropdown
    And the user clicks "Save & Continue"
    Then a validation error should be displayed for the city-locality mismatch
    And the user should remain on the "Locality Details" page

  # ---------------------------------------------------------------
  Scenario: SC_05 — Show validation error when deposit < rent
    Given the user clicks "Post Your Property" in the header
    And the user selects property type "Residential" and ad type "Rent"
    And the user selects city "Bangalore"
    And the user clicks "Start Posting Your AD For Free"
    When the user completes Property Details and clicks "Save & Continue"
    And the user completes Locality Details and clicks "Save & Continue"
    And the user is on the "Rental Details" page
    And the user enters "15000" as Rent and "10000" as Deposit
    And the user clicks "Save & Continue"
    Then a validation error should be displayed: "Deposit must be greater than or equal to rent"
    And the user should remain on the "Rental Details" page

  # ---------------------------------------------------------------
  Scenario: SC_06 — Upload valid photos and verify preview
    Given the user clicks "Post Your Property" in the header
    And the user selects property type "Residential" and ad type "Rent"
    And the user selects city "Bangalore"
    And the user clicks "Start Posting Your AD For Free"
    When the user completes Property Details and clicks "Save & Continue"
    And the user completes Locality Details and clicks "Save & Continue"
    And the user completes Rental Details and clicks "Save & Continue"
    And the user completes Amenities and clicks "Save & Continue"
    And the user is on the "Photo Upload" page
    And the user clicks "Upload Photo"
    And the user uploads "Image1.jpg"
    And the user uploads "Image2.png"
    Then both photos should be uploaded successfully
    And preview thumbnails should be visible

  # ---------------------------------------------------------------
  Scenario: SC_07 — End-to-End: Complete full flow
    Given the user is on the NoBroker Homepage
    When the user clicks "Post Your Property" in the header
    And the user selects property type "Residential" and ad type "Rent"
    And the user selects city "Bangalore"
    And the user clicks "Start Posting Your AD For Free"
    And the user completes Property Details and clicks "Save & Continue"
    And the user completes Locality Details and clicks "Save & Continue"
    And the user completes Rental Details and clicks "Save & Continue"
    And the user completes Amenities and clicks "Save & Continue"
    And the user uploads "Image1.jpg"
    And the user uploads "Image2.png"
    And the user clicks "Save & Continue"
    And the user sets availability "Everyday"
    And the user sets time "09:00 AM" to "06:00 PM"
    And the user clicks "Save & Continue"
    And the user clicks "Post"
    Then a success message should be displayed: "Your property has been posted successfully!"
    And the success screen should show options for "Edit Listing" and "Preview Listing"
