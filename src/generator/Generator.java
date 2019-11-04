package generator;

import dbconnect.CourseDBConnect;
import dbconnect.UserInfoDBConnect;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class Generator {
    public static final int MAX_NUM_COURSES = 5;
    private static int numOfFullPlans = 0;

    public Generator() {
    }


    public static ArrayList<Plan> generate(ArrayList<Course> courses, User user) throws Exception {
        // the input courses should be ranked from high to low priority exactly and should not include courses the user has already taken.
        Plan planA = new Plan();
        Plan planB = new Plan();
        Plan planC = new Plan();
        Plan planD = new Plan();
        Plan planE = new Plan();

        ArrayList<Plan> plans = new ArrayList<Plan>(); // only generate five plans here, could generate more
        plans.add(planA);
        plans.add(planB);
        plans.add(planC);
        plans.add(planD);
        plans.add(planE);

        //Delete all taken course
        ArrayList<Course> qualifiedCourses = new ArrayList<>();
        ArrayList<String> courseTaken = UserInfoDBConnect.getCourseCodeTaken(user.getUserName());
        for(Course course: courses)
            if(!courseTaken.contains(course.getCourseCode()))
                qualifiedCourses.add(course);

        ArrayList<Course> viableCourses = new ArrayList<Course>();

        for (int i = 0; i < qualifiedCourses.size(); i++) {
            if (user.metPrerequisite(qualifiedCourses.get(i)) == true) // first, find all courses that meet prerequisites and save them in
                // an arraylist called viableCourses
            {
                viableCourses.add(qualifiedCourses.get(i));
            }
        }

        System.out.println("-----");
        for(Course c: viableCourses)
            System.out.println(c.toString());
        System.out.println("-----");

        plans.get(0).clear();
        System.out.println("plan1");
        // plan1
        plans.get(0).addCourse(viableCourses.get(0)); // add the first course to plan1
        ArrayList<Course> C1 = viableCourses;
        for(int j = 0; j < MAX_NUM_COURSES - 1; j++) { // first find every viable course that does not overlap with the
            // first course in plan1 and save it in array c1, then add the first course in c1 to plan1. Then find every viable
            // course that does not overlap with the second course in plan1, which is saved in c1 again, add the first course in
            // c1 to plan1. Repeat until reach the maximum number of courses allowed in one plan.

            String timeslot1 = plans.get(0).getCourseAt(j).getTimeSlot();
            C1 = noOverlapCourses(timeslot1, C1);
            if (isInPlan(C1.get(0), plans.get(0)) == false)
                plans.get(0).addCourse(C1.get(0));
        }

        for (int i = 0; i < plans.get(0).getCourseList().size(); i++)
        {
            System.out.println(plans.get(0).getCourseList().get(i));
        }

        // plan2
        plans.get(1).clear();
        System.out.println("plan2");
        plans.get(1).addCourse(viableCourses.get(0)); // add the first course to plan2
        ArrayList<Course> C2 = viableCourses;

        for(int k = 0; k < MAX_NUM_COURSES - 1; k++) { // the only difference is that here it add the second course in c2 to plan2 instead
            // of adding the first course in c1 to plan1
            if (C2.size() > 2) {
            String timeslot1 = plans.get(1).getCourseAt(k).getTimeSlot();
            C2 = noOverlapCourses(timeslot1, C2);
            if (isInPlan(C2.get(1), plans.get(1)) == false)
                plans.get(1).addCourse(C2.get(1));
            }
        }

        for (int i = 0; i < plans.get(1).getCourseList().size(); i++)
        {
            System.out.println(plans.get(1).getCourseList().get(i));
        }

        // plan3
        plans.get(2).clear();
        System.out.println("plan3");
        plans.get(2).addCourse(viableCourses.get(0)); // add the first course to plan3
        ArrayList<Course> C3 = viableCourses;
        for(int m = 0; m < MAX_NUM_COURSES - 1; m++) { // the only difference is that here it add the third course in c3 to plan3 instead
            // of adding the first course in c1 to plan1
            if (C3.size() > 2){
            String timeslot1 = plans.get(2).getCourseAt(m).getTimeSlot();
            C3 = noOverlapCourses(timeslot1, C3);
            if (C3.size() > 2) {
                if (isInPlan(C3.get(2), plans.get(2)) == false)
                    plans.get(2).addCourse(C3.get(2));
            }
            }
        }

        for (int i = 0; i < plans.get(2).getCourseList().size(); i++)
        {
            System.out.println(plans.get(2).getCourseList().get(i));
        }

        // plan4
        plans.get(3).clear();
        System.out.println("plan4");
        plans.get(3).addCourse(viableCourses.get(1)); // add the first course to plan4
        ArrayList<Course> C4 = viableCourses;
        for(int n = 0; n < MAX_NUM_COURSES - 1; n++) { // the only difference is that here it add the third course in c4 to plan4 instead
            // of adding the first course in c1 to plan1
            String timeslot1 = plans.get(3).getCourseAt(n).getTimeSlot();
            C4 = noOverlapCourses(timeslot1, C4);
            if (isInPlan(C4.get(0), plans.get(3)) == false)
                plans.get(3).addCourse(C4.get(0));
        }

        for (int i = 0; i < plans.get(3).getCourseList().size(); i++)
        {
            System.out.println(plans.get(3).getCourseList().get(i));
        }

        // plan5
        plans.get(4).clear();
        System.out.println("plan5");
        plans.get(4).addCourse(viableCourses.get(1)); // add the first course to plan5
        ArrayList<Course> C5 = viableCourses;
        for(int g = 0; g < MAX_NUM_COURSES - 1; g++) { // the only difference is that here it add the third course in c4 to plan4 instead
            // of adding the first course in c1 to plan1
            if (C5.size() > 1) {
            String timeslot1 = plans.get(4).getCourseAt(g).getTimeSlot();
            C5 = noOverlapCourses(timeslot1, C5);
            if(C5.size() > 1)
                {
            if (isInPlan(C5.get(1), plans.get(4)) == false)
                plans.get(4).addCourse(C5.get(1));
                }
            }
        }

        for (int i = 0; i < plans.get(4).getCourseList().size(); i++)
        {
            System.out.println(plans.get(4).getCourseList().get(i));
        }


        user.setPlans(plans);
        return plans;
    }

    public static boolean isInPlan(Course course, Plan plan)
    {
        boolean output = false;
        for (int i = 0; i < plan.getCourseList().size(); i++)
        {
            if (plan.getCourseList().get(i).getCourseCode().equals(course.getCourseCode()))
                output = true;
        }
        return output;
    }

    public static ArrayList<Course> noOverlapCourses(String timeslot1, ArrayList<Course> courses) throws Exception {
        ArrayList<Course> output = new ArrayList<Course>();
        for (int i =0; i < courses.size(); i++)
        {
            String timeslot2 = courses.get(i).getTimeSlot();
            if (Generator.isSplit(timeslot1,timeslot2) == false)
            {
                output.add(courses.get(i));
            }
        }
        return output;
    }

    
    public static boolean isSplit(String timeSlot1, String timeSlot2) throws Exception {
      boolean overlap = false;
      if (timeSlot1.length()>11) {
        String a1 = timeSlot1.substring(0, 11);
        String a2 = timeSlot1.substring(11, 22);
        if (timeSlot2.length()>11) { //if both courses have labs
          String b1 = timeSlot2.substring(0, 11);
          String b2 = timeSlot2.substring(11, 22);
          overlap = ifOverlap(a1, b1);
          if (overlap) return overlap;
          overlap = ifOverlap(a1, b2);
          if (overlap) return overlap;
          overlap = ifOverlap(a2, b1);
          if (overlap) return overlap;
          overlap = ifOverlap(a2, b2);
        }else{ //if the first course has lab
          overlap = ifOverlap(a1, timeSlot2);
          if (overlap) return overlap;
          overlap = ifOverlap(a2, timeSlot2);
        }
      }else{
        if (timeSlot2.length()>11) { //if the second course has lab
          String b1 = timeSlot2.substring(0, 11);
          String b2 = timeSlot2.substring(11, 22);
          
          overlap = ifOverlap(timeSlot1, b1);
          if (overlap) return overlap;
          overlap = ifOverlap(timeSlot1, b2);
        }else{ //if both courses don't have labs
          overlap = ifOverlap(timeSlot1, timeSlot2);
        }
      }
      return overlap;
    }
    
    public static boolean ifOverlap(String timeSlot1, String timeSlot2) throws Exception {
        boolean overlap = false;

        char[] timeSlot1charArray = timeSlot1.toCharArray();
        char[] timeSlot2charArray = timeSlot2.toCharArray();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (timeSlot1charArray[i]!='0' && timeSlot1charArray[i]==timeSlot2charArray[j]) {
                    //if they have the same date
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

                    if (ss1-ss2<0) {//the first class is earlier
                        ee1 = ee1 + 15*60*1000;
                    }else if(ss1-ss2>0){//the second class is earlier
                        ee2 = ee2 + 15*60*1000;
                    }else{//if they are at the same time
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

    public static void main(String[] args) throws Exception {
        User xx = new User("jieyu",1);

        Instant start = Instant.now();
        Generator.generate(CourseDBConnect.getCourseDBConnectInstance().getAllHighPriorityCoursesByPriority(), xx);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();  //in millis
        System.out.println("The execution time is " + timeElapsed / 1000 + " seconds."); //print in seconds
    }
}