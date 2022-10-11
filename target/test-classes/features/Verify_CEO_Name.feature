@GetCEOName
Feature: 	This feature is to get the CEO name from the Orange HRM application
Scenario Outline: This test is to verify the CEO name.
	Given the user is logged in sucussfully and is on home page
	When the user clicks on the directory option from the menu bar
	And the user selects the job title as "Chief Executive Officer" from the dropdown list
	And clicks the search button
	Then the user should see the CEO name as "<CEO_Name>"
	
	Examples:
|CEO_Name|
|John Smith|
