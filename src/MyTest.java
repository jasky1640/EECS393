import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

    private static ArrayList<Integer> normalRequirements;
    private static ArrayList<Integer> requirementWithOneCourse;
    private static Course courseWithPrerequisite;
    private static ArrayList<Integer> coursesTaken1;
    private static ArrayList<Integer> coursesTaken2;
    private static ArrayList<Integer> coursesTaken3;
    private static Plan fullPlan1, fullPlan2;
    private static ArrayList<Plan> fullPlansList;
    private static User user1, user2, user3;

    @Before
    public void setUp() {

        courseWithPrerequisite = new Course(5, 4, "EECS233",
                "Introduction to Data Structures", "13514301520",
                "EECS132", "010000", Course.NO_SUBSTITUTES);


        for (int i = 0; i < Generator.MAX_NUM_COURSES; i++) {
            fullPlan1.addCourse(i);
            fullPlan2.addCourse(i+5);
        }
        fullPlansList.add(fullPlan1);
        fullPlansList.add(fullPlan2);

        normalRequirements = new ArrayList<>();
        requirementWithOneCourse = new ArrayList<>();

        /* assume requirements1 includes courses with id's 1,3,5,7,9 */
        normalRequirements.add(1);
        normalRequirements.add(3);
        normalRequirements.add(5);
        normalRequirements.add(7);
        normalRequirements.add(9);
        normalRequirements.add(11);
        normalRequirements.add(13);
        normalRequirements.add(15);
        normalRequirements.add(17);
        normalRequirements.add(19);

        /* assume requirements2 includes only course with id=1 */
        requirementWithOneCourse.add(500);

        // courses taken by user1
        coursesTaken1 = new ArrayList<>();
        coursesTaken1.add(1);
        coursesTaken1.add(3);
        coursesTaken1.add(5);
        coursesTaken1.add(7);
        coursesTaken1.add(9);
        coursesTaken1.add(11);
        coursesTaken1.add(13);
        coursesTaken1.add(15);
        coursesTaken1.add(17);
        coursesTaken1.add(19);
        coursesTaken1.add(100);

        // user1 has taken all courses from the requirements list
        user1 = new User(23, HighPriorityCourse.DDM, coursesTaken1);

        // courses taken by user2
        coursesTaken2 = new ArrayList<>();
        coursesTaken2.add(2);
        coursesTaken2.add(4);
        coursesTaken2.add(6);
        coursesTaken2.add(8);
        coursesTaken2.add(10);

        // user2 hasn't taken any courses from the requirements list
        user2 = new User(17, HighPriorityCourse.DDM, coursesTaken2);

        // courses taken by user3
        coursesTaken3 = new ArrayList<>();
        coursesTaken3.add(1);
        coursesTaken3.add(2);
        coursesTaken3.add(3);
        coursesTaken3.add(4);
        coursesTaken3.add(5);

        // user3 has taken some courses from the requirements list
        user3 = new User(10, HighPriorityCourse.DDM, coursesTaken3);



    }

    /**
     * Structured Basis: nominal case, first boolean condition is true:
     * the user does NOT meet the prerequisite of one course from the requirement list
     *  Good data: nominal case: 10 items
     */
    @DisplayName("Test fulfillRequirement: prerequisite not met")
    @Test
    public void prerequisiteNotMetTest() throws Exception {
        Generator.fulfillRequirement(normalRequirements, user3);
        /* since course with id = 5 has a prerequisite of course with id = 100,
        and user3 hasn't taken course with id = 100,
        the result plans list should NOT include this course (id=5)
         */
        boolean hasWrongCourse = false;
        ArrayList<Plan> plans = user3.getPlans();
        for (int i = 0; i < plans.size(); i++) { // go through all plans
            Plan plan = plans.get(i);
            for (int j = 0; j < plan.getNumOfCourses(); j++) { // go through all courses in a plan
                int courseID = plan.getCourseAt(j);
                if (courseID == courseWithPrerequisite.getCourseID())
                    hasWrongCourse = true;
            }
        }

        assertFalse(hasWrongCourse);

    }

    /**
     * Structured Basis: nominal case, first boolean condition is false and
     * the second if condition is true:
     * the user does meet the prerequisite of one course from the requirement list
     * and the plans list is empty
     *  Good data: nominal case: 10 items
     */
    @DisplayName("Test fulfillRequirement: empty plans list")
    @Test
    public void emptyPlansTest() throws Exception {
        Generator.fulfillRequirement(requirementWithOneCourse, user1);
        /* user1's plans list was initialized as an empty list, and requirements2
        includes only one course with id=1, so user1's plans list should only contain
        one array list which has one element
         */
        ArrayList<Plan> plans = user1.getPlans();
        assertEquals(plans.size(), 1);
        assertEquals(plans.get(0).getCourseAt(0), requirementWithOneCourse.get(0));
    }

    /**
     * Structured Basis: nominal case, first boolean condition is false:
     * the user does meet the prerequisite of one course from the requirement list
     *  Good data: nominal case: 10 items
     */
    @Test
    public void prerequisiteMetTest() throws Exception {
        Generator.fulfillRequirement(normalRequirements, user1);
        /* since course with id = 5 has a prerequisite of course with id = 100,
        and user1 has taken this course,
        at least one of the result plans should include this course (id=5)
         */
        boolean hasRequirementCourse = false;
        ArrayList<Plan> plans = user1.getPlans();
        for (int i = 0; i < plans.size(); i++) { // go through all plans
            Plan plan = plans.get(i);
            for (int j = 0; j < plan.getNumOfCourses(); j++) { // go through all courses in a plan
                int courseID = plan.getCourseAt(j);
                if (courseID == courseWithPrerequisite.getCourseID())
                    hasRequirementCourse = true;
            }
        }

        assertFalse(hasRequirementCourse);

    }

    /**
     * Structured Basis: nominal case:
     * all of the user's plans are full (i.e., each plan has been assigned
     * the maximum number of courses
     *  Good data: nominal case: 1 items
     */
    @DisplayName("Test fulfillRequirement: full plans list")
    @Test
    public void fullPlansTest() throws Exception {
        User user4 = new User(11, HighPriorityCourse.DDM, coursesTaken3);
        user4.setPlans(fullPlansList);
        int oldPlansSize = user4.getPlans().size();
        Generator.fulfillRequirement(requirementWithOneCourse, user4);
        /* Here our requirements list contains only one course, and each plan from
        user4's current plans list is full.
        Therefore, we expect the new user4's plans list has one new list containing
        the requirement course's id after executing fulfillRequirement.
         */
        ArrayList<Plan> newPlans = user4.getPlans();
        int newPlansSize = newPlans.size();
        Plan newPlan = newPlans.get(newPlansSize-1);
        assertEquals(oldPlansSize+1, newPlansSize);
        assertEquals(1, newPlan.getNumOfCourses());
        assertEquals(requirementWithOneCourse.get(0), newPlan.getCourseAt(0));
    }


    @Test
    public void getEGERoptionsTest()
    {
        HighPriorityCourse test1 = new HighPriorityCourse(23,3, "EECS393", "Software Engineering", "13511401230",
                "Instructor:Andy Podgurski", "EECS233", "001001", HighPriorityCourse.NO_SUBSTITUTES);
        ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
        coursesTaken.add(1);
        coursesTaken.add(3);
        coursesTaken.add(5);
        coursesTaken.add(7);
        coursesTaken.add(9);
        assertEquals(19, test1.getEGERoptions(coursesTaken).get(0), "should return courses still need to take");
    }

    @Test
    public void getCSCRoptionsTest()
    {
        HighPriorityCourse test1 = new HighPriorityCourse(23, 3, "EECS393", "Software Engineering", "13511401230",
                "Instructor:Andy Podgurski", "EECS233", "001001", HighPriorityCourse.NO_SUBSTITUTES);
        ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
        coursesTaken.add(1);
        coursesTaken.add(3);
        coursesTaken.add(5);
        coursesTaken.add(7);
        coursesTaken.add(9);
        assertEquals(19, test1.getCSCRoptions(coursesTaken).get(0), "should return courses still need to take");
    }

    @Test
    public void getCSDRoptionsTest()
    {
        HighPriorityCourse test1 = new HighPriorityCourse(23, 3, "EECS393", "Software Engineering", "13511401230",
                "Instructor:Andy Podgurski", "EECS233", "001001", HighPriorityCourse.NO_SUBSTITUTES);
        ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
        coursesTaken.add(1);
        coursesTaken.add(3);
        coursesTaken.add(5);
        coursesTaken.add(7);
        coursesTaken.add(9);
        assertEquals(19, test1.getCSDRoptions(coursesTaken).get(0), "should return courses still need to take");
    }

    @Test
    public void getCSBRoptionsTest()
    {
        HighPriorityCourse test1 = new HighPriorityCourse(23, 3, "EECS393", "Software Engineering", "13511401230",
                "Instructor:Andy Podgurski", "EECS233", "001001", HighPriorityCourse.NO_SUBSTITUTES);
        ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
        coursesTaken.add(1);
        coursesTaken.add(3);
        coursesTaken.add(5);
        coursesTaken.add(7);
        coursesTaken.add(9);
        assertEquals(19, test1.getCSBRoptions(coursesTaken).get(0), "should return courses still need to take");
    }

    @Test
    public void getSRoptionsTest()
    {
        HighPriorityCourse test1 = new HighPriorityCourse(23, 3, "EECS393", "Software Engineering", "13511401230",
                "Instructor:Andy Podgurski", "EECS233", "001001", HighPriorityCourse.NO_SUBSTITUTES);
        ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
        coursesTaken.add(1);
        coursesTaken.add(3);
        coursesTaken.add(5);
        coursesTaken.add(7);
        coursesTaken.add(9);
        assertEquals(19, test1.getSRoptions(coursesTaken).get(0), "should return courses still need to take");
    }

    @Test
    public void checkPrerequisiteTest()
    {
        Course EECS302 = new Course(3, 3, "EECS302",
                "Discrete Mathematics", "13509301020",
                "MATH122", "010000", HighPriorityCourse.NO_SUBSTITUTES);
        ArrayList<Integer> coursesTaken = new ArrayList<>();
        coursesTaken.add(1);
        coursesTaken.add(2);
        coursesTaken.add(3);
        coursesTaken.add(4);
        coursesTaken.add(5);
        User user = new User(15, HighPriorityCourse.AI, coursesTaken);
        assertFalse(user.metPrerequisite(EECS302), "should return false");
    }

}
