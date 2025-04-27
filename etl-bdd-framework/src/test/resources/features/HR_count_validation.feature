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
#test
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @smoketest
  Scenario Outline: Validate the source and target DB count of HR schema
    Given I have source and target HR DB connections
    When I fetch record count from "<source_query>" and "<target_query>" tables
    Then the record counts should match of given tables.

    Examples: 
      | source_query         | target_query         |
      | Employee_count.sql   | Employee_count.sql   |
      | Department_count.sql | Department_count.sql |


