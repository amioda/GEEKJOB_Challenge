<%-- 
    Document   : main
    Created on : 2018/06/19, 13:13:42
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>メインページ</title>
    </head>
    <body>
        <!--商品情報の登録-->
        
        <form action="./additem.jsp" method="POST">
            
            <p>商品情報の登録</p>

            商品名： <input type="text" name = "itemname">
            
            <br><br>
            
            種類　： <input type="text" name = "itemtype">
            
            <br><br>
            
            <input type="submit" name="submit" value="登録">
            
        </form>
        
        <br><br><br><br>
        
        <!--商品一覧-->
        
        <input type="button" onclick="location.href='items.jsp'"value="商品一覧表示">
        
        <br><br><br><br>
        
        <button type="button" onclick="history.back()">ログアウト</button>
        
    </body>
</html>
