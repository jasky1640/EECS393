import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Generator {
    public static final int MAX_NUM_COURSES = 5;
    private static int numOfFullPlans = 0;

    public Generator() {
    }


    public static void generatePlans(User User) throws Exception {

        /* step 1: add courses needed to fulfill engineering general education requirements */
        // get the courses needed to fulfill CS major requirements
        ArrayList<Integer> EGER_requirements = HighPriorityCourse.getEGERoptions(User.getCourses());
        fulfillRequirement(EGER_requirements, User);

        /* step 2: add courses needed to fulfill CS major requirement courses */
        // get the courses needed to fulfill CS major requirements
        ArrayList<Integer> CSMR_requirements = HighPriorityCourse.getEGERoptions(User.getCourses());
        fulfillRequirement(CSMR_requirements, User);

        /* step 3: add courses needed to fulfill CS core requirement courses */
        // get the courses needed to fulfill CS major requirements
        ArrayList<Integer> CSCR_requirements = HighPriorityCourse.getEGERoptions(User.getCourses());
        fulfillRequirement(CSCR_requirements, User);

        /* step 4: add courses needed to fulfill CS depth requirement courses */
        // get the courses needed to fulfill CS major requirements
        ArrayList<Integer> CSDR_requirements = HighPriorityCourse.getEGERoptions(User.getCourses());
        fulfillRequirement(CSDR_requirements, User);

        /* step 5: add courses needed to fulfill CS breadth requirement courses */
        // get the courses needed to fulfill CS major requirements
        ArrayList<Integer> CSBR_requirements = HighPriorityCourse.getEGERoptions(User.getCourses());
        fulfillRequirement(CSBR_requirements, User);

        /* step 6: add courses needed to fulfill statistics requirement courses */
        // get the courses needed to fulfill CS major requirements
        ArrayList<Integer> SR_requirements = HighPriorityCourse.getEGERoptions(User.getCourses());
        fulfillRequirement(SR_requirements, User);

    }

    public static void fulfillRequirement(ArrayList<Integer> requirements, User user) throws Exception {
        /* for each course "course_needed" from the requirement list, check:
        step 1a: if course_needed's prerequisite(s), if any, has been fulfilled
        step 1b: if course_needed's time slot conflicts with the plan being discussed
        step 2: if course_needed is already in the current plan list
         */


        ArrayList<Plan> plans = user.getPlans();
        for (int i = 0; i < requirements.size(); i++) {
            Course course_needed = Database.getCourse(requirements.get(i)); // course that we want to add to the plan
            String timeslot1 = course_needed.getTimeSlot(); // the time slot of course_needed

            // step 1a: check if course_needed's prerequisite(s), if any, has been fulfilled
            if (!user.metPrerequisite(course_needed)) {
                // do nothing so that we can discuss the next course from "EGER_needed" list
            } else { // the prerequisite(s) has been fulfilled

                /* if the plans list is empty or if all the plans in the plans list are full,
                we create a new plan with course_needed being its only element
                and then add this new plan to the plans list
                 */
                if (plans.size() == 0 || numOfFullPlans == plans.size()) {
                    Plan newPlan = new Plan();
                    newPlan.addCourse(requirements.get(i));
                    plans.add(newPlan);
                } else {
                    for (int j = 0; j < plans.size(); j++) {
                        Plan plan = plans.get(j); // the individual plan to which we want to add course_needed

                        if (!plan.isFullPlan()) { // we can add a course to the current plan

                            for (int k = 0; k < plan.getNumOfCourses(); k++) {
                                Course course_in_plan = Database.getCourse(plan.getCourseAt(k)); // course from the discussed plan
                                String timeslot2 = course_in_plan.getTimeSlot(); // time slot of course_in_plan

                                // step 1b: check if course_needed's time slot conflicts with the plan being discussed
                                if (ifOverlap(timeslot1, timeslot2))
                                    break; // exit the for loop so that we can discuss the next plan

                                else if (course_needed.getCourseCode().equalsIgnoreCase(course_in_plan.getCourseCode()))
                                    // step 2: if course_needed is already in the current plan list
                                    break; // exit the for loop so that we can discuss the next plan
                                else { // no confliction
                                    if (k == plan.getNumOfCourses() - 1) // we have checked all courses in this plan
                                        plan.addCourse(requirements.get(i)); // add course_needed to the current plan
                                }

                            }
                        } else { // the current plan has been assigned a maximum number of courses
                            numOfFullPlans++;
                        }
                    }
                }
            }
        }
        user.setPlans(plans);
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


}
