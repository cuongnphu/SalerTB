<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Thống Kê Nhà Sản Xuất</title>
    <link rel="stylesheet" href="../webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/general.css"/>
    <script src="../webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="../webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="../../js/statistic.js"></script>
</head>

<body>
<div class="navbar">
    <a class="active" href="/start">&#127968 Home</a>
    <a href="/statistic">&#9636 Thống Kê OrderBill</a>
    <a href="/product?teamId=0">&#9196 Nhập Hàng</a>
</div>
<h3>Tra Cứu Nhà Sản Xuất :</h3>
<form:form method="post" action="/poststatisticproduct" modelAttribute="modelTeam">
    <div class="table-responsive">
        <div>
            <form:input type="text" path="id" readonly="true" hidden="true"/>
            <form:input type="text" path="total" readonly="true" hidden="true"/>
            <form:input type="text" path="enable" readonly="true" hidden="true"/>
        </div>
        <br>
        <div class="container-fluid">
            <table class="table table-bordered" style="width: 800px;">
                <thead class="thead">
                <tr>
                    <th>Sắp Xếp Alphabet</th>
                    <th>Tên Nhà Sản Xuất</th>
                </tr>
                </thead>
                <tbody id="myProduct">
                <tr class="tb-row">
                    <td>
                        <form:select id="alphabetTeamId" path="teamId">
                            <option value="" disabled selected>ABC...</option>
                            <form:option value="1">A</form:option>
                            <form:option value="2">B</form:option>
                            <form:option value="3">C</form:option>
                            <form:option value="4">D</form:option>
                            <form:option value="5">E</form:option>
                            <form:option value="6">G</form:option>
                            <form:option value="7">H</form:option>
                            <form:option value="8">I</form:option>
                            <form:option value="9">K</form:option>
                            <form:option value="10">L</form:option>
                            <form:option value="11">M</form:option>
                            <form:option value="12">N</form:option>
                            <form:option value="13">O</form:option>
                            <form:option value="14">P</form:option>
                            <form:option value="15">Q</form:option>
                            <form:option value="16">R</form:option>
                            <form:option value="17">S</form:option>
                            <form:option value="18">T</form:option>
                            <form:option value="19">U</form:option>
                            <form:option value="20">V</form:option>
                            <form:option value="21">X</form:option>
                            <form:option value="22">Y</form:option>
                        </form:select>
                    </td>
                    <td>
                        <form:select id="nameProduct" path="name">
                            <c:forEach items="${teamList}" var="team">
                                <form:option value="${team.name}">${team.name}</form:option>
                            </c:forEach>
                        </form:select>
                    </td>
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
                <input class="btn btn-info" type="submit" value="Hoàn Thành"/>
            </div>
        </div>
    </div>
</form:form>
<br>
<h4 style="color: red"> Kết Quả Tra Cứu Nhập Hàng Kho :</h4>
<div class="table-responsive">
    <div class="container-fluid">
        <table class="table table-bordered" style="width: 800px">
            <thead>
            <tr>
                <th></th>
                <th>Ngày (Date)</th>
                <th>Tên Nhà Sản Xuất</th>
                <th>S.Lượng (Ri)</th>
                <th>Giá $(K)</th>
                <th>Tổng Tiền $(K)</th>
            </tr>
            </thead>
            <tbody id="listProduct">
            <c:if test="${statisticProduct.productList.size() > 0}">
            <c:forEach items="${statisticProduct.productList}" var="prod" varStatus="status">
                <tr class="tb-row">
                    <td>${status.index}</td>
                    <td><fmt:formatDate value="${prod.date}" pattern="dd/MM/yyyy"/></td>
                    <td>${prod.name}</td>
                    <td>${prod.quantity}</td>
                    <td>${prod.price}</td>
                    <td>${prod.total}</td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><c:set var="val" value="${statisticProduct.statisticTotal}"/>
                    <fmt:setLocale value="en"/>
                    <fmt:formatNumber value="${val}"/></td>
            </tr>
            </tbody>
            </c:if>
        </table>
    </div>
</div>

</body>
</html>