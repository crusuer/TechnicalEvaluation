# CHALLENGE
This project was created as a Back-End Coding Exercise for Kantox.

## Goal
Write a command line driven to simulate a simple cashier function that adds products to a cart and displays the total 
price.

## Requirements
Before running the application, ensure the following dependencies are installed:

```
Java 11+
Maven 3.2.2+
```
## Compile
```
$ cd <pathToProject>
$ mvn clean package
```
## Running
```
$ java -jar target/TechnicalEvaluation-1.0.0.jar
```
## Testing
You can provide some products code (e.g. GR1,SR1,CF1), separated by comma (`,`) and the program will display the total 
price of 
basket.
To exit the program use just have to type `quit`. Example:
```
$ Basket: GR1,SR1,GR1,GR1,CF1
Total price expected: £22.45
$ Basket: GR1,GR1
Total price expected: £3.11
$ Basket: SR1,SR1,GR1,SR1
Total price expected: £16.61
$ Basket: GR1,CF1,SR1,CF1,CF1
Total price expected: £30.57
$ quit
```