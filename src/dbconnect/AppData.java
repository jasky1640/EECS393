package dbconnect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.User;

public class AppData {

	public static final String JDBC_DRIVER = "org.postgresql.Driver";
	public static final String DB_URL = "jdbc:postgresql://localhost:5432/CSCGS";
	public static final String USER = "postgres";
	public static final String PASS = "Jasky981013#";
    
	public static User curLoginUser = null;
	public static ArrayList<String> listUniqueCourseCode = null;
	public static Map<String, String> mapCourseCodeType = new HashMap<String, String>();
	public static int user_type = 1;//default student
}
