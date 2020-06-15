package com.unipi.alexandris.CreatePolygons;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Scanner;

public class Blackboard extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 5839527675529025230L;
	
	public static String polyx, polyy;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private static Scanner input = new Scanner(System.in);
	
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
	
	public static void main(String[] args) {
		System.out.println("Give the name of your array for the 'x' coordinates, eg; xPoly[] \n");
		polyx =input.nextLine();
		System.out.println("Give the name of your array for the 'y' coordinates, eg; yPoly[] \n");
		polyy = input.nextLine();
		System.out.println("The coordinates of each vertex will be printed here, available to copy and paste as code for creating the respective Polygon.\n");
		System.out.println("Controls are the following:\n"
				+ "1: W, S, A, D for moving the pen around,\n"
				+ "2: Holding SPACE will move the pen for 10 steps instead of just 1,\n"
				+ "3: Clicking anywhere inside the window will teleport the pen to the position of the mouse,\n"
				+ "4: T to write down coordinates in the form 'x:y' to teleport the pen (not recomended),\n"
				+ "5: P to place down a vertex,\n"
				+ "6: U to remove the latest vertex,\n"
				+ "7: C to clear the canvas,\n"
				+ "8: ENTER to print the current vertex lists.\n"
				+ "This is a work in progress.\n");
		new Blackboard();
	}
	
}
