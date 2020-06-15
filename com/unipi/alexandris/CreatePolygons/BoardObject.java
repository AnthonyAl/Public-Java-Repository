package com.unipi.alexandris.CreatePolygons;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class BoardObject{

	protected double x, y;
	protected ID id;
	protected boolean w, s, a, d, wr, st, und, clr, rn, prnt;
	protected int[] tp = {10001, 10001}, mp = {0, 0};
	
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
	public void setWR(boolean wr) {
		this.wr = wr;
	}
	public boolean getWR() {
		return wr;
	}
	public void setST(boolean st) {
		this.st = st;
	}
	public boolean getST() {
		return st;
	}
	public void setUD(boolean und) {
		this.und = und;
	}
	public boolean getUD() {
		return und;
	}
	public void setCLR(boolean clr) {
		this.clr = clr;
	}
	public boolean getCLR() {
		return clr;
	}
	public void setRun(boolean rn) {
		this.rn = rn;
	}
	public boolean getRun() {
		return rn;
	}
	public void setTp(int[] tp) {
		this.tp = tp;
	}
	public int[] getTp() {
		return tp;
	}
	public void setMp(int[] mp) {
		this.mp = mp;
	}
	public int[] getMp() {
		return mp;
	}
	public void setPrnt(boolean prnt) {
		this.prnt = prnt;
	}
	public boolean getPrnt() {
		return prnt;
	}
}
