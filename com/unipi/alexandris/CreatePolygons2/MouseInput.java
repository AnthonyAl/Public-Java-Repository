package com.unipi.alexandris.CreatePolygons2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	
	Handler handler;
	BoardObject tempObject;
	
	public MouseInput(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Nothing to do.
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// Nothing to do.
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// Nothing to do.
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	    tempObject = handler.object.get(0);
		if(tempObject.getMM()) tempObject.setST(true);
		else {
		    int x = e.getX();
		    int y = e.getY();
		    int[] arr = {x, y};
			tempObject.setTp(arr);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Nothing to do.
	}
}
