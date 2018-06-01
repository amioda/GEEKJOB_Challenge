<%-- 
    Document   : Java_Challenge_11
    Created on : 2018/06/01, 12:35:50
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>for文１</title>
    </head>
    <body>
        <%
            //変数を宣言
            int num = 8;
            //答えの変数。数が大きくなるのでlongを使用
            long ans = 1;
            
            //forを使用した計算式
            for( int i=1; i<=20; i++){
                ans = num * ans;
            }
            
            //結果を表示
            out.print(ans); 

        %>
    </body>
</html>
