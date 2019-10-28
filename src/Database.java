import java.util.ArrayList;

public class Database {

    private static ArrayList<Course> courseList = new ArrayList<Course>();



    public Database() {
    }

    public static void setDatabase()
    {
        Course EECS132 = new Course(1, 4, "EECS132",
                "Introduction to Programming in Java", "13514151505",
                "", "010000", HighPriorityCourse.NO_SUBSTITUTES);

        Course EECS233 = new Course(2, 4, "EECS233",
                "Introduction to Data Structures", "24013001415",
                "EECS132", "010000", HighPriorityCourse.NO_SUBSTITUTES);

        Course EECS302 = new Course(3, 3, "EECS302",
                "Discrete Mathematics", "13509301020",
                "MATH122", "010000", HighPriorityCourse.NO_SUBSTITUTES);

        Course EECS281 = new Course(4, 4, "EECS281",
                "Logic Design and Computer Organization", "24017451835",
                "EECS132", "010000", HighPriorityCourse.NO_SUBSTITUTES);

        Course ENGR210 = new Course(5, 4, "EECS210",
                "Circuit Design", "13514151505",
                "", "000020", HighPriorityCourse.NO_SUBSTITUTES);

        Course PHSY201 = new Course(6, 4, "PHSY201",
                "Introduction to Logic", "24014301545",
                "", "000020", HighPriorityCourse.NO_SUBSTITUTES);

        Course EECS290 = new Course(7, 3, "EECS290",
                "Introduction to Game Design", "24008300945",
                "EECS132", "000010", HighPriorityCourse.NO_SUBSTITUTES);

        Course EECS301 = new Course(8, 2, "EECS301",
                "Digital Logic Lab", "50014151505",
                "EECS281", "000010", HighPriorityCourse.NO_SUBSTITUTES);

        courseList.clear();
        courseList.add(EECS132);
        courseList.add(EECS233);
        courseList.add(EECS302);
        courseList.add(EECS281);
        courseList.add(ENGR210);
        courseList.add(PHSY201);
        courseList.add(EECS290);
        courseList.add(EECS301);

    }

    public static Course getCourse(int courseID) {
        Database.setDatabase();
        return courseList.get(courseID - 1);
    }

    public static ArrayList<Course> getAllCourse() {
        Database.setDatabase();
        return courseList;
    }

    public static String getCourseType(int courseID) {
        return courseList.get(courseID).getCourseType();
    }

    public static String getCourseCode(int courseID) {
        return courseList.get(courseID).getCourseCode();
    }

    public ArrayList<String> getAllCourseCode() {
        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i < courseList.size(); i++)
            output.add(Database.getCourseCode(i));
        return output;
    }

    public static void main(String[] args) throws Exception {


        Database sample = new Database();
        System.out.println(sample.getCourse(8).getCourseCode());

    }

}
