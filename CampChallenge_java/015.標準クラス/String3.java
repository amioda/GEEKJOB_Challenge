/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ami
 */
public class String3 {
    
    public static void main(String[] args){
        
        //文字列を宣言
        String str = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        
        //「I」を「い」に，「U」を「う」に置換
        String str1 = str.replace("I", "い");
        System.out.println(str1.replace("U", "う"));
        
    }
    
}
