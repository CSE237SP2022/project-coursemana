# project-coursemana




## User stories

In this iteration, user can run the user interface with "startScript.sh". The interface supports the following commands:

***add commands:***
- add course: add a course to the system
- add teacher: add a teacher to the system
- add student: add a student to the system

***list commands:***
- list course: list all courses in the system
- list teacher: list all teachers in the system
- list student: list all students in the system

Users can call these commands simply by typing the commad to the interface and follow the instructions for further user inputs. When invalid commands are given, the interface will print out a usage message containing all available commands.


## User stories for the next iteration:

In the next iteration, the following command will be added to the interface:

***edit commands:***
- edit course: edit the information of an existing course in the sysetm
- edit teacher: edit the information of an existing teacher in the sysetm
- edit student: edit the information of an existing student in the sysetm

***course management commands:***
- add student to course: add a student in the system to a course; course size would be considered in the process.
- list student in course: list all student in a course with their current grades

***difference levels of access:***
- possibly we want to have two different levels of user access
- base level for viewing all courses, students, and teachers
- sudo level for adding, deleting, editing, and viewing all courses, students, and teachers


## Implemented but doesn't currently work:

**Data Type Error Catch**

The commands rely on input from the user, so exceptions may be throws when users give input in invalid data type (givng String when the program expects an integer input for course ID, etc.). We will fix this in the next iteration by implementing exception handler.

**Add Course Command Can Throw Exception**

The addCourse() command will throw an exception if the teacher of the course that the user want to add is not currently in the database. We will fix this issue in the next iteration by disabling the user from adding a course if the teacher of that course is not already in the database. 


## How to Run Our Code:
1. Clone and cd into the repository on your command line.
2. start the program with "./startScript.sh".
3. Follow the on screen instructions for inputs. 
