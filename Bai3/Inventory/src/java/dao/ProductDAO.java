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
public class ProductDAO extends DAO {

    public ProductDAO() {
        super();
    }

    public boolean checkInventory(int id, int quantity) {
        boolean result = false;
        String sql = "SELECT * FROM product WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            result = false;
            if (rs.next()) {
                int db_quantity = rs.getInt("quantity");
                if (quantity <= db_quantity) {
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static void main(String[] args) throws ParseException {
        boolean check = new ProductDAO().checkInventory(1, 15);
        System.out.println(check);
    }
}
