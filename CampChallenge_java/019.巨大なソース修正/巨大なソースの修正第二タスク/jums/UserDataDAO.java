package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    public void update(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET name=?,birthday=?,tell=?,type=?,comment=?,newDate=? WHERE UserID = ?");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7,ud.getUserID());
            st.executeUpdate();  
            System.out.println("update completed");
            }catch(SQLException e){
                System.out.println(e.getMessage());
                throw new SQLException(e);
            }finally{
            if(con != null){
                con.close();
            }
        }
}
    
     public void delete(int id) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "DELETE FROM user_t WHERE userID = ?";
            st =  con.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            //
            String sql = "SELECT * FROM user_t";
            boolean flag = false;
            int phChecker = 1;
            if (!ud.getName().equals("")) {
                phChecker *= 2;
                sql += " WHERE name like ?";
               flag = true;
            }else{
            }
            if (ud.getBirthday()!=null) {
                phChecker *= 3;
                if(!flag){
                    sql += " WHERE birthday like ?";
                    flag = true;
                }else{
                    sql += " OR birthday like ?";
                }
            }else{
            }
            if (ud.getType()!=0) {
                phChecker *= 5;
                if(!flag){
                    sql += " WHERE type like ?";
                }else{
                    sql += " OR type like ?";
                }
            }
            if(phChecker == 30){
                sql = "SELECT * FROM user_t;";
                st =  con.prepareStatement(sql);
            }else{
                st =  con.prepareStatement(sql);
                ud.setPhchecker(phChecker);
                setStatement(ud,st);
            }
            
            ResultSet rs = st.executeQuery();
            
            ArrayList<UserDataDTO> resultList = new ArrayList<UserDataDTO>();
            
            while(rs.next()){
            resultList.add(getResult(rs));
            }
            
            System.out.println("search completed");

            return resultList;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            ResultSet rs = st.executeQuery();
            rs.next();
            return getResult(rs);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    public UserDataDTO getResult(ResultSet rs) throws SQLException{
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            return resultUd;
    }
    
//    適切なプレースホルダを設置しステイトメントをセットする
    public void setStatement(UserDataDTO udd, PreparedStatement st) throws SQLException{
	int sum = 0;	
	int addNum = 1;		
	for(int i = 2;i < 6;){
		if(udd.getPhChecker() % i == 0){
			sum += 1;					 
			switch(i){
				case 2:
					st.setString(sum, "%"+udd.getName()+"%");
					break;
				case 3:
					st.setString(sum, "%"+ new SimpleDateFormat("yyyy").format(udd.getBirthday())+"%");
					break;
				case 5:
					st.setInt(sum, udd.getType());
					break;
			}
		}
		i += addNum;
		addNum *= 2;
	}
}
    
}