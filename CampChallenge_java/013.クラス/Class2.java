/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ami
 */

//親クラスの設定
public class Class2 {
    
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

//クラスを継承する
class kei extends Class2{
    
    //フィールドは親クラスからの継承のみ
    
    //メソッドの追加
    public void third(){
        
        this.number = 0;
        this.word = null;
        
        System.out.println(number);
        System.out.println(word);
    }
    
}

//実行クラスの作成
class act{
    
    public static void main(String[] args){
        
        Class2 cls = new Class2();
        
        kei K = new kei();
        
        cls.first(24,"abc");
        
        cls.second();
        
        System.out.println();
        
        //フィールドの値をクリアする
        K.third();
        
    }
    
}