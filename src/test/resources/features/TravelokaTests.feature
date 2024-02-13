@TravelokaTestsFeature

Feature: Automation UI Testing for Traveloka Tests

  Background:
    Given [travelokapage] User tried to open traveloka page

  @Positive
  Scenario Outline: Create successful transaction to order car rental
    When [travelokapage] User click on Car Rental menu
    Then [travelokapage] User choose city to '<city>'
    Then [travelokapage] User choose start date to '<startDate>'
    Then [travelokapage] User choose end date to '<endDate>'
    Then [travelokapage] User click on search button
    And  [travelokapage] User wait for 5 seconds
    Then [travelokapage] User click continue on chosen car
    Then [travelokapage] User click continue on chosen car rental
    Then [travelokapage] User click on rental pickup location on '<rentalPickup>'
    And  [travelokapage] User click on dropoff pickup location on '<dropOffLocation>'
    And  [travelokapage] User input additional request for dropoff Location with request '<requests>'
    And  [travelokapage] User click continue on product detail page
    Then [travelokapage] User wait for 5 seconds
    Then [travelokapage] User input contact name as '<name>'
    And  [travelokapage] User input contact phone number as '<phoneNumber>'
    And  [travelokapage] User input contact email as '<email>'
    Then [travelokapage] User choose driver punctuation as 'Mr'
    And  [travelokapage] User input driver full name as '<name>'
    And  [travelokapage] User input driver phone number as '<phoneNumber>'
    Then [travelokapage] User click continue on contact page
    Then [travelokapage] User wait for 5 seconds
    Then [travelokapage] User input additional request for car as '<requests>'
    And  [travelokapage] User click on check requirements for rental
    Then [travelokapage] User click continue to payment
    Then [travelokapage] User wait for 5 seconds
    Then [travelokapage] User choose bank transfer as payment method
    Then [travelokapage] User click Pay with bank transfer
    Then [travelokapage] User should be redirected to payment confirmation page

    Examples:
      | city    | startDate  | endDate    | rentalPickup  | dropOffLocation  | requests   | name    | phoneNumber | email   |
      | Jakarta | current+2  | current+5  | office        | otherlocation    | Baby Seat  | default | default     | default |