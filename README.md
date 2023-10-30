# Technical assessment

## Introduction
My project consists of a service that provides a REST endpoint for querying, which accepts the following input parameters:

1. Application date. 
2. Product identifier.
3. Chain identifier.

And returns the following output data:

1. In case of an error or no match: a descriptive message.
2. In case of a match: Product identifier, Chain identifier, Applicable rate, Application dates (start and end), and Final price to be applied. 
	
Developing tests for the REST endpoint that validate the service requests with the example data provided at the end of the statement.

## Technical description

To perform this project, I have used Java11 and Spring Boot as the programming language. In addition to dependencies such as H2 (for the in-memory database), JPA, and Lombok.

I have used GitHub as a version control system and Spring Tool Suite 4 as an IDE.

I've structured this project following the hexagonal architecture design.

In the com.priceproject.app package, located within src/main/java, we find:

First:
- application: In which the use case is located. It is responsible for parsing the input date into the correct data format and calls the service, passing the date, productId, and brandId as parameters.

Second: 
- domain: Inside, you will find the model, the repository, and the service.

In the model, you will find the classes:
- Currency, used to represent the currency as an enum.
- Price, which is used to represent the data stored in the database.
- Output, which is an abstract class used to wrap the output type.
- ErrorOutput extends the Output class and has the message as an attribute to be displayed on the screen.
- PriceOutput extends the Output class and is used to represent the attributes of the rate that should be applied.

The PriceRepository class is used to dump the data found in the database into it.

The PriceService class is responsible for calling the EntityManager to retrieve the data stored in the database, and then filtering it based on the input data. If no match is found, it returns an ErrorOutput, whereas if a rate to be applied is found, it returns a PriceOutput.

Third:
- infrastructure:

In the rest package, you will find the PriceController class, which corresponds to the REST controller where the request is mapped. It invokes the use case.

The DateParse class is responsible for transforming a String into a LocalDateTime data.

The EntityManager class is responsible for making the call to the PriceRepository class to retrieve all the data in the database.

In src/main/resources, you will find application.properties, in which the connection with H2 is specified, and the data.sql file is used for dumping example data into the database.

In the com.priceproject.app.application.usecase package, located within src/test/java, we find:

The GetPricesUseCaseTest class contains the implementation of the test cases specified in the statement.

## Installation

If you want to run the application, you should follow the following steps

1. Clone the repository.
2. Navigate to the project directory.
3. Import 'price' folder, which is located within 'assessment,' into your preferred IDE.
4. Perform a Maven Project Update to verify that all dependencies have been successfully downloaded.

## Usage
To make a request to the REST API, open a web browser and enter the following URL:
http://localhost:8080/date_value/product_id_value/chain_id_value

Where

- date_value is the application date in the format yyyy-MM-dd.HH.mm.ss
- product_id_value is the product ID value. It must be a integer number.
- chain_id_value is the chain ID value. It must be a integer number.

An example of a valid input to determine the applicable rate for June fourteenth of this year at ten o'clock in the evening for chain group one and the product with an ID of one thousand would be as follows: 
http://localhost:8080/2023-06-14-22.00.00/1000/1