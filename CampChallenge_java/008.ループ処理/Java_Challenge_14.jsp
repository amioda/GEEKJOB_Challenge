<%-- 
    Document   : Java_Challenge_14
    Created on : 2018/06/01, 13:45:35
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>while文</title>
    </head>
    <body>
        <%
            //変数を宣言
            int num = 1000;
            
            //変数を２で割る
            //結果が１００より小さくなったらループを抜ける
            while(num > 100){
                 num = num / 2;
        }
            
            //結果を表示
            out.print(num);
            
        %>    
    </body>
</html>
