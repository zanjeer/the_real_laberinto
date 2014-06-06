package models;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Celda extends JComponent implements Const{
    private int x,y;
    private Character tipo;
    private BufferedImage player,player_up,player_left,player_right,camino,wall,
    						enemy,enemy_up,enemy_left,enemy_right;

    public Celda(int x, int y,Character tipo){
        this.x = x;
        this.y = y;
        this.tipo = tipo;

        try {
            player = ImageIO.read(new File("src/imagenes/player.png"));
            player_up = ImageIO.read(new File("src/imagenes/player_up.png"));
            player_left = ImageIO.read(new File("src/imagenes/player_left.png"));
            player_right = ImageIO.read(new File("src/imagenes/player_right.png"));
            camino = ImageIO.read(new File("src/imagenes/camino.png"));
            wall = ImageIO.read(new File("src/imagenes/muro.png"));
            enemy = ImageIO.read(new File("src/imagenes/enemy.png"));
            enemy_up = ImageIO.read(new File("src/imagenes/enemy_up.png"));
            enemy_left = ImageIO.read(new File("src/imagenes/enemy_left.png"));
            enemy_right = ImageIO.read(new File("src/imagenes/enemy_right.png"));
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
        case 'W' : g.drawImage(player_up, x, y, null); break;
        case 'A' : g.drawImage(player_left, x, y, null); break;
        case 'D' : g.drawImage(player_right, x, y, null); break;
        case 'P' : g.drawImage(wall, x, y, null); break;	
        case 'V' : g.drawImage(camino, x, y, null); break;
        case '2' : g.drawImage(enemy, x, y, null); break;
        case '5' : g.drawImage(enemy_up, x, y, null); break;
        case '1' : g.drawImage(enemy_left, x, y, null); break;
        case '3' : g.drawImage(enemy_right, x, y, null); break;
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


    public char getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Celda)) return false;
    return ((Celda)obj).getX() == this.getX() &&
            ((Celda)obj).getY() == this.getY();
    }

}
