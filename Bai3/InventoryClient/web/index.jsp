<%-- 
    Document   : index
    Created on : Apr 3, 2023, 7:20:07 PM
    Author     : hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory input</title>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <form method="post" action="InventoryServlet">
            <label>Product ID</label>
            <input type="number" name="id" value="${id}" required><br/>
            <label>Quantity</label>
            <input type="number" name="quantity" value="${quantity}" required><br/>
            <input type="hidden" name="action" value="check">
            <input type="submit">
        </form>
        <p>
            ${check}
        </p>
    </body>
</html>
