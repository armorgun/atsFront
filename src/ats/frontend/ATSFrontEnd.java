/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ats.frontend;

import javax.swing.UIManager;



/**
 *
 * @author armor
 */
public class ATSFrontEnd {
    
     static Login log = new Login();

        public ATSFrontEnd() {
            
            
        
        }
        
       
        
        
    
    public static void main(String[] args) {
        // TODO code application logic here
            
        
            log.setVisible(true);
            
        
        
    }
    
    public static void visi()
    {
        
        
            log.setVisible(true);
            log.m.setVisible(false);
            if(log.getRemember())
            log.resetTextFields();
            
        
    }

    
}
