package com.unipi.alexandris.CreatePolygons2;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class BoardObject{

	protected double x, y;
	protected ID id;
	private boolean w, s, a, d, up, down, left, right, onlyX, onlyY, set, undo, clear, run, print, mouse_mode = false, hide = false, write = true;
	private boolean i1, i2, i3, i4, i5, i6, i7, i8, i9, i0, backspace;
	private int[] teleport = {10001, 10001}, mouse_position = {0, 0};
	private int done = 0;
	
	
	public BoardObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setY(double y) {
		this.y = y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getYy() {
		return y;
	}
	public double getXx() {
		return x;
	}
	public void setld(ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	public void setW(boolean w) {
		this.w = w;
	}
	public boolean getW() {
		return w;
	}
	public void setS(boolean s) {
		this.s = s;
	}
	public boolean getS() {
		return s;
	}
	public void setA(boolean a) {
		this.a = a;
	}
	public boolean getA() {
		return a;
	}
	public void setD(boolean d) {
		this.d = d;
	}
	public boolean getD() {
		return d;
	}
	public void setST(boolean set) {
		this.set = set;
	}
	public boolean getST() {
		return set;
	}
	public void setUD(boolean undo) {
		this.undo = undo;
	}
	public boolean getUD() {
		return undo;
	}
	public void setCLR(boolean clear) {
		this.clear = clear;
	}
	public boolean getCLR() {
		return clear;
	}
	public void setRun(boolean run) {
		this.run = run;
	}
	public boolean getRun() {
		return run;
	}
	public void setTp(int[] teleport) {
		this.teleport = teleport;
	}
	public int[] getTp() {
		return teleport;
	}
	public void setMp(int[] mouse_position) {
		this.mouse_position = mouse_position;
	}
	public int[] getMp() {
		return mouse_position;
	}
	public void setPrnt(boolean print) {
		this.print = print;
	}
	public boolean getPrnt() {
		return print;
	}
	public void setMM(boolean mouse_mode) {
		this.mouse_mode = mouse_mode;
	}
	public boolean getMM() {
		return mouse_mode;
	}
	public void setHide(boolean hide) {
		this.hide = hide;
	}
	public boolean getHide() {
		return hide;
	}

	public boolean getI1() {
		return i1;
	}

	public void setI1(boolean i1) {
		this.i1 = i1;
	}

	public boolean getI2() {
		return i2;
	}

	public void setI2(boolean i2) {
		this.i2 = i2;
	}

	public boolean getI3() {
		return i3;
	}

	public void setI3(boolean i3) {
		this.i3 = i3;
	}

	public boolean getI4() {
		return i4;
	}

	public void setI4(boolean i4) {
		this.i4 = i4;
	}

	public boolean getI5() {
		return i5;
	}

	public void setI5(boolean i5) {
		this.i5 = i5;
	}

	public boolean getI6() {
		return i6;
	}

	public void setI6(boolean i6) {
		this.i6 = i6;
	}

	public boolean getI7() {
		return i7;
	}

	public void setI7(boolean i7) {
		this.i7 = i7;
	}

	public boolean getI8() {
		return i8;
	}

	public void setI8(boolean i8) {
		this.i8 = i8;
	}

	public boolean getI9() {
		return i9;
	}

	public void setI9(boolean i9) {
		this.i9 = i9;
	}

	public boolean getI0() {
		return i0;
	}

	public void setI0(boolean i0) {
		this.i0 = i0;
	}

	public boolean getWrite() {
		return write;
	}

	public void setWrite(boolean write) {
		this.write = write;
	}

	public boolean getBackspace() {
		return backspace;
	}

	public void setBackspace(boolean backspace) {
		this.backspace = backspace;
	}

	public int getDone() {
		return done;
	}

	public void setDone(int done) {
		this.done = done;
	}

	public boolean getUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean getDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean getLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean getRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean getOnlyX() {
		return onlyX;
	}

	public void setOnlyX(boolean onlyX) {
		this.onlyX = onlyX;
	}

	public boolean getOnlyY() {
		return onlyY;
	}

	public void setOnlyY(boolean onlyY) {
		this.onlyY = onlyY;
	}
}
