require 'calabash-android/calabash_steps'

Given(/^I see Quality Excites header$/) do 
element_exists("*:'QE2016'")
end

When(/^I click on Add new product button$/) do
tap_when_element_exists("* id:'fabAdd'")
end
Then (/^I will see a "([^"]*)"$/) do |arg1|
element_exists("*:'arg1'")
end

