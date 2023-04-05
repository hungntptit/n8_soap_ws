/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hung
 */
public class OrderDAO extends DAO {

    public OrderDAO() {
        super();
    }

    public String checkOrderStatus(String orderNumber, String companyID) {
        String sql = "SELECT * FROM tbl_order WHERE order_number = ? AND company_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, orderNumber);
            ps.setString(2, companyID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return "Status: " + rs.getString("order_status");
            } else {
                return "no order found";
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public static void main(String[] args) throws ParseException {
        String status = new OrderDAO().checkOrderStatus("164068", "cpn2");
        System.out.println(status);
    }
}
