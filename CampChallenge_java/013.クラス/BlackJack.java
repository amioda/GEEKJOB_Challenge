
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ami
 */

//実行クラス
public class BlackJack {
    
    public static void main(String[] args){
        
        Dealer dl = new Dealer();
        User uz = new User();

        ArrayList<Integer> return_mC = dl.myCards;
        ArrayList<Integer> return_mC2 = uz.yourCards;
        
        dl.setCard(return_mC);
        uz.setCard(return_mC2);
        
        //親の最初の手札を表示
        System.out.println("親の最初の手札: " + dl.myCards);
        System.out.println("合計値: " + dl.open());
        System.out.println("");
        
        //子の最初の手札を表示
        System.out.println("あなたの最初の手札: " + uz.yourCards);
        System.out.println("合計値: " + uz.open());
        System.out.println("");
        
        //親の次の手札を表示
        int i;
        for(i=0; i<=50; i++){
             dl.checkSum();
             if(dl.checkSum() == true){
                 dl.hit();
                 dl.setCard(return_mC);

             System.out.println("親の次の手札: " + dl.myCards);
             System.out.println("合計値: " + dl.open());
             System.out.println("");
             
             
        //子の次の手札を表示
        int j;
        for(j=0; j<=50; j++){
             uz.checkSum();
             if(uz.checkSum() == true){
                 dl.hit();
                 uz.setCard(return_mC2);
                
            if(uz.open() >=21){
                uz.yourCards.remove((uz.yourCards.size() - 1));
                break;
             }

             System.out.println("あなたの次の手札: " + uz.yourCards);
             System.out.println("合計値: " + uz.open());
             System.out.println("");
             
        }
        }
            if(dl.open() >=17){
                    break;
             }
        }
        }
        
        //最終結果
        System.out.println("");
        System.out.println("親のカードの合計：　" + dl.open());
        System.out.println("あなたのカードの合計：　" + uz.open());
        System.out.println("");
        
        if(uz.open() > 21){
            System.out.println("あなたの負けです！");
        }else if(dl.open() > 21){
            System.out.println("あなたの勝ちです！");
        }else if(dl.open() > uz.open()){
            System.out.println("あなたの負けです！");
        }else if (dl.open() == uz.open()){
            System.out.println("ひきわけです！");
        }else{
            System.out.println("あなたの勝ちです！");
        }
    }
}

//Humanクラス　DealerとUserに共通する情報を定義
abstract class Human {
    
    abstract protected int open(); 
    
    abstract protected void setCard(ArrayList<Integer> array);
    
    abstract protected boolean checkSum();
    
    //親の手札
    protected ArrayList<Integer> myCards = new ArrayList<Integer>();
    
    //子の手札
    protected ArrayList<Integer> yourCards = new ArrayList<Integer>();
    
}

//Dealerクラス　KPに関する情報を定義
class Dealer extends Human{
    
    protected ArrayList<Integer> cards = new ArrayList<Integer>();
    
    //山札にすべてのカードをセットするコンストラクタ
    public Dealer(){
        int i;
        int j;
        for(i=1; i<=13; i++){
            
            if(i >= 11){
                
                for(j=0;j<=3;j++){
                    cards.add(10);
                }
                
            }else{
    
            cards.add(i);
            cards.add(i);
            cards.add(i);
            cards.add(i); 
            
            }
            
         }
    }

    //山札から２枚カードを引いて戻り値にする
    protected ArrayList<Integer> deal () {
        
        ArrayList<Integer> dl = new ArrayList<Integer>();
        
        Collections.shuffle(cards);
        
        int a = cards.get(0);
        int b = cards.get(1);
        
        dl.add(a);
        dl.add(b);
        
        return dl;
    }
    
    //山札から１枚カードを引いて戻り値にする
    protected ArrayList<Integer> hit(){
        ArrayList<Integer> ht = new ArrayList<Integer>();
        
        ht.clear();
        
        if(myCards.size() > yourCards.size()){
            int i = yourCards.size();
        
            int c = cards.get(4 +(i * 2));
        
            ht.add(c); 
        }else{
            int i = myCards.size();
        
            int c = cards.get(5 + (i * 2));
        
            ht.add(c); 
        }
        
        return ht;
    }       

    //カードの合計値を返却
    @Override
    protected int open() {
        int i;
        int sum = 0;
        for(i=0; i<myCards.size();i++){
            
            sum +=myCards.get(i);
          
        }
        
        return sum;
    }

    //カード情報をmyCardsに追加
    @Override
    protected void setCard(ArrayList<Integer> array) {
        
        if(myCards.size() == 0){
            array.addAll(deal());
            
            myCards.clear();
            
            myCards.add(cards.get(0));
            myCards.add(cards.get(1));
            
        }else{
            if(checkSum() == true){
            
            myCards.addAll(hit());
            
        }else{}
        }
        
    }

    //まだカードが必要かどうか判定
    @Override
    protected boolean checkSum() {
        int i;
        int sum = 0;
        for(i=0; i<myCards.size();i++){
            
            sum +=myCards.get(i);
            
        }
        
        if(sum <= 17){
            
            return true;
        }else{
            return false;
        }
    }
}

//Userクラス　PLに関する情報を定義
class User extends Human{
    
    Dealer dl = new Dealer();

    @Override
    protected int open() {
        int i;
        int sum = 0;
        for(i=0; i<yourCards.size();i++){
            
            sum +=yourCards.get(i);
          
        }
        
        return sum;
    }

    @Override
    protected void setCard(ArrayList<Integer> array) {

        if(yourCards.size() == 0){
            array.addAll(dl.deal());
            
            yourCards.clear();
            
            yourCards.add(dl.cards.get(2));
            yourCards.add(dl.cards.get(3));
            
        }else{
            if(checkSum() == true){
            
            yourCards.addAll(dl.hit());
            
        }else{}
        }
        
    }

    @Override
    protected boolean checkSum() {
        int i;
        int sum = 0;
        for(i=0; i<yourCards.size();i++){
            
            sum +=yourCards.get(i);
            
        }
        
        if(sum <= 21){
            
            return true;
        }else{
            return false;
        }
    }
    
}