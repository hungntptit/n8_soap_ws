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
        <title>Input</title>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <form method="post" action="CardServlet">
            <label>Owner</label>
            <input type="text" name="owner" value="${owner}" required><br/>
            <label>Card type</label>
            <input type="text" name="card_type" value="${card_type}" required><br/>
            <label>Card Number</label>
            <input type="text" name="card_number" value="${card_number}" required><br/>
            <label>CVC</label>
            <input type="number" name="cvc" value="${cvc}" required><br/>
            <label>Expire Date</label>
            <input type="text" name="expire_date" value="${expire_date}" required><br/>
            <input type="hidden" name="action" value="check">
            <input type="submit">
        </form>
        <p>
            ${charge}
        </p>
    </body>
</html>
