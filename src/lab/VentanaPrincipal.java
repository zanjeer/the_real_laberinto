package lab;

import java.awt.BorderLayout;
import java.util.ArrayList;


import java.util.Timer;

import javax.swing.JFrame;



import AutoPlayer.Busqueda;
import AutoPlayer.Estado;
import AutoPlayer.AutoPlayer;
import models.Celda;
import models.Const;

public class VentanaPrincipal extends JFrame implements Const{

	private Lienzo lienzo;
	private AutoPlayer animar;
	Estado inicio, meta;
    Celda data_inicial;
	Celda data_fin;
    Busqueda b;
     
	public VentanaPrincipal(){

		
		this.lienzo = new Lienzo();
		lienzo.setFocusable(true);
		lienzo.requestFocus();

		
	
	    animar = new AutoPlayer(lienzo);
		
	    /*
		ArrayList<Character> pasos = new ArrayList<>();
		pasos.add('D');
		pasos.add('S');
		pasos.add('A');
		pasos.add('W');
		
		animar = new AutoPlayer(lienzo,pasos);
	    */
	    
		
		Timer player = new Timer();
		player.scheduleAtFixedRate(animar, 0, 500);
		
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(lienzo);
		this.setSize(lienzo.getWidth()+37,
					lienzo.getHeight()+60);
		this.setLocationRelativeTo(null);
	}

	
	
	
	
	

	
	
}
