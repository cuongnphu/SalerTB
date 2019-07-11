<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Tạo OrderBill</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/general.css"/>
    <script src="/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="../../js/order.js"></script>
</head>

<body>
<h3>Tạo OrderBill: </h3>
<form:form method="post" action="/postorder" modelAttribute="orderBill">
    <div class="table-responsive">
        <table class="table table-bordered" style="width: 600px">
            <tr>
                <form:input type="text" path="id" readonly="true" hidden="true"/>
            </tr>
            <tr>
                <td>Tên Khách :</td>
                <td><form:input id="nameOrder" type="text" path="name" placeholder="Te^n ..."/></td>
            </tr>
            <tr>
                <td></td>
                <td><input class="btn btn-info" type="submit" value="Tạo OrderBill"
                           onchange="return orderScript.orderFormValidate()"
                           onclick="return orderScript.orderFormValidate()"/></td>
            </tr>
        </table>
    </div>
</form:form>
</body>
</html>