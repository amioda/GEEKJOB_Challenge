<%-- 
    Document   : Java_Challenge_9
    Created on : 2018/06/01, 11:29:16
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>配列の変更</title>
    </head>
    <body>
        <%@ page import = "java.util.ArrayList" %>
        
        <%
            
           //ArrayList型の変数を宣言 
           ArrayList<String> data1 = new ArrayList<String>(); 
            
           data1.add("10");
           data1.add("100");
           data1.add("soeda");
           data1.add("hayashi");
           data1.add("-20");
           data1.add("118");
           data1.add("END");
           
           //要素の書き換え
           data1.set(2,"33");
           
           //要素の表示
           out.print(data1);
            
         %>
    </body>
</html>
