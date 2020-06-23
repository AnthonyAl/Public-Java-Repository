package com.unipi.alexandris.CreatePolygons2;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<BoardObject> object = new LinkedList<BoardObject>();
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			BoardObject tempObject = object.get(i);
			tempObject.tick();
		}	
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			BoardObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(BoardObject object) {
		this.object.add(object);
	}
	
	public void removeObject(BoardObject object) {
		this.object.remove(object);
	}
	
	public void removeObject(int i) {
		object.remove(i);
	}
	
	public void removeObject(ID id) {
		for(int i = object.size() - 1; i > -1; i--) {
			if(object.get(i).id == id)
				object.remove(i);
		}		
	}
}
