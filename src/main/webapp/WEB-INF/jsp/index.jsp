<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  ~ Point Grey Mini Print Service - authenticated printer utility
  ~ Copyright (C) 2019  Varun Patel <varun@varunpatel.ca>
  ~
  ~ This program is free software: you can redistribute it and/or modify
  ~ it under the terms of the GNU General Public License as published by
  ~ the Free Software Foundation, either version 3 of the License, or
  ~ (at your option) any later version.
  ~
  ~ This program is distributed in the hope that it will be useful,
  ~ but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~ MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  ~ GNU General Public License for more details.
  ~
  ~ You should have received a copy of the GNU General Public License
  ~ along with this program.  If not, see <https://www.gnu.org/licenses/>.
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>
        ${siteTitle}
    </title>
</head>
<body>
<form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
    <table>
        <tr>
            <td>
                <form:label path="studentID">Username: </form:label>
            </td>

            <td>
                <form:input path="studentID" name="studentID" id="username"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Password:</form:label>
            </td>
            <td>
                <form:password path="password" name="password" id="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:button id="login" name="login">Login</form:button>
            </td>
        </tr>
    </table>
</form:form>
<table>
    <tr>
        <td style="font-style: italic; color: red;">${message} <br /> ${error}</td>
    </tr>
</table>
</body>
</html>
