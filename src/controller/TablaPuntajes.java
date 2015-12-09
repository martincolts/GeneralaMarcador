package controller;

import java.util.Collections;
import java.util.Vector;

import javax.swing.DefaultListModel;

public class TablaPuntajes {
	
	Vector<Jugador> jugadores = new Vector<Jugador>();
	DefaultListModel<String> listaJugadores = new DefaultListModel<String> ();

	public TablaPuntajes(){
		
	}
	
	public void agregarJugador (Jugador j){
		jugadores.add(j);
	}
	
	public void eliminarJugador (String nombre){
		for (int i = 0 ; i < jugadores.size();i++){
			if (jugadores.elementAt(i).getNombre().equals(nombre)){
				jugadores.removeElementAt(i);
				listaJugadores.remove(i);
				return;
			}
				
		}
	}
	
	public DefaultListModel<String> getListaJugadores(){
		return listaJugadores;
	}
	
	public void ordenarJugadores (){
		Collections.sort(jugadores);
	}
	
	public Vector<String> getNombresJugadores (){
		Vector<String> nombres = new Vector<String>();
		for (int i = 0 ; i < jugadores.size();i++)
			nombres.add(jugadores.elementAt(i).getNombre());
		return nombres;
	}
	
	public Vector<Jugador> getJugadores (){
		return jugadores ;
	}
	
}
