<%-- 
    Document   : check
    Created on : 2018/06/19, 12:40:15
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>確認画面</title>
    </head>
    <body>
        <%
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            request.setCharacterEncoding("UTF-8");
            
            //入力された値を取得
            String nm = request.getParameter("nameInfo");
            String pass = request.getParameter("passInfo");
            
        try{
            
            //DBへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:443/challenge_db", "root", "");
            
            //DBに記載
            db_st = db_con.prepareStatement("select * from userinfo where(name = ? AND password = ?)");
            
            db_st.setString(1,nm);
            db_st.setString(2,pass);
            
            db_data = db_st.executeQuery();
            
            String url = "";
            
            if (db_data.next() == true){
                url = "/main.jsp";
            }else {
                url = "/error.jsp";
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request,response);
             
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
