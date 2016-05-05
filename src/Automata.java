/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Automata {
    Estado ini,fin,temp;
    
    
    Automata(){
        ini=fin=temp=null;
        //temparista=null;
    }
    
    public boolean insertarNodo(String valor){
        temp=new Estado(valor);
        if(temp==null){
            return false;
        }

        if(ini==null && fin==null){
            ini=temp;
            fin=temp;
            return true;
        }
            fin.estados=temp;
            fin=temp;
            return true;
    }
    
    public Estado buscar(String valor){
        temp=ini;
        if(temp.compararCon(valor)){
            return temp;
        }
        temp=temp.estados;
        while(temp!=null){
            if(temp.compararCon(valor)){
                return temp;
            }
            temp=temp.estados;
        }
        return null;
    }
    /*public Transicion buscarTransicion(String valor,Estado estado){
        
    }*/
    public boolean insertarArista(String nodoA,String nodoB,String v){
        Transicion temparista,ia,fa;
        Estado primero,segundo;
        
        if(ini==null && fin==null){
        return false;
        }
        
        primero=buscar(nodoA);
        segundo=buscar(nodoB);
        
        if(primero==null || segundo==null){
            return false;
        }
        
        if(primero.transiciones==null){
            temparista=new Transicion(v);
            temparista.estado=segundo;
            primero.transiciones=temparista;
            temparista.enlace=null;
            return true;
        }
        ia=primero.transiciones;
        fa=ia.enlace;
        while(fa!=null){
            ia=fa;
            fa=ia.enlace;
        }
        temparista=new Transicion(v);
        temparista.estado=segundo;
        ia.enlace=temparista;
        //i=i.enlace;
        //i.enlace=null;       
        return true;
    }
    
    
    
    
    public String[][] tablaAdyacencias(){
        String tabla[][];
        Estado t=ini;
        Transicion a;
        int cont=0,contant,contact=0;
        
        if(ini==null && fin==null){
            return null;
        }
        while(t!=null){
            cont++;
            if(t.transiciones!=null){
                a=t.transiciones;
                contant=0;
                while(a!=null){
                    contant++;
                    a=a.enlace;
                }
                if(contant>contact){
                    contact=contant;
                }
            }
            t=t.estados;
        }
        t=ini;
        tabla=new String[cont][contact+1];
        
        for(int i=0;i<tabla.length;i++){
                a=t.transiciones;
            for(int j=0;j<tabla[0].length;j++){
                if(j<1 && t!=null){
                    tabla[i][j]=t.estados.toString();
                }
                else if(a!=null){
                         tabla[i][j]=a.estado.estados.toString();
                         a=a.enlace;
                     }
                    else tabla[i][j]="";
            }
            t=t.estados;
        }  
        return tabla;
    }
}
