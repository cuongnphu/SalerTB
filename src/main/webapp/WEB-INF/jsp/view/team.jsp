<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Quản Lý Đội</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/general.css"/>
    <script src="/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="../../js/team.js"></script>
</head>
<body>
<h3>Thêm Đội: </h3>
<form:form method="post" action="/team" modelAttribute="modelteam">
    <div class="table-responsive">
        <table class="table table-bordered" style="width: 600px">
            <tr>
                <form:input type="text" path="id" readonly="true" hidden="true"/>
                <form:input type="text" path="total" readonly="true" hidden="true"/>
                <form:input type="text" path="enable" readonly="true" hidden="true"/>
            </tr>
            <tr>
                <td>Tên Đội :</td>
                <td><form:input id="nameTeam" type="text" path="name" placeholder="Tên đội"/></td>
            </tr>
            <tr>
                <td>Sắp Xếp Alphabet: </td>
                <td>
                    <form:select path="teamId">
                        <form:option value="1">A</form:option>
                        <form:option value="2">B</form:option>
                        <form:option value="3">C</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><a class="btn btn-info" href="/start">&#10094 Thoát</a></td>
                <td><input class="btn btn-info" type="submit" value="Tạo Đội" onchange="return teamScript.teamFormValidate()"
                           onclick="return teamScript.teamFormValidate()"/>
                </td>
            </tr>
        </table>
    </div>
</form:form>
<h3>Danh Sách Đội :</h3>
<table class="table table-bordered" style="width: 600px">
    <thead class="thead">
    <tr>
        <th style="width: 50%">Tên Đội</th>
        <th style="width: 20%">Alphabet</th>
        <th style="width: 20%">Tình Trạng</th>
        <th style="width: 10%">#</th>
    </tr>
    </thead>
    <tbody class="tbody-list">
    <c:forEach items="${listTeamForm}" var="teamform">
        <tr class="tb-row">
            <td>${teamform.name}</td>
            <td>
                <c:if test="${teamform.teamId == 1}">A</c:if>
                <c:if test="${teamform.teamId == 2}">B</c:if>
                <c:if test="${teamform.teamId == 3}">C</c:if>
            </td>
            <td>
                <c:if test="${teamform.enable == true}">Hoạt Động</c:if>
                <c:if test="${teamform.enable == false}">STOP</c:if>
            </td>
            <td>
                <p><a class="btn-info btn-sm" onclick="teamScript.teamFormConfirmEdit(${teamform.id})">&#9998</a></p>
                <p><a class="btn-info btn-sm" onclick="teamScript.teamFormConfirmDelete(${teamform.id})">&#9940</a></p>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>