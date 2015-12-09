package controller;

public class Jugador implements Comparable<Jugador>{
	
	private String nombre = null ;
	private Integer puntaje = new Integer (0);
	private Puntos puntos = new Puntos();
	
	public Jugador (String nombre){
		this.nombre = nombre ;
	}

	public Integer getPuntaje (){
		return puntaje ;
	}
	
	public void sumaPuntaje (Integer puntos){
		puntaje += puntos ;
	}
	
	public String getNombre (){
		return nombre ;
	}

	@Override
	public int compareTo(Jugador o) {
		return puntaje.compareTo(o.getPuntaje());
	}
	
	public Puntos getPuntos (){
		return puntos;
	}
	
}
