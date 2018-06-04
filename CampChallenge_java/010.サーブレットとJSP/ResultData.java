/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

/**
 *
 * @author Ami
 */

//java.io.Serializableインターフェイスを実装する
import java.io.Serializable;
import java.util.Date;

public class ResultData implements Serializable{
    
    private Date d;
    private String luck;
    
    public ResultData(){}
        
    public Date getD(){
        return this.d;
    }
    
    public void setD(Date d){
        this.d = d;
    }
    
    public String getLuck(){
        return this.luck;
    }
    
    public void setLuck(String luck){
        this.luck = luck;
    }
    
    
}
