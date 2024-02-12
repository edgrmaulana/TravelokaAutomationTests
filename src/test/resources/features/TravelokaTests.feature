@TravelokaTestsFeature

Feature: Automation UI Testing for Traveloka Tests

  Background:
    Given [travelokapage] User tried to open traveloka page

  @Positive
  Scenario Outline: Verify Traveloka UI with '<reason>'
    When [travelokapage] User click on Car Rental menu
    Then [travelokapage] User choose city to '<city>'
    Then [travelokapage] User choose start date to '<startDate>'
    Then [travelokapage] User choose end date to '<endDate>'
    Then [travelokapage] User click on search button
    And  [travelokapage] User wait for 5 seconds
    Then [travelokapage] User click continue on chosen car
    Then [travelokapage] User click continue on chosen car rental
    Then [travelokapage] User click on rental pickup location on '<rentalPickup>'
    Then [travelokapage] User click on dropoff pickup location on '<dropOffLocation>'

    Examples:
      | city    | startDate  | endDate    | rentalPickup  | dropOffLocation  |
      | Jakarta | current+2  | current+5  | office        | otherlocation     |