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
        <table class="table table-bordered" style="width: 800px">
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
<table class="table table-bordered" style="width: 800px">
    <thead class="thead">
    <tr>
        <th >Tên Đội</th>
        <th >Alphabet</th>
        <th >Tình Trạng</th>
        <th >#</th>
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
                <c:if test="${teamform.teamId == 4}">D</c:if>
                <c:if test="${teamform.teamId == 5}">E</c:if>
                <c:if test="${teamform.teamId == 6}">G</c:if>
                <c:if test="${teamform.teamId == 7}">H</c:if>
                <c:if test="${teamform.teamId == 8}">I</c:if>
                <c:if test="${teamform.teamId == 9}">K</c:if>
                <c:if test="${teamform.teamId == 10}">L</c:if>
                <c:if test="${teamform.teamId == 11}">M</c:if>
                <c:if test="${teamform.teamId == 12}">N</c:if>
                <c:if test="${teamform.teamId == 13}">O</c:if>
                <c:if test="${teamform.teamId == 14}">P</c:if>
                <c:if test="${teamform.teamId == 15}">Q</c:if>
                <c:if test="${teamform.teamId == 16}">R</c:if>
                <c:if test="${teamform.teamId == 17}">S</c:if>
                <c:if test="${teamform.teamId == 18}">T</c:if>
                <c:if test="${teamform.teamId == 19}">U</c:if>
                <c:if test="${teamform.teamId == 20}">V</c:if>
                <c:if test="${teamform.teamId == 21}">X</c:if>
                <c:if test="${teamform.teamId == 22}">Y</c:if>
            </td>
            <td>
                <c:if test="${teamform.enable == true}">Hoạt Động</c:if>
                <c:if test="${teamform.enable == false}">STOP</c:if>
            </td>
            <td>
                <a class="btn-info btn-sm" onclick="teamScript.teamFormConfirmEdit(${teamform.id})">&#9998</a>
                <a class="btn-info btn-sm" onclick="teamScript.teamFormConfirmDelete(${teamform.id})">&#9940</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>