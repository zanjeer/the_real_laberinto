package lab;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Celda extends JComponent implements Const{
	private int x,y;
	private boolean seleccionado;
	char tipo;
	BufferedImage player,camino,wall;
	
	public Celda(int x, int y,char tipo){
		this.x = x;
		this.y = y;	
		this.tipo = tipo;
		try {
			player = ImageIO.read(new File("src/imagenes/player.png"));
			camino = ImageIO.read(new File("src/imagenes/camino.png"));
			wall = ImageIO.read(new File("src/imagenes/muro.png"));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	@Override
	public void paintComponent(Graphics g){		
		
		update(g);
	}

	
	@Override
	public void update(Graphics g){
		switch (tipo) {
		case 'J' : g.drawImage(player, x, y, null); break;
		case 'P' : g.drawImage(wall, x, y, null); break;	
		case 'V' : g.drawImage(camino, x, y, null); break;
		}
	}
	
	
	public boolean dentro_area(int xp, int yp){
		Rectangle r= new Rectangle(x,y,longitud_casilla,
									longitud_casilla);
		return r.contains(new Point(xp,yp));
	}
	
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	
	
}
