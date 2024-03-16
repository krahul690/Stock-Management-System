package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ProductsPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductDAO {

    public static String getNextProductId() throws SQLException {

        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select max(P_ID) from products");
        rs.next(); //last one
        String productid = rs.getString(1);
        if (productid == null) {
            return "P101";
        }
        int productno = Integer.parseInt(productid.substring(1));
        productno = productno + 1;
        return "P" + productno;

    }

    public static boolean addProduct(ProductsPojo p) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO products (P_ID, P_NAME, P_COMPANYNAME, P_PRICE, OUR_PRICE, P_TAX, QUANTITY,status) VALUES (?, ?, ?, ?, ?, ?, ?,'Y')")) {

            // Set the values for the prepared statement
            ps.setString(1, p.getProductId());
            ps.setString(2, p.getProductName());
            ps.setString(3, p.getProductCompany());
            ps.setDouble(4, p.getProductPrice());
            ps.setDouble(5, p.getOurPrice());
            ps.setInt(6, p.getTax());
            ps.setInt(7, p.getQuantity());

            // Execute the update and check if one row was affected
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error", "Error!", JOptionPane.ERROR_MESSAGE);
            return false; // or handle the error in a way that suits your application
        }
    }

    public static List<ProductsPojo> getProductDetails() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from products where status='Y' order by p_id");
        ArrayList<ProductsPojo> productList = new ArrayList<>();
        while (rs.next()) {
            ProductsPojo p = new ProductsPojo();
            p.setProductId(rs.getString(1));
            p.setProductName(rs.getString(2));
            p.setProductCompany(rs.getString(3));
            p.setProductPrice(rs.getDouble(4));
            p.setOurPrice(rs.getDouble(5));
            p.setTax(rs.getInt(6));
            p.setQuantity(rs.getInt(7));
            productList.add(p);

        }
        return productList;
    }

    public static boolean deleteProduct(String productId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update products set status='N' where p_id=?");
        ps.setString(1, productId);
        return ps.executeUpdate() == 1;
    }

    public static boolean updateProducts(ProductsPojo p) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update products set P_NAME=?, P_COMPANYNAME=?,P_PRICE=?,P_OURPRICE=?,P_TAX=?,QUANTITY=?, WHERE P_ID=?");

        ps.setString(1, p.getProductName());
        ps.setString(2, p.getProductCompany());
        ps.setDouble(3, p.getProductPrice());
        ps.setDouble(4, p.getOurPrice());
        ps.setInt(5, p.getTax());
        ps.setInt(6, p.getQuantity());
        ps.setString(7, p.getProductId());
        return ps.executeUpdate() == 1;

    }
}
