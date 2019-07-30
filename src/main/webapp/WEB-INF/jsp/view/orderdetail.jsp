<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Nhập Chi Tiết Ri Hàng</title>
    <link rel="stylesheet" href="../webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/general.css"/>
    <script src="../webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="../webjars/jquery/3.3.1/jquery.min.js"></script>

    <script src="../../js/bill.js"></script>
</head>

<body>
<h3>Nhập Chi Tiết Ri Hàng :</h3>
<form:form method="post" action="/postorderdetail" modelAttribute="tabOrder">
    <div class="table-responsive">
        <div>
            <form:input type="text" path="orderBill.id" readonly="true" hidden="true"/>
            <form:input type="date" path="orderBill.date" readonly="true" hidden="true"/>
            <form:input type="text" path="orderBill.total" readonly="true" hidden="true"/>
        </div>
        <div>
            <label>Tên Khách Hàng : </label> <form:input id="nameOrder" type="text" path="orderBill.name" />
        </div>
        <br>
        <div class="container-fluid">
            <table class="table table-bordered" style="width: 600px;">
                <thead class="thead">
                <tr>
                    <th></th>
                    <th>S.Lượng (Ri)</th>
                    <th>Giá : $(K)</th>
                    <th></th>
                </tr>
                </thead>
                <tbody id="myBill">
                <c:forEach items="${tabOrder.billList}" var="bill" varStatus="status">
                    <tr class="tb-row">
                        <td>
                            <form:input type="text" path="billList[${status.index}].id" readonly="true"
                                        hidden="true"/>
                            <form:input type="text" path="billList[${status.index}].orderId"
                                        readonly="true"
                                        hidden="true"/>
                                ${status.index}
                        </td>
                        <td>
                            <form:input type="text" path="billList[${status.index}].quantity"
                                        onfocus="if(this.value == '0'){this.value ='';}"/>
                        </td>
                        <td>
                            <form:input type="text" path="billList[${status.index}].price"
                                        onfocus="if(this.value == '0'){this.value ='';}"/>
                        </td>
                        <td>
                            <c:if test="${bill.id > 0}">
                                <a class="btn-danger btn-xs"
                                   href="bill/${bill.orderId}/delete/${bill.id}">-</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div align="right" style="width: 600px">
            <a class="btn-success btn-sm"
               onclick="addBill(${tabOrder.orderBill.id},${tabOrder.billList.size()})">&#10133</a>
        </div>
        <br>
        <div align="right" style="width: 600px">
                <div class="col-sm-8 p-0">
                    <a class="btn-info btn"
                       href="/deleteorder/${tabOrder.orderBill.id}">&#10094 Thoát</a>
                </div>
                <div class="col-sm-4 p-0">
                    <input class="btn btn-info" type="submit" value="Hoàn Thành"
                           onchange="return billScript.editOrderValidateForm()"
                           onclick="return billScript.editOrderValidateForm()"/>
                </div>
        </div>
    </div>
</form:form>
</body>
</html>