JavaExcel Test Automation Framework is a data driven keyword based REST API testing framework. There is zero coding effort required offering users to start testing within a few minutes of the data setup.
Behind the scene, it uses TestNG to drive the test, Fillo for excel based SQL like queries, Jackson libraries to parse JSON data, Apache HTTPClient for client side REST calls, etc.
At a high level, the framework consists of the following components - 
User defined test data sheet - Test data sheet in excel format using standard convention required by the framework.
	- User provided JSON payload templates - Rest payloads as defined in the Swagger specification document.
	- Request Generator - Component within the framework that reads the test data and generates the API Request Details using the template.
	- Request Sender - Component that triggers the API call
	- Test Validator - Component performing the test assertions per the scope defined in the test data sheet.


Release Version: v2.3

	Comment:
	01/09/2018 (v2.3)	 - Integrated feature related to auto test case generation based on swagger inputs.
	01/04/2018 (v2.2)	 - Fixed issue with defaulting template content.
	12/19/2018 (v2.1)	 - Added feature to upload PDF reports to ALM
	11/27/2018 (v2.01)	 - Added feature to append to resource path. Search for "Adding to Resource Path" in the documentation below.
	11/16/2018 (v2.0)	 - Refactored test framework simplifying test sheet, reporting enhancement and ALM integration.
	11/10/2018 (v1.34.2) - Fixed issue with concatenating date components.
	11/09/2018 (v1.34.1) - Fixed issue with handling double quote in the resource path when using chained request.
	10/12/2018 (v1.34) - Added feature to support overriding Base URI.
	10/11/2018 (v1.33) - Added "Loop" feature to repeat delete action.
	10/11/2018 (v1.32) - Added "Loop" feature to repeat TC as needed.
	9/18/2018 (v1.31) - Fixed issue with handling chained request data with WHERE condition.
	9/18/2018 (v1.30) - Added feature to retrieve local machine IP Address. Example usage: {{IPADDRESS}}
	9/17/2018 (v1.292) - Fixed issue with retrieving webhook_id by STATUS
	9/17/2018 (v1.291) - Fixed issue with header override non authorization fields.
	9/13/2018 (v1.29) - Added feature to support chained request data lookup for Header Override. 
						Example: Pass authorization token based on response of a previous API call.
						Usage: In the "Override Header" column, add - Authorization#body_3_1:tokens[0]$token_id. Note: This is just an example
	9/11/2018 (v1.281) - Expanded range for random URLs using keyword {{RANDOMURL}}.
	9/06/2018 (v1.28) - Added feature to support chained request support with data lookup based on a filter. 
						Example: #body_3_1:webhooks[]webhook_id$WHERE$status#ACTIVE. For details, see under QUERY_PARAMS section.
	9/05/2018 (v1.27) - Added feature to support SORT validations. Example - accounts[0]$transactions[]#transaction_datetime$SORTDESCEND
	9/04/2018 (v1.26) - Added support for keyword {{RANDOMURL}} to generate random URL.
	9/04/2018 (v1.25) - Fixed issue with multiple "+" when formating UTC time formats with offsets.
	8/27/2018 (v1.24) - Added feature to log Response Time in the PDF report.
	8/21/2018 (v1.23) - Added feature to support $NOTEXIST keyword to validate non-existence of a field value. 
						Example: webhooks[]$webhook_id#G232-233$NOTEXIST
	8/20/2018 (v1.22) - Fixed issue with git branch querying locally resulting in pdf generation error.
	8/17/2018 (v1.21) - Fixed issue with ALLIFNOTNULL keyword to account for validation of "null" response. 
	Note that the newly added support checks for "null" keyword within the quotes i.e. a String datatype.
	8/16/2018 - Fixed issue reported by FX API related to handling escape characters.
	8/15/2018 - Added feature to retain pdf reports within the last 3 days.
	8/14/2018 - Added support for forcing individual account usage.
	8/14/2018 - Updated framework to support enhanced PDF report with log outputs.
	8/7/2018 - Added Authentication_Key parameterization code
	6/27/2018 - Disabled hyperlinks from PDF report.
	6/27/2018 - Fixed issue with handling quotes in using chained request data using the response body.
	6/12/2018 - Added support for UTC and TODAY calendar days computation.
	

KEY FEATURES:
-------------
1. Support for Standard validations - Key-Value Pair, NULL, Missing field validations, Response Time Validation, etc.
2. Support for Chained Request via response headers and body.
3. Support for Schema validation  with predefined templates (in-progress).
4. Support for Response Header Validations.
5. Support for Query Params.
6. Support for Array response validations.
7. Support for GET, POST, PUT, PATCH and DELETE.
8. Support for Template override.
9. Support for Method override.
10. Support for test scope driven by Tags.
11. Clean html report with all details (request, response, etc.) captured as collapsible elements.
12. Validation based on pattern matching. 
13. Random generation of userid, address, string with specified length, etc.



SPECIAL KEYWORDS valid for the TEST DATA SHEET:
------------------------------------------------
	{{RANUSERID}} -> Generates random user_id (String datatype) with default "gateway" prefixed. Example: gateway-62c717b2
	{{someText$RANUSERID}} -> Generates random user_id with a user specified Text set as Prefix. Example: someText-62c717b2 or test-635d8239c
	{{RANADDRESS}} -> Generates random address (String datatype). Example: 1026 Malcomn St. NY
	{{RANEMAIL}} -> Generates random email address.
	
	
	{{RANDOM4S}} -> Generates random String with length of 4 characters.
	{{RANDOM8S}} -> Generates random String with length of 8 characters.
	{{RANDOM12S}} -> Generates random String with length of 12 characters.
	
	{{RANDOM4N}} -> Generates random Number with length of 4 characters.
	{{RANDOM8N}} -> Generates random Number with length of 8 characters.
	{{RANDOM12N}} -> Generates random Number with length of 12 characters.
	
	{{RANDOMURL}} -> Generates random URL in the format "https://test.xxxxx.com"
	
	{{UTC0D}} -> Generates UTC (YYYY-MM-DDT00:00:00Z) Date format with current date and time.
	{{UTC1D}} -> Generates UTC Date format with 1 business day from current date and time.
	{{UTC2D}} -> Generates UTC Date format with 2 business day from current date and time.
	{{UTC3D}} -> Generates UTC Date format with 3 business day from current date and time.
	{{UTC4D}} -> Generates UTC Date format with 4 business day from current date and time.
	{{UTC5D}} -> Generates UTC Date format with 5 business day from current date and time.
	
	{{TODAY0D}} 	-> Generates YYYY-MM-DD with today's date.
	{{TODAY5D}}		-> Generates YYYY-MM-DD with today's date + 5 business days.
	{{TODAY10D}}	-> Generates YYYY-MM-DD with today's date + 10 business days.
	{{TODAY20D}}	-> Generates YYYY-MM-DD with today's date + 20 business days.
	{{TODAY30D}}	-> Generates YYYY-MM-DD with today's date + 30 business days.
	{{TODAY60D}}	-> Generates YYYY-MM-DD with today's date + 60 business days.
	
		Note: Use TODAYX for input date in the YYYYMMDD format.
	
	
	{{UTC0CD}} -> Generates UTC (YYYY-MM-DDT00:00:00Z) Date format with current date and time.
	{{UTC1CD}} -> Generates UTC Date format with 1 calendar day from current date and time.
	{{UTC2CD}} -> Generates UTC Date format with 2 calendar days from current date and time.
	{{UTC3CD}} -> Generates UTC Date format with 3 calendar days from current date and time.
	{{UTC4CD}} -> Generates UTC Date format with 4 calendar days from current date and time.
	{{UTC5CD}} -> Generates UTC Date format with 5 calendar days from current date and time.
	
	{{TODAY0CD}} 	-> Generates YYYY-MM-DD with today's date.
	{{TODAY5CD}}		-> Generates YYYY-MM-DD with today's date + 5 calendar days.
	{{TODAY10CD}}	-> Generates YYYY-MM-DD with today's date + 10 calendar days.
	{{TODAY20CD}}	-> Generates YYYY-MM-DD with today's date + 20 calendar days.
	{{TODAY30CD}}	-> Generates YYYY-MM-DD with today's date + 30 calendar days.
	{{TODAY60CD}}	-> Generates YYYY-MM-DD with today's date + 60 calendar days.
	{{IPADDRESS}}	-> Returns local IP Address.
	
	Tip: To create a UTC date time format with a specific time input, use {{TODAY1D}} 
	along with "+" to concatenate the time part of the UTC date time input.
		Example: {{TODAY0D}}+T18:00:00Z will return "2018-05-04T18:00:00Z".
	
	{{UTC-1D}} -> Generates UTC Date format with -1 business day from current date and time.
	{{UTC-2D}} -> Generates UTC Date format with -2 business day from current date and time.
	{{UTC-3D}} -> Generates UTC Date format with -3 business day from current date and time.
	{{UTC-4D}} -> Generates UTC Date format with -4 business day from current date and time.
	{{UTC-5D}} -> Generates UTC Date format with -5 business day from current date and time.
	
	
	{{TODAY-5D}}	-> Generates YYYY-MM-DD with today's date - 5 business days.
	{{TODAY-10D}}	-> Generates YYYY-MM-DD with today's date - 10 business days.
	{{TODAY-20D}}	-> Generates YYYY-MM-DD with today's date - 20 business days.
	{{TODAY-30D}}	-> Generates YYYY-MM-DD with today's date - 30 business days.
	{{TODAY-60D}}	-> Generates YYYY-MM-DD with today's date - 60 business days.
	
	{{UTC-1CD}} -> Generates UTC Date format with -1 calendar day from current date and time.
	{{UTC-2CD}} -> Generates UTC Date format with -2 calendar days from current date and time.
	{{UTC-3CD}} -> Generates UTC Date format with -3 calendar days from current date and time.
	{{UTC-4CD}} -> Generates UTC Date format with -4 calendar days from current date and time.
	{{UTC-5CD}} -> Generates UTC Date format with -5 calendar days from current date and time.
	
	
	{{TODAY-5CD}}	-> Generates YYYY-MM-DD with today's date - 5 calendar days.
	{{TODAY-10CD}}	-> Generates YYYY-MM-DD with today's date - 10 calendar days.
	{{TODAY-20CD}}	-> Generates YYYY-MM-DD with today's date - 20 calendar days.
	{{TODAY-30CD}}	-> Generates YYYY-MM-DD with today's date - 30 calendar days.
	{{TODAY-60CD}}	-> Generates YYYY-MM-DD with today's date - 60 calendar days.
	
	Tip: To create a UTC date time format with a specific time input, use {{TODAY-1D}} 
	along with "+" to concatenate the time part of the UTC date time input.
		Example: {{TODAY0D}}+T18:00:00Z will return "2018-05-04T18:00:00Z".

	{{$guid}}	-> Generates a random guid for use in the request header or body.
	{{EMPTY}}	-> Used to send empty field value WITH quotes in the request header and body. Example: client-request-id#{{EMPTY}}
	{{empty}}	-> Used to send empty field value WITHOUT quotes in the request body only. Example: user_id#{{empty}}
	{{DEFAULT}}	-> Used to default to the template defined values in the request body. Example: For $reservation_number, we could use {{DEFAULT}}.
	{{$Environment}} -> Used to retrieve the name of the selected environment value. Example: SIT.
	
	$NOTNULL 	-> Used to validate if a field in the response body is not NULL. Example: errors[0]error_code$NOTNULL
	$EXIST 		-> Used to validate if a field in the response body is exist. Example: errors[0]error_code$EXIST
	$NOTEXIST 		-> Used to validate that a field value in the response body does not exist. 
					Example: webhooks[]$webhook_id#G232-233$NOTEXIST
	$IFNOTNULL	-> Used to validate if a field in the response is NOT NULL when it exists. 
			This will apply to use cases such as validating an optional field is not null.
			The assertion will be ignored if the optional field is not present in the response body.
	$ALLIFNOTNULL	-> Used to validate all occurrences of a field in the response is NOT NULL when it exists. 
			This will apply to use cases such as validating an optional field is not null.
			The assertion will be ignored if the optional field is not present in the response body.
			
			Example:
			transactions[]$transaction_id$ALLIFNOTNULL
				{
				  "transactions": [
				    {
				      "transaction_id": "20180515300",
				      "transaction_date": "2018-05-15",
				      "debit_credit_memo": "DEBIT",
				      "reference": "20180515300",
				      "transaction_type": "CHECK",
				      "amount": 64.31,
				      "status": "PENDING",
				      "currency_code": "USD",
				      "check_number": 68285
				    },
				    {
				      "transaction_id": "20180514400",
				      "description": "CASHED CHECK",
				      "posted_date": "2018-05-14",
				      "transaction_date": "2018-05-14",
				      "debit_credit_memo": "DEBIT"...
				      }
				 }
			
	$ALLNOTNULL	-> Used to validate all occurrences of a field in the response is NOT NULL. 
			This will apply to use cases such as validating a mandatory field is not null.
			The assertion will fail if the field is not present in the response body.
			
	$OR	-> Used to validate the value of a field with an "OR" assertion. 
			The assertion will pass if the actual value equals to one of the expected values passed which are separated by commas.
			Example: transactions[0]$currency_code#$OR{"USD","EUR"}
			
	$ORALL	-> Used to validate the value of all recurring fields in an array with an "OR" assertion. 
			The assertion will pass if the actual value equals to one of the expected values passed which are separated by commas.
			The assertion will fail if any of the array object fails.
			Example: transactions[]$currency_code#$ORALL{"USD","EUR"}
			
	
	$MATCH$		-> Used to validate REGEX pattern of a field in the response body. Example: errors[0]error_code$MATCH$(\d{3})-(\d{3})
	errors$[0]error_code#401-002	-> Key-Value Pair assertion separated by a "#".
	
	$SORTDESCEND/$SORTASCEND	-> Used to validate the sort order of the values of a specific field in the response. 
									Example - accounts[0]$transactions[]#transaction_datetime$SORTDESCEND
	
	$AssertCertificate	-> Used for Ping v2 API. It will return "NOT TESTED" for DEV/SANDBOX and "TRUE" for SIT/CERT/PROD env.
						   This is used with key-value pair assertion separated by a "#". Example - security_certificate#$AssertCertificate 
						   
	$AssertEnvironment	-> Used for Ping v2 API. It will return "SANDBOX" for DEV/SANDBOX env, "VALIDATION" for CERT env and 
						   "PRODUCTION" for SIT/PROD env.
						   This is used with key-value pair assertion separated by a "#". Example - environment#$AssertEnvironment
	
	##	-> Used to pass data "as is" from the test sheet irrespective of the template datatype definition. 
		This can be used to test invalid data type scenarios.
		Example: ##123.5, ##"Name", ##123, ##true
		
	
	

OVERRIDING AUTH TOKEN
----------------------
To override the default auth token, add a column called "Override Auth Token" and provide the updated auth token in the test data sheet.
This needs to be specified at the TC level. This can be used for scope/entitlements testing.

	Example 1:
	Column header:	Override Auth Token
	Column value:	auth_token_value
	
	Example 2:
	Column header:	Override Auth Token
	Column value:	SIT#auth_token_value

Note: If there is a need to override token specific to an environment, you can override the auth token for multiple environments as per 
the example below -

	Example 3:
	Column header:	Override Auth Token
	Column value:	SIT#auth1,DEV#auth2,SANDBOX#auth3 
	
	In the above example, the column value is a combination of the environment name and the auth token separated by a "#". 
	Multiple environments are separated by a comma.

OVERRIDING SCOPE WHEN GENERATING TOKENS
----------------------------------------
To override the default Scope specified in the config.properties file, add a column called "Override Scope" and provide the updated scopes in the test data sheet.
This needs to be specified at the TC level. This can be used for scope/entitlements testing.


OVERRIDING REQUEST TEMPLATE
---------------------------
To override the default request template, add a column called "Override Template" and provide the template name in the test data sheet.
This needs to be specified at the TC level. This can be used for corner cases with specific request contents.

EXCLUDING REQUEST HEADERS
---------------------------
To exclude a specific request header, add the request header to the "Exclude Header" column in the test data sheet. 
This needs to be defined at the TC level.

	Example:
		Exclude Header -> This will be the column header
		Content-Type	-> This will be the column value

OVERRIDING REQUEST HEADERS
---------------------------
Use the "override header" column in the test sheet to specify key-value pair being overriden.

	Example 1: Content-Type#xml
	In the above example, we are overriding the value of Content-Type as "xml"
		
	Example 2: Content-Type#{{EMPTY}}
	In the above example, we are overriding the value of Content-Type and sending it blank.


QUERY PARAMS INPUT 
-------------------
Simple query parameter:
	
	Example 1: Specify a search parameter in the query param.
	?search=id¦1234¦IN


Specify chained request input in the query param -

	Example 2: Single chained request data
	?search=id¦#header_1_1:Location¦IN
	
	Example 3: Multiple chained request data
	?search=id¦#header_1_1:Location¦#header_1_2:Location¦IN
	
In the examples above, the value for "Location" which is part of the header response is used to feed into the current request.

	Example 4: Chained request data from request body
	?search=customer_id¦#body_5_4:[0]customer_details$id¦IN
	
	[
	  {
	    "id": 2607,
	    "event_id": 1054,
	    "slot_id": 483,
	    "slot_start_datetime": "2017-11-30T18:00:00Z",
	    "status": "NO_SHOW",
	    "confirmation_code": "260770ed41a5-f",
	    "customer_details": {
	      "id": 385,
	      "name": "Su DuvalPullen Er",
	      "email": "melton@mail.com",
	      "phone_number": 7924199073,
	      "address": "456 Bluebrerrynorth",
	      "privileged": true
	    },
	    "party_details": {
	    ...
	    ]
	Example 5: #body_3_1:webhooks[]webhook_id$WHERE$status#ACTIVE 
	The above example looks up the first positive webhook_id based on the WHERE condition under the path specified. 
	Here, it looks for a webhook_id in the response with the ACTIVE status.
	
	Example 6: #body_24_1:webhooks[]webhook_id$WHERE$start_datetime#>{{UTC100D}}
	In the above example, start_datetime in UTC is compared against the local time in UTC.
	
	Example 7:  #body_24_1:webhooks[]webhook_id$WHERE$status#ANY
	The above example filters data by any value for the status field. This is specially useful for performing a delete action in an iterated loop.
	

REQUEST BODY INPUT FORMAT
-------------------------
	Example1:
	$name	
	$event_description	
	$start_date
	$end_date	
	$status	
	$schedule$[0]start_date	
	$schedule$[0]end_date	
	$schedule$[0]Monday$[0]start_time	
	$schedule$[0]Tuesday$[1]start_time

** Tip: To skip a field in the request body, leave the entry blank in the test sheet. This will cover use cases such as missing field scenarios to check for mandatory and optional fields.
** Note: Refer to the sample inputs above for the template below -	

	{
	"name": "Santa Claus Event3",
	"event_description": "To take a Photo with friends and Santa Claus.",
	"start_date": "2018-03-13",
	"end_date": "2018-04-11",
	"status": "DRAFT",
	"schedule": [{
		"start_date": "2018-03-13",
		"end_date": "2018-03-22",
		"monday": [{
				"start_time": "10:00",
				"end_time": "12:00",
				"number_of_slots": 12,
				"service_fee_amount": 10.50,
				"booking_capacity": 10
			},
			{
				"start_time": "14:30",
				"end_time": "17:00",
				"number_of_slots": 18,
				"service_fee_amount": 10.50,
				"booking_capacity": 10
			}
		],
		"tuesday": [{
				"start_time": "10:00",
				"end_time": "12:00",
				"number_of_slots": 12,
				"service_fee_amount": 10.50,
				"booking_capacity": 10
			},
						{
				"start_time": "14:30",
				"end_time": "17:00",
				"number_of_slots": 18,
				"service_fee_amount": 10.50,
				"booking_capacity": 10
			}
			
		],
		"wednesday": [{
				"start_time": "10:00",
				"end_time": "12:00",
				"number_of_slots": 12,
				"service_fee_amount": 10.50,
				"booking_capacity": 10
			}
		],
		"thursday": [{
				"start_time": "10:00",
				"end_time": "12:00",
				"number_of_slots": 12,
				"service_fee_amount": 10.50,
				"booking_capacity": 10
			}
		]
	}],
	"policy_options": {
		"cancellation_policy": 10,
		"reschedule_policy": 10,
		"hold_policy": 20
	},
	"facility_id": 3468

	}
	


REQUEST BODY INPUT FORMAT
-------------------------
	Example2:
	$id
	$event_id	
	$party_details$party_count	
	$party_details$guests_names	
	$slot_start_datetime

	{ "customer_details": {
    "id": 2492
	  },
	  "event_id": 4807,
	  "party_details": {
	    "party_count": 3,
	    "guests_names": [
	      "GTWAY_guest1",
	      "GTWAY_guest2",
	      "GTWAY_guest3"
	    ]
	  },
	  "slot_start_datetime": "2018-04-12T18:00:00Z"
	}



CHAINED REQUEST
---------------
'#' in the TestSheet Data Row

Example 1:
#header_6_1:Location -> Denotes a Chained Request to retrieve "Location" value from the Response Headers from Test Suite 6, Test Case 1.

Example 2:
#body_7_2:[1]id -> Denotes a Chained Request to retrieve "id" value from the Response Body from Test Suite 7, Test Case 2.

	[  {
    "id": 8797,
    "event_id": 4427,
    "slot_id": 7964,
    "slot_start_datetime": "2018-03-12T18:00:00Z",
    "status": "DELETED",
    "confirmation_code": "879767c6741a-0",
    "qr_code": "1027872Wn9P1",
    "customer_details": {
      "id": 2492,
      "name": "1023204J5c2W",
      "email": "1023268CVlsA@1023268CVlsA.com",
      "phone_number": 7622569917,
      "address": "234 Woodnorth",
      "privileged": true
    },
    "party_details": {
      "party_count": 4,
      "guests_names": [
        "GTWAY_guest1",
        "GTWAY_guest2",
        "GTWAY_guest3",
        "GTWAY_guest4"
      ],
      "notes": "Adding additional guests."
    },
    "created_ts": "2018-03-07T15:23:53Z",
    "modified_ts": "2018-03-08T05:07:35Z"
	  },
	  {
	    "id": 8798,
	    "event_id": 4427,
	    "slot_id": 7964,
	    "slot_start_datetime": "2018-03-12T18:00:00Z",
	    "status": "DELETED",
	    "customer_details": {
	      "id": 2492,
	      "name": "1023204J5c2W",
	      "email": "1023268CVlsA@1023268CVlsA.com",
	      "phone_number": 7622569917,
	      "address": "234 Woodnorth",
	      "privileged": true
	    },
	    "party_details": {
	      "party_count": 2,
	      "guests_names": [
	        "GTWAY_guest1",
	        "GTWAY_guest2"
	      ]
	    },
	    "created_ts": "2018-03-07T15:31:01Z",
	    "modified_ts": "2018-03-08T04:50:28Z"
	  }
	]

	Example 3: #body_3_1:user$user_id -> Denotes a Chained Request to retrieve "user_id" value from the Response Body from Test Suite 3, Test Case 1.
	Refer to sample response below -
	
	 {
	  "request_status": "Success",
	  "user": {
	    "user_id": "GATEWAY-286C1627",
	    "user_status": "Pending Login",
	    "first_name": "SIVA",
	    "last_name": "PINNAM",
	    "middle_initial": "S",
	    "email_address": "siva.pinnam@xx.com",
	    "user_contact_preferences": [
	      {
	        "contact_method": "Mobile",
	        "contact_number_type": "US/Canada",
	        "country_calling_code": "1",
	        "contact_number": "6123456789",
	        "contact_number_extension": "123",
	        "call_transfer_available": "Yes",
	        "call_transfer_number": "123456",
	        "delivery_channel_preference": "Call",
	        "created_by": "U571972",
	        "created_datetime": "2018-05-04T18:07:39.681Z"
	      }
	    ],
	    "created_by": "MYAPPADMIN",
	    "created_datetime": "2018-05-04T18:07:39.681Z",
	    "custom_fields": [
	      {
	        "field_name": "Portfolio ID",
	        "field_value": "12345",
	        "updated_by": "U571972"
	      }
	    ],
	    "user_type": "USER",
	    "entry_channel": "WCA_ADMIN",
	    "locale": "en_US"
		  }
		}


Specify chained request input in the query param -

	Example 1: Single chained request data
	?search=id¦#header_1_1:Location¦IN
	
	Example 2: Multiple chained request data
	?search=id¦#header_1_1:Location¦#header_1_2:Location¦IN
	
In the examples above, the value for "Location" which is part of the header response is used to feed into the current request.

VARIABLES IN THE RESOURCE PATH
-------------------------------
	
	'#' in the TestSheet Header Row
	Example #account_id will be added to the resource path listed below -
	 /xx/{account_id}
Here, the framework looks up the resource path and processes any variables defined within the {}.
Tip: You can choose to override the resource path as needed per TC using the "Override Resource Path" column header.

ADDING TO RESOURCE PATH
-------------------------------
	Additional resource information can be included to the resource path using this attribute specified via a column - "Add to Path"
	Example: You may have a base resource path to which you would like to append varying information based on the uses cases being 
	tested such as the ones listed below:

	
	
DEFAULTING TO TEMPLATE'S CONTENT
--------------------------------
To default the request payload to the content of the template specified, add a column called 
"Use Template Defaults" with a value of "Y" at the TC level. This will ignore the data field 
values specified and load the default content from the template. This can be used to test 
use cases such as "Invalid JSON structure" with invalid JSON body in the template.


ADDING ASSERTIONS/VALIDATION KEYWORDS
--------------------------------------
Response Status Line and Status Code Validation:

	Example 1: Validate Status Line
			Column header:	ValidateStatusLine 
			Column Value:	HTTP/1.1 401 Unauthorized
			
	Example 2: Validate Status Code
			Column header:	ValidateStatusCode
			Column Value:	401


Response Time Validation:

	Example 1:
		Column Header: ValidateResponseTime (ms)
		Cell Value: <4000
	The format above validates that the response time is less than 4000 ms.
	
	
	Example 2:
		Column Header: ValidateResponseTime (ms)
		Cell Value: >4000	
	The format above validates that the response time is more than 4000 ms.
	
Key Value, Field Exist, etc.	

	Content-Type#application/json	-> Key:Value Pair assertion.
	X-Global-Transaction-ID$Exist	-> If exist assertion.
	gateway-request-id$Exist		-> Not Null assertion.
	
Array Node validation example - in the e.g. below, the comma separated values are provided for the array node.

	success_users_list#"GATEWAY_RP6","GATEWAY_RP7"
			{
		  "success_users_list": [
		    "GATEWAY_RP6",
		    "GATEWAY_RP7"
		  ]
		}

Validating value for array object in the response:
In the example below, the API response returns an "accounts" object containing a list of accounts in an array. Further, each array entry contains
key-value pairs capturing the account details. Here, the value after the '#' is the expected result for the 2nd entry in the array -

	Example 1:	
	accounts[1]account_id#01C6U6T55VO5X5KX4ZZNJ37FEEQAAGBTOAPP2Q2J2YLLM64JS3GFWUGXCCXBN4HIHDWPT7V5R6LJBTI
	or
	accounts$[1]account_id#01C6U6T55VO5X5KX4ZZNJ37FEEQAAGBTOAPP2Q2J2YLLM64JS3GFWUGXCCXBN4HIHDWPT7V5R6LJBTI

	API Response Body:
	{    "accounts": [
      {
        "account_type": "CHECKING",
        "account_id": "01MUCSYXEMMAL57HCG3PWIGDOK4YKIKSWTY3GKMD3YWQ2JJVMKGMOFAYMP5IGG54I7FDH3EH3EDTDZE",
        "is_command_account": false,
        "description": " Simple Business Checking",
        "display_name": "BUSINESS CHECKING ...0615",
        "status": "OPEN"
      },
      {
        "account_type": "CHECKING",
        "account_id": "01C6U6T55VO5X5KX4ZZNJ37FEEQAAGBTOAPP2Q2J2YLLM64JS3GFWUGXCCXBN4HIHDWPT7V5R6LJBTI",
        "is_command_account": true,
        "description": "Command Asset Program Business",
        "display_name": "BUSINESS BROKERAGE CASH ...2215",
        "status": "OPEN"
      },
      {
        "account_type": "TIME",
        "account_id": "01QL5CIGMCBAZDIRWQNL3E7DYQWFYQ6RELFCTLLNLLCCWBI754KAZ54HFW2RIERLQRVNM4TNGOPET4O",
        "is_command_account": false,
        "account_sub_type": "CD",
        "description": "Certificate Of Deposit",
        "display_name": "TIME ACCOUNT ...0616",
        "status": "OPEN"
      }
     ]
  }
  
	Example 2:	
	[0]event_id#4427				or $[0]event_id#4427
	[0]party_details$party_count#4	or $[0]party_details$party_count#4
	
	API Response Body:
	[{  "customer_details": {
    "id": 2492
	  },
	  "event_id": 4427,
	  "party_details": {
	    "party_count": 4,
	    "guests_names": [
	      "GTWAY_guest1",
	      "GTWAY_guest2",
	      "GTWAY_guest3",
	      "GTWAY_guest4"
	    ],
	    "notes": "Adding additional guests."
	  },
	  "qr_code": "19n82828",
	  "slot_start_datetime": "2018-04-03T18:00:00Z"
	}]

	Example 3:
	errors[0]error_code#400-016		or errors$[0]error_code#400-016
	
	API Response Body:
	{  "errors": [
	    {
	      "error_code": "400-016",
	      "description": "'location_id' does not match the pattern: ^[a-zA-Z0-9]{1,7}$.",
	      "field_name": "location_id",
	  
	    }
	  ]
	}

	Example 4:
	times[0]$EXIST
	times[1]#2018-04-04T17:30:00Z
	
	API Response Body:
	{  "times": [
	    "2018-04-04T17:00:00Z",
	    "2018-04-04T17:30:00Z",
	    "2018-04-04T18:00:00Z",
	    "2018-04-04T18:30:00Z",
	    "2018-04-04T19:00:00Z",
	    "2018-04-04T19:30:00Z",
	    "2018-04-04T20:00:00Z",
	    "2018-04-04T20:30:00Z",
	    "2018-04-04T21:00:00Z",
	    "2018-04-04T21:30:00Z",
	    "2018-04-04T22:00:00Z",
	    "2018-04-04T22:30:00Z",
	    "2018-04-04T23:00:00Z"
	  ]
	}


	Example 5:
	users[0]user_id#GATEWAY711	or users$[0]user_id#GATEWAY711
	users[0]user_status$Exist	or users$[0]user_status$Exist	
	users[0]first_name$Exist	
	users[0]last_name$Exist	
	users[0]middle_initial$Exist
	
		{
	  "item_count": 1,
	  "users": [
	    {
	      "user_id": "GATEWAY711",
	      "user_status": "Disabled",
	      "first_name": "KIRAN",
	      "last_name": "YELIMELI",
	      "middle_initial": "H",
	      "email_address": "kiran.1@xxcom",
	      "user_contact_preferences": {
	        "contact_method": "Mobile",
	        "contact_number_type": "US/Canada",
	        "country_calling_code": "1",
	        "contact_number": "9999999999",
	        "call_transfer_available": "No",
	        "delivery_channel_preference": "Text",
	        "created_by": "myAppAdmin",
	        "created_datetime": "2018-04-04T08:22:08.914-07:00"
	      },
	      "created_by": "MYAPPADMIN",
	      "created_datetime": "2018-04-04T08:22:08.914-07:00",
	      "updated_by": "U571972",
	      "updated_datetime": "2018-04-10T10:52:28.920-07:00"
	    }
	  ]
	}


PARAMETERIZATION OF AUTH-TOKEN FOR HIGHER ENVIRONMENTS
======================================================
1. As per the new change in the framework, we have made Authentication_Key, gatewayEntityId and gatewayUserId as build parameters and it is
mandatory to pass these values for all higher environments script execution. Failing to provide the values, script will not be executed. 2. For lower environments, it is not mandatory to pass the values when triggering the build. If the values are not passed by the
user, then the framework will pick the values from the excel sheet for the respective environment selected.
3. Scenarios where multiple entity Id is used, we can use the exiting functionality to achieve this condition (OverrideHeader)
4. Running locally: To execute the test locally with parameters, we need to set these parameters values in VM arguments: 
-DAuthentication_Key= Basic Auth token generated by encrypting CustomerKey:ConsumerSecret
-DgatewayEntityID=xxxxxxxxxx-xxxxx-xxxxx
-DgatewayUserID=xxxxxxxx

REPEATING TCs VIA THE LOOP FEATURE
======================================================
1. Add a column named "Loop" in the test data sheet.
2. Enter a number for the TC to be repeatedly executed.


SETUP INSTRUCTION:
====================
1. Update the project name, test file name API_Scopes in the config.properties file in the project folder. 
2. Clone the provided excel test sheet.
3. Add the resource details in the "API_Env_Properties" tab.
4. Add the environment-resource combination entry in the "TestConfig"tab.
5. Add the Test Suite details in the "Test" tab and add steps as needed including the DataSource name.
6. Add the TCs in the test cases tab. This name should be as defined in the DataSource column in Step 4.
7. Download dependencies - navigate to the project folder in the cmd prompt and run "mvn install exec:java -s override-settings.xml"
8. To run the test, goto src/main/test -> TestRunner.java and right click on the TestRunner.java file and select "Java Application".
   Subsequently, you can just click on the "Play" icon to run the test.
9. Update the environment and tagName as needed in the config.properties file and rerun.

Note: If there are issues with resolving the custom JARs included in the framework, execute the Maven commands below to manually install the JARs to your local .m2 repository.

    mvn install:install-file -Dfile=src/test/resources/custom-jars/reporting-templates.jar -DgroupId=org.testng -DartifactId=java-framework -Dversion=1.10.3.0-SNAPSHOT -Dpackaging=jar

    mvn install:install-file -Dfile=src/test/resources/custom-jars/testng-6.9.12-Custom.9.jar -DgroupId=org.testng -DartifactId=testng -Dversion=6.9.12-Custom.9 -Dpackaging=jar

SETTING UP GIT TO PULL IN REMOTE CHANGES FROM THE RELEASE BRANCH
================================================================
1. Add the remote release branch to your local setup -

		git remote add release <test farmework git url>
		
2. Update the repo -

		git pull release master <test framework git url>
	
Tip: At any point, if there is a need to reset the branch with the release master, run the following command - 

		git reset --hard release/master

	
