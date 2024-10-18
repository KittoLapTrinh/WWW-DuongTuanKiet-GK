<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.wwwduongtuankietgk.models.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: KittoLapTrinh
  Date: 09/28/2024
  Time: 1:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 2</title>
</head>
<body>
<h1>List Candidate Has Email</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Full Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Detail</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Candidate> candidates = (List<Candidate>)request.getAttribute("candidates");
        if (candidates != null) {
            for (Candidate can:
                    candidates) {
    %>

    <tr>
        <td><%=can.getId()%></td>
        <td><%=can.getFullName()%></td>
        <td><%=can.getPhone()%></td>
        <td><%=can.getEmail()%></td>
        <td><a href="page?action=detail-candidate&id=<%=can.getId()%>">See Detail</a></td>
    </tr>
    <%
            }
        }
    %>

    </tbody>
</table>
</body>
</html>
