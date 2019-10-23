import java.io.*;
import java.util.*;

public class lowPriorityCourse extends Course
{
  private int courseID;
  private String courseCode;
  private String courseName;
  private String timeSlot;
  private String information;
  private String prerequisite;
  private int courseType;
  private int substituteID;
  
  private ArrayList<Integer> LpCourses = new ArrayList<Integer>();
  
  public lowPriorityCourse(int courseIDs, String courseCodes, String courseNames, String timeSlots, 
                String informations, String prerequisites, int courseTypes,int substituteIDs)
  {
    super(courseIDs, courseCodes, courseNames,timeSlots, informations, prerequisites, courseTypes, substituteIDs);
    courseID = courseIDs;
    courseCode = courseCodes;
    courseName = courseNames;
    timeSlot = timeSlots;
    information = informations;
    prerequisite = prerequisites;
    courseType = courseTypes;
    substituteID = substituteIDs;
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