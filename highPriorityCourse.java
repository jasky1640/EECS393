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
  
  public static void addCourses(ArrayList<Integer> input) // only for testing purpose
  {
    input.add(5);
    input.add(9);
    input.add(19);
    input.add(17);
  }
  
  public highPriorityCourse(int courseIDs, String courseCodes, String courseNames, String timeSlots, 
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
  
  public ArrayList<Integer> getEGERoptions(ArrayList<Integer> coursesTaken)
  {
    highPriorityCourse.addCourses(EGERCourses);
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.addAll(EGERCourses);
    for (int i = 0; i < EGERCourses.size() - 2; i++)
    {
      for (int j = 0; j < coursesTaken.size(); j++)
      {
      if (EGERCourses.get(i) == coursesTaken.get(j))
      {
        output.remove(j);
      } 
    }
    }
    return output;
  }
  
  public ArrayList<Integer> getCSMRoptions(ArrayList<Integer> coursesTaken)
  {
    ArrayList<Integer> output = CSMRCourses;
    for (int i = 0; i < coursesTaken.size(); i++)
    {
      for (int j = 0; j < CSMRCourses.size(); j++)
      {
      if (coursesTaken.get(i) == CSMRCourses.get(j))
      {
        output.remove(j);
      }
      }
    }
    return output;
  }
  
  public ArrayList<Integer> getCSCRoptions(ArrayList<Integer> coursesTaken)
  {
    ArrayList<Integer> output = CSCRCourses;
    for (int i = 0; i < coursesTaken.size(); i++)
    {
      for (int j = 0; j < CSCRCourses.size(); j ++)
      {
      if (coursesTaken.get(i) == CSCRCourses.get(j))
      {
        output.remove(j);
      }
      }
    }
    return output;
  }
  
  public ArrayList<Integer> getCSDRoptions(ArrayList<Integer> coursesTaken)
  {
    ArrayList<Integer> output = CSDRCourses;
    for (int i = 0; i < coursesTaken.size(); i++)
    {
      for (int j = 0; j < CSDRCourses.size(); j ++)
      {
      if (coursesTaken.get(i) == CSDRCourses.get(j))
      {
        output.remove(j);
      }
      }
    }
    return output;
  }
  
  public ArrayList<Integer> getCSBRoptions(ArrayList<Integer> coursesTaken)
  {
    ArrayList<Integer> output = CSBRCourses;
    for (int i = 0; i < coursesTaken.size(); i++)
    {
      for (int j = 0; j < CSBRCourses.size(); j ++)
      {
      if (coursesTaken.get(i) == CSBRCourses.get(j))
      {
        output.remove(j);
      }
      }
    }
    return output;
  }
  
  public ArrayList<Integer> getSRoptions(ArrayList<Integer> coursesTaken)
  {
    ArrayList<Integer> output = SRCourses;
    for (int i = 0; i < coursesTaken.size(); i++)
    {
      for (int j = 0; j < SRCourses.size(); j ++)
      {
      if (coursesTaken.get(i) == SRCourses.get(j))
      {
        output.remove(j);
      }
      }
    }
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
    System.out.println(coursesTaken);
    System.out.println(test1.getEGERoptions(coursesTaken));
   }
  
}