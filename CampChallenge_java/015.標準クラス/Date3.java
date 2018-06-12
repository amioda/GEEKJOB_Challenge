
import java.util.Date;
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
public class Date3 {
    
    public static void  main(String[] args){
        
        //2016/11/04 10:00:00の日付データを入力
        Date d = new Date((46*365*24*60*60*1000L) + (20*365*60*60*1000L) + (15*24*60*60*1000L) - (3*60*60*1000L));
        
        //タイムスタンプの表示
        System.out.println(d.getTime());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        //日付データを表示
        System.out.print(sdf.format(d));

    }
    
}
