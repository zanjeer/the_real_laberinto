package lab;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Lienzo extends Canvas{
	private Laberinto lab;
	
	public Lienzo(){
		this.lab = new Laberinto();
		
		this.setBackground(Color.cyan);
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
	
	
	@Override
	public void paint(Graphics g){
		this.lab.paintComponent(g);
	}
	
	
	private void identificarCelda(java.awt.event.MouseEvent evt){
		for(int i=0;i< this.lab.getCasillas().length;i++){
			for(int j=0;j< this.lab.getCasillas().length;j++){
				if(this.lab.getCasillas()[i][j].dentro_area(evt.getX(),evt.getY())){
					this.lab.getCasillas()[i][j].setTipo('P');;
				}
			}
		}
	}
	
	@Override
	public void update(Graphics g){
		this.lab.update(g);
	}
	
}
