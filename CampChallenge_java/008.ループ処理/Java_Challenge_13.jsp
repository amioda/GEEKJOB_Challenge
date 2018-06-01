<%-- 
    Document   : Java_Challenge_13
    Created on : 2018/06/01, 12:35:50
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>for文3</title>
    </head>
    <body>
        <%
            //変数を宣言
            int num = 0;
            
            //ループ計算
            for( int i=0; i<=100; i++){
                num = num + i;
            }
            
            //変数の表示
            out.print(num);

        %>
    </body>
</html>
