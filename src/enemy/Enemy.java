package enemy;

import models.Laberinto;

public class Enemy {
private Laberinto lab;
private int enemy_i, enemy_j;

public Enemy(Laberinto l){
        this.lab = l;
}

  public void ini(int i,int j){
        enemy_j=j;
        enemy_i=i;
        lab.getCasillas()[i][j].setTipo('2');
    }

    public  void animar_enemy(char a){
        switch (a) {
        case 'S' : enemy_abajo();break;
        case 'W' : enemy_arriba();break;
        case 'D' : enemy_derecha();break;
        case 'A' : enemy_izquerda();break;	
        }
    }

    private void enemy_arriba(){
        if(enemy_j>0){
            if(lab.getCasillas()[enemy_i][enemy_j-1].getTipo() != 'P'){
                lab.getCasillas()[enemy_i][enemy_j].setTipo('V');
                enemy_j-=1;
                lab.getCasillas()[enemy_i][enemy_j].setTipo('5');
            }  
        }  
    }

    private void enemy_abajo(){
        if(enemy_j < lab.getCasillas().length-1){
            if(lab.getCasillas()[enemy_i][enemy_j+1].getTipo() != 'P'){
                lab.getCasillas()[enemy_i][enemy_j].setTipo('V');
                enemy_j+=1;
                lab.getCasillas()[enemy_i][enemy_j].setTipo('2');           
            }  
        }    
    }

    private void enemy_izquerda(){      
        if(enemy_i>0){
            if(lab.getCasillas()[enemy_i-1][enemy_j].getTipo() != 'P'){
                lab.getCasillas()[enemy_i][enemy_j].setTipo('V');
                enemy_i-=1;
                lab.getCasillas()[enemy_i][enemy_j].setTipo('1');               
            }
        } 
    }

    private void enemy_derecha(){   
        if(enemy_i<lab.getCasillas().length-1){
            if(lab.getCasillas()[enemy_i+1][enemy_j].getTipo() != 'P'){
                lab.getCasillas()[enemy_i][enemy_j].setTipo('V');
                enemy_i+=1;
                lab.getCasillas()[enemy_i][enemy_j].setTipo('3');             
            }
        }
    }

    public int getEnemy_i() {
            return enemy_i;
    }

    public void setEnemy_i(int enemy_i) {
            this.enemy_i = enemy_i;
    }

    public int getEnemy_j() {
            return enemy_j;
    }

    public void setEnemy_j(int enemy_j) {
            this.enemy_j = enemy_j;
    }
}
