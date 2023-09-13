<div align="center"><h3><a href="README.md">English</a> | <a href="README_ES.md">Spanish</a></h3></div>
<div align="center"><h1>SpinWords Api</h1></div>

#### The SpinWords API takes an input and reverses each word if said word has a length of five or more characters.  

#### In the most recent update, it was introduced a new method that takes the length of each word as a parameter so it can be personalized.

## Development and Status
The roadmap for this project will consist in:
+ Adding the base java logic for reversing the words ✅
+ Make use of the SpringBoot annotations to make it a RESTful service ✅
+ Refine the java logic to make the project more precise and with more functionalities ✅
+ Make use of a JDBC and JPA to connect to a local database ✅
+ Add Junit tests to ensure the functionality of the code ✅

## Purpose of this project

+ The main purpose of this project is to showcase my knowledge and abilities in the following technologies:
    + Java
    - SpringBoot
    + Git
    - JDBC
    - JPA
    - MySQL
    - Junit
    - Mockito

## Project Structure
The project is structured as follows:
#### com.example.SpinWordsApi
This is the main folder where is the application main method and all its sub-packages
#### Entity
Here we'll find the "SentenceEntity" class which represents an entity in a database.
#### SentenceController
Here is the "SpinWordsController" which handles the HTTP methods.
#### Service
Here we will find two interfaces "SentenceRepository", "SentenceService" and one class "SentenceServiceImpl".

###### SentenceRepository
This interface extends the JpaRepository interface so we can make use of commun endpoints that Jpa offers, aditionally
there's a custom method for retrieven sentences with a custom query called "findByOriginalSentenceLengthGreaterThan"

###### SentenceService
This interface offers two abstracts methods that will be the ones responsible for the main logic of this code. 

###### SentenceServiceImpl
This class implements the "SentenceService" interface and its the one responsible for reversing the sentences and saving them in the database.
