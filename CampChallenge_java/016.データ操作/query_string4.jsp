<%-- 
    Document   : query_string4
    Created on : 2018/06/14, 14:23:24
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String nu = request.getParameter("num");
        int m = Integer.parseInt(nu);
            
        //最初の数値
        
        out.print(m + " = ");
        
        // 2で割っていく
        while (m % 2 == 0) {
            out.print(2);
            out.print("  ");
            m /= 2;
        }
        
        // 3で割っていく
        while (m % 3 == 0) {
            out.print(3);
            out.print("  ");
            m /= 3;
        }
        
        // 5で割っていく
        while (m % 5 == 0) {
            out.print(5);
            out.print("  ");
            m /= 5;
        }
        
        // 7で割っていく
        while (m % 7 == 0) {
            out.print(7);
            out.print("  ");
            m /= 7;
        }
        
        
        //あまりを表示
        if(m == 0){
            
        }else{
            
            out.print(" あまり " + m);
            
        }
        
        %>
    </body>
</html>
