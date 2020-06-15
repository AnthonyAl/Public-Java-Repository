package com.unipi.alexandris.CreatePolygons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Scanner;

public class Pen extends BoardObject {
	Handler handler;
	Scanner input = new Scanner(System.in);
	String[] str;
	ArrayList<Integer> polyX = new ArrayList<Integer>();
	ArrayList<Integer> polyY = new ArrayList<Integer>();
	int X, Y;
	
	public Pen(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;	
	}

	public void tick() {
		
		if(getPrnt()) {
			printPolyCoords();
			setPrnt(false);
		}
		
		if(getW()) {
			if(getRun()) y -= 10;
			else y -= 1;
			setW(false);
		}
		
		if(getS()) {
			if(getRun()) y += 10;
			else y += 1;
			setS(false);
		}
		
		if(getA()) {
			if(getRun()) x -= 10;
			else x -= 1;
			setA(false);
		}
		
		if(getD()) {
			if(getRun()) x += 10;
			else x += 1;
			setD(false);
		}
		
		if(getWR()) {
			setWR(false);
			String choice = input.nextLine();
			str = choice.split(":");
			X = Integer.parseInt(str[0]);
			Y = Integer.parseInt(str[1]);
			System.out.println(choice + "\n\n" + str + "\n\n" + X + " " + Y);
			x = X;
			y = Y;
		}
		
		if(getST()) {
			int x1, x2, y1, y2;
			polyX.add((int)x);
			polyY.add((int)y);
			setST(false);
			if(polyX.size() >= 2) {
				x1 = polyX.get(polyX.size() - 2);
				x2 = polyX.get(polyX.size() - 1);
				y1 = polyY.get(polyY.size() - 2);
				y2 = polyY.get(polyY.size() - 1);
				handler.addObject(new Lines(x1, y1, x2, y2, ID.Line));
			}
		}
		
		if(getUD()) {
			if(polyX.size() > 0) polyX.remove(polyX.size() - 1);
			if(polyY.size() > 0) polyY.remove(polyY.size() - 1);
			setUD(false);
			if(polyX.size() > 0)
				handler.removeObject(polyX.size());
		}
		
		if(getCLR()) {
			polyX.clear();
			polyY.clear();
			handler.removeObject(ID.Line);
			setCLR(false);
		}
		
		if(getTp()[0] <= 10000) {
			x = getTp()[0];
			y = getTp()[1];
			int[] arr = {10001, 10001};
			setTp(arr);
		}
	}
	
	public void printPolyCoords() {
		System.out.print("\n\nint " + Blackboard.polyx + " = {");
		for(int i = 0; i < polyX.size(); i++) {
			if(i < polyX.size() - 1) System.out.print(polyX.get(i) + ", ");
			else System.out.print(polyX.get(i));
		}
		System.out.print("};\nint " + Blackboard.polyy + " = {");
		for(int i = 0; i < polyY.size(); i++) {
			if(i < polyY.size() - 1) System.out.print(polyY.get(i) + ", ");
			else System.out.print(polyY.get(i));
		}
		System.out.print("};\n\n");
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x,(int) y, 2, 2);
		String str = "Pen| X: " + x + " --- " + "Y: " + y + " |    Mouse| X: " + getMp()[0] + " --- " + "Y: " + getMp()[1] + " |";
		g.drawString(str , 15, 15);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 2, 2);
	}
}
