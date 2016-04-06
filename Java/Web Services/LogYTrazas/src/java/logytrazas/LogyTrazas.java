/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logytrazas;

import com.co.myticket.log.RegistrarLog;

/**
 *
 * @author joanrincon
 */
public class LogyTrazas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RegistrarLog log = new RegistrarLog();
        log.registarLog("usuario", "JAVA", 0, "OK", log.getClass().getName());
    }
    
    
    
}
