/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ami
 */
public class Class1 {
    
    //フィールドの宣言
    public int number = 0;
    public String word = "";
    
    //①の条件を満たすメソッド
    public void first(int num, String wrd){
        
        //引数を設定
        this.number = num;
        this.word = wrd;
        
    }
    
    //②の条件を満たすメソッド
    public void second(){
        
        System.out.println(number);
        System.out.println(word); 
        
    }
    
    
}

//実行クラスの作成
class action {
    
    public static void main(String[] args){
        
        Class1 cls = new Class1();
        
        cls.first(24,"abc");
        
        cls.second();
        
    }
    
}
