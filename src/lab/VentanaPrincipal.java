package lab;

import java.awt.BorderLayout;
import java.util.Timer;

import javax.swing.JFrame;

import player.AutoPlayer;
import enemy.AutoEnemy;
import models.Const;

public class VentanaPrincipal extends JFrame implements Const{
    private Lienzo lienzo;
    private AutoPlayer animar;
	private AutoEnemy enemy_ia;

    public VentanaPrincipal(){
        lienzo = new Lienzo();
        lienzo.setFocusable(true);
        lienzo.requestFocus();
        
        animar = new AutoPlayer(lienzo);
        Timer player = new Timer();
        player.scheduleAtFixedRate(animar, 0, 950);
        
        enemy_ia = new AutoEnemy(lienzo);
        Timer enemy = new Timer();
        enemy.scheduleAtFixedRate(enemy_ia, 0, 950);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(lienzo);
        this.setSize(lienzo.getWidth()+37,
                    lienzo.getHeight()+60);
        this.setLocationRelativeTo(null);
    }
}
