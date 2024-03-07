package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.UserPojo;
import emart.pojo.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO Data Access Object (DAO) class for handling user-related
 * database operations.
 */
public class UserDao {

    //call from frame
    public static boolean validateUser(UserPojo user) throws SQLException {

        //open connection obj.
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from users where USERID=? and   PASSWORD=? and USERTYPE=?");

        //call setters-3 from a pojo
        // Set values for placeholders using user details.
        ps.setString(1, user.getUserid());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUsertype());

        // Execute the query.
        ResultSet rs = ps.executeQuery();

        //check if any record available or not
        if (rs.next()) {
            //show user name in panel
            String username = rs.getString("USERNAME");
            UserProfile.setUsername(username);
            return true;
        }
        return false;

    }

    public static boolean isUserPresent(String empid) throws SQLException {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT 1 FROM users WHERE empid=?")) {
            ps.setString(1, empid);
            ResultSet rs = ps.executeQuery();

            return rs.next();
        }
    }

}
