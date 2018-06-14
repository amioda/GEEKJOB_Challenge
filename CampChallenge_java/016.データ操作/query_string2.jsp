<%-- 
    Document   : query_string2
    Created on : 2018/06/14, 10:15:28
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
          
          request.setCharacterEncoding("UTF-8");
          String num = request.getParameter("type");
          String con = request.getParameter("count");
          int c = Integer.parseInt(con);
          int tot = 0;
          
          //雑貨を選択したとき
          if(num.compareTo("1") == 0){
              
              out.println("雑貨");
              out.println("<br>");
              out.println("単価：500円");
              
              out.println("<br>");
              out.println("総計:" + (c * 500 ) + "円");
              
              tot = c * 500;
          
          //生鮮食品を選択したとき    
          }else if(num.compareTo("2") == 0){
              
              out.println("生鮮食品");
              out.println("<br>");
              out.println("単価：150円");
              
              out.println("<br>");
              out.println("総計:" + (c * 150 ) + "円");
              
              tot = c * 150;
           
          //その他を選択したとき    
          }else{
              
              out.println("その他");
              out.println("<br>");
              out.println("単価：300円");
              
              out.println("<br>");
              out.println("総計:" + (c * 300 ) + "円");
              
              tot = c * 300;
          }
          
          //ポイント計算
          out.println("<br>");
          
          if(tot <= 3000){
              
              out.println("今回のポイントは0ポイントです");
              
          }else{
              
              if(tot <= 5000){
                  
                  out.println("今回のポイントは" + (tot*0.04) + "ポイントです");
                  
              }else{
                  
                  out.println("今回のポイントは" + (tot*0.05) + "ポイントです");
                  
              }
              
          }
          


        %>
        
    </body>
</html>
