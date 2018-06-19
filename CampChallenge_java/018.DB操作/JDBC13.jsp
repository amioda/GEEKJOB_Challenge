<%-- 
    Document   : JDBC13
    Created on : 2018/06/19, 10:17:49
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
            String id = request.getParameter("idInfo");
            
            //文字列を数値に変換
            int i = Integer.parseInt(id);

        try{
            
            //DBへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:443/challenge_db", "root", "");
            
            //DBから削除
            db_st = db_con.prepareStatement("delete from profiles where profilesID = ?");
            
            db_st.setInt(1, i);
            
            //SQL文を実行する
            int k = db_st.executeUpdate();
            
            out.println("削除しました");
             
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
    </body>
</html>
