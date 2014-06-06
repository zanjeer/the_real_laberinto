package player;

import java.awt.event.KeyEvent;

import models.Laberinto;

public class Player {
    private Laberinto l;
    private int player_i,player_j;

    public Player(Laberinto lab){
        this.l = lab;
    }

    public void ini(int i,int j){
        this.player_j = j;
        this.player_i = i;
        l.getCasillas()[i][j].setTipo('J');
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
            if(l.getCasillas()[player_i][player_j-1].getTipo() != 'P'){
                l.getCasillas()[player_i][player_j].setTipo('V');
                player_j-=1;
                l.getCasillas()[player_i][player_j].setTipo('W');
                System.out.println("Se movio arriba: " + player_i + "," + player_j);
            }else System.out.println("pared pls");   
        }else System.out.println("tablero pls");  
    }

    private void mover_abajo(){
        System.out.println("Player: " + player_i + "," + player_j);
        if(player_j < l.getCasillas().length-1){
            if(l.getCasillas()[player_i][player_j+1].getTipo() != 'P'){
                l.getCasillas()[player_i][player_j].setTipo('V');
                player_j+=1;
                l.getCasillas()[player_i][player_j].setTipo('J');
                System.out.println("Se movio abajo: " + player_i + "," + player_j);
            }else System.out.println("pared pls");  
        }else  System.out.println("tablero pls");     
    }

    private void mover_izquerda(){
        System.out.println("Player: " + player_i + "," + player_j);
        if(player_i>0){
            if(l.getCasillas()[player_i-1][player_j].getTipo() != 'P'){
                l.getCasillas()[player_i][player_j].setTipo('V');
                player_i-=1;
                l.getCasillas()[player_i][player_j].setTipo('A');
                System.out.println("Se movio izq: " + player_i + "," + player_j);
            }else System.out.println("pared pls");
        }else System.out.println("tablero pls");  
    }

    private void mover_derecha(){
        System.out.println("Player: " + player_i + "," + player_j);
        if(player_i<l.getCasillas().length-1){
            if(l.getCasillas()[player_i+1][player_j].getTipo() != 'P'){
                l.getCasillas()[player_i][player_j].setTipo('V');
                player_i+=1;
                l.getCasillas()[player_i][player_j].setTipo('D');
                System.out.println("Se movio der: " + player_i + "," + player_j);
            }else System.out.println("pared pls");
        }else System.out.println("tablero pls");
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
