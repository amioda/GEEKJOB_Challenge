<%-- 
    Document   : Java_Challenge_12
    Created on : 2018/06/01, 12:35:50
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>for文2</title>
    </head>
    <body>
        <%
            //変数を宣言
            String a = "A";
            
            //変数を表示
            for( int i=1; i<=30; i++){
                out.print(a);
            }

        %>
    </body>
</html>
