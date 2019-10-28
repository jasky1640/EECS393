
import java.io.*;
import java.util.*;

public class LowPriorityCourse extends Course
{
    private int courseID;
    private String courseCode;
    private String courseName;
    private String timeSlot;
    private String information;
    private String prerequisite;
    private String courseType;
    private String substituteCourseCode;

    private ArrayList<Integer> LpCourses = new ArrayList<Integer>();

    public LowPriorityCourse(int courseIDs,int credit, String courseCodes, String courseNames, String timeSlots,
                             String prerequisites, String courseType, String substituteCourseCode)  // constructor
    {
        super(courseIDs, credit, courseCodes, courseNames,timeSlots, prerequisites, courseType, substituteCourseCode);
        courseID = courseIDs;
        courseCode = courseCodes;
        courseName = courseNames;
        timeSlot = timeSlots;
        prerequisite = prerequisites;
        courseType = courseType;
        substituteCourseCode = substituteCourseCode;
    }

    public static void setLpCourses(ArrayList<Integer> input) // only for testing purpose at this moment,
    // should get data from database in the end.
    {
        // do nothing
    }

    public ArrayList<Integer> getLpCourses() // should return a list of all low priority courses
    {
        return LpCourses;
    }

    public String toString()
    {
        return super.toString();
    }
}