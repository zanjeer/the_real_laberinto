package lab;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame implements Const{

	private Lienzo lienzo;
	
	public VentanaPrincipal(){
		
		
		
		
		this.lienzo = new Lienzo();
		lienzo.setFocusable(true);
		lienzo.requestFocus();
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(lienzo);
		this.setSize(lienzo.getWidth()+30,
					lienzo.getHeight()+50);
	}

	
	
	
	
	

	
	
}
