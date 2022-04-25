# project-coursemana




## User stories

In this iteration, our group focused on making the previous funcionality more robust.

**Handling Input Type Error**

The interface now can handle the error caused by wrong user input type. The program will now repeatedly ask the user for a positive integer instead of throwing an error.

**New Functionality: add student to course**

The interface can now handle adding student to course commands.

**New Functionality: list students from a course**

The interface can now list students from a particular course.

**New Functinality: uppercase commands**

The interface now also supports uppercase commands. E.g. both "add course" and "ADD course" will work.

**Extracted Helper Methods**

We extracted several helper methods from the methods in Interface class to make the implementation cleaner. We also were able to develop test cases for these helper method since they do not depend on user input anymore. 

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
