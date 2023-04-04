/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom08;

import dao.CardDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Card;

/**
 *
 * @author hung
 */
@WebService(serviceName = "CreditCardService")
public class CreditCardService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "card_charge")
    public float cardCharge(@WebParam(name = "owner") String owner, @WebParam(name = "card_type") String card_type,
            @WebParam(name = "card_number") String card_number, @WebParam(name = "cvc") int cvc,
            @WebParam(name = "expire_date") String expire_date) {
        try {
            new SimpleDateFormat("mm/yyyy").parse(expire_date);
            Card card = new Card(owner, card_type, card_number, cvc, expire_date);
            boolean check = new CardDAO().checkCard(card);
            if (check) {
                long diff = card.getEnd_date().getTime() - card.getStart_date().getTime();
                long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                if (days < 10) {
                    return days;
                } else {
                    return 10;
                }
            } else {
                return -1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
