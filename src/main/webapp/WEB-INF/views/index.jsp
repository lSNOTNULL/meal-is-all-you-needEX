<%@ page import="org.example.mealisallyouneedex.model.vo.Anime" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--    <pre> 결과는 <%= request.getAttribute("result")%></pre>--%>
    <section>
        <ul>
            <% for (Anime a : (List<Anime>)request.getAttribute("result")) {
                %>
            <li>
                <%= a.title()%> / <%= a.description()%> / <%= a.createdAt() %>
            </li>

            <%
            }%>
        </ul>

    </section>

    <section>
        <form action="anime" method="post">
            <label>이름 : <input name="title"></label>
            <label>설명 : <input name="description"></label>
            <button>등록</button>
        </form>
    </section>
</body>
</html>