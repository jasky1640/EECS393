import java.util.*;

public class User
{
    private int track;
    private ArrayList<Integer> coursesTaken;
    private int userID;
    private ArrayList<Plan> plans;

    public User(int userID, int trackChoice, ArrayList<Integer> courses)
    {
        this.userID = userID;
        this.track = trackChoice;
        coursesTaken = courses;
    }

    public ArrayList<Plan> getPlans() {
        if (this.plans == null)
            this.plans = new ArrayList<>();
        return this.plans;
    }

    public void setPlans(ArrayList<Plan> newPlans) {
        this.plans = newPlans;
    }

    public int getTrack()
    {
        return track;
    }

    public ArrayList<Integer> getCourses()
    {
        return coursesTaken;
    }

    public int getUserID()
    {
        return this.userID;
    }

    public void updateTrack(int input)
    {
        this.track = input;
    }

    public void updateUserID(int input)
    {
        this.userID = input;
    }

    public void updateCourses(ArrayList<Integer> input)
    {
        coursesTaken.clear();
        coursesTaken.addAll(input);
    }

    public String toString()
    {
        return (this.userID + "\t" + track + "\t" + coursesTaken);
    }

    public boolean metPrerequisite(Course course) // return true if the input course has no prerequisite or the user has already taken the prerequisite,
    // return false otherwise.
    {
        if (course.getPrerequisite().equalsIgnoreCase(HighPriorityCourse.NO_SUBSTITUTES) ||
        this.getCourses().contains(course.getPrerequisite()))
            return true;
        else
            return false;
    }

}