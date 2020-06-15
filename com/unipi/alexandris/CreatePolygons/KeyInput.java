package com.unipi.alexandris.CreatePolygons;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();	
		for(int i = 0; i < handler.object.size(); i++) {
			BoardObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Pen) {
				if(key == KeyEvent.VK_W) tempObject.setW(true);
				if(key == KeyEvent.VK_S) tempObject.setS(true);
				
				if(key == KeyEvent.VK_A) tempObject.setA(true);
				if(key == KeyEvent.VK_A) tempObject.setD(false);
				
				if(key == KeyEvent.VK_D) tempObject.setD(true);
				if(key == KeyEvent.VK_D) tempObject.setA(false);	
				
				if(key == KeyEvent.VK_T) tempObject.setWR(true);
				
				if(key == KeyEvent.VK_P) tempObject.setST(true);
				
				if(key == KeyEvent.VK_U) tempObject.setUD(true);
				
				if(key == KeyEvent.VK_C) tempObject.setCLR(true);
				
				if(key == KeyEvent.VK_ENTER) tempObject.setPrnt(true);
				
				if(key == KeyEvent.VK_SPACE) tempObject.setRun(true);
			}
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();	
		for(int i = 0; i < handler.object.size(); i++) {
			BoardObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Pen) {
				if(key == KeyEvent.VK_SPACE) tempObject.setRun(false);
			}
		}
	}
}
