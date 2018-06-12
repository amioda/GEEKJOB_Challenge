
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ami
 */
public class File2 {
    
    public static void main(String[] args) throws IOException{
        
        //ファイルオープン
        File prof = new File("profile.txt");
        
        //ファイルに書き込み
        FileWriter fw = new FileWriter(prof);
        fw.write("私の名前は小田亜味です。好きな魚はイサキです。");
        
        //ファイルクローズ
        fw.close();
        
        //ファイルの読み込み
        FileReader fr = new FileReader(prof);
        BufferedReader br = new BufferedReader(fr);
        
        //ファイルの表示
        System.out.println(br.readLine());
        
        br.close();
        
    }
    
}
