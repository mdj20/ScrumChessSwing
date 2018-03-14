package com.mdj20.scrumchessswing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class Square extends JPanel {
	static int defaultWidth = 100;
	private int rank;
	private int file;
	private Color defaultColor;
	private int width;
	private JLabel jLabel;
	private BorderLayout borderLayout;
	private JPanel imagePanel;  // used for image of 
	private BoardPanel boardPanel; // parent board
	
	Square(int file, int rank,BoardPanel boardPanel){
		setRFL(rank,file,boardPanel);
	}
	Square(int file, int rank, Color color ,BoardPanel boardPanel){
		this.defaultColor = color;
		this.width = defaultWidth;
		setRFL(rank,file,boardPanel);
		
	}
	Square(int file, int rank, Color color, int width, BoardPanel boardPanel){
		this.defaultColor = color;
		this.width = width;
		setRFL(rank,file,boardPanel);
	}
	private void setRFL(int rank, int file,BoardPanel boardPanel){ 
		this.rank = rank;
		this.file = file;
		this.boardPanel=boardPanel;
		this.borderLayout = new BorderLayout();
		setLayout(this.borderLayout);
		setWidthAndColor();
		this.jLabel = new JLabel();
		jLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 23));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(jLabel,BorderLayout.CENTER);
		initMouseClickListener();
	}
	public void setWidthAndColor(){
		setPreferredSize(new Dimension(this.width,this.width));
		setBackground(defaultColor);
	}
	
	
	
	private void initMouseClickListener(){
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				boardPanel.squareClick((Square)e.getSource());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setFile(int file) {
		this.file = file;
	}
	public static int getDefaultWidth() {
		return defaultWidth;
	}
	public int getRank() {
		return rank;
	}
	public int getFile() {
		return file;
	}
	public Color getDefaultColor() {
		return defaultColor;
	}
	public int getWidth() {
		return width;
	}
	public JLabel getjLabel() {
		return jLabel;
	}
}
