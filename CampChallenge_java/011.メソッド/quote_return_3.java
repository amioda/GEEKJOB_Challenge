/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ami
 */
public class quote_return_3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //プロフィール情報
    
    String[] prof1 (){
        String[] prof1 = {"1","01/01","東京"};
        return prof1;
    }
    
    String[] prof2 (){
        String[] prof2 = {"2","02/04","大阪"};
        return prof2;
    }
    
    String[] prof3 (){
        String[] prof3 = {"3","05/12",null};
        return prof3;
    }
    
    int limit(int lim){
        
        return lim;
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        String[] return_prof1 = prof1();
        String[] return_prof2 = prof2();
        String[] return_prof3 = prof3();
        
        
        //limit値の設定
        int lim = 2;
        
        String id1 = "0";
        String id2 = "0";
        String id3 = "0";
        
        //IDを決定
        
        if(limit(lim) <= 1){
            
            id1 = "1";
            
        }else if(limit(lim) <= 2){
            
            id1 = "1";
            id2 = "2";
            
        }else if(limit(lim) <= 3){
            
           id1 = "1";
           id2 = "2";
           id3 = "3";
            
        }
        
        //配列表示
        if(id1 == return_prof1[0]){
            
            int i = 0;
            for(i=0;i<=2;i++){
                if(return_prof1[i] == null){
                    continue;
                }
                out.print(return_prof1[i]);
                out.print(" ");
            }
            
        }
        
        out.print("<br>");
        
        if(id2 == return_prof2[0]){
            
            int i = 0;
            for(i=0;i<=2;i++){
                if(return_prof2[i] == null){
                    continue;
                }
                out.print(return_prof2[i]);
                out.print(" ");
            }
            
        }
        
        out.print("<br>");
        
        if(id3 == return_prof3[0]){
            
            int i = 0;
            for(i=0;i<=2;i++){
                if(return_prof3[i] == null){
                    continue;
                }else{
                    out.print(return_prof3[i]);
                    out.print(" "); 
                }           
            }

                    
        }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
