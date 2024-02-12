@TravelokaTestsFeature

Feature: Automation UI Testing for Traveloka Tests

  Background:
    Given [travelokapage] User tried to open traveloka page

  @Positive
  Scenario Outline: Verify Traveloka UI with '<reason>'
    When [travelokapage] User click on Car Rental menu

    Examples:
      | user        |
      | default     |