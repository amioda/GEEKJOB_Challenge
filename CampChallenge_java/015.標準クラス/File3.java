
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ami
 */
public class File3 {
    
    public static void main(String[] args) throws IOException{
        
        //開始の日付の取得
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date1 = new Date();
        
        //開始のログを記述
        File log = new File("log.txt");
        FileWriter fw = new FileWriter(log);
        
        fw.write("処理の内容：　さいころを２回振って出目が大きいほうを決定する");
        fw.write("\r\n");
        fw.write("処理を開始します/ " + sdf.format(date1) + " 開始" );
        fw.write("\r\n");
        
        //さいころを二回ふる
        int num1;
        int num2;
        
        num1 = (int)(Math.random()*6) + 1;
        num2 = (int)(Math.random()*6) + 1;
        
        
        System.out.println("最初の目：" + (num1));
        System.out.println("次の目　：" + (num2));
        System.out.println("");
        if(Math.max(num1, num2) == num1){
            
            System.out.println("最初の目が大きい");
            
        }else{
            
            System.out.println("次の目が大きい");
            
        }
        
        //終了の日付の取得
        Date date2 = new Date();
        
        //終了ログを記述
        fw.write("処理を終了します/ " + sdf.format(date2) + " 終了" );
        fw.write("\r\n");
        
        fw.close();
        
    }
    
}