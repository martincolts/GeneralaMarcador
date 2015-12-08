package controller;

import java.util.Vector;

public class Puntos {
	
	Vector<Punto> puntos = new Vector<Punto>();
			
	Puntos(){
	}
	
	public void addPunto (Punto p){
		puntos.add(p);
	}
	
	public boolean existePunto (Punto p){
		for (int i = 0 ; i < puntos.size() ; i++){
			if ((puntos.elementAt(i).getColumna()==p.getColumna())&&(puntos.elementAt(i).getFila()==p.getFila())){
				return true ;
			}
		}
		return false ;
	}
}
