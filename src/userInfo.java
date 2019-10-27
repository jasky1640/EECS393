import java.io.*;
import java.util.*;

public class userInfo
{
  private String track;
  private ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
  private String username;
  
  public userInfo(String userID, String trackChoice, ArrayList<Integer> courses)
  {
    username = userID;
    track = trackChoice;
    coursesTaken = courses;
  }
  
  public String getTrack()
  {
    return track;
  }
  
  public ArrayList<Integer> getCourses()
  {
    return coursesTaken;
  }
  
  public String getUsername()
  {
    return username;
  }
  
  public void updateTrack(String input)
  {
    track = input;
  }
    
  public void updateUsername(String input)
  {
    username = input;
  }
  
  public void updateCourses(ArrayList<Integer> input)
  {
    coursesTaken.clear();
    coursesTaken.addAll(input);
  }
  
  public String toString()
  {
    return (username + "\t" + track + "\t" + coursesTaken);
  }
  
  public static void main(String[] args)
   {
    ArrayList<Integer> coursesTaken = new ArrayList<Integer>();
    coursesTaken.add(5);
    coursesTaken.add(17);
    coursesTaken.add(23);
    userInfo sample = new userInfo("Jerry", "AI", coursesTaken);
    System.out.println(sample);
   }
}