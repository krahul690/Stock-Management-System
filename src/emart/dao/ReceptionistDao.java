package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class ReceptionistDao {

    // Retrieves a map of non-registered receptionists from the database
    // The map contains employee IDs as keys and employee names as values
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
}

