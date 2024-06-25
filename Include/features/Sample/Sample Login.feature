#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag @login
Feature: The test case verifies that a user can login with a valid account
	
  Scenario Template: Login successfully
    Given The Login page is loaded successfully
    When I login the system with valid "<username>" username and "<password>" password
    Then The Dashboard Page is loaded successfully

    Scenarios: 
      | username|                  | password                 |
      | John Doe | 								 |g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM|
      
     