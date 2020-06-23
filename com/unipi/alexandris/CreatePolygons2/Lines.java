package com.unipi.alexandris.CreatePolygons2;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Lines extends BoardObject {
	
	int x1, x2, y1, y2;
	
	public Lines(int x, int y, int x2, int y2, ID id) {
		super(x, y, id);
		this.x1 = (int) x;
		this.x2 = (int) x2;
		this.y1 = (int) y;
		this.y2 = (int) y2;
	}

	public void tick() {
		x1 = Blackboard.x + x1;
		x2 = Blackboard.x + x2;
		y1 = Blackboard.y + y1;
		y2 = Blackboard.y + y2;
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawLine(x1, y1, x2, y2);
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}

