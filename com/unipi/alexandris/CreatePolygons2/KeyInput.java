package com.unipi.alexandris.CreatePolygons2;

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
				
				if(key == KeyEvent.VK_P) tempObject.setST(true);
				
				if(key == KeyEvent.VK_U) tempObject.setUD(true);
				
				if(key == KeyEvent.VK_C) tempObject.setCLR(true);
				
				if(key == KeyEvent.VK_H) tempObject.setHide(!tempObject.getHide());
				
				if(key == KeyEvent.VK_M) tempObject.setMM(!tempObject.getMM());
				
				if(key == KeyEvent.VK_SPACE) tempObject.setRun(true);
				
				if(key == KeyEvent.VK_1) tempObject.setI1(true);
				
				if(key == KeyEvent.VK_2) tempObject.setI2(true);
				
				if(key == KeyEvent.VK_3) tempObject.setI3(true);
				
				if(key == KeyEvent.VK_4) tempObject.setI4(true);
				
				if(key == KeyEvent.VK_5) tempObject.setI5(true);
				
				if(key == KeyEvent.VK_6) tempObject.setI6(true);
				
				if(key == KeyEvent.VK_7) tempObject.setI7(true);
				
				if(key == KeyEvent.VK_8) tempObject.setI8(true);
				
				if(key == KeyEvent.VK_9) tempObject.setI9(true);
				
				if(key == KeyEvent.VK_0) tempObject.setI0(true);
				
				if(key == KeyEvent.VK_BACK_SPACE) tempObject.setBackspace(true);
				
				if(key == KeyEvent.VK_ENTER) tempObject.setDone(tempObject.getDone() + 1);
				
				if(key == KeyEvent.VK_ENTER) tempObject.setPrnt(true);
				
				if(key == KeyEvent.VK_UP) tempObject.setUp(true);
				
				if(key == KeyEvent.VK_DOWN) tempObject.setDown(true);
				
				if(key == KeyEvent.VK_LEFT) tempObject.setLeft(true);
				
				if(key == KeyEvent.VK_RIGHT) tempObject.setRight(true);
				
				if(key == KeyEvent.VK_X) tempObject.setOnlyX(true);
				
				if(key == KeyEvent.VK_Z) tempObject.setOnlyY(true);
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
				if(key == KeyEvent.VK_X) tempObject.setOnlyX(false);
				if(key == KeyEvent.VK_Z) tempObject.setOnlyY(false);
			}
		}
	}
}
