import java.io.*;
import java.util.*;

public class userInfo
{
  private String track;
  private String [] courses;
  private String username;
  
  public userInfo(String userID, String trackChoice, String[] coursesTaken)
  {
    username = userID;
    track = trackChoice;
    courses = coursesTaken;
  }
  
  public String getTrack()
  {
    return track;
  }
  
  public String[] getCourses()
  {
    return courses;
  }
  
  public String getUsername()
  {
    return username;
  }
  
  public String toString()
  {
    String stringArr = Arrays.toString(courses);
    return (username + "\t" + track + "\t" + stringArr);
  }
  
  public static void main(String[] args)
   {
    String [] courses = {"database", "data structure"};
    userInfo sample = new userInfo("Jerry", "AI", courses);
    System.out.println(sample);
   }
}