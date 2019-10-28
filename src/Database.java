import java.util.ArrayList;

public class Database {

    private static ArrayList<Course> courseList;

    private static final Course EECS132 = new Course(1, 4, "EECS132",
            "Introduction to Programming in Java", "1351415150530015201610",
            "", "010000", HighPriorityCourse.NO_SUBSTITUTES);

    private static final Course EECS233 = new Course(2, 4, "EECS233",
            "Introduction to Data Structures", "24013001415",
            "EECS132", "010000", HighPriorityCourse.NO_SUBSTITUTES);

    private static final Course EECS302 = new Course(3, 3, "EECS302",
            "Discrete Mathematics", "13509301020",
            "MATH122", "010000", HighPriorityCourse.NO_SUBSTITUTES);

    private static final Course EECS281 = new Course(4, 4, "EECS281",
            "Logic Design and Computer Organization", "2401000111520013001350",
            "EECS132", "010000", HighPriorityCourse.NO_SUBSTITUTES);

    private static final Course ENGR210 = new Course(5, 4, "EECS210",
            "Circuit Design", "13514151505",
            "", "000020", HighPriorityCourse.NO_SUBSTITUTES);

    private static final Course PHSY201 = new Course(6, 4, "PHSY201",
            "Introduction to Logic", "24014301545",
            "", "000020", HighPriorityCourse.NO_SUBSTITUTES);

    private static final Course EECS290 = new Course(7, 3, "EECS290",
            "Introduction to Game Design", "24008300945",
            "EECS132", "000010", HighPriorityCourse.NO_SUBSTITUTES);

    private static final Course EECS301 = new Course(8, 2, "EECS301",
            "Digital Logic Lab", "50014151505",
            "EECS281", "000010", HighPriorityCourse.NO_SUBSTITUTES);

    public Database() {
        this.courseList.add(EECS132);
        this.courseList.add(EECS233);
        this.courseList.add(EECS302);
        this.courseList.add(EECS301);
        this.courseList.add(PHSY201);
        this.courseList.add(EECS281);
        this.courseList.add(EECS290);
        this.courseList.add(ENGR210);

    }

    public static Course getCourse(int courseID) {
        return courseList.get(courseID);
    }

    public String getCourseType(int courseID) {
        return courseList.get(courseID).getCourseType();
    }

}
