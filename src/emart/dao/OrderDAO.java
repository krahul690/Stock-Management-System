package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.OrderPojo;
import emart.pojo.ProductsPojo;
import emart.pojo.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        return "O-" + orderno;

    }

    public static boolean addOrder(ArrayList<ProductsPojo> al, String orderid) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into orders values(?,?,?,?)");
        int count = 0;
        for (ProductsPojo p : al) {
            ps.setString(1, orderid);
            ps.setString(2, p.getProductId());
            ps.setInt(3, p.getQuantity());
            ps.setString(4, UserProfile.getUserid());
            count = count + ps.executeUpdate();
        }
        return count == al.size();
    }     

    public static List<OrderPojo> getAllOrders() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<OrderPojo> orderList = new ArrayList<>();
            conn = DBConnection.getConnection();
            String query = "SELECT * FROM orders";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                OrderPojo order = new OrderPojo();
                order.setOrderId(rs.getString("Order_id"));
                order.setProductId(rs.getString("P_ID"));
                order.setQuantity(rs.getInt("QUANTITY"));
                order.setUserId(rs.getString("USERID"));
                orderList.add(order);
            }
        
        return orderList;
    }

}
