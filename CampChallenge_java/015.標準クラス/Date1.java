/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ami
 */

import java.util.Date;

public class Date1 {
    
    public static void  main(String[] args){
        
        //2016/01/01 00:00:00の日付データを入力
        Date d = new Date((46*365*24*60*60*1000L) + (11*24*60*60*1000L) - (9*60*60*1000L));
        
        System.out.println(d);
        
        System.out.println(d.getTime());
        
    }
    
}
