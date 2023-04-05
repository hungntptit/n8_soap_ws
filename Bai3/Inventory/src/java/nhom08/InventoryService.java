/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom08;

import dao.ProductDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hung
 */
@WebService(serviceName = "InventoryService")
public class InventoryService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "checkInventory")
    public boolean checkInventory(@WebParam(name = "id") int id, @WebParam(name = "quantity") int quantity) {
        return new ProductDAO().checkInventory(id, quantity);
    }
}
