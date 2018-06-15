<%-- 
    Document   : Session2
    Created on : 2018/06/14, 18:46:12
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <%//セッションの変数を取得
            String userName = (String)session.getAttribute("name");
            String userSex = (String)session.getAttribute("sex");
            String userHobby = (String)session.getAttribute("hobby");
            %>
        
        <form action="Session3.jsp" method="GET">
            
            <!--フォームに入力-->
            名前<input type="text" name="name" value="<%= userName %>">
            <br><br>
            性別　男<input type="radio" name="sex" value="男" checked="checked">
                　女<input type="radio" name="sex" value="女">
            <br><br>
            趣味<input type="text" name="hobby" value="<%= userHobby %>">
            <br><br>
            <input type="submit" value="送信" />
    </body>
</html>
