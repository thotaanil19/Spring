# spring-boot

1. Build and Run spring-soap-producer
http://localhost:8081/ws/countries.wsdl
2. Build and Run spring-soap-consumer
http://localhost:8080/test


Test soap client directly in Postman...
Case 1: 
[POST]http://localhost:8081/ws

Request:
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
					  xmlns:gs="http://spring.io/guides/gs-producing-web-service">
	   <soapenv:Header/>
	   <soapenv:Body>
		  <gs:getCountryRequest>
			 <gs:name>India</gs:name>
		  </gs:getCountryRequest>
	   </soapenv:Body>
	</soapenv:Envelope>
	
Response:
	<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
		<SOAP-ENV:Header/>
		<SOAP-ENV:Body>
			<ns2:getCountryResponse xmlns:ns2="http://spring.io/guides/gs-producing-web-service">
				<ns2:country>
					<ns2:name>India</ns2:name>
					<ns2:population>32435353</ns2:population>
					<ns2:capital>Delhi</ns2:capital>
					<ns2:currency>INR</ns2:currency>
				</ns2:country>
			</ns2:getCountryResponse>
		</SOAP-ENV:Body>
	</SOAP-ENV:Envelope>
	
Case 2: 
[POST]http://localhost:8081/ws

Request:
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
					  xmlns:gs="http://spring.io/guides/gs-producing-web-service">
	   <soapenv:Header/>
	   <soapenv:Body>
		  <gs:getEmployeeRequest>
			 <gs:id>1</gs:id>
		  </gs:getEmployeeRequest>
	   </soapenv:Body>
	</soapenv:Envelope>

Response:
	<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
		<SOAP-ENV:Header/>
		<SOAP-ENV:Body>
			<ns2:getEmployeeResponse xmlns:ns2="http://spring.io/guides/gs-producing-web-service">
				<ns2:employee>
					<ns2:id>1</ns2:id>
					<ns2:name>Anil</ns2:name>
					<ns2:sal>100.0</ns2:sal>
					<ns2:dept>
						<ns2:id>1000</ns2:id>
						<ns2:name>CSE</ns2:name>
					</ns2:dept>
				</ns2:employee>
			</ns2:getEmployeeResponse>
		</SOAP-ENV:Body>
	</SOAP-ENV:Envelope>



To created XSD files, first create sample xml for resuest, reponse, DTO's and convert them into XSD using XML to XSD converter


For More:
https://www.tutorialspoint.com/springws/springws_first_application.htm