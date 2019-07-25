<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Tạo OrderBill</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/general.css"/>
    <script src="/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="../../js/order.js"></script>
</head>

<body>
<div class="navbar">
    <a class="active" href="/start">&#127968 Home</a>
    <a href="/statistic">&#9636 Thống Kê OrderBill</a>
    <a href="/product">&#9196 Nhập Hàng</a>
</div>
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
<br>
<h4 style="color: red"> Danh Sách :</h4>
<div class="table-responsive">
    <div class="container-fluid">
        <table class="table table-bordered" style="width: 600px">
            <thead>
            <tr>
                <th></th>
                <th>Ngày (Date)</th>
                <th>Tên Khách</th>
                <th>Tổng Tiền $(K)</th>
                <th>#</th>
            </tr>
            </thead>
            <tbody id="myBill">
            <c:if test="${listOrderBill.size() > 0}">
            <c:forEach items="${listOrderBill}" var="order" varStatus="status">
                <tr class="tb-row">
                    <td>${status.index}</td>
                    <td><fmt:formatDate value="${order.date}" pattern="dd/MM/yyyy"/></td>
                    <td>${order.name}</td>
                    <td>${order.total}</td>
                    <td><a class="btn-info btn-sm" href="/orderdetail/${order.id}">&#9998</a></td>
                </tr>
            </c:forEach>
            </tbody>
            </c:if>
        </table>
    </div>
</div>


</body>
</html>