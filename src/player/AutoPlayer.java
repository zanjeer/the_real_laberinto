package player;

import java.util.ArrayList;
import java.util.TimerTask;
import lab.Lienzo;
import models.Const;

public class AutoPlayer extends TimerTask implements Const {
    private Lienzo lienzo;
    private ArrayList<Character> pasos;

    public AutoPlayer(  Lienzo lienzo){
        this.lienzo = lienzo;
        this.pasos = null;
    }
	
    @Override
    public void run() {
        pasos = new ArrayList<>();
        pasos = lienzo.iniciar_busqueda(lienzo.getJugador().getPlayer_i(),
                                        lienzo.getJugador().getPlayer_j());
        for(Character c : pasos) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }            
            lienzo.getJugador().animar_player(c);
            lienzo.repaint();      
            /*if(System.currentTimeMillis() - scheduledExecutionTime() >= 950) {        
                return;
              }   */       
        }              
    }
}
