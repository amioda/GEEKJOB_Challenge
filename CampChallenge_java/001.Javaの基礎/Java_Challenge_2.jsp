<%-- 
    Document   : Java_Challenge_2
    Created on : 2018/05/31, 13:57:49
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>変数の宣言と表示（自己紹介）</title>
    </head>
    <body>
        <%
        
        String hello = "私の名前は";
        hello += "小田亜味です";
        
        out.print(hello);
        
        %>
    </body>
</html>
