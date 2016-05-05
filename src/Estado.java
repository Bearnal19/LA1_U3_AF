/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author
 */
public class Estado{
    Estado estados;
    Transicion transiciones;
    Object nombreE;
    
    Estado (String valor){
        nombreE=valor;
        transiciones=null;
        estados=null;
    }
    
    public boolean compararCon(String o){
        return nombreE.equals(o);
    }
    
}
