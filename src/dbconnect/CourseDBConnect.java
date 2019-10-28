package dbconnect;

import java.sql.*;
import java.util.ArrayList;

public class CourseDBConnect {
    private static CourseDBConnect CourseDBConnectSingleton = new CourseDBConnect();

    //Return the singleton instance of DBConnect Class
    public static CourseDBConnect getCourseDBConnectInstance() {
        return CourseDBConnectSingleton;
    }

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/CSCGS";

    //  Database credentials
    private static final String USER = "postgres";
    private static final String PASS = "Jasky981013#";

    private CourseDBConnect(){}

    public String getCourseName(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String output = "ERROR";
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT name FROM courses.course Where course_id = " + id;
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            if (rs.next()){
                 output = rs.getString("name");
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return output;
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
        return output;
    }

    public String getCourseCode(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String output = "ERROR";
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT course_code FROM courses.course Where course_id =" + id;
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            if(rs.next()) {
                output = rs.getString("course_code");
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return output;
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
        return output;
    }

    public String getCourseTimeSlots(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String output = "ERROR";
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT time_slots FROM courses.course Where course_id =" + id;
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            if(rs.next()) {
                output = rs.getString("time_slots");
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return output;
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
        return output;
    }

    public String getPrerequisiteCourses(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String output = "ERROR";
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT prerequisite_courses FROM courses.course Where course_id =" + id;
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            if(rs.next()) {
                output = rs.getString("prerequisite_courses");
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return output;
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
        return output;
    }

    public String getCourseTypeFromDB(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String output = "ERROR";

        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT type FROM courses.course Where course_id =" + id;
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            if(rs.next()) {
                output = rs.getString("type");
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return output;
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
        return output;
    }

    public int getCourseDepth(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int output = -1;
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM courses.course Where course_id =" + id;
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            if(rs.next()) {
                output = rs.getInt("depth");
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return output;
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
        return output;
    }

    public int getCourseCreditHour(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int output = -1;
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT credit_hour FROM courses.course Where course_id =" + id;
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            if(rs.next()) {
                output = rs.getInt("credit_hour");
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return output;
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
        return output;
    }

    public String getCourseType(int id){
        CourseDBConnect courseDBConnect = CourseDBConnect.getCourseDBConnectInstance();
        String courseCode = courseDBConnect.getCourseCode(id);
        String output = courseDBConnect.getCourseTypeFromDB(id);
        if (courseCode.equals("MATH380")||courseCode.equals("STAT312")){
            output = "000001";
        }
        if (!courseCode.equals("MATH380") && !courseCode.equals("STAT312")){
            output = output + "0";
        }
        return output;
    }

    public ArrayList<Integer> getGeneralCourseList(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> output = new ArrayList<>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT course_id FROM courses.course Where type = '10000'";
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while(rs.next()) {
                output.add(rs.getInt("course_id"));
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            output.remove(Integer.valueOf(39));
            output.remove(Integer.valueOf(40));
            output.remove(Integer.valueOf(41));
            output.remove(Integer.valueOf(56));
            return output;
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
        return output;
    }

    public ArrayList<Integer> getCoreCourseList(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> output = new ArrayList<>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT course_id FROM courses.course Where type = '01000' or type = '01010'";
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while(rs.next()) {
                output.add(rs.getInt("course_id"));
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return output;
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
        return output;
    }

    public ArrayList<Integer> getBreadthCourseList(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> output = new ArrayList<>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT course_id FROM courses.course Where type = '00111' or type = '00101'";
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while(rs.next()) {
                output.add(rs.getInt("course_id"));
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return output;
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
        return output;
    }

    public ArrayList<Integer> getDepthCourseList(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> output = new ArrayList<>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT course_id FROM courses.course Where type = '00111' or type = '00011' or type = '01010'";
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while(rs.next()) {
                output.add(rs.getInt("course_id"));
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return output;
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
        return output;
    }

    public ArrayList<Integer> getElectiveGroup1CourseList(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> output = new ArrayList<>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT course_id FROM courses.course Where type = '00111' or type = '00101' or type = '00011' or type = '00001'";
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while(rs.next()) {
                output.add(rs.getInt("course_id"));
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return output;
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
        return output;
    }

    public ArrayList<Integer> getElectiveGroup2CourseList(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> output = new ArrayList<>();
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT course_id FROM courses.course Where type = '00002'";
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            while(rs.next()) {
                output.add(rs.getInt("course_id"));
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return output;
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
        return output;
    }

    public ArrayList<Integer> getStatisticsCourseList(){
        ArrayList<Integer> output = new ArrayList<>();
        output.add(Integer.valueOf(39));
        output.add(Integer.valueOf(40));
        output.add(Integer.valueOf(41));
        output.add(Integer.valueOf(56));
        return output;
    }

    public static void main(String[] args) {
        CourseDBConnect db = CourseDBConnect.getCourseDBConnectInstance();
        System.out.println(db.getCourseName(56));
        System.out.println(db.getCourseCode(56));
        System.out.println(db.getCourseTimeSlots(57));
        System.out.println(db.getCourseType(57));
        System.out.println(db.getPrerequisiteCourses(56));
        System.out.println(db.getCourseCreditHour(56));
        System.out.println(db.getCourseDepth(56));
        System.out.println(db.getCourseType(39));
        System.out.println("General ID");
        for(Integer i: db.getGeneralCourseList())
            System.out.println(i);
        System.out.println("Core ID");
        for(Integer i: db.getCoreCourseList())
            System.out.println(i);
        System.out.println("Breadth ID");
        for(Integer i: db.getBreadthCourseList())
            System.out.println(i);
        System.out.println("Depth ID");
        for(Integer i: db.getDepthCourseList())
            System.out.println(i);
        System.out.println("Elective Group 1 ID");
        for(Integer i: db.getElectiveGroup1CourseList())
            System.out.println(i);
        System.out.println("Elective Group 2 ID");
        for(Integer i: db.getElectiveGroup2CourseList())
            System.out.println(i);
        System.out.println("Statistics ID");
        for(Integer i: db.getStatisticsCourseList())
            System.out.println(i);
    }
}