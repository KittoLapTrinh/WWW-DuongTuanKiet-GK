<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.wwwduongtuankietgk.models.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: KittoLapTrinh
  Date: 09/27/2024
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Candidate</title>
    <style>

    </style>
</head>
<body>
    <h1>List Candidate</h1>
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
                int i = 1;
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
            %>

        </tbody>
    </table>

</body>
</html>
