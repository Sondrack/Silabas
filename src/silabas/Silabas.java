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
public class Silabas {
    public static void main(String[] args) {
        // sencillez
        String palabra = "transgresor";
        Silabas.separar(palabra);
    }
        
    public static boolean esPalabra(String palabra){ //Determina que lo ingresado si sea una palabra
        String []arregloPalabras = palabra.split(""); //.split separa los elementos de un objeto String
        boolean esPalabra = true;
        String abecedario = "abcdefghijklmnñopqrstuvwxyzáéíóú";
        for (int i = 0; i < arregloPalabras.length; i++) {
            //Si en la variable palabra, hay un elemento no perteneciente al abecedario, entonces no es una palabra.
            if (!abecedario.contains(arregloPalabras[i])) esPalabra=false;
        }
        return esPalabra==true;
    }
    
    public static boolean esConsonante(String c){//True si es consonante
        return !c.equals("a") && !c.equals("e") && !c.equals("i") && !c.equals("o") && !c.equals("u") &&
                !c.equals("á") && !c.equals("é") && !c.equals("í") && !c.equals("ó") && !c.equals("ú");
    }
    
    public static boolean esVocal(String v){ //True si es vocal
        return v.equals("a") || v.equals("e") || v.equals("i") || v.equals("o") || v.equals("u") ||
                v.equals("á") || v.equals("é") || v.equals("í") || v.equals("ó") || v.equals("ú");
    }
    
    public static boolean esGrupoConsonantico(String c1, String c2){
        //Si hay br,cr,dr,fr,gr,pr o tr.
        if ( (c1.equals("b")||c1.equals("c")||c1.equals("d")||c1.equals("f")||c1.equals("g")||c1.equals("p")||c1.equals("t"))
                &&c2.equals("r")) {
            return true;
        }
        //Si hay bl,cl,fl,gl,pl o tl.
        else if ( (c1.equals("b")||c1.equals("c")||c1.equals("f")||c1.equals("g")||c1.equals("p")||c1.equals("t"))
                &&c2.equals("l")) {
            return true;
        }
        else {
            return false;
        }
        
    }
    public static boolean esEspecial(String c1, String c2){
        if (c1.equals("l")&&c2.equals("l")) {
            return true;
        }
        else if (c1.equals("c")&&c2.equals("h")) {
            return true;
        }
        else if (c1.equals("r")&&c2.equals("r")) {
            return true;
        }
        else
            return false;
        
    }
    public static boolean esVocalFuerte(String v){
        return v.equals("a") || v.equals("e") || v.equals("o") ||
                v.equals("á") || v.equals("é") || v.equals("í") || v.equals("ó") || v.equals("ú");
    }
    /*
    public static boolean esVocalDebil(String v){
        return v.equals("i") || v.equals("u");
    }
    */
    public static void separar(String palabra){
        if (esPalabra(palabra)) {
            String []elemento = palabra.split("");
            int bandera = 0;
            for (int i = 1; i < elemento.length; i++) {
                 // de 0...7, entonces desde 41 hasta 6
                    if (esConsonante(elemento[i])&&i<(elemento.length-1)) {// es consonante
                        if (esGrupoConsonantico(elemento[i],elemento[i+1]) || esEspecial(elemento[i],elemento[i+1])) {
                            System.out.println(palabra.substring(bandera, i)); //separa
                            bandera = i;
                        }
                        if (i>1&&esConsonante(elemento[i-1])&&!esGrupoConsonantico(elemento[i-1],elemento[i])&&!esEspecial(elemento[i-1],elemento[i])&&!esConsonante(elemento[i+1])) {
                            System.out.println(palabra.substring(bandera, i)); //separa
                            bandera = i;
                        }
                        if (esVocal(elemento[i-1]) && esVocal(elemento[i+1])) {
                            System.out.println(palabra.substring(bandera, i)); //separa
                            bandera = i;
                        }
                        
                    }
                    else if (esVocal(elemento[i])) {
                        if (esVocal(elemento[i-1])) {
                            if (esVocalFuerte(elemento[i-1])&&esVocalFuerte(elemento[i])) {
                            System.out.println(palabra.substring(bandera, i)); //separa
                            bandera = i;
                            }
                        }
                        
                        
                    }
                    if (i==(elemento.length-1)) {
                           System.out.println(palabra.substring(bandera, elemento.length)); //imprime ultima silaba
                 }
                
            }
            
            
            
            
        }
        else{
            System.out.println("No es palabra");
        }
        
        
    }
}
