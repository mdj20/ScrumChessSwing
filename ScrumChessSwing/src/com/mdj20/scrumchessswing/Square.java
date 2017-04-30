package com.mdj20.scrumchessswing;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
public class Square extends JPanel {
	static int defaultWidth = 100;
	private int rank;
	private int file;
	public Color color;
	private int width;
	Square(int rank, int file){
		super();
		setRF(rank,file);
	}
	Square(int rank, int file, Color color){
		super();
		setRF(rank,file);
		this.color = color;
		this.width = defaultWidth;
	}
	Square(int rank, int file, Color color, int width){
		super();
		setRF(rank,file);
		this.color = color;
		this.width = width;
	}
	private void setRF(int rank, int file){ 
		this.rank = rank;
		this.file = file;
	}
	public void setWidthAndColor(){
		super.setPreferredSize(new Dimension(this.width,this.width));
		//super.setMinimumSize();
		super.setBackground(this.color);
	}
}
