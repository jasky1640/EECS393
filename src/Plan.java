import java.util.ArrayList;

public class Plan {

    private ArrayList<Integer> courseList;
    private int numOfCourses;

    public Plan() {
        this.courseList = new ArrayList<>();
    }

    public Plan(ArrayList<Integer> courseList) {
        this.courseList = courseList;
    }


    public ArrayList<Integer> getCourseList() {
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
}
