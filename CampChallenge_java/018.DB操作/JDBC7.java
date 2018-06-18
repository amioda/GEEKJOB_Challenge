/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ami
 */

import java.sql.*;

public class JDBC7 {
    
    public static void main(String[] args){
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        
        try{
            
            //DBへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:443/challenge_db", "root", "");
            
            //DBを更新
            db_st = db_con.prepareStatement("update profiles set name = '鈴木　実', tel = '080-5566-7788', age = 24, birthday = '2000-12-24' where profilesID = 1");

            int i = db_st.executeUpdate();
            
            System.out.println("更新しました");
            
            //DBを書き出し
            db_st = db_con.prepareStatement("select * from profiles");
            
            db_data = db_st.executeQuery();
            while(db_data.next()){
                
                System.out.println(db_data.getInt("profilesID") +" " + db_data.getString("name") + " " + db_data.getString("tel") + " " + 
                        db_data.getInt("age") + " " + db_data.getDate("birthday"));
                
            }
             
            db_st.close();
            db_con.close();
            db_data.close();
            
        }catch (SQLException e_sql){
            
            System.out.println("接続時にエラーが発生しました:" + e_sql.toString());
            
        }catch (Exception e){
            
            System.out.println("接続時にエラーが発生しました:" + e.toString());
            
        }finally{
            
            if(db_con != null){
            
            try
            {
                db_con.close();
            }catch (Exception e_con){
                
                System.out.println(e_con.getMessage());
                
            }
            
        }
            
        }
        
    }
    
}
