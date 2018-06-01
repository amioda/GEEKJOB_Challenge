<%-- 
    Document   : Java_Challenge_7
    Created on : 2018/06/01, 10:49:23
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>switch文2</title>
    </head>
    <body>
        <%
             //変数を宣言
             char word = 'A';
          
             //条件分岐
             switch(word){
                 //英語の場合
                 case 'A':
                     out.print("英語");
                     break;
                     
                //日本語の場合     
                 case 'あ':
                     out.print("日本語");
                     break;
                     
                //それ以外の場合
                 default:
                     break;
                 
             }

            
        %>
    </body>
</html>
