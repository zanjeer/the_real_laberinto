package models;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;

public class Laberinto extends JComponent implements Const {
	
    private int ancho,largo;
    private Celda[][] casillas;
    private int player_i,player_j;

    public Laberinto(){
        casillas = new Celda[n][m];
        for(int i=0;i< n;i++){
            for(int j=0;j<m;j++){
                casillas[i][j] = new Celda(i+(i*Const.longitud_casilla),
                                            j+(j*Const.longitud_casilla),'V');
        }

        ancho = n*longitud_casilla;
        largo = m*longitud_casilla;
        setSize(ancho,largo);	    
    }
}
    
    public void player_ini(int i,int j){
    	this.setPlayer_j(j);
    	this.setPlayer_i(i);
    	this.casillas[i][j].setTipo('J');
    }
    
    public void nivel_ini(int k){
    	 for (int c = 0; c < n; c++){
    		 this.casillas[n-1][c].setTipo('P');
             this.casillas[0][c].setTipo('P');   
         }
         for (int l = 0; l < m; l++) {
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

    public void verTecla(KeyEvent evento){
        if( evento.getKeyCode() == 38 )mover_arriba();
        if( evento.getKeyCode() == 40 )mover_abajo();
        if( evento.getKeyCode() == 37 )mover_izquerda();
        if( evento.getKeyCode() == 39 )mover_derecha();
    }

    public  void animar_player(char a){
        switch (a) {
        case 'S' : mover_abajo();break;
        case 'W' : mover_arriba();break;
        case 'D' : mover_derecha();break;
        case 'A' : mover_izquerda();break;	
        }
    }

    private void mover_arriba(){
        System.out.println("Player: " + player_i + "," + player_j);
        if(player_j>0){
            if(casillas[player_i][player_j-1].getTipo() != 'P'){
                casillas[player_i][player_j].setTipo('V');
                player_j-=1;
                casillas[player_i][player_j].setTipo('W');
                System.out.println("Se movio arriba: " + player_i + "," + player_j);
            }else System.out.println("pared pls");   
        }else System.out.println("tablero pls");  
    }

    private void mover_abajo(){
        System.out.println("Player: " + player_i + "," + player_j);
        if(player_j < casillas.length-1){
            if(casillas[player_i][player_j+1].getTipo() != 'P'){
                casillas[player_i][player_j].setTipo('V');
                player_j+=1;
                casillas[player_i][player_j].setTipo('J');
                System.out.println("Se movio abajo: " + player_i + "," + player_j);
            }else System.out.println("pared pls");  
        }else  System.out.println("tablero pls");     
    }

    private void mover_izquerda(){
        System.out.println("Player: " + player_i + "," + player_j);
        if(player_i>0){
            if(casillas[player_i-1][player_j].getTipo() != 'P'){
                casillas[player_i][player_j].setTipo('V');
                player_i-=1;
                casillas[player_i][player_j].setTipo('A');
                System.out.println("Se movio izq: " + player_i + "," + player_j);
            }else System.out.println("pared pls");
        }else System.out.println("tablero pls");  
    }

    private void mover_derecha(){
        System.out.println("Player: " + player_i + "," + player_j);
        if(player_i<casillas.length-1){
            if(casillas[player_i+1][player_j].getTipo() != 'P'){
                casillas[player_i][player_j].setTipo('V');
                player_i+=1;
                casillas[player_i][player_j].setTipo('D');
                System.out.println("Se movio der: " + player_i + "," + player_j);
            }else System.out.println("pared pls");
        }else System.out.println("tablero pls");
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

    public int getPlayer_i() {
        return player_i;
    }

    public void setPlayer_i(int player_i) {
        this.player_i = player_i;
    }

    public int getPlayer_j() {
        return player_j;
    }

    public void setPlayer_j(int player_j) {
        this.player_j = player_j;
    }
	
}
