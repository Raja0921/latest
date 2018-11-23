#------------------------------------------------------------------------------------------------------------------------------------------------------------#
#---- Base Framework model - CBOL Sign On v2---------------------------10/05/2018------------------------------------------------------------#
#------------------------------------------------------------------------------------------------------------------------------------------------------------#
@CBOLSignOn
Feature: Verify CBOL Login for a Bank ONLY Customer - CitiBlue
Provided the correct User ID and Password and user should be able to successfully login into Citibank Online.
In case the info provided is incorrect and/or eligibility criteria are not met, user is blocked from Login into Citibank Online.
 
 #-------------------------------------------------------------------------------------------
#------------------------------------Positive Flow------------------------------------------
#-------------------------------------------------------------------------------------------

@CBOLSignOn @CBOLAngular @Healthcheck @Hourly
Scenario Outline: Verify CBOL Login for a Bank ONLY Customer - CitiBlue : RCE101; HealthCheck; Regression
Given I am on the Home Page "<URL>" and "<PageType>" 
When I enter a valid User ID and Password "<UserID>" and "<Password>"
And If I click on Sign on button
Then I see CBOL dashboard Page "<AccountNumber>"


Examples:
|URL|UserID|Password|AccountNumber|CustomerType|PageType|Ind_PayeeName|Ind_PayeeNName|OneTimeRef#|Merch_PayeeName|Merch_PayeeNName|
##@data@src/test/java/dataProvider/TestData.xlsx@BLUE
