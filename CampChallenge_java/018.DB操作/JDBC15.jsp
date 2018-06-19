<%-- 
    Document   : JDBC15
    Created on : 2018/06/19, 10:31:50
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
            ResultSet db_data = null;
            
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
            
            //DBの検索
            db_st = db_con.prepareStatement("update profiles set name = ?, tel = ?, age = ?, birthday = ? where profilesID = ?");
            
            db_st.setString(1, nm);
            db_st.setString(2, tel);
            db_st.setInt(3, j);
            db_st.setDate(4, date);
            db_st.setInt(5, i);
            
            //SQL文を実行する
            int k = db_st.executeUpdate();
            
            out.println("更新が完了しました");
            
            out.println("<br>");
            
            out.println("全てのデータを記載します");
            out.println("<br>");
            
            //DBを表示
            db_st = db_con.prepareStatement("select * from profiles");
            
            db_data = db_st.executeQuery();
            while(db_data.next()){
                
                out.println(db_data.getInt("profilesID") +" " + db_data.getString("name") + " " + db_data.getString("tel") + " " + 
                        db_data.getInt("age") + " " + db_data.getDate("birthday"));
                
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
    </body>
</html>
