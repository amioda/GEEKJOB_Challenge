<%-- 
    Document   : Java_Challenge_10
    Created on : 2018/06/01, 12:00:03
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>連想配列の作成</title>
    </head>
    <body>
        <%@ page import="java.util.HashMap" %>
        
        <%
            //連想配列の作成
            HashMap<String, String> data1 = new HashMap<String, String>();
            
            //要素の追加
            data1.put("1", "AAA");
            data1.put("hello", "world");
            data1.put("soeda", "33");
            data1.put("20", "20");
            
            //要素の表示
            out.print(data1);
            
         %>   
    </body>
</html>
