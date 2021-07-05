Feature: Book Appointment for haircut


  Scenario Outline: validate haircut service and location
    Given User is on the Mytime HomePage
    And user Search for '<type of service>' in '<location>'
    And Verify that multiple results are shown <Expected_number>
    And Open business with name '<Busniness_Name>'
    When user Select '<Service>' in the services filter from the left panel
    And user Select second staff from the staff filter in the left side panel
    And user Click the Book button for the '<Service_selection>' service
    When user Press Select Time in the add-on modal opened
    Then Verify that the user is presented with a list of available time slots with at least 2 entries
    Then verify '<Service_selection>' is displayed with service price and staff name



    Examples:
      | type of service | location          |Busniness_Name| Expected_number|Service|Service_selection|
      | haircut         | San Francisco, CA |Test - Sabre Cuts|3            |All services|Men's Haircut|








