import java.io.*;
import java.util.*;

public class highPriorityCourse extends Course
{
  private int courseID;
  private String courseCode;
  private String courseName;
  private String timeSlot;
  private String information;
  private String prerequisite;
  private int courseType;
  private int substituteID;
  
  private ArrayList<Integer> EGERCourses = new ArrayList<Integer>();
  private ArrayList<Integer> CSMRCourses = new ArrayList<Integer>();
  private ArrayList<Integer> CSCRCourses = new ArrayList<Integer>();
  private ArrayList<Integer> CSDRCourses = new ArrayList<Integer>();
  private ArrayList<Integer> CSBRCourses = new ArrayList<Integer>();
  private ArrayList<Integer> SRCourses = new ArrayList<Integer>();
  
  public static void setEGERCourses(ArrayList<Integer> input) // only for testing purpose at this moment, 
    // should get data from database in the end.
  {
    input.clear();
    input.add(5);
    input.add(9);
    input.add(19);
  }
  
    public static void setCSMRCourses(ArrayList<Integer> input) // only for testing purpose at this moment, 
    // should get data from database in the end.
  {
    input.clear();
    input.add(5);
    input.add(9);
    input.add(19);
  }
    
      public static void setCSCRCourses(ArrayList<Integer> input) // only for testing purpose at this moment, 
    // should get data from database in the end.
  {
    input.clear();
    input.add(5);
    input.add(9);
    input.add(19);
  }
      
        public static void setCSDRCourses(ArrayList<Integer> input) // only for testing purpose at this moment, 
    // should get data from database in the end.
  {
    input.clear();
    input.add(5);
    input.add(9);
    input.add(19);
  }
        
          public static void setSRCourses(ArrayList<Integer> input) // only for testing purpose at this moment, 
    // should get data from database in the end.
  {
    input.clear();
    input.add(5);
    input.add(9);
    input.add(19);
  }
  
  public highPriorityCourse(int courseIDs, String courseCodes, String courseNames, String timeSlots, 
                String informations, String prerequisites, int courseTypes,int substituteIDs)  // constructor
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
  
      public String getUserName(userInfo input)
  {
    return input.getUsername();
  }
  
    public String getUserDegree(userInfo input)
  {
    return input.getDegree();
  }
  
    public String getUserTrack(userInfo input)
  {
    return input.getTrack();
  }
  
  public ArrayList<Integer> getUserCourses(userInfo input)
  {
    return input.getCourses();
  }
  
   public userInfo getUserInfo(userInfo input)
  {
    return input;
  }
   
   public ArrayList<Integer> getHpCourses() // should return a list of all high priority courses
   {
     ArrayList<Integer> output = new ArrayList<Integer>();
     output.addAll(EGERCourses);
     output.addAll(CSMRCourses);
     output.addAll(CSCRCourses);
     output.addAll(CSDRCourses);
     output.addAll(SRCourses);
     return output;
   }
  
  public ArrayList<Integer> getEGERoptions(ArrayList<Integer> coursesTaken) // should return a list of EGER courses 
    // still need to take
  {
    highPriorityCourse.setEGERCourses(EGERCourses);
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.addAll(EGERCourses);
    output.removeAll(coursesTaken);
    return output;
  }
  
  public ArrayList<Integer> getCSMRoptions(ArrayList<Integer> coursesTaken) // should return a list of CSMR courses 
    // still need to take
  {
    highPriorityCourse.setCSMRCourses(EGERCourses);
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.addAll(CSMRCourses);
    output.removeAll(coursesTaken);
    return output;
  }
  
  public ArrayList<Integer> getCSCRoptions(ArrayList<Integer> coursesTaken) // should return a list of CSCR courses 
    // still need to take
  {
    highPriorityCourse.setCSCRCourses(EGERCourses);
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.addAll(CSCRCourses);
    output.removeAll(coursesTaken);
    return output;
  }
  
  public ArrayList<Integer> getCSDRoptions(ArrayList<Integer> coursesTaken) // should return a list of CSDR courses 
    // still need to take
  {
    highPriorityCourse.setCSDRCourses(EGERCourses);
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.addAll(CSDRCourses);
    output.removeAll(coursesTaken);
    return output;
  }
  
  public ArrayList<Integer> getSRoptions(ArrayList<Integer> coursesTaken) // should return a list of SR courses 
    // still need to take
  {
    highPriorityCourse.setSRCourses(EGERCourses);
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.addAll(SRCourses);
    output.removeAll(coursesTaken);
    return output;
  }
  
   public static void main(String[] args)
   {
    highPriorityCourse test1 = new highPriorityCourse(23, "EECS393", "Software Engineering", "MWF11:40-12:30", 
                                                     "Instructor:Andy Podgurski", "EECS132", 4, -1);
    highPriorityCourse test2 = new highPriorityCourse(24, "EECS391", "Artificial Intelligence", "MWF13:30-14:45", 
                                                     "Instructor:Michael Lewcki", "EECS132", 4, -1);
    System.out.println(test1);
    System.out.println(test2);
    
    ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
    coursesTaken.add(5);
    coursesTaken.add(7);
    coursesTaken.add(11);
    coursesTaken.add(19);
    coursesTaken.add(23);
    userInfo xx = new userInfo("Jerry", "BS", "AI", coursesTaken);
    System.out.println(test1.getUserInfo(xx));
    System.out.println(test1.getEGERoptions(coursesTaken));
    
   }
  
}