/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Transicion {
    Estado estado;
    Transicion enlace;
    Object valor;
    
    Transicion(String v){
        estado=null;
        enlace=null;
        valor=v;
    }
       
}
