Feature: Hubspot login page functionality 

Scenario: Verify hubspot login page title 
	Given user is in hubspot application login page 
	When user gets the page title 
	Then page title should be "OrangeHRM" 
	
Scenario: Verify forgot my password link displayed 
	Given user is in hubspot application login page 
	Then verify forgot my password link is displayed 
	
Scenario: Verify hubspot login page with valid data 
	Given user is in hubspot application login page 
	When user enter email and password 
		|email|password |
		|Admin|admin123|
	And user clicks login button 
	When user gets the page title 
	Then page title should be "OrangeHRM" 
		