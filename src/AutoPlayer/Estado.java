package AutoPlayer;

import models.Celda;

public class Estado {
	private Celda celda;
	private Estado antecesor;
	private final char movimiento;
	
	
	
	public Estado(Celda celda, Estado antecesor, char movimiento) {
		
		this.celda = celda;
		this.antecesor = antecesor;
		this.movimiento = movimiento;
		
	}



	public Celda getCelda() {
		return celda;
	}


	public Estado getAntecesor() {
		return antecesor;
	}


	public char getMov() {
		return movimiento;
	}

	@Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Estado)) return false;
        return celda.equals(((Estado)obj).getCelda());
    }

	
	
}
