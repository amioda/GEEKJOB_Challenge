<%-- 
    Document   : JDBC9
    Created on : 2018/06/18, 15:35:00
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果表示</title>
    </head>
    <body>
        <%
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            request.setCharacterEncoding("UTF-8");
            
            String st = request.getParameter("nameInfo");
            

        try{
            
            //DBへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:443/challenge_db", "root", "");
            
            //DBを検索
            db_st = db_con.prepareStatement("select * from profiles where name like ? ");
            
            db_st.setString(1,"%"+st+"%");
            db_data = db_st.executeQuery();
            while(db_data.next()){
                
                out.println(db_data.getInt("profilesID") +" " + db_data.getString("name") + " " + db_data.getString("tel") + " " + 
                        db_data.getInt("age") + " " + db_data.getDate("birthday"));
                
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
    </body>
</html>
