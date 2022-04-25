# project-coursemana




## User stories

In this iteration, our group focused on making the previous functionalities more robust while also adding new minor functionalities. We improved code cleanliness by separating out helper methods from several methods in the Interface class. We also improved the testing of our project. 

***Handling Input Type Error***

The interface now can handle the error caused by wrong user input type. I.e. when the user inputs a string when the program expects a positive integer. The program will now repeatedly ask the user for a positive integer instead of throwing an error.

***New Functionality: add student to course***

The interface can now handle adding student to course command.

***New Functionality: list students from a course***

The interface can now list students from a particular course.

***New Functinality: uppercase commands***

The interface now also supports uppercase commands. E.g. "add course", "ADD course" and "add     course" will all work.

***Extracted Helper Methods***

We extracted several helper methods from the methods in Interface class to make the implementation cleaner. 

***Test Cases for Extracted Helper Methods***

Since the helper methods do not depend on user inputs anymore, we are able to develop a list of test cases for these helper methods. The tests are presented in <Interface_test.java>.

## User stories for the next iteration:

Looking forward, these funcionalities might be added to the program:

***edit commands:***
- edit course: edit the information of an existing course in the sysetm
- edit teacher: edit the information of an existing teacher in the sysetm
- edit student: edit the information of an existing student in the sysetm

***difference levels of access:***
- possibly we want to have two different levels of user access
- base level for viewing all courses, students, and teachers
- sudo level for adding, deleting, editing, and viewing all courses, students, and teachers


## Implemented but doesn't currently work:

Everything currently works!!


## How to Run Our Code:
1. Clone and cd into the repository on your command line.
2. start the program with "./startScript.sh".
3. Follow the on screen instructions for inputs. 
