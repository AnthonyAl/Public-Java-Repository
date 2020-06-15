package com.unipi.alexandris.CreatePolygons;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMotionSensor extends MouseMotionAdapter {
	
	Handler handler;
	
	public MouseMotionSensor(Handler handler) {
		this.handler = handler;
	}
	
	public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
		int x = p.x;
		int y = p.y;
		int[] arr = {x, y};
		BoardObject tempObject = handler.object.get(0);
		tempObject.setMp(arr);
	}
}
