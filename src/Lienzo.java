
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.QuadCurve2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amaral
 */
public class Lienzo extends Canvas{
    Image flecha,triarriba,triabajo;
    
    boolean tipoEstado,tipo;
    
    Graphics2D g2;
    //Graphics g;
    
    String estados[],alfabeto[],aceptacion[],matriz[][];
    int posx,posy;
    EstadoProp arrEst[];
    int ciclo;
   
    public Lienzo(String[] alfa,String[] esta,String acep[],String mat[][],boolean tipo){
        tipoEstado=false;
        flecha =this.getToolkit().createImage(getClass().getResource("flechita2.png"));
        triarriba=this.getToolkit().createImage(getClass().getResource("tri_up.png"));
        triabajo=this.getToolkit().createImage(getClass().getResource("tri_down.png"));
        alfabeto=alfa;
        estados=esta;
        aceptacion=acep;
        matriz=mat;
        posx=0;
        posy=0;
        this.tipo=tipo;
        ciclo=estados.length;
        arrEst=new EstadoProp[ciclo];
        estados();
 
    }

    public void estados(){
        int cuenta=30;
        int x=20,y=30;
        boolean acept=true;
        for(int i=0;i<ciclo;i++){
           for(int j=0;j<aceptacion.length;j++){
              if(estados[i].equals(aceptacion[j])){
                   acept=true;
                   break;
              }
              else {
                   acept=false;
              }
           }
           if(i!=0)  {    
              if(i%8==0){
                   cuenta=cuenta+80;
                   x=20;
                   y=cuenta;
                }
           }
           arrEst[i]=new EstadoProp(x, y, acept, estados[i]);
              x=x+120;
              y=cuenta;
        }
    }
    
    
    public void paint(Graphics g){
         g2=(Graphics2D)g; 
         g.drawImage(flecha, 0, 45, this);        
         QuadCurve2D q = new QuadCurve2D.Float();
        if(tipo){     
            for(int i=0;i<estados.length;i++){     
                if(arrEst[i].tipo==true){
                g.drawOval(arrEst[i].x, arrEst[i].y, 50,50 );
                g.drawOval(arrEst[i].x+5, arrEst[i].y+5, 40,40 );
                g.drawString(arrEst[i].letra, arrEst[i].x+20, arrEst[i].y+28);
            }
           else{
                g.drawOval(arrEst[i].x, arrEst[i].y, 50,50 );
                g.drawString(arrEst[i].letra, arrEst[i].x+20, arrEst[i].y+28);
           }
                
          lineas(g); 
          
       }
       
     }
     
      if(tipo==false){//*************************************************************AFND**************************       
       for(int i=0;i<estados.length;i++){     
           if(arrEst[i].tipo==true){
               
                g.drawOval(arrEst[i].x, arrEst[i].y, 50,50 );
                g.drawOval(arrEst[i].x+5, arrEst[i].y+5, 40,40 );
                g.drawString(arrEst[i].letra, arrEst[i].x+20, arrEst[i].y+28);
           }
           else{
                g.drawOval(arrEst[i].x, arrEst[i].y, 50,50 );
                g.drawString(arrEst[i].letra, arrEst[i].x+20, arrEst[i].y+28);
           }
          
       }
        lineas(g);
     }
    }
    
    
    public void lineas(Graphics g){
       String aux[];
       
      if(!tipo){
          for(int i=0;i<estados.length;i++){
            for(int j=0;j<alfabeto.length;j++){  
             if(!(matriz[i][j].equals("")))
               {
                aux=matriz[i][j].split(",");
                for(int d=0;d<aux.length;d++) {      
                for(int k=0;k<estados.length;k++)  {  
                  
                   if(aux[d].equals(arrEst[k].letra)){
                       pintarLineasnodet( g,arrEst[i].x,arrEst[i].y,arrEst[k].x,arrEst[k].y,alfabeto[j]);
                   }
                }
            }}}
        }

    }
      else{

          for(int i=0;i<estados.length;i++){
           for(int j=0;j<alfabeto.length;j++){
             for(int k=0;k<estados.length;k++)  {    
                  if(matriz[i][j].equals(arrEst[k].letra)){
                    pintarLineas( g,arrEst[i].x,arrEst[i].y,arrEst[k].x,arrEst[k].y,alfabeto[j]);
                  }
              }    
            }
          }

         }
    }
    
    
    public void pintarLineas(Graphics g,int origenx,int origeny,int finx,int finy,String l ){
                   g.drawString(l,  ((origenx+finx+70)/2),origeny);
                   QuadCurve2D q = new QuadCurve2D.Float();
                   q.setCurve(origenx+49, origeny+15, (origenx+finx+70)/2,origeny-50 , finx+15, finy);
                   g2.draw(q);
                  
                   g.drawImage(triabajo, finx+12, finy, this);
                 
    }
    
    public void pintarLineasnodet(Graphics g,int origenx,int origeny,int finx,int finy,String l ){
                    g.drawString(l,  ((origenx+finx+70)/2),origeny);
                    QuadCurve2D q = new QuadCurve2D.Float();
                   
                    q.setCurve(origenx+49, origeny+15, (origenx+finx+70)/2,origeny-50 , finx+15, finy);
                    g2.draw(q);
                    
                    g.drawImage(triabajo, finx+12, finy, this);
                    
    }
    
}//class
