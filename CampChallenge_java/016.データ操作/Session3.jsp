<%-- 
    Document   : Session3
    Created on : 2018/06/15, 10:31:44
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
// 内容：受け取ったパラメータをセッションに格納する

//文字化け防止
request.setCharacterEncoding("UTF-8");

// パラメータの取得
String name = request.getParameter("name");
String sex = request.getParameter("sex");
String hobby = request.getParameter("hobby");

// セッション変数の格納
session.setAttribute("name", name);
session.setAttribute("sex", sex);
session.setAttribute("hobby", hobby);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            名前： <%= name %><br><br>
            性別： <%= sex %><br><br>
            趣味： <%= hobby %><br><br>
            <a href="Session2.jsp">戻る</a>
        </p>
    </body>
</html>
