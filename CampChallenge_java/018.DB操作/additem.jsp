<%-- 
    Document   : additem
    Created on : 2018/06/19, 13:36:42
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
            
            request.setCharacterEncoding("UTF-8");
            
            //入力された値を取得
            String nm = request.getParameter("itemname");
            String type = request.getParameter("itemtype");
            
        try{
            
            //DBへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:443/challenge_db", "root", "");
            
            //DBに記載
            db_st = db_con.prepareStatement("INSERT INTO iteminfo (itemName, itemType) values(?, ?)");
            
            db_st.setString(1, nm);
            db_st.setString(2, type);
            
            //SQL文を実行する
            int k = db_st.executeUpdate();
            
            out.println("商品を登録しました。");
            out.println("<br>");
            out.println("<br>");
             
            db_st.close();
            db_con.close();
            
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
