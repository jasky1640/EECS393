import java.util.*;

public class Course
{
  private int courseID;
  private String courseCode;
  private String courseName;
  private String timeSlot;
  private String information;
  private String prerequisite;
  private int courseType;
  private int substituteID;
  
  public Course(int courseIDs, String courseCodes, String courseNames, String timeSlots, 
                String informations, String prerequisites, int courseTypes,int substituteIDs)
  {
    courseID = courseIDs;
    courseCode = courseCodes;
    courseName = courseNames;
    timeSlot = timeSlots;
    information = informations;
    prerequisite = prerequisites;
    courseType = courseTypes;
    substituteID = substituteIDs;
  }
  
  public void printCourse()
  {
    System.out.println("Course id: " + courseID);
    System.out.println("Course code: " + courseCode);
    System.out.println("Course name: " + courseName);
    System.out.println("Time slot: " + timeSlot);
    System.out.println("Information: " + information);
    System.out.println("Prerequisites: " + prerequisite);
    System.out.println("Type: " + courseType);
    System.out.println("Substitute Id: "+ substituteID);
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
  
  public String getInformation()
  {
    return information;
  }
  
  public String getPrerequisite()
  {
    return prerequisite;
  }
  
  public int getCourseType()
  {
    return courseType;
  }
  
  public int getSubstituteID()
  {
    return substituteID;
  }
  
  public String toString()
  {
    return (courseID + "  " + courseCode + "  " + courseName + "  " + timeSlot + "  " + information + "  " + 
  prerequisite + "  " + courseType + "  " + substituteID);
  }
}