#### Status of Known Bugs

###### Computer Science Schedule Generating System

https://github.com/jasky1640/EECS393/issues

------

###### Known Bugs

1. **Math 201/307 Time Conflict with Other Courses**

   Description: Math 201/307 courses are not checked by the time_conflict method, therefore the generated schedule has these two courses conflicting with other courses.

   Status: Solved at commit c9af574fcc66ae1db777bc77c94c626b43cd2e04

2. **Metprequisite method cannot handle more than one prerequisite**

   Description: current method could only handle one perquisite. In the case of multiple perquisites, only the first one will be checked.

   Status: Solved at commit 4a065e3292e5f7201fe99c263da14e272f4256c1

3. **Incorrect course type from Database access layer**

   Description: The course type should be 6 digits with last digit representing the statistics requirement. The problem is located in Coursedbconnect class: getCourse() and getCourseByDepth() methods.

   Status: Solved at commit d7fd7b3e271e11e4bfeaa0e1a9f9431c41c9330d

4. **Incorrect format in the selectUserPage.jsp table**

   Description: The format of the table in selectUserPage.jsp is skewed. The table format for each column is not consistent.

   Status: Solved at commit 7f0efa47b905d1bded3f5331c2b774d2089807bb

5. **An administration account could be registered in the normal user's registration page**

   Description: An administration, designed to be created in the database, could be registered in the current normal user registration page.

   Status: Solved at commit 7f0efa47b905d1bded3f5331c2b774d2089807bb

6. **Low priority course ranking is not correct**

   Description: The low priority course ranking is not correct in accordance of our design proposal. The source of the problem haven't been located yet.

   Status: Solved at commit 625f86d9deb63492339c02429431ecc7702e089e

7. **IndexOutOfBoundary exception in the test case of user "taotao"**

   Description: The edge case with vast majority of courses taken breaks the generating program. The source of the problem is located as no enough courses could be used in the generating system.

   Status: Solved at commit 7a49b533b6fa4f1f06fef8dc87a4eddfd9a28971
   
8. **Doesn’t take into consideration SAGES Requirements**

   Description: As an essential part of graduation and school of engineering requirements, SAGES requirements should be taken into consideration in the process of course generation. The current generator doesn’t support SAGES requirement courses, and so doesn’t the database.	

   Status: Not solved, reserved as part of future enhancements

9. **Doesn’t take into consideration the difference between BA (Bachelor of Arts) and BS (Bachelor of Science)**

   Description: The requirements for BA students and BS students are different, which is what we did not consider in our current implementation.

   Status: Not solved, reserved as part of future enhancements

10. **Doesn’t generate schedules for more than one semester**

    Description: The current system doesn’t support the functionality of generating a multiple-semester schedule that further benefits students’ academic progress. The main problem is that the database could not be updated since the available information for future semesters’ courses is limited.	

    Status: Not solved, reserved as part of future enhancements

11. **Doesn’t generate schedule according to a given number of total credits**

    Description: To generate schedule according to a number of total credits specified by the user would be a convenient function, which is not supported by our current system.	

    Status: Not solved, reserved as part of future enhancements

12. **The generating time is relatively long.**

    Description: Our current implementation takes around ten seconds to generate the schedules, which is too long. We may shorten the generating time by optimizing the generating algorithm.

    Status: Not solved, reserved as part of future enhancement

13. **Doesn’t handle courses with labs with different time slots**

    Description: Our current implementation couldn't handle courses with labs with different time slots. The source of problems is current over-complicated generating algorithm. Further optimization and abstraction will be required for the implementation of this feature.

     Status: Not solved, reserved as part of future enhancement

