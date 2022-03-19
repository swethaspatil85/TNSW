Feature: Find a stop and access modes
  Scenario Outline: Get Stop
    Given John is looking for a stop
    When tester hits API and John searches for <stop1>
    Then Success status code is coming
    And a stop named <stopName> is found
    And the stop provides more than one mode of transport

		Examples:
        | stop1 | stopName |
        | "Wynyard Station" | "Wynyard Station, Sydney" |
        
        
   