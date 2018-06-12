
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ami
 */
public class Date4 {
    
    public static void  main(String[] args){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //2015/01/01 00:00:00の日付データを取得
        Date d1 = new Date((45*365*24*60*60*1000L) + (11*24*60*60*1000L) - (9*60*60*1000L));
        long df = d1.getTime();
 
        //2015/12/31 23:59:59の日付データを取得
        Date d2 = new Date((45*365*24*60*60*1000L) + (24*365*60*60*1000L) + (10*24*60*60*1000L) + (14*60*60*1000L) + (59*60*1000L) + (59*1000L));
        long ds = d2.getTime();
        
        //日付の差(ミリ秒)を表示
        long Dif = (ds - df);
        
        System.out.println(Dif);
        
    }
    
}
