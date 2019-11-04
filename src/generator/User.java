package generator;

import dbconnect.UserInfoDBConnect;

import java.util.*;

public class User {
    private int track;
    private String userName;
    private static ArrayList<Plan> plans = new ArrayList<Plan>();

    public User(String userName, int trackChoice) {
        this.userName = userName;
        this.track = trackChoice;
    }

    public ArrayList<Plan> getPlans() {
        return this.plans;
    }

    public void setPlans(ArrayList<Plan> newPlans) {
        this.plans.addAll(newPlans);
    }

    public void addPlans(Plan newPlans) {
        this.plans.add(newPlans);
    }

    public int getTrack() {
        return track;
    }

    public String getUserName() {
        return this.userName;
    }

    public void updateTrack(int input) {
        this.track = input;
    }

    public void updateUserName(String input) {
        this.userName = input;
    }

    public String toString() {
        return (this.userName + "\t" + track);
    }


    public boolean metPrerequisite(Course course) // return true if the input course has no prerequisite or the user has already taken the prerequisite,
    // return false otherwise.
    {
        boolean output = false;
        if (course.getPrerequisite().equals(""))
            output = true;
        else if (UserInfoDBConnect.getCourseCodeTaken(this.getUserName()).contains(course.getPrerequisite()))
            output = true;
        return output;
    }
}