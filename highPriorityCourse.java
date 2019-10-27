import java.io.*;
import java.util.*;

public class highPriorityCourse extends Course
{
  private static final int MAX_NUM_COURSES = 5;
  private static int numOfFullPlans = 0;
  private int courseID;
  private String courseCode;
  private String courseName;
  private String timeSlot;
  private String information;
  private int prerequisite;
  private int courseType;
  private int substituteID;
  
  private static ArrayList<Integer> EGERCourses = new ArrayList<Integer>();
  private static ArrayList<Integer> CSMRCourses = new ArrayList<Integer>();
  private static ArrayList<Integer> CSCRCourses = new ArrayList<Integer>();
  private static ArrayList<Integer> CSDRCourses = new ArrayList<Integer>();
  private static ArrayList<Integer> CSBRCourses = new ArrayList<Integer>();
  private static ArrayList<Integer> SRCourses = new ArrayList<Integer>();
  private static ArrayList<ArrayList<Integer>> plans = new ArrayList<ArrayList<Integer>>();
  
  public static ArrayList<ArrayList<Integer>> generatePlans(userInfo userInfo) {

        /* step 1: add courses needed to fulfill engineering general education requirements */
        // get the courses needed to fulfill CS major requirements
        ArrayList<Integer> EGER_requirements = getEGERoptions(userInfo.getCourses());
        fulfillRequirement(EGER_requirements, userInfo);

        /* step 2: add courses needed to fulfill CS major requirement courses */
        // get the courses needed to fulfill CS major requirements
        ArrayList<Integer> CSMR_requirements = getEGERoptions(userInfo.getCourses());
        fulfillRequirement(CSMR_requirements, userInfo);

        /* step 3: add courses needed to fulfill CS core requirement courses */
        // get the courses needed to fulfill CS major requirements
        ArrayList<Integer> CSCR_requirements = getEGERoptions(userInfo.getCourses());
        fulfillRequirement(CSCR_requirements, userInfo);

        /* step 4: add courses needed to fulfill CS depth requirement courses */
        // get the courses needed to fulfill CS major requirements
        ArrayList<Integer> CSDR_requirements = getEGERoptions(userInfo.getCourses());
        fulfillRequirement(CSDR_requirements, userInfo);

        /* step 5: add courses needed to fulfill CS breadth requirement courses */
        // get the courses needed to fulfill CS major requirements
        ArrayList<Integer> CSBR_requirements = getEGERoptions(userInfo.getCourses());
        fulfillRequirement(CSBR_requirements, userInfo);

        /* step 6: add courses needed to fulfill statistics requirement courses */
        // get the courses needed to fulfill CS major requirements
        ArrayList<Integer> SR_requirements = getEGERoptions(userInfo.getCourses());
        fulfillRequirement(SR_requirements, userInfo);

        /* step 7: return the plans */

    }
	
  public static void fulfillRequirement(ArrayList<Integer> requirements, userInfo userInfo) {
        /* for each course "course_needed" from the requirement list, check:
        step 1a: if course_needed's prerequisite(s), if any, has been fulfilled
        step 1b: if course_needed's time slot conflicts with the plan being discussed
         */
        for (int i = 0; i < requirements.size(); i++) {
            Course course_needed = Database.getCourse(requirements.get(i)); // course that we want to add to the plan
            String timeslot1 = course_needed.getTimeSlot(); // the time slot of course_needed

            // step 1a: check if course_needed's prerequisite(s), if any, has been fulfilled
            if (!checkPrerequisite(course_needed, userInfo)) {
                // do nothing so that we can discuss the next course from "EGER_needed" list
            } else { // the prerequisite(s) has been fulfilled

                /* if the plans list is empty or if all the plans in the plans list are full,
                we create a new plan with course_needed being its only element
                and then add this new plan to the plans list
                 */
                if (plans.size() == 0 || numOfFullPlans == plans.size()) {
                    ArrayList<Integer> newPlan = new ArrayList<>();
                    newPlan.add(requirements.get(i));
                    plans.add(newPlan);
                } else {
                    for (int j = 0; j < plans.size(); j++) {
                        ArrayList<Integer> plan = plans.get(j); // the individual plan to which we want to add course_needed

                        if (plan.size() < MAX_NUM_COURSES) { // we can add a course to the current plan

                            for (int k = 0; k < plan.size(); k++) {
                                Course course_in_plan = Database.getCourse(plan.get(k)); // course from the discussed plan
                                String timeslot2 = course_in_plan.getTimeSlot(); // time slot of course_in_plan

                                // step 1b: check if course_needed's time slot conflicts with the plan being discussed
                                if (ifOverlap(timeslot1, timeslot2))
                                    break; // exit the for loop so that we can discuss the next plan
                                else { // no confliction
                                    if (k == plan.size() - 1) // we have checked all courses in this plan
                                        plan.add(requirements.get(i)); // add course_needed to the current plan
                                }
                            }
                        } else { // the current plan has been assigned a maximum number of courses
                            numOfFullPlans++;
                        }
                    }
                }
            }
        }
    }
  
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
   
   public static ArrayList<Integer> getHpCourses() // should return a list of all high priority courses
   {
     ArrayList<Integer> output = new ArrayList<Integer>();
     output.addAll(EGERCourses);
     output.addAll(CSMRCourses);
     output.addAll(CSCRCourses);
     output.addAll(CSDRCourses);
     output.addAll(SRCourses);
     return output;
   }
  
  public static ArrayList<Integer> getEGERoptions(ArrayList<Integer> coursesTaken) // should return a list of EGER courses 
    // still need to take
  {
    highPriorityCourse.setEGERCourses(EGERCourses);
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.addAll(EGERCourses);
    output.removeAll(coursesTaken);
    return output;
  }
  
  public static ArrayList<Integer> getCSMRoptions(ArrayList<Integer> coursesTaken) // should return a list of CSMR courses 
    // still need to take
  {
    highPriorityCourse.setCSMRCourses(CSMRCourses);
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.addAll(CSMRCourses);
    output.removeAll(coursesTaken);
    return output;
  }
  
  public static ArrayList<Integer> getCSCRoptions(ArrayList<Integer> coursesTaken) // should return a list of CSCR courses 
    // still need to take
  {
    highPriorityCourse.setCSCRCourses(CSCRCourses);
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.addAll(CSCRCourses);
    output.removeAll(coursesTaken);
    return output;
  }
  
  public static ArrayList<Integer> getCSDRoptions(ArrayList<Integer> coursesTaken) // should return a list of CSDR courses 
    // still need to take
  {
    highPriorityCourse.setCSDRCourses(CSDRCourses);
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.addAll(CSDRCourses);
    output.removeAll(coursesTaken);
    return output;
  }
  
  public static ArrayList<Integer> getCSBRoptions(ArrayList<Integer> coursesTaken) // should return a list of CSBR courses 
    // still need to take
  {
    highPriorityCourse.setCSBRCourses(CSBRCourses);
    ArrayList<Integer> output = new ArrayList<Integer>();
    output.addAll(CSBRCourses);
    output.removeAll(coursesTaken);
    return output;
  }
  
  public static ArrayList<Integer> getSRoptions(ArrayList<Integer> coursesTaken) // should return a list of SR courses 
    // still need to take
  {
    highPriorityCourse.setSRCourses(SRCourses);
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
  
   public static void main(String[] args)
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
    
   }
  
}
