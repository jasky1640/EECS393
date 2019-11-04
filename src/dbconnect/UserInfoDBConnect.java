package dbconnect;

import java.sql.*;

public class UserInfoDBConnect {
    private static UserInfoDBConnect UserInfoDBConnectSingleton = new UserInfoDBConnect();

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/CSCGS";

    //  Database credentials
    private static final String USER = "postgres";
    private static final String PASS = "Jasky981013#";

    private UserInfoDBConnect(){}

    //Return the singleton instance of DBConnect Class
    public static UserInfoDBConnect getUserInfoDBConnectInstance() {
        return UserInfoDBConnectSingleton;
    }

    //Return if the administrator username matches the password
    public static boolean IsCorrectAdminUserPasswordPair(String username, String password){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String actual_password = null;
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT user_password FROM user_information.user_information Where user_type = 0 AND user_name = '" + username + "'";
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            if (rs.next()){
                actual_password = rs.getString("user_password");
            }
            if (actual_password == null){
                return false;
            }
            if (!actual_password.equals(password)){
                return false;
            }
            //Clean-up environment
            rs.close();
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

    //Return if the student username matches the password
    public static boolean IsCorrectNormalUserPasswordPair(String username, String password){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String actual_password = null;
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT user_password FROM user_information.user_information Where user_type = 1 AND user_name = '" + username + "'";
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            if (rs.next()){
                actual_password = rs.getString("user_password");
            }
            if (actual_password == null){
                return false;
            }
            if (!actual_password.equals(password)){
                return false;
            }
            //Clean-up environment
            rs.close();
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

    //Check if an username is used already
    public static boolean IsUserNameUsed(String username){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT user_password FROM user_information.user_information Where user_name = '" + username + "'";
            rs = stmt.executeQuery(sql);

            //Extract data from result set
            //Retrieve by column name
            if (rs.next()){
                return true;
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return false;
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
        return true;
    }

    public static void main(String[] args) {
        System.out.println(IsCorrectAdminUserPasswordPair("haha","1234567"));
        System.out.println(IsCorrectAdminUserPasswordPair("zhizhi","123456"));
        System.out.println(IsUserNameUsed("zhizhi"));
        System.out.println(IsUserNameUsed("hanhan"));
    }
}
