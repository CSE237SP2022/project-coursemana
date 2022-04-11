# project-coursemana




## User stories

In this iteration, user can run the user interface with "startScript.sh". The interface supports the following commands:

***add commands:***
- add course: add a course to the sysetm
- add teacher: add a teacher to the sysetm
- add student: add a student to the sysetm

***list commands:***
- list course: list all courses in the system
- list teacher: list all teachers in the system
- list student: list all students in the system

Users can call these commands simply by typing the commad to the interface and follow the instructions for further user inputs. When invlaid commands are given, the interface will print out a usage message containning all available commands.


## User stories for the next iteration:

In the next iteration, the following command will be added to the interface:

***edit commands:***
- edit course: edit the information of an existing course in the sysetm
- edit teacher: edit the information of an existing teacher in the sysetm
- edit student: edit the information of an existing student in the sysetm

***course management commands:***
- add student to course: add a student in the system to a course; course size would be considered  in the process.
- list student in course: list all student in a course with their current grades


## Implemented but doesn't currently work:

***Data Type Error Catch***

The commands rely on input from the user, so errors may be caused when users give input in invalid data type (givng String to an integer scanner, etc.). We will fix this in the next iteration by implementing exception handler.


## How to Run Our Code:
1. Clone and cd into the repository on your command line.
2. start the program with "./startScript.sh".
