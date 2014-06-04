package lab;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import AutoPlayer.Busqueda;
import AutoPlayer.Estado;
import models.Celda;
import models.Laberinto;

public class Lienzo extends Canvas{
    private Laberinto lab;

    public Lienzo(){
        this.lab = new Laberinto();
        lab.player_ini(2, 2);
        lab.nivel_ini(3);
        
        this.setBackground(Color.gray);
        this.setSize(this.lab.getAncho(),lab.getLargo());

        addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                identificarCelda(evt);
                repaint();
            }
        });

        addKeyListener(new java.awt.event.KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                lab.verTecla(e);
                repaint();
            }
        });
    }

    private void identificarCelda(java.awt.event.MouseEvent evt){
        for(int i=0;i< lab.getCasillas().length;i++){
            for(int j=0;j< lab.getCasillas().length;j++){
                if(lab.getCasillas()[i][j].dentro_area(evt.getX(),evt.getY())){
                    if( lab.getCasillas()[i][j].getTipo() != 'P'){
                        lab.getCasillas()[i][j].setTipo('P');break;
                    }else {
                        lab.getCasillas()[i][j].setTipo('V');break;
                    }
                }
            }
        }
    }
	
    public ArrayList<Character> iniciar_busqueda(int x, int y){
    	Estado inicio, meta;
        Celda data_inicial;
    	Celda data_fin;
        Busqueda b;
    	data_inicial = new Celda(x,y,' ');
        data_fin = new Celda(17,17,' ');
        inicio = new Estado(data_inicial, null, ' ');
        meta = new Estado(data_fin, null, ' ');    
        b = new Busqueda(inicio, meta,this);
    return b.buscar();
    }
    	
    @Override
    public void paint(Graphics g){
        this.lab.paintComponent(g);
    }

    @Override
    public void update(Graphics g){
        this.lab.update(g);
    }

    public Laberinto getLab() {
        return lab;
    }

    public void setLab(Laberinto lab) {
        this.lab = lab;
    }

}
