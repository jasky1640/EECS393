package generator;

import dbconnect.CourseDBConnect;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GeneratorTest {

    @Test
    public void generateTest1() throws Exception {
        User u1 = new User("ge1", 1);
        ArrayList<Course> courses = CourseDBConnect.getCourseDBConnectInstance().getAllHighPriorityCoursesByPriority();

        Plan planA = new Plan();
        Plan planB = new Plan();
        Plan planC = new Plan();
        Plan planD = new Plan();
        Plan planE = new Plan();

        planA.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planA.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planA.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planA.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planA.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));

        planB.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planB.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planB.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planB.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planB.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));

        planC.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planC.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planC.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planC.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planC.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));

        planD.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planD.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planD.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planD.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planD.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));

        planE.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planE.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planE.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planE.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        planE.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));

        ArrayList<Plan> expected_plans = new ArrayList<Plan>();
        expected_plans.add(planA);
        expected_plans.add(planB);
        expected_plans.add(planC);
        expected_plans.add(planD);
        expected_plans.add(planE);

        Assert.assertEquals(expected_plans, Generator.generate(courses, u1));
    }

    /**
     * math 201 and math 307 taken
     */
    @Test
    public void hardCodeTest1() {
        User u1 = new User("hc1", 1);
        Assert.assertEquals(true, Generator.hardCode(u1));
    }

    /**
     * math 201 taken only
     */
    @Test
    public void hardCodeTest2() {
        User u2 = new User("hc2", 1);
        Assert.assertEquals(true, Generator.hardCode(u2));
    }

    /**
     * math 307 taken only
     */
    @Test
    public void hardCodeTest3() {
        User u3 = new User("hc3", 1);
        Assert.assertEquals(true, Generator.hardCode(u3));
    }

    /**
     * Neither of math 307 nor math 201 taken
     */
    @Test
    public void hardCodeTest4() {
        User u4 = new User("hc4", 1);
        Assert.assertEquals(false, Generator.hardCode(u4));
    }

    /**
     * stat course
     */
    @Test
    public void isStatTest1() {
        Course input = CourseDBConnect.getCourseDBConnectInstance().getCourse(1);
        Assert.assertEquals(true, Generator.isStat(input));
    }

    /**
     * not stat course
     */
    @Test
    public void isStatTest2() {
        Course input = CourseDBConnect.getCourseDBConnectInstance().getCourse(1);
        Assert.assertEquals(false, Generator.isStat(input));
    }

    /**
     * satisfyStat
     */
    @Test
    public void satisfyStatTest1() {
        User u1 = new User("sf1", 1);
        Assert.assertEquals(true, Generator.satisfyStat(u1));
    }

    /**
     * doesn't satisfyStat
     */
    @Test
    public void satisfyStatTest2() {
        User u2 = new User("sf2", 1);
        Assert.assertEquals(false, Generator.satisfyStat(u2));
    }

    /**
     * is depth
     */
    @Test
    public void isDepthTest1() {
        Course input = CourseDBConnect.getCourseDBConnectInstance().getCourse(1);
        Assert.assertEquals(true, Generator.isDepth(input));
    }

    /**
     * is not depth
     */
    @Test
    public void isDepthTest2() {
        Course input = CourseDBConnect.getCourseDBConnectInstance().getCourse(1);
        Assert.assertEquals(false, Generator.isDepth(input));
    }

    /**
     * is Breadth
     */
    @Test
    public void isBreadthTest1() {
        Course input = CourseDBConnect.getCourseDBConnectInstance().getCourse(1);
        Assert.assertEquals(true, Generator.isBreadth(input));
    }

    /**
     * is not Breadth
     */
    @Test
    public void isBreadthTest2() {
        Course input = CourseDBConnect.getCourseDBConnectInstance().getCourse(1);
        Assert.assertEquals(false, Generator.isBreadth(input));
    }

    /**
     * plan is empty
     */
    @Test
    public void inInPlanTest1(){
        Course input = CourseDBConnect.getCourseDBConnectInstance().getCourse(1);
        Plan input2 = new Plan();
        Assert.assertEquals(false,Generator.isInPlan(input, input2));
    }

    /**
     * plan is not empty and the input course is not in the plan
     */
    @Test
    public void inInPlanTest2(){
        Course input = CourseDBConnect.getCourseDBConnectInstance().getCourse(1);
        Plan input2 = new Plan();
        input2.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(2));
        Assert.assertEquals(false,Generator.isInPlan(input, input2));
    }

    /**
     * plan is not empty and the input course is in the plan
     */
    @Test
    public void inInPlanTest3(){
        Course input = CourseDBConnect.getCourseDBConnectInstance().getCourse(1);
        Plan input2 = new Plan();
        input2.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        Assert.assertEquals(true,Generator.isInPlan(input, input2));
    }

    /**
     * plan is empty
     */
    @Test
    public void inInPlan2Test1(){
        Course input = CourseDBConnect.getCourseDBConnectInstance().getCourse(1);
        Plan input2 = new Plan();
        Assert.assertEquals(false,Generator.isInPlan(input, input2));
    }

    /**
     * plan is not empty and the input course is not in the plan
     */
    @Test
    public void inInPlan2Test2(){
        Course input = CourseDBConnect.getCourseDBConnectInstance().getCourse(1);
        Plan input2 = new Plan();
        input2.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(2));
        Assert.assertEquals(false,Generator.isInPlan(input, input2));
    }

    /**
     * plan is not empty and the input course is in the plan
     */
    @Test
    public void inInPlan2Test3(){
        Course input = CourseDBConnect.getCourseDBConnectInstance().getCourse(1);
        Plan input2 = new Plan();
        input2.addCourse(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        Assert.assertEquals(true,Generator.isInPlan(input, input2));
    }

    /**
     * overlapping time, non-overlapping days.
     */
    @Test
    public void ifOverlapTest1() throws Exception {
        String input1 = "13511301220";
        String input2 = "24011301220";
        Assert.assertEquals(false, Generator.ifOverlap(input1,input2));
    }

    /**
     * overlapping days, non-overlapping times.
     */
    @Test
    public void ifOverlapTest2() throws Exception {
        String input1 = "13511301220";
        String input2 = "13515301620";
        Assert.assertEquals(false, Generator.ifOverlap(input1,input2));
    }

    /**
     * overlapping days, one time slot is included in the other time slot
     */
    @Test
    public void ifOverlapTest3() throws Exception {
        String input1 = "13511301220";
        String input2 = "13511401210";
        Assert.assertEquals(true, Generator.ifOverlap(input1,input2));
    }

    /**
     * overlapping days, one time slot intersect with another time slot
     */
    @Test
    public void ifOverlapTest4() throws Exception {
        String input1 = "13511301220";
        String input2 = "13511401230";
        Assert.assertEquals(true, Generator.ifOverlap(input1,input2));
    }

    /**
     * both courses have labs, no overlap
     */
    @Test
    public void isSplitTest1() throws Exception {
        String input1 = "1351130122024011301220";
        String input2 = "1351430152024014301520";
        Assert.assertEquals(false, Generator.isSplit(input1,input2));
    }

    /**
     * both courses have labs, lecture overlaps with lecture
     */
    @Test
    public void isSplitTest2() throws Exception {
        String input1 = "1351130122024011301220";
        String input2 = "1351130122024014301520";
        Assert.assertEquals(true, Generator.isSplit(input1,input2));
    }

    /**
     * both courses have labs, lab overlaps with lab
     */
    @Test
    public void isSplitTest3() throws Exception {
        String input1 = "1351130122024011301220";
        String input2 = "1351430152024011301220";
        Assert.assertEquals(true, Generator.isSplit(input1,input2));
    }

    /**
     * both courses have labs, lab overlaps with lecture
     */
    @Test
    public void isSplitTest4() throws Exception {
        String input1 = "1351130122024011301220";
        String input2 = "1351430152030011001200";
        Assert.assertEquals(true, Generator.isSplit(input1,input2));
    }

    /**
     * only one course has lab, lab overlaps with lecture
     */
    @Test
    public void isSplitTest5() throws Exception {
        String input1 = "13511301220";
        String input2 = "1351430152030011001200";
        Assert.assertEquals(true, Generator.isSplit(input1,input2));
    }

    /**
     * only one course has lab, lecture overlaps with lecture
     */
    @Test
    public void isSplitTest6() throws Exception {
        String input1 = "13514301620";
        String input2 = "1351430152030011001200";
        Assert.assertEquals(true, Generator.isSplit(input1,input2));
    }

    /**
     * only one course has lab, no overlaps
     */
    @Test
    public void isSplitTest7() throws Exception {
        String input1 = "13508301020";
        String input2 = "1351430152030011001200";
        Assert.assertEquals(false, Generator.isSplit(input1,input2));
    }

    /**
     * neither have lab, no overlap
     */
    @Test
    public void isSplitTest8() throws Exception {
        String input1 = "13508301020";
        String input2 = "13514301520";
        Assert.assertEquals(false, Generator.isSplit(input1,input2));
    }

    /**
     * neither have lab, overlaps
     */
    @Test
    public void isSplitTest9() throws Exception {
        String input1 = "13514301510";
        String input2 = "13514301520";
        Assert.assertEquals(true, Generator.isSplit(input1,input2));
    }

    /**
     * course list is empty
     */
    @Test
    public void noOverlapCoursesTest1() throws Exception {
        String input1 = "13510301120";
        ArrayList<Course> input2 = new ArrayList<Course>();
        Assert.assertEquals(true, Generator.noOverlapCourses(input1,input2));
    }

    /**
     * course list is not empty, there is not overlap courses
     */
    @Test
    public void noOverlapCoursesTest2() throws Exception {
        String input1 = "13510301120";
        ArrayList<Course> input2 = new ArrayList<Course>();
        input2.add(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        input2.add(CourseDBConnect.getCourseDBConnectInstance().getCourse(2));
        Assert.assertEquals(true, Generator.noOverlapCourses(input1,input2));
    }

    /**
     * course list is not empty, there is one overlap course
     */
    @Test
    public void noOverlapCoursesTest3() throws Exception {
        String input1 = "13510301120";
        ArrayList<Course> input2 = new ArrayList<Course>();
        input2.add(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        input2.add(CourseDBConnect.getCourseDBConnectInstance().getCourse(2));
        Assert.assertEquals(false, Generator.noOverlapCourses(input1,input2));
    }

    /**
     * course list is not empty, overlap with more than one course
     */
    @Test
    public void noOverlapCoursesTest4() throws Exception {
        String input1 = "13510301120";
        ArrayList<Course> input2 = new ArrayList<Course>();
        input2.add(CourseDBConnect.getCourseDBConnectInstance().getCourse(1));
        input2.add(CourseDBConnect.getCourseDBConnectInstance().getCourse(2));
        Assert.assertEquals(false, Generator.noOverlapCourses(input1,input2));
    }
}
