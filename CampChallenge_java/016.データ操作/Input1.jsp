<%-- 
    Document   : Input1
    Created on : 2018/06/12, 16:50:21
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力フィールド</title>
    </head>
    <body>
        
        <form action="./result.jsp" method = "get">
            
            <!--氏名を入力するフォーム-->
            氏名：　<input type="text" name = "nameInfo">
            <br><br>
            
            <!--性別を選択するフォーム-->
            男<input type="radio" name="sex" value="男" checked="checked">
            女<input type="radio" name="sex" value="女">
            <br><br>
            
            <!--趣味を入力するフォーム-->
            趣味：　<textarea name="hobby"></textarea>
            <br><br>
            <input type="submit" name="submit" value="入力">
            
        </form>
        
    </body>
</html>
