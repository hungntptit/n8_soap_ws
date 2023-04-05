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
        <title>Order input</title>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <form method="post" action="OrderServlet">
            <label>Order number</label>
            <input type="text" name="order_number" value="${order_number}" required><br/>
            <label>CompanyID</label>
            <input type="text" name="company_id" value="${company_id}" required><br/>
            <input type="hidden" name="action" value="check">
            <input type="submit">
        </form>
        <p>
            ${status}
        </p>
    </body>
</html>
