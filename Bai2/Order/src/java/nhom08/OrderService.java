/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom08;

import dao.OrderDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hung
 */
@WebService(serviceName = "OrderService")
public class OrderService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "checkOrderStatus")
    public String checkOrderStatus(@WebParam(name = "orderNumber") String orderNumber,@WebParam(name = "companyID") String companyID) {
        return new OrderDAO().checkOrderStatus(orderNumber, companyID);
    }
}
