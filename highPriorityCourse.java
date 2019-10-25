import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class highPriorityCourse extends Course
{
  private int courseID;
  private String courseCode;
  private String courseName;
  private String timeSlot;
  private String information;
  private int prerequisite;
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
        
        public static void setCSBRCourses(ArrayList<Integer> input) // only for testing purpose at this moment, 
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
                String informations, int prerequisites, int courseTypes,int substituteIDs)  // constructor
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
  
  public ArrayList<Integer> getCSBRoptions(ArrayList<Integer> coursesTaken) // should return a list of CSBR courses 
    // still need to take
  {
    highPriorityCourse.setCSBRCourses(EGERCourses);
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.addAll(CSBRCourses);
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
  
  public static boolean checkPrerequisite(Course course, userInfo user) // return true if the input course has no prerequisite or the user has already taken the prerequisite, 
    // return false otherwise.
  {
    boolean output = false;
    if (course.getPrerequisite() == 0)
    {
      output = true;
      return output;
    }
    else if (user.getCourses().contains(course.getPrerequisite()) == true)
    {
      output = true;
      return output;
    }
    else
      return output;
  }
  
  public static boolean ifOverlap(String timeSlot1, String timeSlot2) throws Exception {
    boolean overlap = false;
  
    char[] timeSlot1charArray = timeSlot1.toCharArray();
    char[] timeSlot2charArray = timeSlot2.toCharArray();
  
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (timeSlot1charArray[i]!='0' && timeSlot1charArray[i]==timeSlot2charArray[j]) {
          //有相同日期需要进行比较了
          SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
          StringBuffer dateStr1_1 = new StringBuffer()
            .append(timeSlot1charArray[3])
            .append(timeSlot1charArray[4])
            .append(":")
            .append(timeSlot1charArray[5])
            .append(timeSlot1charArray[6]);
          StringBuffer dateStr1_2 = new StringBuffer()
            .append(timeSlot1charArray[7])
            .append(timeSlot1charArray[8])
            .append(":")
            .append(timeSlot1charArray[9])
            .append(timeSlot1charArray[10]);
          StringBuffer dateStr2_1 = new StringBuffer()
            .append(timeSlot2charArray[3])
            .append(timeSlot2charArray[4])
            .append(":")
            .append(timeSlot2charArray[5])
            .append(timeSlot2charArray[6]);
          StringBuffer dateStr2_2 = new StringBuffer()
            .append(timeSlot2charArray[7])
            .append(timeSlot2charArray[8])
            .append(":")
            .append(timeSlot2charArray[9])
       .append(timeSlot2charArray[10]);
          Date s1 = sdf.parse(dateStr1_1.toString());
          Date e1 = sdf.parse(dateStr1_2.toString());
          Date s2 = sdf.parse(dateStr2_1.toString());
          Date e2 = sdf.parse(dateStr2_2.toString());
          long ss1 = s1.getTime();
          long ee1 = e1.getTime();
          long ss2 = s2.getTime();
          long ee2 = e2.getTime();
     
          if (ss1-ss2<0) {//第一组早
            ee1 = ee1 + 15*60*1000;
          }else if(ss1-ss2>0){//第二组早
            ee2 = ee2 + 15*60*1000;
          }else{//相等 必定冲突
            overlap = true;
            return overlap;
          }
          if ((ss1 < ss2) && (ee1 > ss2)) {
            overlap = true;
            return overlap;
          } else if ((ss1 > ss2) && (ss1 < ee2)) {
            overlap = true;
            return overlap;
          } else {
            overlap = false;
          }
        }
      }
    }
    return overlap;
  }

  
   public static void main(String[] args)throws Exception
   {
    highPriorityCourse test1 = new highPriorityCourse(23, "EECS393", "Software Engineering", "MWF11:40-12:30", 
                                                     "Instructor:Andy Podgurski", 5, 4, -1);
    highPriorityCourse test2 = new highPriorityCourse(24, "EECS391", "Artificial Intelligence", "MWF13:30-14:45", 
                                                     "Instructor:Michael Lewcki", 5, 4, -1);
    System.out.println(test1);
    System.out.println(test2);
    
    ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
    coursesTaken.add(5);
    coursesTaken.add(7);
    coursesTaken.add(11);
    coursesTaken.add(19);
    coursesTaken.add(23);
    userInfo xx = new userInfo("Jerry", "AI", coursesTaken);
    System.out.println(test1.getUserInfo(xx));
    System.out.println(test1.getEGERoptions(coursesTaken));
    String class1 = "13513001400";
    String class2 = "12414141420";
    System.out.println(ifOverlap(class1, class2));
    
   }
  
}