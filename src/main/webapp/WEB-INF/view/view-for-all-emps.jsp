<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: jeraldin
  Date: 7/10/23
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VIEW FOR ALL EMPS</title>
</head>
<body>
INFORMATION FOR ALL EMPS
<security:authorize access="hasRole('HR')">
    <br>
    INFO FOR HR'S
    <br>
    <input type="button" value="SALARY" onclick="window.location.href='hr_info'">
</security:authorize>

<security:authorize access="hasRole('MANAGER')">
    <br>
    INFO FOR MANAGERS
    <br>
    <input type="button" value="PERFORMANCE" onclick="window.location.href='manager_info'">
</security:authorize>

</body>
</html>
