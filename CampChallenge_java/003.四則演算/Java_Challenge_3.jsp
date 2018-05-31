<%-- 
    Document   : Java_Challenge_3
    Created on : 2018/05/31, 14:36:33
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>変数の宣言と表示（四則演算）</title>
    </head>
    <body>
        <%
            
            final int num1 = 50;
            int num2 = 10;
            
            int plus = num1 + num2;
            int minus = num1 - num2;
            int multiply = num1 * num2;
            int divide = num1 / num2;
            
            out.print(plus + "<br>");
            out.print(minus + "<br>");
            out.print(multiply + "<br>");
            out.print(divide + "<br>");
            
            num2++;
            
            int remainder = num1 % num2;
            
            out.print(remainder);


        %>
    </body>
</html>
