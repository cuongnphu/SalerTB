<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Nhập Hàng Vô Kho</title>
    <link rel="stylesheet" href="../webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/general.css"/>
    <script src="../webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="../webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="../../js/product.js"></script>
</head>

<body>
<h3>Nhập Hàng Vô Kho :</h3>
<form:form method="post" action="/postproduct" modelAttribute="product">
    <div class="table-responsive">
        <div>
            <form:input type="text" path="id" readonly="true" hidden="true"/>
            <form:input type="date" path="date" readonly="true" hidden="true"/>
            <form:input type="text" path="total" readonly="true" hidden="true"/>
        </div>
        <br>
        <div class="container-fluid">
            <table class="table table-bordered" style="width: 600px;">
                <thead class="thead">
                <tr>
                    <th>Tên Nhà Sản Xuất</th>
                    <th>S.Lượng (Ri)</th>
                    <th>Giá : $(K)</th>
                    <th></th>
                </tr>
                </thead>
                <tbody id="myProduct">
                <tr class="tb-row">
                    <td><form:input id="nameProduct" type="text" path="name"/></td>
                    <td><form:input type="text" path="quantity" onfocus="if(this.value == '0'){this.value ='';}"/></td>
                    <td><form:input type="text" path="price" onfocus="if(this.value == '0'){this.value = '';}"/></td>
                </tr>
                </tbody>
            </table>
        </div>
        <br>
        <div align="right" style="width: 600px">
            <div class="col-sm-8 p-0">
                <a class="btn-info btn" href="/start">&#10094 Thoát</a>
            </div>
            <div class="col-sm-4 p-0">
                <input class="btn btn-info" type="submit" value="Hoàn Thành"
                       onclick="return productScript.productValidateForm()"/>
            </div>
        </div>
    </div>
</form:form>
<br>
<h4 style="color: red"> Danh Sách Nhập Hàng Kho :</h4>
<div class="table-responsive">
    <div class="container-fluid">
        <table class="table table-bordered" style="width: 600px">
            <thead>
            <tr>
                <th></th>
                <th>Ngày (Date)</th>
                <th>Tên Nhà Sản Xuất</th>
                <th>S.Lượng (Ri)</th>
                <th>Giá $(K)</th>
                <th>Tổng Tiền $(K)</th>
                <th>#</th>
            </tr>
            </thead>
            <tbody id="listProduct">
            <c:if test="${productList.size() > 0}">
            <c:forEach items="${productList}" var="prod" varStatus="status">
                <tr class="tb-row">
                    <td>${status.index}</td>
                    <td><fmt:formatDate value="${prod.date}" pattern="dd/MM/yyyy"/></td>
                    <td>${prod.name}</td>
                    <td>${prod.quantity}</td>
                    <td>${prod.price}</td>
                    <td>${prod.total}</td>
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