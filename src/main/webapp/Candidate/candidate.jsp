<%@ page import="vn.edu.iuh.fit.wwwduongtuankietgk.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 10/12/2024
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Candidate</title>
    <style>
        table{
            width: 100%;
            border-collapse: collapse;
        }
        th,td{
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th{
            background-color: #C4C4C4;
        }
        h1{
            text-align: center;
            color: dodgerblue;
        }


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
            List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates");
//            int i = 1;
            for(Candidate can : candidates) {
        %>
        <tr>
            <td><%=can.getId()%></td>
            <td><%=can.getFullName()%></td>
            <td><%=can.getPhone()%></td>
            <td><%=can.getEmail()%></td>
            <td><a href="page?action=detail-candidate&id=<%=can.getId()%>">See Detail</a> </td>
        </tr>

        <%
            }
        %>

    </tbody>
</table>

</body>
</html>
