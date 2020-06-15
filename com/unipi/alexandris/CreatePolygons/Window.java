package com.unipi.alexandris.CreatePolygons;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{
	
	private static final long serialVersionUID = 2184430560234321567L;
	
	public Window(String title, Blackboard board) {
		JFrame frame = new JFrame(title);
		frame.setMinimumSize(new Dimension(200, 200));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(false);
		frame.add(board);
		frame.setVisible(true);
		board.start();
	}
	
}
