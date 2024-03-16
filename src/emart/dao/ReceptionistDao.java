package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ReceptionistPojo;
import emart.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class ReceptionistDao {

    public static Map<String, String> getNonRegisteredReceptionists() throws SQLException {
        Connection con = DBConnection.getConnection(); // Establish a database connection
        Statement st = con.createStatement();
        String sql = "SELECT empid, empname FROM employees WHERE job='Receptionist' AND empid NOT IN (SELECT empid FROM users WHERE usertype='Receptionist')";
        ResultSet rs = st.executeQuery(sql); // Execute the SQL query
        HashMap<String, String> nonRegisteredReceptionists = new HashMap<>();

        // Iterate through the ResultSet and populate the map with employee details
        while (rs.next()) {
            String empId = rs.getString(1);
            String empName = rs.getString(2);
            nonRegisteredReceptionists.put(empId, empName);
        }

        return nonRegisteredReceptionists; // Return the map of receptionists
    }

    // Adds a receptionist to the users table in the database
    // Returns true if the addition is successful, false otherwise
    public static boolean addReceptionist(UserPojo user) throws SQLException {
        Connection con = DBConnection.getConnection(); // Establish a database connection
        String sql = "INSERT INTO users VALUES(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        // Set parameters for the prepared statement using values from the UserPojo object
        ps.setString(1, user.getUserid());
        ps.setString(2, user.getEmpid());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getUsertype());
        ps.setString(5, user.getUsername());

        int result = ps.executeUpdate(); // Execute the update query

        return result == 1; // Return true if one row was affected (successful insertion)
    }

    public static List<ReceptionistPojo> getAllReceptionistDetails() throws SQLException {
        // Establish a database connection
        Connection con = DBConnection.getConnection();

        // Create a statement for executing SQL queries
        Statement st = con.createStatement();

        // SQL query to select receptionist details from users and employees tables
        String sql = "SELECT users.empid, empname, userid, job, salary FROM users, employees "
                + "WHERE usertype='Receptionist' AND users.empid = employees.empid";

        // Execute the SQL query and get the result set
        ResultSet rs = st.executeQuery(sql);

        // Create an ArrayList to store ReceptionistPojo objects
        ArrayList<ReceptionistPojo> al = new ArrayList<>();

        // Iterate through the result set and populate the ReceptionistPojo objects
        while (rs.next()) {
            // Create a new ReceptionistPojo object
            ReceptionistPojo recep = new ReceptionistPojo();

            // Set the attributes of the ReceptionistPojo object based on the result set
            recep.setEmpid(rs.getString(1));
            recep.setEmpname(rs.getString(2));
            recep.setUserid(rs.getString(3));
            recep.setJob(rs.getString(4));
            recep.setSalary(rs.getDouble(5));

            // Add the ReceptionistPojo object to the ArrayList
            al.add(recep);
        }

        // Return the ArrayList containing ReceptionistPojo objects
        return al;

    }

    public static Map<String, String> getAllReceptionistI() throws SQLException {
        Connection con = DBConnection.getConnection(); // Establish a database connection
        Statement st = con.createStatement();
        String sql = "SELECT userid,username FROM users WHERE usertype='Receptionist' order by userid";
        ResultSet rs = st.executeQuery(sql); // Execute the SQL query
        HashMap<String, String> nonRegisteredReceptionists = new HashMap<>();

        // Iterate through the ResultSet and populate the map with employee details
        while (rs.next()) {
            String empId = rs.getString(1);
            String empName = rs.getString(2);
            nonRegisteredReceptionists.put(empId, empName);
        }

        return nonRegisteredReceptionists; // Return the map of receptionists
    }

    public static boolean updatePassword(String userid, String pwd) throws SQLException {
        Connection con = DBConnection.getConnection(); // Establish a database connection
        PreparedStatement ps = con.prepareStatement("UPDATE users set password=? where userid=?");
        ps.setString(1, pwd);
        ps.setString(2, userid);
        return ps.executeUpdate() == 1;

    }

    public static List<String> getAllreceptionistUserid() throws SQLException {
        Connection con = DBConnection.getConnection(); // Establish a database connection
        Statement st = con.createStatement();
        String sql = "SELECT userid FROM users WHERE usertype='Receptionist' order by userid";
        ResultSet rs = st.executeQuery(sql); // Execute the SQL query
        List<String> ReceptionistList = new ArrayList<>();

        // Iterate through the ResultSet and populate the map with employee details
        while (rs.next()) {
            String empId = rs.getString(1);
            ReceptionistList.add(empId);
        }

        return ReceptionistList; // Return the map of receptionists
    }

    public static boolean deleteReceptionist(String userid) throws SQLException {
        Connection con = DBConnection.getConnection(); // Establish a database connection
        PreparedStatement deleteUser = con.prepareStatement("DELETE FROM users WHERE userid = ?");
        deleteUser.setString(1, userid);

        int result = deleteUser.executeUpdate();

        return result == 1; // Return true if one row was affected (successful deletion)
    }

}
