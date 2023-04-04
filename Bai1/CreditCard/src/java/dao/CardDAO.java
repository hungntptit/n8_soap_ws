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
import model.Card;

/**
 *
 * @author hung
 */
public class CardDAO extends DAO {

    public CardDAO() {
        super();
    }

    public boolean checkCard(Card card) {
        boolean result = false;
//        String sql = "SELECT * FROM card WHERE owner = ? AND card_type = ? AND card_number = ? AND cvc = ? AND expire_date = ?";
        String sql = "SELECT * FROM card WHERE owner = ? AND card_type = ? AND card_number = ? AND cvc = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, card.getOwner());
            ps.setString(2, card.getCard_type());
            ps.setString(3, card.getCard_number());
            ps.setInt(4, card.getCvc());
//            ps.setDate(5, new Date(new SimpleDateFormat("mm/yyyy").parse(card.getExpire_date()).getTime()));
            ResultSet rs = ps.executeQuery();
            result = false;
            if (rs.next()) {
//                System.out.println(rs.getInt("id"));
                String[] splits = card.getExpire_date().split("/");
                int month = Integer.parseInt(splits[0]);
                int year = Integer.parseInt(splits[1]);
//                System.out.println(rs.getDate("expire_date").getMonth());
//                System.out.println(rs.getDate("expire_date").getYear());
//                System.out.println(month);
//                System.out.println(year);
                if (rs.getDate("expire_date").getMonth() + 1 == month && rs.getDate("expire_date").getYear() + 1900 == year) {
                    card.setStart_date(new Date(rs.getDate("start_date").getTime()));
                    card.setEnd_date(new Date(rs.getDate("end_date").getTime()));
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static void main(String[] args) throws ParseException {
        Card c = new Card("hung", "mastercard", "1234", 123, "02/2025");
        boolean check = new CardDAO().checkCard(c);
        System.out.println(check);
    }
}
