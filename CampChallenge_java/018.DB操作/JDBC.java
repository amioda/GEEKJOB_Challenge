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

public class JDBC {
    
    public static void main(String[] args){
    
    Connection db_con = null;
    
    try
    {
        //例外の発見が予見される処理
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        //BDへの接続を取得
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:443/challenge_db", "root", "");

        //SQL文を実行
        db_con.close();
        
    } catch (SQLException e_sql){
    
    //例外が発生した場合の処理
    System.out.println("接続時にエラーが発生しました:" + e_sql.toString());
    
    }catch (Exception e){
        
    System.out.println("接続時にエラーが発生しました:" + e.toString());
    
    }finally{
        //例外の有無関係なく、実施したい処理
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

