package com.unipi.alexandris.CreatePolygons2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Blackboard extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 5839527675529025230L;
	
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private static File shapes;
	private static final String str = "Shapes.txt";
	public static int x = 0, y = 0;
	
	public Blackboard(){
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput(handler));
		this.addMouseMotionListener(new MouseMotionSensor(handler));
		new Window("Blackboard Environment!", this);
		handler.addObject(new Pen(500, 522, ID.Pen, handler));
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		//common game loop.
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		//int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			//frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				//frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, 10000, 10000);
		handler.render(g);
		g.dispose();
		bs.show();
	}
	
	public static ArrayList<Integer> toIntegerArrayList(String[] list) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(String j : list) {
			ret.add(Integer.parseInt(j));
		}
		return ret;
	}
	
	public static void printToFile(ArrayList<Integer> listX, ArrayList<Integer> listY) {
		try {
			shapes = new File(str);
			FileWriter fileWriter = new FileWriter(shapes, true);
			if(shapes.length() == 0) fileWriter.write("1\r\n{");
			else fileWriter.append("\r\n" + (getProjectNumber(str) + 1) + "\r\n{");
			for(int i = 0; i < listX.size(); i++) {
				if(i < listX.size() - 1) fileWriter.append(listX.get(i) + ",");
				else fileWriter.append(listX.get(i).toString());
			}
			fileWriter.append("}\r\n{");
			for(int i = 0; i < listY.size(); i++) {
				if(i < listY.size() - 1) fileWriter.append(listY.get(i) + ",");
				else fileWriter.append(listY.get(i).toString());
			}
			fileWriter.append("}\r\n" + Pen.getMultiplierX() + ":" + Pen.getMultiplierY() + "\r\nNL");
			fileWriter.close();
		}
		catch(IOException e) {
			System.out.println("Something went wrong.");
		}
	}
	
	public static int getProjectNumber(String str) {
		ArrayList<String> tempList = new ArrayList<String>();
		int count = 0;
		int i = 0;
		try {
			shapes = new File(str);
			Scanner fileReader = new Scanner(shapes);
			while (fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				tempList.add(data);
				if(tempList.get(i).equals("NL")) count++;
				i++;
			}
			fileReader.close();
			return count;
		}
		catch(IOException e) {
			System.out.println("Something went wrong.");
			return 0;
		}
	}
	
	public static ArrayList<Integer> getPolyArrayList(String str, int x, int iterator) {
		File shapes;
		ArrayList<String> tempList = new ArrayList<String>();
		String[] tempString = new String[2];
		int count = 0;
		int i = 0;
		try {
			
			//---------------------------------------------//
			shapes = new File(str);
			Scanner fileReader = new Scanner(shapes);
			while (fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				tempList.add(data);
				if(tempList.get(i).equals("NL")) count++;
				if(count >= x) break;
				i++;
			}
			fileReader.close();
			
			//---------------------------------------------//
			tempString[0] = tempList.get(i - 3).replace("{", "");
			tempString[0] = tempString[0].replace("}", "");
			tempString[1] = tempList.get(i - 2).replace("{", "");
			tempString[1] = tempString[1].replace("}", "");	
			System.out.println(toIntegerArrayList(tempString[0].split(",")));
			if(iterator <= 0) return toIntegerArrayList(tempString[0].split(","));
			else return toIntegerArrayList(tempString[1].split(","));
			
		}
		catch(IOException e) {
			System.out.println("Something went wrong.");
			return null;
		}
	}
	
	public static int getMultipliers(String str, int x, int iterator) {
		File shapes;
		ArrayList<String> tempList = new ArrayList<String>();
		String[] tempString = new String[2];
		int count = 0;
		int i = 0;
		try {
			
			//---------------------------------------------//
			shapes = new File(str);
			Scanner fileReader = new Scanner(shapes);
			while (fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				tempList.add(data);
				if(tempList.get(i).equals("NL")) count++;
				if(count >= x) break;
				i++;
			}
			fileReader.close();
			
			//---------------------------------------------//
			tempString = tempList.get(i - 1).split(":");
			if(iterator <= 0) return Integer.parseInt(tempString[0]);
			else return Integer.parseInt(tempString[1]);
		}
		catch(IOException e) {
			System.out.println("Something went wrong.");
			return 1;
		}
	}
	
	public static void main(String[] args) {
		new Blackboard();
	}
	
}
