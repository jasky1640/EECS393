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
  
    public String toString()
  {
    return super.toString();
  }
}