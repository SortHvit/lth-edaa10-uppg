import java.util.ArrayList;

import se.lth.cs.window.SimpleWindow;

public class ShapeList {
	private ArrayList<Shape> lista;
	
	/** Skapar en tom lista */ 
	public ShapeList() {
		lista = new ArrayList();
	}
	
	/** L�gger in figuren s i listan */ 
	void insert(Shape s) {
		lista.add(s);
	}
	
	/** Ritar upp figurerna i listan i f�nstret w */ 
	void draw(SimpleWindow w) {
		for(int i = 0; i < lista.size(); i++) {
			lista.get(i).draw(w);
		}
	}
	
	/** Tar reda p� en figur som ligger n�ra punkten xc,yc; ger null om 
	ingen s�dan figur finns i listan */ 
	Shape findHit(int xc, int yc) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).near(xc, yc)) {
				return lista.get(i);
			}
		}
		
		/** int distance;
		for(int i = 0; i < lista.size(); i++) {
			distance = lista.get(i).getSide()/2;
			if (lista.get(i).near(distance, distance)) {
				return lista.get(i);
			}
		} */
		return null;
	}
}
