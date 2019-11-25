package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import entity.Course;
import entity.User;

public class DBCRUD {

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = AppData.JDBC_DRIVER;
    private static final String DB_URL = AppData.DB_URL;

    //  Database credentials
    private static final String USER = AppData.USER;
    private static final String PASS = AppData.PASS;
    
	//Add
	/***
	 * 
	 * @param course_code
	 * @param name
	 * @param time_slots
	 * @param prerequisite_courses
	 * @param type
	 * @param depth
	 * @param credit_hour
	 * @return
	 */
	public static boolean AddCourse(String course_code, String name, String time_slots, String prerequisite_courses, String type, int depth, long credit_hour)
	{
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "INSERT INTO courses.course ("; 
            if(course_code!=null&&!course_code.isEmpty())
            {
            	sql+="course_code,";
            }
            if(name!=null&&!name.isEmpty())
            {
            	sql+="name,";
            }
            if(time_slots!=null&&!time_slots.isEmpty())
            {
            	sql+="time_slots,";
            }
            if(prerequisite_courses!=null&&!prerequisite_courses.isEmpty())
            {
            	sql+="prerequisite_courses,";
            }
            if(type!=null&&!type.isEmpty())
            {
            	sql+="type,";
            }
            if(depth>-1)
            {
            	sql+="depth,";
            }
            if(credit_hour>-1)
            {
            	sql+="credit_hour,";
            }
            sql=sql.substring(0, sql.length()-1);
            sql+=") VALUES ('";
            
            if(course_code!=null&&!course_code.isEmpty())
            {
            	sql+=course_code+"','";
            }
            if(name!=null&&!name.isEmpty())
            {
            	sql+=name+"','";
            }
            if(time_slots!=null&&!time_slots.isEmpty())
            {
            	sql+=time_slots+"','";
            }
            if(prerequisite_courses!=null&&!prerequisite_courses.isEmpty())
            {
            	sql+=prerequisite_courses+"','";
            }
            if(type!=null&&!type.isEmpty())
            {
            	sql+=type+"',";
            }
            if(depth>-1)
            {
            	sql+=depth+",";
            }
            if(credit_hour>-1)
            {
            	sql+=credit_hour+",";
            }
            sql=sql.substring(0, sql.length()-1);
            sql+=")";
            stmt.execute(sql);

            //Clean-up environment
            stmt.close();
            conn.close();
            return true;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return false;
	}
	/***
	 * 
	 * @param user_name
	 * @param user_password
	 * @param user_type
	 * @param core
	 * @param breadth
	 * @param depth
	 * @param general
	 * @param technical_elective
	 * @param track
	 * @return
	 */
	public static boolean AddUser(String user_name, String user_password, int user_type, String core, String breadth, String depth, String general, String technical_elective, int track)
	{
		if(user_name==null || user_name.isEmpty() || user_password==null || user_password.isEmpty())
		{
			return false;
		}
		if(user_type == -1){
			user_type = 1;//default student;
		}
		
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "INSERT INTO user_information.user_information (";
            if(user_name!=null&&!user_name.isEmpty())
            {
            	sql+="user_name,";
            }
            if(user_password!=null&&!user_password.isEmpty())
            {
            	sql+="user_password,";
            }
            if(user_type>-1)
            {
            	sql+="user_type,";
            }
            if(core!=null&&!core.isEmpty())
            {
            	sql+="core,";
            }
            if(breadth!=null&&!breadth.isEmpty())
            {
            	sql+="breadth,";
            }
            if(depth!=null&&!depth.isEmpty())
            {
            	sql+="depth,";
            }
            if(general!=null&&!general.isEmpty())
            {
            	sql+="general,";
            }
            if(technical_elective!=null&&!technical_elective.isEmpty())
            {
            	sql+="technical_elective,";
            }
            if(track>-1)
            {
            	sql+="track,";
            }
            sql=sql.substring(0, sql.length()-1);
            sql+=") VALUES ('";
            if(user_name!=null&&!user_name.isEmpty())
            {
            	sql+=user_name+"','";
            }
            if(user_password!=null&&!user_password.isEmpty())
            {
            	sql+=user_password+"','";
            }
            if(user_type>-1)
            {
            	sql+=user_type+"','";
            }
            if(core!=null&&!core.isEmpty())
            {
            	sql+=core+"','";
            }
            if(breadth!=null&&!breadth.isEmpty())
            {
            	sql+=breadth+"','";
            }
            if(depth!=null&&!depth.isEmpty())
            {
            	sql+=depth+"','";
            }
            if(general!=null&&!general.isEmpty())
            {
            	sql+=general+"','";
            }
            if(technical_elective!=null&&!technical_elective.isEmpty())
            {
            	sql+=technical_elective+"',";
            }
            if(track>-1)
            {
            	sql+=track+"','";
            }
            sql=sql.substring(0, sql.length()-2);
            sql+=")";
            
            stmt.execute(sql);

            //Clean-up environment
            stmt.close();
            conn.close();
            return true;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return false;
	}
	//Del
	public static boolean DelCourse(int course_id)
	{
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "DELETE FROM courses.course WHERE course_id = "+course_id;
            stmt.execute(sql);

            //Clean-up environment
            stmt.close();
            conn.close();
            return true;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return false;
	}
	public static boolean DelUser(int user_id)
	{
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "DELETE FROM user_information.user_information WHERE user_id = "+user_id;
            stmt.execute(sql);

            //Clean-up environment
            stmt.close();
            conn.close();
            return true;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return false;
	}
	//Update
	public static boolean UpdateCourse(int course_id, String course_code, String name, String time_slots, String prerequisite_courses, String type, int depth, long credit_hour)
	{
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "UPDATE courses.course SET ";
            if(course_code!=null&&!course_code.isEmpty())
            {
            	sql+="course_code='"+course_code+"', ";
            }
            if(name!=null&&!name.isEmpty())
            {
            	sql+="name='"+name+"', ";
            }
            if(time_slots!=null&&!time_slots.isEmpty())
            {
            	sql+="time_slots='"+time_slots+"', ";
            }
            if(prerequisite_courses!=null&&!prerequisite_courses.isEmpty())
            {
            	sql+="prerequisite_courses='"+prerequisite_courses+"', ";
            }
            if(type!=null&&!type.isEmpty())
            {
            	sql+="type='"+type+"', ";
            }
            if(depth>-1)
            {
            	sql+="depth="+depth+", ";
            }
            if(credit_hour>-1)
            {
            	sql+="credit_hour="+credit_hour+", ";
            }
            sql = sql.substring(0, sql.length()-2);
            sql+= " WHERE course_id="+course_id;
            
            stmt.execute(sql);

            //Clean-up environment
            stmt.close();
            conn.close();
            return true;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return false;            
	}
	public static boolean UpdateUser(int user_id, String user_name, String user_password, int user_type, String core, String breadth, String depth, String general, String technical_elective, int track)
	{
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "UPDATE user_information.user_information SET ";
            if(user_name!=null&&!user_name.isEmpty())
            {
            	sql+="user_name='"+user_name+"', ";
            }
            if(user_password!=null&&!user_password.isEmpty())
            {
            	sql+="user_password='"+user_password+"', ";
            }
            if(user_type>-1)
            {
            	sql+="user_type="+user_type+", ";
            }
            if(core!=null&&!core.isEmpty())
            {
            	sql+="core='"+core+"', ";
            }
            if(breadth!=null&&!breadth.isEmpty())
            {
            	sql+="breadth='"+breadth+"', ";
            }
            if(depth!=null&&!depth.isEmpty())
            {
            	sql+="depth='"+depth+"', ";
            }
            if(general!=null&&!general.isEmpty())
            {
            	sql+="general='"+general+"', ";
            }
            if(technical_elective!=null&&!technical_elective.isEmpty())
            {
            	sql+="technical_elective='"+technical_elective+"', ";
            }
            if(track>-1)
            {
            	sql+="track="+track+", ";
            }
            sql = sql.substring(0, sql.length()-2);
            sql+=" WHERE user_id="+user_id;
            
            stmt.execute(sql);

            //Clean-up environment
            stmt.close();
            conn.close();
            return true;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return false;
	}
	//List
	public static ArrayList<Course> ListCourses()
	{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Course> list = new ArrayList<Course>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM courses.course";
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while (rs.next()){
                Course course = new Course(
            		rs.getInt("course_id"),
            		rs.getString("course_code"),
            		rs.getString("name"),
            		rs.getString("time_slots"),
            		rs.getString("prerequisite_courses"),
            		rs.getString("type"),
            		rs.getInt("depth"),
            		rs.getLong("credit_hour")                		
            		);
                list.add(course);
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return list;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return list;
	}
	public static ArrayList<User> ListUsers()
	{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM user_information.user_information";
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while (rs.next()){
                User user = new User(
                		rs.getInt("user_id"),
                		rs.getString("user_name"),
                		rs.getString("user_password"),
                		rs.getInt("user_type"),
                		rs.getString("core"),
                		rs.getString("breadth"),
                		rs.getString("depth"),
                		rs.getString("general"),
                		rs.getString("technical_elective"),
                		rs.getInt("track")           		
            		);
                list.add(user);
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return list;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return list;
	}
	//Find
	public static ArrayList<Course> FindCourse(int course_id)
	{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Course> list = new ArrayList<Course>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM courses.course WHERE course_id = "+course_id;
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while (rs.next()){
                Course course = new Course(
            		rs.getInt("course_id"),
            		rs.getString("course_code"),
            		rs.getString("name"),
            		rs.getString("time_slots"),
            		rs.getString("prerequisite_courses"),
            		rs.getString("type"),
            		rs.getInt("depth"),
            		rs.getLong("credit_hour")                		
            		);
                list.add(course);
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return list;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return list;
	}
	public static ArrayList<User> FindUser(int user_id)
	{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM user_information.user_information WHERE user_id = "+user_id;
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while (rs.next()){
                User user = new User(
                		rs.getInt("user_id"),
                		rs.getString("user_name"),
                		rs.getString("user_password"),
                		rs.getInt("user_type"),
                		rs.getString("core"),
                		rs.getString("breadth"),
                		rs.getString("depth"),
                		rs.getString("general"),
                		rs.getString("technical_elective"),
                		rs.getInt("track")           		
            		);
                list.add(user);
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return list;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return list;
	}
	public static ArrayList<Course> FindCourse(String course_code, String name, String time_slots, String prerequisite_courses, String type, int depth, long credit_hour)
	{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Course> list = new ArrayList<Course>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM courses.course WHERE ";
            if(course_code!=null&&!course_code.isEmpty())
            {
            	sql+="course_code='"+course_code+"' AND ";
            }
            if(name!=null&&!name.isEmpty())
            {
            	sql+="name='"+name+"' AND ";
            }
            if(time_slots!=null&&!time_slots.isEmpty())
            {
            	sql+="time_slots='"+time_slots+"' AND ";
            }
            if(prerequisite_courses!=null&&!prerequisite_courses.isEmpty())
            {
            	sql+="prerequisite_courses='"+prerequisite_courses+"' AND ";
            }
            if(type!=null&&!type.isEmpty())
            {
            	sql+="type='"+type+"' AND ";
            }
            if(depth>-1)
            {
            	sql+="depth="+depth+" AND ";
            }
            if(credit_hour>-1)
            {
            	sql+="credit_hour="+credit_hour+" AND ";
            }
            sql = sql.substring(0, sql.length()-5);
            
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while (rs.next()){
                Course course = new Course(
            		rs.getInt("course_id"),
            		rs.getString("course_code"),
            		rs.getString("name"),
            		rs.getString("time_slots"),
            		rs.getString("prerequisite_courses"),
            		rs.getString("type"),
            		rs.getInt("depth"),
            		rs.getLong("credit_hour")                		
            		);
                list.add(course);
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return list;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return list;
	}
	public static ArrayList<User> FindUser(String user_name, String user_password, int user_type, String core, String breadth, String depth, String general, String technical_elective, int track)
	{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM user_information.user_information WHERE ";
            if(user_name!=null&&!user_name.isEmpty())
            {
            	sql+="user_name='"+user_name+"' AND ";
            }
            if(user_password!=null&&!user_password.isEmpty())
            {
            	sql+="user_password='"+user_password+"' AND ";
            }
            if(user_type>-1)
            {
            	sql+="user_type="+user_type+" AND ";
            }
            if(core!=null&&!core.isEmpty())
            {
            	sql+="core='"+core+"' AND ";
            }
            if(breadth!=null&&!breadth.isEmpty())
            {
            	sql+="breadth='"+breadth+"' AND ";
            }
            if(depth!=null&&!depth.isEmpty())
            {
            	sql+="depth='"+depth+"' AND ";
            }
            if(general!=null&&!general.isEmpty())
            {
            	sql+="general='"+general+"' AND ";
            }
            if(technical_elective!=null&&!technical_elective.isEmpty())
            {
            	sql+="technical_elective='"+technical_elective+"' AND ";
            }
            if(track>-1)
            {
            	sql+="track="+track+" AND ";
            }
            sql = sql.substring(0, sql.length()-5);
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while (rs.next()){
                User user = new User(
                		rs.getInt("user_id"),
                		rs.getString("user_name"),
                		rs.getString("user_password"),
                		rs.getInt("user_type"),
                		rs.getString("core"),
                		rs.getString("breadth"),
                		rs.getString("depth"),
                		rs.getString("general"),
                		rs.getString("technical_elective"),
                		rs.getInt("track")           		
            		);
                list.add(user);
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return list;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return list;
	}	
	
    //User Login
    public static ArrayList<User> UserLogin(String user_name, String user_password,String userType){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM user_information.user_information WHERE ";
            if(user_name!=null&&!user_name.isEmpty())
            {
            	sql+="user_name='"+user_name+"' AND ";
            }
            if(user_password!=null&&!user_password.isEmpty())
            {
            	sql+="user_password='"+user_password+"'";
            }
            if(userType!=null&&!userType.isEmpty())
            {
            	sql+=" AND user_type="+userType;
            }
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while (rs.next()){
                User user = new User(
                		rs.getInt("user_id"),
                		rs.getString("user_name"),
                		rs.getString("user_password"),
                		rs.getInt("user_type"),
                		rs.getString("core"),
                		rs.getString("breadth"),
                		rs.getString("depth"),
                		rs.getString("general"),
                		rs.getString("technical_elective"),
                		rs.getInt("track")           		
            		);
                list.add(user);
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            if(list.size()==1)
            {
            	AppData.curLoginUser = list.get(0);          	
            }
            else
            {
            	AppData.curLoginUser = null;
            	list.clear();
            }
            return list;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        AppData.curLoginUser = null;
        return list;
    }
    
    
    
    
    //User getUserByUserName
    public static ArrayList<User> getUserByUserName(String user_name,String userType){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM user_information.user_information WHERE ";
            if(user_name!=null&&!user_name.isEmpty())
            {
            	sql+="user_name='"+user_name+"' ";
            }
            if(userType!=null&&!userType.isEmpty())
            {
            	sql+=" AND user_type="+userType;
            }
           
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while (rs.next()){
                User user = new User(
                		rs.getInt("user_id"),
                		rs.getString("user_name"),
                		rs.getString("user_password"),
                		rs.getInt("user_type"),
                		rs.getString("core"),
                		rs.getString("breadth"),
                		rs.getString("depth"),
                		rs.getString("general"),
                		rs.getString("technical_elective"),
                		rs.getInt("track")           		
            		);
                list.add(user);
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            if(list.size()==1)
            {
            	AppData.curLoginUser = list.get(0);          	
            }
            else
            {
            	AppData.curLoginUser = null;
            	list.clear();
            }
            return list;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        AppData.curLoginUser = null;
        return list;
    }
    
	public static ArrayList<String> ListUniqueCourseCode()
	{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> list = new ArrayList<String>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //Execute a query
            stmt = conn.createStatement();

            String sql = "SELECT DISTINCT course_code, type FROM courses.course";
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            AppData.mapCourseCodeType.clear();
            while (rs.next()){
            	String course_code = rs.getString(1);
            	String type = rs.getString(2);
                list.add(course_code);
                //course_code pair with type
                AppData.mapCourseCodeType.put(course_code, type);
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            AppData.listUniqueCourseCode = list;
            return list;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        return list;
	}
	public static boolean UpdateUserCourseInfo(String courseSelected, int s_track)
	{
		String core = "";
		String breadth = "";
		String depth = "";
		String general = "";
		String technical_elective = "";
		int track = s_track;
		
		if(courseSelected==null || courseSelected.length()<=0)
		{
			return false;
		}
		String[] arrSelected = courseSelected.split("_");
		if(arrSelected.length<=0)
		{
			return false;
		}
		//type format: general core breadth depth elective, track=[1...6]
		if(arrSelected!=null && arrSelected.length>0)
		{
			for(String course_code : arrSelected)
			{
				String type = AppData.mapCourseCodeType.get(course_code);
				boolean flag = false;
				for(int i=0; !flag&&i<5&&i<type.length(); i++)
				{
					if(type.charAt(i)=='1')
					{
						switch(i)
						{
						case 0:
							general+=course_code+"-";
							flag = true;
							break;
						case 1:
							core+=course_code+"-";
							flag = true;
							break;	
						case 2:
							breadth+=course_code+"-";
							flag = true;
							break;	
						case 3:
							depth+=course_code+"-";
							flag = true;
							break;	
						case 4:
							technical_elective+=course_code+"-";
							flag = true;
							break;	
						default:
							flag = true;
							break;
						}
					}
				}
			}
			if(core.length()>0)
			{
				core = core.substring(0, core.length()-1);
			}
			if(breadth.length()>0)
			{
				breadth = breadth.substring(0, breadth.length()-1);
			}
			if(depth.length()>0)
			{
				depth = depth.substring(0, depth.length()-1);
			}
			if(general.length()>0)
			{
				general = general.substring(0, general.length()-1);
			}
			if(technical_elective.length()>0)
			{
				technical_elective = technical_elective.substring(0, technical_elective.length()-1);
			}			
		}
		return UpdateUser(AppData.curLoginUser.getUser_id(), "", "", -1, core, breadth, depth, general, technical_elective, track);
	}
}
