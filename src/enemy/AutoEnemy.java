package enemy;

import java.util.ArrayList;
import java.util.TimerTask;
import lab.Lienzo;
import models.Const;

public class AutoEnemy extends TimerTask implements Const{
    private Lienzo lienzo;
    private ArrayList<Character> pasos;

    public AutoEnemy(  Lienzo lienzo){
        this.lienzo = lienzo;
        this.pasos = null;
    }
	
    @Override
    public void run() {  	
        pasos = new ArrayList<>();
        pasos = lienzo.iniciar_enemy(lienzo.getEnemigo().getEnemy_i(),
                                    lienzo.getEnemigo().getEnemy_j());
        for(Character c : pasos) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }            
            lienzo.getEnemigo().animar_enemy(c);
            lienzo.repaint();      
            /*if(System.currentTimeMillis() - scheduledExecutionTime() >= 950) {        
                return;
              }    */      
        }              
    }
}
