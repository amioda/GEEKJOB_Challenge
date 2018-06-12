
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ami
 */
public class Date2 {
    
    public static void  main(String[] args){
        
        //1988/05/21 1:23:45の日付データを入力
        Calendar c = Calendar.getInstance(); 
        c.set(1988, 5, 21, 1, 23, 45);
        
        //データを表示
        System.out.print(c.get(Calendar.YEAR) + "年" + c.get(Calendar.MONTH) + "月" + c.get(Calendar.DAY_OF_MONTH) + "日" 
                + c.get(Calendar.HOUR_OF_DAY) + "時" + c.get(Calendar.MINUTE) + "分" + c.get(Calendar.SECOND) + "秒");
    }
    
}
