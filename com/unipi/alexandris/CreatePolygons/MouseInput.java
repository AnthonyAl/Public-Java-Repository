package com.unipi.alexandris.CreatePolygons;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	
	Handler handler;
	
	public MouseInput(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	    int x = e.getX();
	    int y = e.getY();
	    int[] arr = {x, y};
		BoardObject tempObject = handler.object.get(0);
		tempObject.setTp(arr);
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
		// Nothing to do.
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Nothing to do.
	}
}
