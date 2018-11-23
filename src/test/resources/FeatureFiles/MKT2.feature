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
##@data@src/test/java/dataProvider/TestData.xlsx@MKTSimplicity
|https://test02.creditcards.citi.com/credit-cards/citi.action?|Simplicity|

@MKTCostcoVisa
Scenario Outline: Cards Marketing_DD MKT_PDP page_Costco Anywhere Visa Card by Citi_Large breakpoint_Link Validation
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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|CostcoVisa|


@MKTCostcoBusiness
Scenario Outline: Cards Marketing_DD MKT_PDP page_Costco Anywhere Visa Business Card by Citi_Large breakpoint_Link Validationn
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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|CostcoBusiness|


@MKTAdvantageexecutive
Scenario Outline: Cards Marketing_DD MKT_PDP page_Citi AAdvantage Executive World Elite MasterCard_Large breakpoint_Link Validation
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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|Advantageexecutive|

@MKTAdvantageplatniumworld
Scenario Outline: Cards Marketing_DD MKT_PDP page_CitiBusiness AAdvantage Platinum Select World MasterCard_Large breakpoint_Link Validation

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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|Advantageplatniumworld|

@MKTAdvantageplatinumelite
Scenario Outline: Cards Marketing_DD MKT_PDP page_Citi AAdvantage Platinum Select World Elite MasterCard_Large breakpoint_Link Validation

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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|Advantageplatinumelite|

@MKTDoublecash
Scenario Outline: Cards Marketing_DD MKT_PDP page_Citi Double Cash Card_Large breakpoint_Link Validation

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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|Doublecash|



@MKTATTAcesscard
Scenario Outline: Cards Marketing_DD MKT_PDP page_ATT Access Card from Citi_Large breakpoint_Link Validation

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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|ATTAcesscard|

@MKTSecuredcard
Scenario Outline:Cards Marketing_DD MKT_PDP page_Citi Secured MasterCard_Large breakpoint_Link Validation 

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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|Securedcard|

@MKTThankyouPreferredcollege
Scenario Outline:Cards Marketing_DD MKT_PDP page_Citi ThankYou Preferred Card for College Students_Large breakpoint_Link Validation

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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|ThankyouPreferredcollege|

@MKTThankyouPreferred
Scenario Outline:Cards Marketing_DD MKT_PDP page_Citi ThankYou Preferred Card_Large breakpoint_Link Validation

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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|ThankyouPreferred|

@MKTThankyouPremier
Scenario Outline:Cards Marketing_DD MKT_PDP page_Citi ThankYou Premier Card_Large breakpoint_Link Validation

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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|ThankyouPremier|

@MKTExpedia
Scenario Outline:Cards Marketing_DD MKT_PDP page_Expedia Card from Citi_Large breakpoint_Link Validation

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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|Expedia|

@MKTExpediaVoyager 
Scenario Outline:Cards Marketing_DD MKT_PDP page_Expedia Voyager Card from Citi_Large breakpoint_Link Validation

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
|https://test02.creditcards.citi.com/credit-cards/citi.action?|ExpediaVoyager|
