<%-- 
    Document   : JDBC11
    Created on : 2018/06/18, 17:25:55
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%@page import = "java.text.SimpleDateFormat"%>

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
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            //入力された値を取得
            String id = request.getParameter("idInfo");
            String nm = request.getParameter("nameInfo");
            String tel = request.getParameter("telInfo");
            String age = request.getParameter("ageInfo");
            String birth = request.getParameter("birthInfo");
            
            //文字列を数値に変換
            int i = Integer.parseInt(id);
            int j = Integer.parseInt(age);
            
            //文字列を日付に変換
            Date date = new java.sql.Date(dateFormat .parse(birth).getTime());

        try{
            
            //DBへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:443/challenge_db", "root", "");
            
            //DBに書き込み
            db_st = db_con.prepareStatement("INSERT INTO profiles values(?, ?, ?, ?, ?)");
            
            db_st.setInt(1, i);
            db_st.setString(2, nm);
            db_st.setString(3, tel);
            db_st.setInt(4, j);
            db_st.setDate(5, date);
            
            //SQL文を実行する
            int k = db_st.executeUpdate();
            
            out.println("書き込み完了しました");
             
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
