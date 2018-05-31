<%-- 
    Document   : Java_Challenge_4
    Created on : 2018/05/31, 16:48:35
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>文字の連結表示</title>
    </head>
    <body>
        <%
            
           //文字列を扱う変数の宣言
           String grv = "groove";
           String hyphen = "-";
           String gear = "gear";
           
           //文字列の表示
           out.print(grv + hyphen + gear);
            
         %>   
    </body>
</html>
