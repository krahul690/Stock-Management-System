package emart.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {

    private static Connection conn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql:///stms";
            String user = "root";
            String password = "Rahul@2003";
            conn = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Connection opened");
        } catch (ClassNotFoundException | SQLException ee) {
            // Log the exception or use a logging framework
            ee.printStackTrace();
            // Consider throwing an exception or handling it in a more graceful way
            // System.exit(1);
            // For example:
            throw new RuntimeException("Unable to establish a database connection", ee);
        }
    }

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection("jdbc:mysql:///stms", "root", "Rahul@2003");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to obtain a new database connection", e);
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                JOptionPane.showMessageDialog(null, "Connection closed");
            }
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }
}



















// 
//package emart.dbutil;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;
//
// 
//public class DBConnection {
//    
//    // use Static to open one time Connectio only
//    private static Connection conn;
//    
//    static{
//        try{
//            //Load a driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            
//            //open connection
//            //step2 create connection
//            String url = "jdbc:mysql:///stms";
//            String user = "root";
//            String password = "Rahul@2003";
//            conn = DriverManager.getConnection(url, user, password);
//              JOptionPane.showMessageDialog(null, "connectio open");
//             
//            
//        }
//        catch(ClassNotFoundException | SQLException ee){
//            ee.printStackTrace();
//            System.exit(1);
//        }
//         
//    }
//    //Getter to give Access to return connection 
//    public static Connection getConnection()
//    {
//        return conn;
//    }
//    
//    //close connection
//    public static void closeConnection()
//    {
//        try{
//            conn.close();
////            System.out.println("empms.dbutil.cloooseses.closeConnection()");
//            
//        }
//        catch(SQLException ee)
//        {
//            ee.printStackTrace();
//            
//        }
//    }
//}
