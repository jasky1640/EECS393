import java.util.ArrayList;

public class Plan {

    private static ArrayList<Integer> courseList = new ArrayList<Integer>();
    private int numOfCourses;

    public Plan() {}

    public Plan(ArrayList<Integer> courseList) {
        this.courseList = courseList;
    }


    public static ArrayList<Integer> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Integer> courseList) {
        this.courseList = courseList;
    }

    public boolean isFullPlan() {
        return this.courseList.size()==Generator.MAX_NUM_COURSES;
    }

    public void addCourse(int courseID) {
        courseList.add(courseID);
    }

    public int getNumOfCourses() {
        return numOfCourses;
    }

    public void setNumOfCourses(int numOfCourses) {
        this.numOfCourses = numOfCourses;
    }

    public int getCourseAt(int index) {
        return this.getCourseList().get(index);
    }

    public void printPlan() {
        Database sample = new Database();
        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i < courseList.size(); i++)
            output.add(sample.getCourse(courseList.get(i)).getCourseCode());

        System.out.println(output);
    }
}
