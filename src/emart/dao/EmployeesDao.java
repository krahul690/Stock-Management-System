package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.EmployeePojo;

/**
 *
 * @author LENOVO
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {

    public static String getNextEmpId() throws SQLException {

        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select max(EMPID) from employees");
        rs.next(); //last one
        String empid = rs.getString(1);
        int empno = Integer.parseInt(empid.substring(1));
        empno = empno + 1;
        return "E" + empno;

    }

    public static boolean addEmployee(EmployeePojo emp) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = DBConnection.getConnection();
        ps = conn.prepareStatement("INSERT INTO employees VALUES (?, ?, ?, ?)");
        ps.setString(1, emp.getEMPID());
        ps.setString(2, emp.getEMPNAME());
        ps.setString(3, emp.getJOB());
        ps.setDouble(4, emp.getSALARY());

        int result = ps.executeUpdate();

        return result == 1;

        // Do not close the Connection here; let the calling code handle the connection
    }

    public static List<EmployeePojo> getAllEmployees() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from employees order by empid");

        ArrayList<EmployeePojo> emplist = new ArrayList<>();

        while (rs.next()) {
            EmployeePojo emp = new EmployeePojo();
            emp.setEMPID(rs.getString(1));
            emp.setEMPNAME(rs.getString(2));
            emp.setJOB(rs.getString(3));
            emp.setSALARY(rs.getDouble(4));

            emplist.add(emp);
        }
        return emplist;
    }

    public static List<String> getAllEmpId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select empid from employees order by empid");

        ArrayList<String> allId = new ArrayList<>();
        while (rs.next()) {
            allId.add(rs.getString(1));
        }
        return allId;
    }

    public static EmployeePojo findEmpById(String empid) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from employees where empid=?");
        ps.setString(1, empid);

        ResultSet rs = ps.executeQuery();
        rs.next(); //nextline rocord go
        EmployeePojo e = new EmployeePojo();
        e.setEMPID(rs.getString(1));
        e.setEMPNAME(rs.getString(2));
        e.setJOB(rs.getString(3));
        e.setSALARY(rs.getDouble(4));
        return e;

    }

    public static boolean updateEmployee(EmployeePojo e) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            // Update employee details
            try (PreparedStatement ps = conn.prepareStatement("UPDATE employees SET empname=?, job=?, salary=? WHERE empid=?")) {
                ps.setString(1, e.getEMPNAME());
                ps.setString(2, e.getJOB());
                ps.setDouble(3, e.getSALARY());
                ps.setString(4, e.getEMPID());

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected == 0) {
                    // No records were updated in the employees table
                    return false;
                }
            }

            // Check if the corresponding user exists
            boolean userPresent = UserDao.isUserPresent(e.getEMPID());

            if (userPresent) {
                // Update user details
                try (PreparedStatement ps = conn.prepareStatement("UPDATE users SET username=?, usertype=? WHERE empid=?")) {
                    ps.setString(1, e.getEMPNAME());
                    ps.setString(2, e.getJOB());
                    ps.setString(3, e.getEMPID());

                    int rowsAffected = ps.executeUpdate();
                    return rowsAffected == 1;
                }
            } else {
                // The user is not present, so the update is considered successful
                return true;
            }
        }
    }

    public static boolean deleteEmployee(String empid) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("delete from employees WHERE empid=?")) {
                ps.setString(1, empid);
                int rowsAffected = ps.executeUpdate();
                return rowsAffected == 1;
            }
        }

    }
}

 