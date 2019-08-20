<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Cập Nhật Thông Tin Đội</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/general.css"/>
    <script src="/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="../../js/team.js"></script>
</head>
<body>
<h3>Cập Nhật Thông Tin Đội: </h3>
<form:form method="post" action="/updateteam" modelAttribute="modelteam">
    <div class="table-responsive">
        <table class="table table-bordered" style="width: 600px">
            <tr>
                <form:input type="text" path="id" readonly="true" hidden="true"/>
                <form:input type="text" path="total" readonly="true" hidden="true"/>
            </tr>
            <tr>
                <td>Tên Đội :</td>
                <td><form:input id="nameTeam" type="text" path="name" readonly="true"
                                cssStyle="background: gainsboro"/></td>
            </tr>
            <tr>
                <td>Sắp Xếp Alphabet :</td>
                <td>
                    <form:select path="teamId" cssStyle="background: gainsboro; ">
                        <c:if test="${modelteam.teamId == 1}">
                            <form:option value="1" selected="selected">A</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 2}">
                            <form:option value="2" selected="selected">B</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 3}">
                            <form:option value="3" selected="selected">C</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 4}">
                            <form:option value="4" selected="selected">D</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 5}">
                            <form:option value="5" selected="selected">E</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 6}">
                            <form:option value="6" selected="selected">G</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 7}">
                            <form:option value="7" selected="selected">H</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 8}">
                            <form:option value="8" selected="selected">I</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 9}">
                            <form:option value="9" selected="selected">K</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 10}">
                            <form:option value="10" selected="selected">L</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 11}">
                            <form:option value="11" selected="selected">M</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 12}">
                            <form:option value="12" selected="selected">N</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 13}">
                            <form:option value="13" selected="selected">O</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 14}">
                            <form:option value="14" selected="selected">P</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 15}">
                            <form:option value="15" selected="selected">Q</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 16}">
                            <form:option value="16" selected="selected">R</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 17}">
                            <form:option value="17" selected="selected">S</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 18}">
                            <form:option value="18" selected="selected">T</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 19}">
                            <form:option value="19" selected="selected">U</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 20}">
                            <form:option value="20" selected="selected">V</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 21}">
                            <form:option value="21" selected="selected">X</form:option>
                        </c:if>
                        <c:if test="${modelteam.teamId == 22}">
                            <form:option value="22" selected="selected">Y</form:option>
                        </c:if>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Tình Trang:</td>
                <td>
                    <form:select path="enable">
                        <c:if test="${modelteam.enable == true}">
                            <form:option value="1" selected="selected">Hoạt Động</form:option>
                            <form:option value="0">STOP</form:option>
                        </c:if>
                        <c:if test="${modelteam.enable == false}">
                            <form:option value="1">Hoạt Động</form:option>
                            <form:option value="0" selected="selected">STOP</form:option>
                        </c:if>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <a class="btn btn-info" onclick="teamScript.editTeamConfirmOut()">&#10094 Thoát</a>
                    <button class="btn-info btn" type="submit">Cập Nhật &#10004</button>
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
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>