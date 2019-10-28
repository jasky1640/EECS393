import java.util.*;

public class Course
{
    public static final String NO_SUBSTITUTES = "";

    private int credit;
    private int courseID;
    private String courseCode;
    private String courseName;
    private String timeSlot;
    private String prerequisite;
    private String courseType;
    private String substituteCourseCode;

    public Course(int courseIDs, int credit, String courseCodes, String courseNames, String timeSlots,
                  String prerequisites, String courseTypes,String substituteCourseCodes)
    {
        this.credit = credit;
        courseID = courseIDs;
        courseCode = courseCodes;
        courseName = courseNames;
        timeSlot = timeSlots;
        prerequisite = prerequisites;
        courseType = courseTypes;
        substituteCourseCode = substituteCourseCodes;
    }

    public void printCourse()
    {
        System.out.println("Course id: " + courseID);
        System.out.println("Course code: " + courseCode);
        System.out.println("Course name: " + courseName);
        System.out.println("Time slot: " + timeSlot);
        System.out.println("Prerequisites: " + prerequisite);
        System.out.println("Type: " + courseType);
        System.out.println("Substitute Id: "+ substituteCourseCode);
    }

    public int getCourseID()
    {
        return courseID;
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public String getTimeSlot()
    {
        return timeSlot;
    }

    public String getPrerequisite()
    {
        return prerequisite;
    }

    public String getCourseType()
    {
        return courseType;
    }

    public String getSubstituteCourseCode()
    {
        return substituteCourseCode;
    }

    public String toString()
    {
        return (courseID + "  " + courseCode + "  " + courseName + "  " + timeSlot + "  " +
                prerequisite + "  " + courseType + "  " + substituteCourseCode);
    }
}