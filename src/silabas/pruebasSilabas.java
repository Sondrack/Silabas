/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silabas;

/**
 *
 * @author esteb
 */
import java.lang.ArrayIndexOutOfBoundsException;
public class pruebasSilabas {
    public static void main(String args[]){
        String palabra = "orbrero";
        String []array = palabra.split("");
        
        System.out.println(palabra.length());
        System.out.println(palabra.substring(0, 1));
                System.out.println(palabra.substring(2, 5));
                    System.out.println(palabra.substring(5, palabra.length()));
                
        
       
        
    }
}
