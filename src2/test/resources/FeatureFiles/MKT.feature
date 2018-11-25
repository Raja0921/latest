#------------------------------------------------------------------------------------------------------------------------------------------------------------#
#---- Base Framework model - CBOL Sign On v2---------------------------10/05/2018------------------------------------------------------------#
#------------------------------------------------------------------------------------------------------------------------------------------------------------#
@MKT
Feature: Link Validation 
 #-------------------------------------------------------------------------------------------
#------------------------------------Positive Flow------------------------------------------
#-------------------------------------------------------------------------------------------
@MKTSimplicity
Scenario Outline: Cards Marketing_DD MKT_PDP page_Citi Simplicity Cash Card_Large breakpoint_Link Validation
Given I am on the Home Page "<URL>"
When I click search card
And I enter and select "<CardName>"
And I get PDP page
And I validate apply now link
And I validate pricing info link
Then I validate additional info link

Examples:
|URL|CardName|
##@data@src/test/java/dataProvider/TestData.xlsx@MKT
|https://test02.creditcards.citi.com/credit-cards/citi.action?|Simplicity|
