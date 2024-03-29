package emart.dao;

import emart.dbutil.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDAO {

    public static String getNextOrderId() throws SQLException {

        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select max(Order_id) from orders");
        rs.next(); //last one
        String orderid = rs.getString(1);
        if (orderid == null) {
            return "O-101";
        }
        int orderno = Integer.parseInt(orderid.substring(2)); //O-101 already in 1 index
//        orderno = orderno + 1;
        orderno++;
        return "O" + orderno;

    }
}
