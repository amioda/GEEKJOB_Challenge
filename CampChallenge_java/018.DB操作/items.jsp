<%-- 
    Document   : items
    Created on : 2018/06/19, 13:36:28
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            request.setCharacterEncoding("UTF-8");

        try{
            
            //DBへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:443/challenge_db", "root", "");
            
            out.println("商品一覧");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            
            //DBを表示
            db_st = db_con.prepareStatement("select * from iteminfo");
            
            db_data = db_st.executeQuery();
            while(db_data.next()){
                
                out.println("ID：" + db_data.getInt("itemID") +" " + "商品名：" + db_data.getString("itemName") + " " + "種類：" + db_data.getString("itemType"));
                
                out.println("<br>");
                out.println("<br>");
                
            }
             
            db_st.close();
            db_con.close();
            db_data.close();
            
        }catch (SQLException e_sql){
            
            out.println("接続時にエラーが発生しました:" + e_sql.toString());
            
        }catch (Exception e){
            
            out.println("接続時にエラーが発生しました:" + e.toString());
            
        }finally{
            
            if(db_con != null){
            
            try
            {
                db_con.close();
            }catch (Exception e_con){
                
                out.println(e_con.getMessage());
                
            }
            
        }
            
        }
        
        
        %>
        
        <button type="button" onclick="history.back()">戻る</button>
    </body>
</html>
