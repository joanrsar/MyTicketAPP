/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.myticket.utilidades;

import java.util.Random;

/**
 *
 * @author joanrincon
 */
public class Utilidades {
    
    
    public static int generarRamdon(){
        int codigo = 0;
        try{
             Random rnd = new Random();
             codigo = rnd.nextInt();
             if( codigo < 0 ){
                 generarRamdon();
             }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return codigo;
    }
}
