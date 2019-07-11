<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title> In Chi Tiết Bill</title>
    <link rel="stylesheet" href="../webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/general.css"/>
    <script src="../webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="../webjars/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<h3> Đơn Hàng :</h3>
<div class="table-responsive">
    <div>
        <label>Tên : </label> ${tabOrder.orderBill.name}
    </div>
    <div class="container-fluid">
        <table class="table table-bordered" style="width: 600px">
            <thead>
            <tr>
                <th></th>
                <th>S.Lượng (Ri)</th>
                <th>Giá : $(K)</th>
                <th>Thành Tiền $(K)</th>
            </tr>
            </thead>
            <tbody id="myBill">
            <c:if test="${tabOrder.billList.size() > 0}">
            <c:forEach items="${tabOrder.billList}" var="bill" varStatus="status">
                <tr class="tb-row">
                    <td>${status.index}</td>
                    <td>${bill.quantity}</td>
                    <td>${bill.price}</td>
                    <td>${bill.total}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3" align="right"> Tổng Tiền:</td>
                <td>${tabOrder.orderBill.total}</td>
            </tr>
            </tbody>
            </c:if>
        </table>
    </div>
    <div>
        <input class="btn btn-info" type="submit" value="In Bill"
               onclick="window.print()"/>
    </div>
</div>
</body>
</html>