package com.unipi.alexandris.CreatePolygons2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Pen extends BoardObject {
	
	private Handler handler;
	private ArrayList<Integer> polyX = new ArrayList<Integer>();
	private ArrayList<Integer> polyY = new ArrayList<Integer>();
	private String str = "project-number: ";
	private boolean menu = true;
	private int xOff = 0, yOff = 0, project = 0;
	private static int multiplierx, multipliery;
	
	public Pen(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		
		if(!getWrite() && project > 0) {
			setPrnt(false);
			int x1, x2, y1, y2, multiplierx, multipliery;
			polyX.addAll(Blackboard.getPolyArrayList("Shapes.txt", project, 0));
			polyY.addAll(Blackboard.getPolyArrayList("Shapes.txt", project, 1));
			multiplierx = Blackboard.getMultipliers("Shapes.txt", project, 0);
			multipliery = Blackboard.getMultipliers("Shapes.txt", project, 1);
			project = 0;
			polyX.set(0, polyX.get(0) / multiplierx);
			polyY.set(0, polyY.get(0) / multipliery);
			for(int i = 0; i < polyX.size() - 1; i++) {
				polyX.set(i + 1, polyX.get(i + 1) / multiplierx);
				polyY.set(i + 1, polyY.get(i + 1) / multipliery);
				x1 = polyX.get(i);
				x2 = polyX.get(i + 1);
				y1 = polyY.get(i);
				y2 = polyY.get(i + 1);
				handler.addObject(new Lines(x1, y1, x2, y2, ID.Line));
			}
			for(int i = 0; i < polyX.size(); i++) {
				polyX.set(i, polyX.get(i) * Pen.multiplierx);
				polyY.set(i, polyY.get(i) * Pen.multipliery);
			}
		}
		
		if(!getWrite() && getUp()) {
			if(getRun()) Blackboard.y += 10;
			else Blackboard.y += 1;
			setUp(false);
		}
		else if(!getWrite() && getDown()) {
			if(getRun()) Blackboard.y -= 10;
			else Blackboard.y -= 1;
			setDown(false);
		} else Blackboard.y = 0;
		
		if(!getWrite() && getLeft()) {
			if(getRun()) Blackboard.x += 10;
			else Blackboard.x += 1;
			setLeft(false);
		}
		else if(!getWrite() && getRight()) {
			if(getRun()) Blackboard.x -= 10;
			else Blackboard.x -= 1;
			setRight(false);
		} else Blackboard.x = 0;
		
		if(getHide()) menu = false;
		else menu = true;
		
		if(polyX.size() > 2) {
			if(getPrnt()) {
				printPolyCoords();
				setPrnt(false);
			}
		} else setPrnt(false);
		
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
		
		if(!getWrite() && getST()) {
			int x1, x2, y1, y2;
			polyX.add((int)x * multiplierx);
			polyY.add((int)y * multipliery);
			if(polyX.size() >= 2) {
				x1 = polyX.get(polyX.size() - 2) / multiplierx;
				x2 = polyX.get(polyX.size() - 1) / multiplierx;
				y1 = polyY.get(polyY.size() - 2) / multipliery;
				y2 = polyY.get(polyY.size() - 1) / multipliery;
				handler.addObject(new Lines(x1, y1, x2, y2, ID.Line));
			}
			setST(false);
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
			if(getOnlyX()) {
				x = getTp()[0];
			} else if(getOnlyY()) {
				y = getTp()[1];
			}
			else {
				x = getTp()[0];
				y = getTp()[1];
			}
			int[] arr = {10001, 10001};
			setTp(arr);
		}
		
		if(getMM()) {
			x = getMp()[0];
			y = getMp()[1];
		}
		
		if(getWrite()) {
			setST(false);
		}
		
		xOff += Blackboard.x;
		yOff += Blackboard.y;
		for(int i = 0; i < polyX.size(); i++) {
			polyX.set(i, (polyX.get(i) / multiplierx + Blackboard.x) * multiplierx);
			polyY.set(i, (polyY.get(i) / multipliery + Blackboard.y) * multipliery);
		}
	}
	
	private void printPolyCoords() {
		System.out.print("{");
		for(int i = 0; i < polyX.size(); i++) {
			if(i < polyX.size() - 1) System.out.print(polyX.get(i) + ",");
			else System.out.print(polyX.get(i));
		}
		System.out.print("}\n{");
		for(int i = 0; i < polyY.size(); i++) {
			if(i < polyY.size() - 1) System.out.print(polyY.get(i) + ",");
			else System.out.print(polyY.get(i));
		}
		System.out.print("}\n\n");
		Blackboard.printToFile(polyX, polyY);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x,(int) y, 2, 2);
		String str = "Pen| X: " + x + " --- " + "Y: " + y + " |    Mouse| X: " + getMp()[0] + " --- " + "Y: " + getMp()[1] + " |"+ " |    Blackboard| X: " + xOff + " --- " + "Y: " + yOff + " |";
		g.drawString(str , 15, 15);
		if(menu) {
			g.drawString("The coordinates of each vertex will be printed to a file named  'shapes', which will be created in the program's path.", 15, 35);
			g.drawString("This is a work in progress.", 15, 50);
			g.drawString("Controls are as following:", 15, 65);
			g.drawString("1: W, S, A, D for moving the pen around / UP, DOWN, LEFT, RIGHT for moving the shape around,", 15, 80);
			g.drawString("2: Holding SPACE will set the above movements to 10 steps instead of just 1,", 15, 110);
			g.drawString("3: When teleporting or while in mouse mode, holding Z (or X), will force the pen to move only on the z (y) axis (or the x axis),", 15, 95);
			g.drawString("4: Clicking anywhere inside the window will teleport the pen to the position of the mouse (while not in mouse mode),", 15, 125);
			g.drawString("5: M to switch between Mouse Mode and W-S-A-D mode,", 15, 140);
			g.drawString("6: P to place down a vertex (holding it down will place verticies continiusly - synergizes with mouse mode.),", 15, 155);
			g.drawString("7: U to remove the latest vertex (UNDO),", 15, 170);
			g.drawString("8: C to clear the canvas,", 15, 185);
			g.drawString("9: ENTER to add the lists to the file,", 15, 200);
			g.drawString("10: ESC to close the window,", 15, 215);
			g.drawString("Press H to hide this Menu.", 15, 230);
		}
		if(getWrite()) {
			g.drawString(this.str, 350, 400);
			if(getDone() > 1)
				g.drawString("Please type the multiplier of x and y (ONLY numbers and ENTER to set the multiplier),", 350, 350);
			else
				g.drawString("Would you like to open an existing project? Give the project's number (0 == new project),", 350, 350);
			this.str = type(this.str);
		}
		if(getDone() == 1) {
			this.str = this.str.substring(16);
			if(this.str.length() > 0) project = Integer.parseInt(this.str);
			else project = 0;
			this.str = "x: ";
			setDone(2);
		}
		else if(getDone() == 3) {
			this.str = this.str.substring(3);
			if(this.str.length() > 0) multiplierx = Integer.parseInt(this.str);
			else multiplierx = 1;
			this.str = "y: ";
			setDone(4);
		}
		else if(getDone() == 5) {
			this.str = this.str.substring(3);
			if(this.str.length() > 0) multipliery = Integer.parseInt(this.str);
			else multipliery = 1;
			this.str = "";
			setDone(6);
		}
		else if (getDone() > 5) {
			setWrite(false);
		}
	}
	
	private String type(String str) {
		if(getI0()) {
			str += "0";
			setI0(false);
		}
		if(getI1()) {
			str += "1";
			setI1(false);
		}
		if(getI2()) {
			str += "2";
			setI2(false);
		}
		if(getI3()) {
			str += "3";
			setI3(false);
		}
		if(getI4()) {
			str += "4";
			setI4(false);
		}
		if(getI5()) {
			str += "5";
			setI5(false);
		}
		if(getI6()) {
			str += "6";
			setI6(false);
		}
		if(getI7()) {
			str += "7";
			setI7(false);
		}
		if(getI8()) {
			str += "8";
			setI8(false);
		}
		if(getI9()) {
			str += "9";
			setI9(false);
		}
		if(getBackspace()) {
			if(str.length() > 3) str = str.substring(0, str.length() - 1);
			setBackspace(false);
		}
		return str;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 2, 2);
	}
	
	public static int getMultiplierX() {
		return multiplierx;
	}
	
	public static int getMultiplierY() {
		return multipliery;
	}
}
