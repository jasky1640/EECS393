import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.*;

public class MyTests
{

  @Test
  public void getEGERoptionsTest()
  {
    highPriorityCourse test1 = new highPriorityCourse(23, "EECS393", "Software Engineering", "MWF11:40-12:30",
            "Instructor:Andy Podgurski", 5, 4, -1);
    ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
    coursesTaken.add(1);
    coursesTaken.add(3);
    coursesTaken.add(5);
    coursesTaken.add(7);
    coursesTaken.add(9);
    assertEquals(19, test1.getEGERoptions(coursesTaken).get(0), "should return courses still need to take");
  }

  @Test
  public void getCSMRoptionsTest()
  {
    highPriorityCourse test1 = new highPriorityCourse(23, "EECS393", "Software Engineering", "MWF11:40-12:30",
            "Instructor:Andy Podgurski", 5, 4, -1);
    ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
    coursesTaken.add(1);
    coursesTaken.add(3);
    coursesTaken.add(5);
    coursesTaken.add(7);
    coursesTaken.add(9);
    assertEquals(19, test1.getCSMRoptions(coursesTaken).get(0), "should return courses still need to take");
  }

  @Test
  public void getCSCRoptionsTest()
  {
    highPriorityCourse test1 = new highPriorityCourse(23, "EECS393", "Software Engineering", "MWF11:40-12:30",
            "Instructor:Andy Podgurski", 5, 4, -1);
    ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
    coursesTaken.add(1);
    coursesTaken.add(3);
    coursesTaken.add(5);
    coursesTaken.add(7);
    coursesTaken.add(9);
    assertEquals(19, test1.getCSCRoptions(coursesTaken).get(0), "should return courses still need to take");
  }

  @Test
  public void getCSDRoptionsTest()
  {
    highPriorityCourse test1 = new highPriorityCourse(23, "EECS393", "Software Engineering", "MWF11:40-12:30",
            "Instructor:Andy Podgurski", 5, 4, -1);
    ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
    coursesTaken.add(1);
    coursesTaken.add(3);
    coursesTaken.add(5);
    coursesTaken.add(7);
    coursesTaken.add(9);
    assertEquals(19, test1.getCSDRoptions(coursesTaken).get(0), "should return courses still need to take");
  }

  @Test
  public void getCSBRoptionsTest()
  {
    highPriorityCourse test1 = new highPriorityCourse(23, "EECS393", "Software Engineering", "MWF11:40-12:30",
            "Instructor:Andy Podgurski", 5, 4, -1);
    ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
    coursesTaken.add(1);
    coursesTaken.add(3);
    coursesTaken.add(5);
    coursesTaken.add(7);
    coursesTaken.add(9);
    assertEquals(19, test1.getCSBRoptions(coursesTaken).get(0), "should return courses still need to take");
  }

  @Test
  public void getSRoptionsTest()
  {
    highPriorityCourse test1 = new highPriorityCourse(23, "EECS393", "Software Engineering", "MWF11:40-12:30",
            "Instructor:Andy Podgurski", 5, 4, -1);
    ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
    coursesTaken.add(1);
    coursesTaken.add(3);
    coursesTaken.add(5);
    coursesTaken.add(7);
    coursesTaken.add(9);
    assertEquals(19, test1.getSRoptions(coursesTaken).get(0), "should return courses still need to take");
  }

  @Test
  public void checkPrerequisiteTest()
  {
    highPriorityCourse test1 = new highPriorityCourse(23, "EECS393", "Software Engineering", "MWF11:40-12:30",
            "Instructor:Andy Podgurski", 5, 4, -1);
    ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
    coursesTaken.add(1);
    coursesTaken.add(3);
    coursesTaken.add(5);
    coursesTaken.add(7);
    coursesTaken.add(9);
    userInfo user = new userInfo("Jerry", "AI", coursesTaken);
    assertEquals(true, test1.checkPrerequisite(test1, user), "should return true");
  }
}
  