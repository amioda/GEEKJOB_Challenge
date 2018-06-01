<%-- 
    Document   : Java_Challenge_5
    Created on : 2018/06/01, 9:56:09
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>変数の宣言と表示(if文)</title>
    </head>
    <body>
        <%
            //変数の宣言
            int num = 2;
            
            //条件分岐
            if(num == 1) //変数が１のとき
            {
                out.print("１です！");
            }else if(num == 2)//変数が２のとき
                {
                    out.print("プログラミングキャンプ！");
                }else//変数がそれ以外のとき
            {
                out.print("その他です！");
            }
            
        %>
    </body>
</html>
