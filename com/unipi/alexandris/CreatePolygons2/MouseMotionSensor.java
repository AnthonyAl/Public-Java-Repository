package com.unipi.alexandris.CreatePolygons2;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMotionSensor extends MouseMotionAdapter {
	
	Handler handler;
	
	public MouseMotionSensor(Handler handler) {
		this.handler = handler;
	}
	
	public void mouseMoved(MouseEvent e) {
		BoardObject tempObject = handler.object.get(0);
		Point p = e.getPoint();
		int x = p.x;
		int y = p.y;
	    int[] arr = new int[2];
	    if(tempObject.getOnlyX()) {
	    	arr[0] = x;
	    	arr[1] = (int) tempObject.y;
	    } else if(tempObject.getOnlyY()) {
	    	arr[0] = (int) tempObject.x;
	    	arr[1] = y;
	    } else {
	    	arr[0] = x;
	    	arr[1] = y;
	    }
		tempObject.setMp(arr);
	}
}
