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
import java.text.SimpleDateFormat;

public class JDBC3 {
    
    public static void main(String[] args){
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            
            //DBへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:443/challenge_db", "root", "");
            
            //DBの読み込み
            db_st = db_con.prepareStatement("select * from profiles");
            
            //データを書き出す
            db_data = db_st.executeQuery();
            while(db_data.next()){
                
                System.out.println(db_data.getInt("profilesID") +" " + db_data.getString("name") + " " + db_data.getString("tel") + " " + 
                        db_data.getInt("age") + " " + db_data.getDate("birthday"));
                
            }
             
            db_st.close();
            db_con.close();
            
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
