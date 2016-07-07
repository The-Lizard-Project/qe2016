
Feature: Add product

Scenario: As an application user I can see add a new product to the list

Given I see the text "QE 2016"
When I press image button number 1
Then I wait to see "Category"
And I wait to see "Priority"

Scenario: As an application user  I can add a new product
Given I see the text "QE 2016"
When I press image button number 1
And I wait to see "Category"
And I wait to see "Priority"
Then I enter "New product" into input field number 1
And I press "fruits"
And I press "rtv"
And I press "normal"
And I press "minor"
And I press image button number 1

Scenario: As a an application user I can remove a product from the list
Given I see the text "New product"
When I press "deleteButton"
Then I don't see "New product"

