<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Thống Kê OrderBill</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/general.css"/>
    <script src="/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="../../js/statistic.js"></script>
</head>

<body>
<div class="navbar">
    <a class="active" href="/start">&#127968 Home</a>
    <a href="/statistic">&#9636 Thống Kê OrderBill</a>
    <a href="">&#9196 Nhập Hàng</a>
</div>
<h3>Tra Cứu OrderBill: </h3>
<form:form method="post" action="/statisticsale" modelAttribute="statisticOrder">
    <div class="table-responsive">
        <table class="table table-bordered" style="width: 600px">
            <tr>
                <td>Từ:<form:input id="fromDate" path="orderBillList[0].date"
                                   placeholder="dd/MM/YYYY e.g:15/07/2019"/></td>
                <td>Đến:<form:input id="toDate" path="orderBillList[${statisticOrder.orderBillList.size()-1}].date"
                                    placeholder="dd/MM/YYYY"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input class="btn btn-info" type="submit" value="Thống Kê"
                           onchange="return statisticScript.formValidate()"
                           onclick="return statisticScript.formValidate()"/></td>
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
            </tr>
            </thead>
            <tbody id="myStatistic">
            <c:if test="${statisticOrder.orderBillList.size() > 0}">
                <c:forEach items="${statisticOrder.orderBillList}" var="order" varStatus="status">
                    <tr class="tb-row">
                        <td>${status.index}</td>
                        <td><fmt:formatDate value="${order.date}" pattern="dd/MM/yyyy"/></td>
                        <td>${order.name}</td>
                        <td>${order.total}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><c:set var="val" value="${statisticOrder.statisticTotal}"/>
                        <fmt:setLocale value="en"/>
                        <fmt:formatNumber value="${val}"/></td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>