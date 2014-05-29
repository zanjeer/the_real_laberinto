package AutoPlayer;

import java.util.ArrayList;
import java.util.TimerTask;

import lab.Lienzo;
import models.Celda;
import models.Const;

public class AutoPlayer extends TimerTask implements Const {

	private Lienzo lienzo;
	private ArrayList<Character> pasos;
	private int paso_actual;
	
	
	public AutoPlayer(  Lienzo lienzo){
		this.lienzo = lienzo;
		this.pasos = null;
		this.paso_actual=0;
		
	}
	
	@Override
	public void run() {
	
		pasos = new ArrayList<Character>();
		pasos = lienzo.iniciar_busqueda(lienzo.getLab().getPlayer_i(), lienzo.getLab().getPlayer_j());
	
		 if( !pasos.isEmpty()){
			if( paso_actual < pasos.size() ){
				lienzo.getLab().animar_player( pasos.get(paso_actual));
				lienzo.repaint();
				paso_actual++;
				  System.out.println(lienzo.getLab().getCasillas()[0][19].getTipo());
			}else {
				this.cancel();
			}
		}
	}
	
}
