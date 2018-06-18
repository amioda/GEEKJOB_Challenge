
import java.sql.*;
import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ami
 */
public class JDBC6 {
    
    
    public static void main(String[] args){
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            
            //DBへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:443/challenge_db", "root", "");
            
            //DBに書き込み
            db_st = db_con.prepareStatement("delete from profiles where name = '鈴木　実'");
            
            //SQL文を実行する
            int i = db_st.executeUpdate();
            
            System.out.println("削除完了");
             
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
