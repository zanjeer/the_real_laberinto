package models;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

public class Laberinto extends JComponent implements Const {
	
    private int ancho,largo;
    private Celda[][] casillas;
   
    public Laberinto(){
        casillas = new Celda[n][m];
        for(int i=0;i< n;i++){
            for(int j=0;j<m;j++){
                casillas[i][j] = new Celda(i+(i*Const.longitud_casilla),
                                            j+(j*Const.longitud_casilla),'V');
            }   
        }
           
        ancho = n*longitud_casilla;
        largo = m*longitud_casilla;
        setSize(ancho,largo);
    }
    
    public void nivel_ini(int k){
        for(int c = 0; c < n; c++){
            this.casillas[n-1][c].setTipo('P');
            this.casillas[0][c].setTipo('P');   
         }
        for(int l = 0; l < m; l++) {
            this.casillas[l][0].setTipo('P');
            this.casillas[l][m-1].setTipo('P');
         }
         
        int obstM = (n * m)/k;
        for (int i=0; i<obstM ; i++){
            int x = (int)(Math.random()*n);
            int y = (int)(Math.random()*m);
            if( x!=n-k && y != m-k )
                this.casillas[x][y].setTipo('P');
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                casillas[i][j].paintComponent(g);  
    }

    @Override
    public void update(Graphics g){
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                casillas[i][j].update(g);     
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public Celda[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Celda[][] casillas) {
        this.casillas = casillas;
    }

}
