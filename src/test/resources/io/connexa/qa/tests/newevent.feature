Feature: User Creates a new Event As a Community Member
		 I want to create a new event so other Community Members could join to it

Scenario: Invalid Conditions 
	Given the user is on Create New Event Page
	When he enters " " as event name
	And he enters " " as short description
	And he enters " " as start date
	And he enters " " as start hour
	And he enters " " as end date
	And he enters " " as end hour
	And he clicks Save Button for Event Creation
	Then ensure an error "can't be blank" message is displayed	
	
Scenario: Create a New Event 
	Given the user is on Create New Event Page
	When he enters "Automated Event" as event name
	And he enters "Automated Event Short Description" as short description
	And he enters "YYYY/MM/DD" as start date
	And he enters "HH:MM" as start hour
	And he enters "YYYY/MM/DD" as end date
	And he enters "HH:MM" as end hour
	And he clicks Save Button for Event Creation
	Then ensure the event is created	