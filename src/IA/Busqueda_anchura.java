package IA;

import java.util.ArrayList;

import lab.Lienzo;
import models.Celda;
import models.Estado;

public class Busqueda_anchura {

    private ArrayList<Estado> abiertos;
    private ArrayList<Estado> cerrados;
    private Estado actual;
    private Estado meta;
    private Lienzo lienzo;

    public Busqueda_anchura(Estado actual, Estado meta,Lienzo lienzo) {
        this.abiertos = new ArrayList<>();
        this.cerrados = new ArrayList<>();
        this.actual = actual;
        this.meta = meta;
        this.lienzo = lienzo;
    }

    public ArrayList<Character> buscar(){
        boolean win = false;

        ArrayList<Character> mov;
        abiertos.add(actual);

        while( !win && !abiertos.isEmpty() ){
            actual = abiertos.get(0);
            if( !cerrados.contains(actual) ){
                cerrados.add(actual);
                expandir(actual);	
                if(actual.equals(meta)){ win = true; }
            }	
            abiertos.remove(0);	
        }

        mov = new ArrayList<>();
        if(!win) return mov;

        while ( actual.getAntecesor() != null ){
            mov.add(0,actual.getMov());       
            actual = actual.getAntecesor();		
        }	
    return mov;	
    }

    private void expandir(Estado actual) {
        arriba(actual);
        abajo(actual);
        izquerda(actual);
        derecha(actual);	
    }


    private void arriba(Estado actual) {
        int i = actual.getCelda().getX();
        int j = actual.getCelda().getY();
        Celda c;
        Estado nuevo;	
        if( j > 0 ){
            if( lienzo.getLab().getCasillas()[i][j-1].getTipo() != 'P' ){
                c = new Celda(i,j-1,'J');
                nuevo = new Estado(c,actual,'W');
                abiertos.add(nuevo);
            }
        }
    }


    private void abajo(Estado actual) {
        int i = actual.getCelda().getX();
        int j = actual.getCelda().getY();
        Celda c;
        Estado nuevo;
        if( j < lienzo.getLab().getCasillas().length-1 ){
            if( lienzo.getLab().getCasillas()[i][j+1].getTipo() != 'P' ){
                c = new Celda(i,j+1,'J');
                nuevo = new Estado(c,actual,'S');
                abiertos.add(nuevo);
            }
        }
    }

    private void derecha(Estado actual) {
        int i = actual.getCelda().getX();
        int j = actual.getCelda().getY();
        Celda c;
        Estado nuevo;
        if( i < lienzo.getLab().getCasillas().length-1 ){
            if( lienzo.getLab().getCasillas()[i+1][j].getTipo() != 'P' ){
                c = new Celda(i+1,j,'J');
                nuevo = new Estado(c,actual,'D');
                abiertos.add(nuevo);
            }
        }	
    }

    private void izquerda(Estado actual) {
        int i = actual.getCelda().getX();
        int j = actual.getCelda().getY();
        Celda c;
        Estado nuevo;
        if( i > 0 ){
            if( lienzo.getLab().getCasillas()[i-1][j].getTipo() != 'P' ){
                c = new Celda(i-1,j,'J');
                nuevo = new Estado(c,actual,'A');
                abiertos.add(nuevo);
            }
        }
    }

}
