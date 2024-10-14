<%@ page import="vn.edu.iuh.fit.wwwduongtuankietgk.models.Candidate" %>
<%@ page import="vn.edu.iuh.fit.wwwduongtuankietgk.models.Experience" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 10/12/2024
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
    <h1>Detail</h1>

    <%
        Candidate candidate = (Candidate) request.getAttribute("candidates");
        StringBuilder listRole = new StringBuilder();
        for(Experience experience : candidate.getExperiences()) {
            listRole.append(experience);
        }
        System.out.println(listRole);
    %>
    <table>
        <tr>
            <td>Id</td>
            <td><%=candidate.getId()%></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><%=candidate.getFullName()%></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><%=candidate.getPhone()%></td>
        </tr>
        <tr>
            <td>List Exp</td>
            <td><%=candidate.getExperiences()%></td>
        </tr>

    </table>


</body>
</html>
