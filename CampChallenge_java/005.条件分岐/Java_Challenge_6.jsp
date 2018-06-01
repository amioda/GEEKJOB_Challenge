<%-- 
    Document   : Java_Challenge_6
    Created on : 2018/06/01, 10:35:07
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Switch文1</title>
    </head>
    <body>
        <% 
            //変数の宣言
            int num = 1;
            
            switch ( num ) {
                
                //変数が１の場合
                case 1:
                    out.print("one");
                    break;
    
                 //変数が２の場合  
                case 2:
                    out.print("two");
                    break;
                    
                 //変数がそれ以外
                default:
                    out.print("想定外");
                    
            }    
            
        %>
    </body>
</html>
